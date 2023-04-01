package csa.springframework.springbootgraphql.controllers;


import csa.springframework.springbootgraphql.domain.UserRequest;
import csa.springframework.springbootgraphql.model.User;
import csa.springframework.springbootgraphql.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserController.Base_URL)
@RequiredArgsConstructor
public class UserController {
    public static final String Base_URL = "/api/users";
    private final UserRepository userRepository;
    @QueryMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @QueryMapping
    public User getUserById(@Argument Long id){
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );
    }
    @MutationMapping
    public User createUser(@Argument UserRequest userRequest){
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role(userRequest.getRole())
                .build();
        return userRepository.save(user);
    }
    @MutationMapping
    public User updateUser(@Argument Long id,@Argument UserRequest userRequest){
        return userRepository.findById(id)
                .map(u -> {
                    u.setName(userRequest.getName());
                    u.setEmail(userRequest.getEmail());
                    u.setPassword(userRequest.getPassword());
                    u.setRole(userRequest.getRole());
                    return userRepository.save(u);
                })
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );
    }
    @MutationMapping
    public void deleteUser(@Argument Long id){
        userRepository.deleteById(id);
    }
}
