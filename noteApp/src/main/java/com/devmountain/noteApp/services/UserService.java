package com.devmountain.noteApp.services;
import jakarta.transaction.Transactional;
import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDTO userDTO);
    List<String> userLogin(UserDTO userDTO);
}
