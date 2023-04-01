package csa.springframework.springbootgraphql.model;


import csa.springframework.springbootgraphql.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User  extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
