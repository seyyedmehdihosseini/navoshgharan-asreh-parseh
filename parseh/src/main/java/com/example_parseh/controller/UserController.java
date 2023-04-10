package com.example_parseh.controller;

import com.example_parseh.entity.model.AccountModel;
import com.example_parseh.entity.model.UserModel;
import com.example_parseh.service.JoinAccountService;
import com.example_parseh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userServ;
    @Autowired
    private JoinAccountService accountServ;

    @PostMapping("created-new-account")
    public ResponseEntity<?> createdNewAccount(@RequestBody UserModel user ) { // , @RequestBody AccountModel account
        UserModel save = userServ.save(user);//(user,account)
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("login")
    public ResponseEntity<?> loginAccount(@RequestBody AccountModel account) {
        boolean login = userServ.login(account);
        if (!login) {
            return new ResponseEntity<>("login is failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{username}/list-all-account")
    public ResponseEntity<?> listAllUsers(@PathVariable String username) {
        if (userServ.existByUsername(username)) {
            return new ResponseEntity<>(userServ.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>("user by username is not found ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("send-request/{username-me}/{username-he}")
    public ResponseEntity<?> sendRequest(@PathVariable(value = "username-me") String usernameSen
            ,@PathVariable(value = "username-he") String usernameRec){
        return new ResponseEntity<>(accountServ.saveRequest(usernameSen, usernameRec),HttpStatus.OK);
    }

    @GetMapping("accept-request/{username-me}/{username-he}")
    public ResponseEntity<?> acceptRequest(@PathVariable(value = "username-me") String usernameSen
            ,@PathVariable(value = "username-he") String usernameRec){
        return new ResponseEntity<>(accountServ.acceptRequest(usernameSen,usernameRec),HttpStatus.OK);
    }

    @GetMapping("reject-request/{username-me}/{username-he}")
    public ResponseEntity<?> rejectRequest(@PathVariable(value = "username-me") String usernameSen
            ,@PathVariable(value = "username-he") String usernameRec){
        return new ResponseEntity<>(accountServ.rejectRequest(usernameSen,usernameRec),HttpStatus.OK);
    }




}
