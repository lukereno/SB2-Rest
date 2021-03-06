package com.luke.restdemo.controllers;

import com.luke.foundation.web.InternalServerError;
import com.luke.foundation.web.WrongParameters;
import com.luke.restdemo.dto.UserDTO;
import com.luke.restdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/users")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService service;

    @RequestMapping(value="", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<List<UserDTO>> readAll() {
        List<UserDTO> user = service.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="{username}", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<UserDTO> read(@PathVariable String username) {
        UserDTO user = service.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="", method=RequestMethod.POST, produces="application/json" )
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        try {
            service.createUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WrongParameters p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="", method=RequestMethod.PUT, produces="application/json" )
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user) {
        try {
            service.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WrongParameters p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException.InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="{username}", method=RequestMethod.DELETE, produces="application/json" )
    public ResponseEntity<UserDTO> delete(@PathVariable String username) {
        try {
            service.deleteUser(username);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WrongParameters p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (InternalServerError u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

