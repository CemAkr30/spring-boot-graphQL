package csa.springframework.springbootgraphql.domain;


import csa.springframework.springbootgraphql.enums.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
