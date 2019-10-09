package ua.od.telegrambot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ua.od.telegrambot.entity.User;

public interface UserService extends UserDetailsService {
	
	User findByName(String name);

}
