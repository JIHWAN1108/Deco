package com.deco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dibs {		// 찜목록
	private int idx;
	private String dibCafe;
	private String dibFood;
	private String dibShow;
	private String dibEx;
	private String nickname;	//찜목록 주인 닉네임값
}
