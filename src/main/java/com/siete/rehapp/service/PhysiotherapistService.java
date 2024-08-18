package com.siete.rehapp.service;

import com.siete.rehapp.dto.PhysioUserRegisterDTO;
import com.siete.rehapp.entity.PhysiotherapistEntity;
import com.siete.rehapp.entity.UserEntity;
import com.siete.rehapp.exception.UserException;
import com.siete.rehapp.mapper.UserMapper;
import com.siete.rehapp.repository.PhysiotherapistRepository;
import com.siete.rehapp.repository.UserRepository;
import com.siete.rehapp.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PhysiotherapistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhysiotherapistRepository physiotherapistRepository;

    @Autowired
    private UserMapper userMapper;

    public PhysioUserRegisterDTO registerPhysiotherapist(PhysioUserRegisterDTO physioUserRegisterDTO) {
        try {
            log.info("Registering new physiotherapist: {}", physioUserRegisterDTO);

            String encodedPassword = Base64Util.encode(physioUserRegisterDTO.getPassword());
            physioUserRegisterDTO.setPassword(encodedPassword);

            UserEntity userEntity = userMapper.toUserEntityRegister(physioUserRegisterDTO);
            UserEntity savedUserEntity = userRepository.save(userEntity);

            PhysiotherapistEntity physiotherapistEntity = userMapper.toPhysiotherapistEntity(physioUserRegisterDTO);
            physiotherapistEntity.setUser(savedUserEntity);
            physiotherapistRepository.save(physiotherapistEntity);

            log.info("Physiotherapist registered successfully: {}", physioUserRegisterDTO);
            return physioUserRegisterDTO;
        } catch (Exception e) {
            log.error("Error registering physiotherapist: ", e);
            throw new UserException("Error registering physiotherapist: " + e.getMessage());
        }
    }

}
