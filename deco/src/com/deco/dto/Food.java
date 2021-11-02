package com.deco.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
	private int fidx;
	private String name;
	private String content;
	private String phone;
	private String addr;
	private String menu;
	private String opentime;
	private String closetime;
	private double grade;
	private String location;
	private String outimage;
	private String inimage;
}
