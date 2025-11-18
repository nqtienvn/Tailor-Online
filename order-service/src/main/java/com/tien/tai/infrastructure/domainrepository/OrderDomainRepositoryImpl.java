package com.tien.tai.infrastructure.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.application.dto.mapper.entitytoresponse.MapperEntityToResponse;
import com.tien.tai.application.dto.response.OrderDTO;
import com.tien.tai.application.dto.response.OrderItemDTO;
import com.tien.tai.domain.model.OrderDomain;
import com.tien.tai.domain.model.OrderItemDomain;
import com.tien.tai.domain.repository.OrderDomainRepository;
import com.tien.tai.infrastructure.persistence.model.OrderEntity;
import com.tien.tai.infrastructure.persistence.model.OrderItemEntity;
import com.tien.tai.infrastructure.persistence.repository.OrderItemRepository;
import com.tien.tai.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderDomainRepositoryImpl implements OrderDomainRepository {
    private final OrderRepository orderRepository;
    private final ToEntityDomain<OrderEntity,OrderDomain> toEntityDomain;
    private final OrderItemRepository orderItemRepository;
    private final MapperEntityToResponse mapperEntityToResponse;


    @Override
    public OrderDomain save(OrderDomain domain) {
        OrderEntity savedOrder = orderRepository.save(toEntityDomain.toEntity(domain));
        return toEntityDomain.toDomain(savedOrder);
    }

    @Override
    public OrderDomain findById(Integer id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() ->  new RuntimeException(new AppException(NotFoundError.NOT_FOUND)));
        return toEntityDomain.toDomain(orderEntity);
    }

    @Override
    public void softDelete(OrderDomain domain) {
        domain.softDelete();
        OrderEntity entity = toEntityDomain.toEntity(domain);
        orderRepository.save(entity);
    }

    @Override
    public void saveStatus(OrderDomain domain) {
        orderRepository.save(toEntityDomain.toEntity(domain));
    }

    @Override
    public void enrichDTO(List<OrderDTO> orderDTOList) {
        if (orderDTOList == null || orderDTOList.isEmpty()) return;

        List <Integer> orderIds = orderDTOList.stream()
                .map(OrderDTO ::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List <OrderItemEntity> listEntity = orderItemRepository.findByOrderIdIn(orderIds);
        List <OrderItemDTO> listDTO = mapperEntityToResponse.toOrderItemDTOs(listEntity);

//        Map<Integer,List<OrderItemDTO>> groupsByOrderID = listDTO.stream()
//                .collect(Collectors.groupingBy(OrderItemDTO :: getOrderID));
//
//        for (OrderDTO orderDTO : orderDTOList){
//            List <OrderItemDTO> orderItemDTOS = groupsByOrderID.getOrDefault(orderDTO.getId(),List.of());
//            orderDTO.setOrderItems(orderItemDTOS);
        }
    }
//    // 1. Gom nhóm dữ liệu theo một khóa
//    Map<K, List<V>> groupedMap = listV.stream()
//            .collect(Collectors.groupingBy(V::getKey));
//
//// 2. Gắn dữ liệu nhóm lại vào danh sách đối tượng chính
//for (T item : listT) {
//        List<V> relatedValues = groupedMap.getOrDefault(item.getKey(), List.of());
//        item.setValues(relatedValues);
//}
