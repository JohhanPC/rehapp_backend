package com.siete.rehapp.mapper;
import com.siete.rehapp.dto.UserDTO;
import com.siete.rehapp.dto.UserRegisterDTO;
import com.siete.rehapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(UserEntity userEntity);

    @Mappings({
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "sex", ignore = true),
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "phoneNumber", ignore = true),
            @Mapping(target = "city", ignore = true),
            @Mapping(target = "userName", source = "userName")
    })
    UserEntity toUserEntity(UserDTO userDTO);

    UserEntity toUserEntityRegister(UserRegisterDTO userRegisterDTO);

    UserRegisterDTO toUserRegisterDTO(UserEntity userEntity);

    void updateUserFromDto(UserDTO userDTO, @MappingTarget UserEntity userEntity);
}
