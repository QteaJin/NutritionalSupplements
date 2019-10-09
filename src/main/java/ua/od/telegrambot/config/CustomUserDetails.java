package ua.od.telegrambot.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ua.od.telegrambot.dao.UserDAO;
import ua.od.telegrambot.entity.Role;
import ua.od.telegrambot.entity.User;

@Component
public class CustomUserDetails implements UserDetailsService{
	
	@Autowired
    private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        User user = userDao.findByName(username).get();
        Set<GrantedAuthority> roles = new HashSet<>();
        List<Role> userRoles = user.getRoles();
        for (Role role : userRoles) {
        	roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole())); // Important to add "ROLE_" => ROLE_ADMIN
		}
        
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getName(), 
                                                                       user.getPassword(), 
                                                                       roles);

        return userDetails;
	}

}
