package com.dub.spring.oauth.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class MyUser implements Serializable {

	//private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5401371388638027961L;
	private long id;
	private String username;
	private byte[] hashedPassword;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private Set<UserAuthority> authorities = new HashSet<>();
	

	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}


	public byte[] getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(byte[] hashedPassword) {
		this.hashedPassword = hashedPassword;
	}


	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}



    public long getId() {
        return this.id;
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setId(long id)
    {
        this.id = id;
    }
	
  
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
	


	public boolean isEnabled() {
		return enabled;
	}

}