package com.siete.rehapp.repository;

import com.siete.rehapp.entity.UserEntity;
import com.siete.rehapp.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByIdentificationNumberAndUserType(String identificationNumber, UserType userType);

}
