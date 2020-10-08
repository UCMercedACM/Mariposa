package com.example.mariposa;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/info")
    public LANInfo lanInfo() {
        return new LANInfo(counter.incrementAndGet());
    }

    @GetMapping("/dateinfo")
    public LANInfo lanInfo(@RequestParam(value = "date", defaultValue = "") String date) {
        return new LANInfo(counter.incrementAndGet(), date);
    }
    
    @GetMapping("/semesterinfo")
    /**
     * @param semester S or F for Spring or Fall semester
     * @param year Last two digits of the year
     */
    public LANInfo lanInfo(@RequestParam(value = "semester", defaultValue = "") String semester, @RequestParam(value = "year", defaultValue = "") int year) {
        return new LANInfo(counter.incrementAndGet(), semester, year);
    }
}