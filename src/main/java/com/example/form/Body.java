package com.example.form;

import javax.validation.constraints.NotBlank;

//リクエストボディの中身
public class Body {
	@NotBlank
	public String password;
	public String name;
	public String id;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}