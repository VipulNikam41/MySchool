package com.myschool.service;

import com.myschool.aspects.annotation.Loggable;
import com.myschool.constants.UserRole;
import com.myschool.domain.dto.UserRequest;
import com.myschool.domain.dto.UserResponse;
import com.myschool.domain.entities.User;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.mapper.UserMapper;
import com.myschool.domain.repository.InstituteRepo;
import com.myschool.domain.repository.UserRepo;
import com.myschool.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final InstituteRepo instituteRepo;

    private final UserMapper userMapper;
    private final InstituteMapper instituteMapper;

    @Loggable
    public UserResponse getUserById(UUID id) {
        log.info("Returning user info for user {}", id);
        Optional<User> userProfile = userRepo.findById(id);

        if (userProfile.isEmpty()) {
            return null;
        }

        User user = userProfile.get();

        return userMapper.entityToDto(user);
    }

    public Boolean validateAndAdd(UserRequest userDto) {
        userDto.setName(Utils.beautify(userDto.getName()));
        if (userDto.getPrimaryGoal() == null) {
            userDto.setPrimaryGoal(UserRole.STUDENT);
        }

        try {
            User user = userMapper.dtoToEntity(userDto);
            userRepo.save(user);
            log.info("User is saved {}", user.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean validateAndUpdate(UserRequest user, UUID id) {
        User userProfile = userMapper.dtoToEntity(user);
        userProfile.setId(id);
        try {
            userRepo.save(userProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
