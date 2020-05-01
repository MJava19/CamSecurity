package ua.lviv.lgs.CamSecurity.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Введіть у форматі малих латинських літер, цифр та спец. символів '-, _'. Мінімум 3 символи!")
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Не справжній email!")
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @Lob
    private byte[] avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull
    private List<Role> roles = new ArrayList<>();

    @Column(length = 100000)
    private String base64;

    @OneToOne
    @NotNull
    private ShoppingBasket shoppingBasket;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
