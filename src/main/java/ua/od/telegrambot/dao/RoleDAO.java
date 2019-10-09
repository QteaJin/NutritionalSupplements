package ua.od.telegrambot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.od.telegrambot.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long>{

	Optional<Role> findByRole(String name);
}
