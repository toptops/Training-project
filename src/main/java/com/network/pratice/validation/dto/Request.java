package com.network.pratice.validation.dto;

import javax.validation.constraints.NotNull;

import com.network.pratice.validation.enums.TestEnum;
import com.network.pratice.validation.valid.CustomValid;

import lombok.Data;

@Data
@CustomValid
public class Request {
	@NotNull
	private int data;
	
	@NotNull
	private TestEnum enums;
}
