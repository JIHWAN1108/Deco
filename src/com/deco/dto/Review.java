package com.deco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Review {
	private int idx;
	private String nickname;
	private double grade;
	private String content;
	private String category;
	private String imgfile;
	private int refidx;
}