package com.covoiturage.security.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.covoiturage.security.token.Token;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
 

  
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  

  
  
  
 
 
  
  @Enumerated(EnumType.STRING)
  private Role role = Role.CONDUCTEUR;
  

 

  

  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

 
  public String getEmail() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

public String getRole() {
	// TODO Auto-generated method stub
	
	return this.role.toString();
}

public Integer getId() {
	// TODO Auto-generated method stub
	return id;
}



@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}

@JsonIgnore




public void setPassword(String password)
{
	this.password =password;
}

public void setEmail(String email) {
	this.email = email;
}








@JsonIgnore
public List<Token> getTokens() {
	return tokens;
}

public void setTokens(List<Token> tokens) {
	this.tokens = tokens;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}


public void setId(Integer id) {
	this.id = id;
}

public void setRole(Role role) {
	this.role = role;
}


}
