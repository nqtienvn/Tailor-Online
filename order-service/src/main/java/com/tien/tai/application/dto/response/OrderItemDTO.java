package com.tien.tai.application.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tien.tai.application.dto.request.MeasurementTrouserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Double price;
    private Integer orderId;
    private Integer measurementShirtID;
    private Integer measurementTrouserID;
}
