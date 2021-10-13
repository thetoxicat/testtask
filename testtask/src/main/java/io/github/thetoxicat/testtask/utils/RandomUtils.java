package io.github.thetoxicat.testtask.utils;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtils {
	
	private static final int DEFAULT_LENGTH = 10;
	
	public static String randomEmail() {
		return RandomStringUtils.randomAlphabetic(DEFAULT_LENGTH) + 
				"@" +
				RandomStringUtils.randomAlphabetic(DEFAULT_LENGTH) + 
				".com";
	}
	
	public static String randomLink() {
		return "https://" + 
				RandomStringUtils.randomAlphabetic(DEFAULT_LENGTH) + 
				".com";
	}
	
	public static String randomText() {
		return RandomStringUtils.randomAlphabetic(DEFAULT_LENGTH);
	}
	
	public static String randomAlphanumericText() {
		return RandomStringUtils.randomAlphanumeric(DEFAULT_LENGTH);
	}

}
