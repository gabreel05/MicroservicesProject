package br.com.users.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Profile implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
