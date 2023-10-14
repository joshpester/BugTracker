package com.example.restservice;

import com.BugTrackerDB.BugTrackerDBConnector;
import com.BugTrackerDB.Defect;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = "http://*")
public class DefectController {

	private BugTrackerDBConnector bugTrackerDBConnector = new BugTrackerDBConnector();

	@GetMapping("/defects")
	public List<Defect> getAllDefects() throws SQLException {
		System.out.println(bugTrackerDBConnector.getDefectDAO().getAllDefects());
		return bugTrackerDBConnector.getDefectDAO().getAllDefects();
	}

	@GetMapping("/defectCount")
	public int getDefectCount() {
		return bugTrackerDBConnector.getDefectDAO().getDefectCount();
	}
}
