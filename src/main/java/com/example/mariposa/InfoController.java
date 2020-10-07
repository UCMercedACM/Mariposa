package com.example.mariposa;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	private final AtomicLong counter = new AtomicLong();

    @GetMapping("/info")
    public LANInfo lanInfo(@RequestParam(value = "date", defaultValue = "") String date) {
		return new LANInfo(counter.incrementAndGet(), date);
	}
}