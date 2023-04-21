package com.example.demo3layer;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUser();
    UserDTO findUserById(Long id);

    void saveOrUpdate(User user);

    void deleteUser(Long id);
}
