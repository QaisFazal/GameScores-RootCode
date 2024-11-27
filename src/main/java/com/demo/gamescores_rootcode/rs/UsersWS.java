package com.demo.gamescores_rootcode.rs;

import com.demo.gamescores_rootcode.model.User;
import com.demo.gamescores_rootcode.payload.ErrorResponse;
import com.demo.gamescores_rootcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
public class UsersWS {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (IllegalArgumentException e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            ErrorResponse error = new ErrorResponse(e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }
}
