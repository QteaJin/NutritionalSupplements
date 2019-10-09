package ua.od.telegrambot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.od.telegrambot.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);

}
