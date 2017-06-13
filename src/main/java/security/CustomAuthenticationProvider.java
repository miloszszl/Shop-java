package security;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import service.UserService;
import POJO.User;

/**
 * Created by przemek on 2017-05-21.
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> authorities = new ArrayList<>();
        User u=userDao.findByLoginAndPassword(name,password);

        if(u!=null)
        {
            authorities.add(new SimpleGrantedAuthority(u.getAccountType().getAccountTypeName()));
            return new UsernamePasswordAuthenticationToken(
                    name, password, authorities);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
