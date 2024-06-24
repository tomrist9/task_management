package com.example.user_management.registration.entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
    Long userId;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "authority")
    private Collection<GrantedAuthority> authorities;

    public void setId(Long id) {
        this.userId = userId;
    }

    public Long getId() {
        return userId;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
