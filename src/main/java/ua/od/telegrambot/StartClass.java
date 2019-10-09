package ua.od.telegrambot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.od.telegrambot.dao.RoleDAO;
import ua.od.telegrambot.dao.UserDAO;
import ua.od.telegrambot.entity.Role;


public class StartClass {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	
	public StartClass() {
		createNewRole();
	}



	public void createNewRole() {
		
		Role role = new Role();
		role.setRole("ADMIN");
		role.setUsers(null);
		roleDAO.save(role);
		
		Role roleUser = new Role();
		roleUser.setRole("USER");
		roleUser.setUsers(null);
		roleDAO.save(roleUser);
	}

}
