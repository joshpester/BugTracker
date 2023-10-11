package com.example.restservice;

import com.BugTrackerDB.BugTrackerDBConnector;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

	private final BugTrackerDBConnector BugTrackerDBConnector = null;

	// @GetMapping("/data")
	// public {

	// }
}
