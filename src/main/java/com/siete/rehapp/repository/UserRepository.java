package com.siete.rehapp.repository;

import com.siete.rehapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
