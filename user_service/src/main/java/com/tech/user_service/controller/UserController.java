package com.tech.user_service.controller;

import com.tech.user_service.dto.UserDTO;
import com.tech.user_service.model.User;
import com.tech.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByid(@PathVariable Long id){
        User user = userService.getUserById(id);
        List contacts = restTemplate.getForObject("http://contact-service/api/contact/" + id, List.class);

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setContacts(contacts);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
