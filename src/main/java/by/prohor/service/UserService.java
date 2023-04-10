package by.prohor.service;

import by.prohor.models.ApplicationUser;
import by.prohor.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("in the user details service");

        if(!username.equals("Garry")) throw new UsernameNotFoundException("Not Garry");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));

        return new ApplicationUser(1, "Garry", encoder.encode("password"), roles);
    }
}
