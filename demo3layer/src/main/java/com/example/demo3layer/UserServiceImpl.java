package com.example.demo3layer;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUser() {
        List<User> users =  userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user -> mapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findUserById(id);
        UserDTO userDto = mapper.map(user,UserDTO.class);
        return userDto;
    }


    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
