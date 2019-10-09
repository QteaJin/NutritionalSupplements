package ua.od.telegrambot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

import ua.od.telegrambot.dao.RoleDAO;
import ua.od.telegrambot.dao.UserDAO;
import ua.od.telegrambot.entity.Role;
import ua.od.telegrambot.entity.User;

@SpringBootApplication
public class TelegramBotApplication implements CommandLineRunner {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(TelegramBotApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		User user = userDAO.findByName("admin").get();
//		Role role = roleDAO.findByRole("ADMIN").get();
//		Role roleUser = roleDAO.findByRole("USER").get();
//		List<Role> roles = new ArrayList<>();
//		roles.add(role);
//		roles.add(roleUser);
//		user.setRoles(roles);
//		userDAO.saveAndFlush(user);

	}

}
