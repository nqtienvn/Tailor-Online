package com.tien.tai.infrastructure.persistence.repository;


import com.tien.tai.infrastructure.persistence.model.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {

}