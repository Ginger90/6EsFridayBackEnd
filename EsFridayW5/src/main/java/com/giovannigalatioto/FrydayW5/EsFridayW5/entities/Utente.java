package com.giovannigalatioto.FrydayW5.EsFridayW5.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "utente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastname;
	private String username;
	private String email;
	private String password;
	
	@OneToMany (fetch = FetchType.EAGER )
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn (name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
}
