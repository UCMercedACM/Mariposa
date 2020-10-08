package com.example.mariposa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class LANInfoTests {

	@Test
	void allData() {
		LANInfo actual = new LANInfo(0);
		Assert.hasText(actual.getContent(), "placeholder for all lan party content");
	}

	@Test
	void octThird() {
		LANInfo actual = new LANInfo(0, "10.3");
		Assert.hasText(actual.getContent(), "month: 10, day: 3");
	}

	@Test
	void f19() {
		LANInfo actual = new LANInfo(0, "F", 19);
		Assert.hasText(actual.getContent(), "F19");
	}

}
