package com.tien.tai.domain.model;
import com.tien.tai.domain.command.MeasurementCmd;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class MeasurementDomain {

    Double chest;
    Double waist;
    Double hips;
    Double shoulder;
    Double sleeveLength;
    Double trouserLength;

    int orderID;

    Boolean status = true;
    Boolean isDeleted = false;

    public MeasurementDomain(MeasurementCmd cmd) {
        if (cmd == null) return;
        this.chest = cmd.getChest();
        this.waist = cmd.getWaist();
        this.hips = cmd.getHips();
        this.shoulder = cmd.getShoulder();
        this.sleeveLength = cmd.getSleeveLength();
        this.trouserLength = cmd.getTrouserLength();
        this.orderID = cmd.getOrderID();
    }

    // ===== Hàm update từ MeasurementCmd =====
    public void update(MeasurementCmd cmd) {
        if (cmd == null) return;

        if (cmd.getChest() != null) this.chest = cmd.getChest();
        if (cmd.getWaist() != null) this.waist = cmd.getWaist();
        if (cmd.getHips() != null) this.hips = cmd.getHips();
        if (cmd.getShoulder() != null) this.shoulder = cmd.getShoulder();
        if (cmd.getSleeveLength() != null) this.sleeveLength = cmd.getSleeveLength();
        if (cmd.getTrouserLength() != null) this.trouserLength = cmd.getTrouserLength();
        if (cmd.getOrderID() > 0) this.orderID = cmd.getOrderID();
    }

    // ===== Hàm soft delete =====
    public void softDelete() {
        this.isDeleted = true;
        this.status = false; // nếu muốn đánh dấu inactive khi xóa
    }

}
