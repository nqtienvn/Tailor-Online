package com.tien.tai.domain.model;

import com.tien.tai.domain.command.MeasurementTrouserCmd;
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
public class MeasurementTrouserDomain {
    Integer id;
    Double trouserLength;
    Double waist;
    Double hips;
    Double knee;
    Double legWidth;
    Boolean status = true;
    Boolean isDeleted = false;

    public MeasurementTrouserDomain(MeasurementTrouserCmd cmd) {
        if (cmd == null) return;
        this.trouserLength = cmd.getTrouserLength();
        this.waist = cmd.getWaist();
        this.hips = cmd.getHips();
        this.knee = cmd.getKnee();
        this.legWidth = cmd.getLegWidth();
        this.status = true;
        this.isDeleted = false;
    }

    public void update(MeasurementTrouserCmd cmd) {
        if (cmd == null) return;
        if (cmd.getTrouserLength() != null) this.trouserLength = cmd.getTrouserLength();
        if (cmd.getWaist() != null) this.waist = cmd.getWaist();
        if (cmd.getHips() != null) this.hips = cmd.getHips();
        if (cmd.getKnee() != null) this.knee = cmd.getKnee();
        if (cmd.getLegWidth() != null) this.legWidth = cmd.getLegWidth();
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
