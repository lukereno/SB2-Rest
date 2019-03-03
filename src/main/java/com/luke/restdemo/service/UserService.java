package com.luke.restdemo.service;

import com.luke.restdemo.dao.IUserDAO;
import com.luke.restdemo.dto.ApiDTOBuilder;
import com.luke.restdemo.dto.UserDTO;
import com.luke.restdemo.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Component
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> entities = userDAO.getUsers();
        List<UserDTO> users = new ArrayList<>();

        Iterator<User> iterator = entities.iterator();

        while(iterator.hasNext()) {
            User user = iterator.next();
            ModelMapper modelMapper = new ModelMapper();
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            users.add(userDTO);
//            users.add(ApiDTOBuilder.userToUserDTO(user));
        }
        return users;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userDAO.getUser(username);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
        //return ApiDTOBuilder.userToUserDTO(user);
    }

    @Override
    public void createUser(UserDTO user) {
        userDAO.createUser(ApiDTOBuilder.userDTOToUser(user));
    }

    @Override
    public void updateUser(UserDTO user) {
        userDAO.updateUser(ApiDTOBuilder.userDTOToUser(user));

    }

    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

}

