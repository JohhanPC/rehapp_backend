package com.siete.rehapp.mapper;
import com.siete.rehapp.dto.PatientUserRegisterDTO;
import com.siete.rehapp.dto.PhysioUserRegisterDTO;
import com.siete.rehapp.dto.UserDTO;
import com.siete.rehapp.entity.PhysiotherapistEntity;
import com.siete.rehapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(UserEntity userEntity);

    @Mappings({
            @Mapping(target = "userName", source = "userName"),
            @Mapping(target = "identificationNumber", ignore = true),
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "sex", ignore = true),
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "phoneNumber", ignore = true),
            @Mapping(target = "city", ignore = true)
    })
    UserEntity toUserEntity(UserDTO userDTO);

    UserEntity toUserEntityRegister(PatientUserRegisterDTO patientUserRegisterDTO);

    PatientUserRegisterDTO toUserRegisterDTO(UserEntity userEntity);

    void updateUserFromDto(UserDTO userDTO, @MappingTarget UserEntity userEntity);

    @Mappings({
            @Mapping(target = "userType", constant = "PHYSIOTHERAPIST"),
            @Mapping(target = "userId", ignore = true)
    })
    UserEntity toUserEntityRegister(PhysioUserRegisterDTO physioUserRegisterDTO);

    @Mapping(target = "id", ignore = true)
    PhysiotherapistEntity toPhysiotherapistEntity(PhysioUserRegisterDTO physioUserRegisterDTO);
}
