package br.com.users.mapper.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(this.username, this.password);
    }
}
