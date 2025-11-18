package com.tien.tai.domain.model;

import com.tien.tai.domain.command.MeasurementShirtCmd;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class MeasurementShirtDomain {
    Integer id;
    Double chest;
    Double shoulder;
    Double sleeveLength;
    Double armhole;
    Double bicep;
    Double neck;
    Double shirtLength;
    Boolean status = true;
    Boolean isDeleted = false;

    public MeasurementShirtDomain(MeasurementShirtCmd cmd) {
        if (cmd == null) return;
        this.chest = cmd.getChest();
        this.shoulder = cmd.getShoulder();
        this.sleeveLength = cmd.getSleeveLength();
        this.armhole = cmd.getArmhole();
        this.bicep = cmd.getBicep();
        this.neck = cmd.getNeck();
        this.shirtLength = cmd.getShirtLength();
        this.status = true;
        this.isDeleted = false;
    }


    public void update(MeasurementShirtCmd cmd) {
        if (cmd == null) return;
        if (cmd.getChest() != null) this.chest = cmd.getChest();
        if (cmd.getShoulder() != null) this.shoulder = cmd.getShoulder();
        if (cmd.getSleeveLength() != null) this.sleeveLength = cmd.getSleeveLength();
        if (cmd.getArmhole() != null) this.armhole = cmd.getArmhole();
        if (cmd.getBicep() != null) this.bicep = cmd.getBicep();
        if (cmd.getNeck() != null) this.neck = cmd.getNeck();
        if (cmd.getShirtLength() != null) this.shirtLength = cmd.getShirtLength();

    }

    public void softDelete() {
        this.isDeleted = true;
        this.status = false;
    }

    public void activate() {
        this.status = true;
        this.isDeleted = false;
    }

    public void inActivate() {
        this.status = false;
    }
}
