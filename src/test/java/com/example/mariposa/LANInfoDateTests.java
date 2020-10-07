package com.example.mariposa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class LANInfoDateTests {

	@Test
	void octThird() {
		LANInfo actual = new LANInfo(0, "10.3");
		Assert.hasText(actual.getContent(), "month: 10, day: 3");
	}

	@Test
	void noDate() {
		LANInfo actual = new LANInfo(0, "");
		Assert.hasText(actual.getContent(), "no date provided");
	}
}
