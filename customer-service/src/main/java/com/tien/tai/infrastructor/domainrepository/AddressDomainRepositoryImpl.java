package com.tien.tai.infrastructor.domainrepository;

import com.tien.common.exception.AppException;
import com.tien.common.exception.error.BadRequestError;
import com.tien.common.exception.error.NotFoundError;
import com.tien.common.mapper.catalogservice.ToEntityDomain;
import com.tien.tai.domain.model.Address;
import com.tien.tai.domain.repository.AddressDomainRepository;
import com.tien.tai.infrastructor.persistence.model.AddressEntity;
import com.tien.tai.infrastructor.persistence.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressDomainRepositoryImpl implements AddressDomainRepository {
    private final ToEntityDomain<AddressEntity, Address> toEntityDomain;
    private final AddressRepository addressRepository;

    @Override
    public Address save(Address domain) {
        return toEntityDomain.toDomain(addressRepository.save(toEntityDomain.toEntity(domain)));
    }

    @Override
    public Address findById(Integer id) {
        return toEntityDomain.toDomain(addressRepository.findById(id).orElseThrow(() -> new AppException(NotFoundError.NOT_FOUND)));
    }

    @Override
    public void softDelete(Address domain) {

    }

    @Override
    public void saveStatus(Address domain) {

    }

    @Override
    public List<Address> findAddressByCustomerId(Integer id) {
        return toEntityDomain.toDomain(addressRepository.findAddressEntityByCustomerId(id));
    }

    @Override
    @Transactional
    public Boolean delete(Integer id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            throw new AppException(BadRequestError.CAN_NOT_DELETE);
        }
    }
}
