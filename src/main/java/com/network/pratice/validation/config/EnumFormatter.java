package com.network.pratice.validation.config;

import org.springframework.core.convert.converter.Converter;

import com.network.pratice.validation.enums.TestEnum;

public class EnumFormatter implements Converter<String, TestEnum>{
	@Override
	public TestEnum convert(String source) {
		try {
			return TestEnum.valueOf(source);
		} catch (Exception e) {
			return null;
		}
	}
}
