package com.luke.restdemo.service;

import com.luke.restdemo.dao.IUserDAO;
import com.luke.restdemo.dao.UserDAO;
import com.luke.restdemo.dto.UserDTO;
import com.luke.restdemo.entities.User;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

//@Component
@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

//    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> entities = userDAO.getUsers();
        List<UserDTO> users = new ArrayList<>();

        log.info("lombok logging !");

        return entities.stream()
                .map(x -> modelMapper.map(x, UserDTO.class))
                .collect(Collectors.toList());

//        Iterator<User> iterator = entities.iterator();
//
//        while(iterator.hasNext()) {
//            User user = iterator.next();
////            ModelMapper modelMapper = new ModelMapper();
//            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//            users.add(userDTO);
////            users.add(ApiDTOBuilder.userToUserDTO(user));
//        }
//        return users;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userDAO.getUser(username);
        //ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
        //return ApiDTOBuilder.userToUserDTO(user);
    }

    @Override
    public void createUser(UserDTO user) {
        userDAO.createUser(modelMapper.map(user, User.class));
    }

    @Override
    public void updateUser(UserDTO user) {
        userDAO.updateUser(modelMapper.map(user, User.class));

    }

    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

}

