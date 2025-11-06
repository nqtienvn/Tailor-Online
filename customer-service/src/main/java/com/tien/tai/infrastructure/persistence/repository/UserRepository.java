package com.tien.tai.infrastructure.persistence.repository;

import com.tien.tai.infrastructure.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
