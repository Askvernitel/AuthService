package com.judge.auth.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "user_id")
	Long userId;

	@Column(name = "email", unique = true)
	String email;

	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;

	@Column(name = "created_at")
	Date createdAt;

}
