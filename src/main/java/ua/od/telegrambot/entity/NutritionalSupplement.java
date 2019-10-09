package ua.od.telegrambot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ua.od.telegrambot.utils.DangerStatus;

@Entity
@Table(name = "NutritionalSupplement")
public class NutritionalSupplement implements Serializable {

	private long id;
	private String name;
	private String description;
	private DangerStatus danger;

	public NutritionalSupplement() {

	}

	public NutritionalSupplement(long id, String name, String description, DangerStatus danger) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.danger = danger;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
	public DangerStatus getDanger() {
		return danger;
	}

	public void setDanger(DangerStatus danger) {
		this.danger = danger;
	}

}
