package com.deco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private int idx;
	private String name;
	private String password;
	private String email;
	private String gender;
	private int age;
	private String phone;
	private String addr;
	private String nickname;
}
