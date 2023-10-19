package com.example.restservice;

import com.BugTrackerDB.BugTrackerDBConnector;
import com.BugTrackerDB.Defect;
import com.BugTrackerDB.UserDefectCounts;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = "http://*")
public class DefectController {

	private BugTrackerDBConnector bugTrackerDBConnector = new BugTrackerDBConnector();

	//GET method to get a List of all the defects
	@GetMapping("/defects")
	public List<Defect> getAllDefects() throws SQLException {
		return bugTrackerDBConnector.getDefectDAO().getAllDefects();
	}

	//GET method to get a single defect
	@GetMapping("/singleDefect")
	public Defect getSingleDefect(@RequestParam("defectID") int defectID) throws SQLException{
		return bugTrackerDBConnector.getDefectDAO().getSingleDefect(defectID);
	}

	//GET method to get the count of the defects in the Defects table
	@GetMapping("/defectCount")
	public int getDefectCount() throws SQLException{
		return bugTrackerDBConnector.getDefectDAO().getDefectCount();
	}

	//GET method to get the count of the open defects in the Defects table
	@GetMapping("/openDefectCount")
	public int getOpenDefectCount() throws SQLException{
		return bugTrackerDBConnector.getDefectDAO().getOpenDefectCount();
	}
	//GET method to get the count of the defects in the Defects table
	@GetMapping("/inProgressDefectCount")
	public int getInProgressDefectCount() throws SQLException{
		return bugTrackerDBConnector.getDefectDAO().getInProgressDefectCount();
	}
	//GET method to get the count of the defects in the Defects table
	@GetMapping("/closedDefectCount")
	public int getClosedDefectCount() throws SQLException{
		return bugTrackerDBConnector.getDefectDAO().getClosedDefectCount();
	}

	//GET method to get the Defect Status counts by User
	@GetMapping("/defectCountsByUser")
	public List<UserDefectCounts> getUserDefectCounts() throws SQLException {
		return bugTrackerDBConnector.getDefectDAO().getDefectCountsByUser();
	}

	//POST method to add a defect to the Defects table
	@PostMapping("/addDefect")
	public ResponseEntity<String> addDefect(@RequestBody Defect newDefect) {
		try {
			bugTrackerDBConnector.getDefectDAO().addDefect(newDefect);
			return ResponseEntity.status(HttpStatus.CREATED).body("Defect Created Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating defect: " + e.getMessage());
		}
	}

	//POST method to add a defect to the Defects table
	@PostMapping("/editDefect")
	public ResponseEntity<String> editDefect(@RequestBody Defect edittedDefect) {
		try {
			bugTrackerDBConnector.getDefectDAO().editDefect(edittedDefect);
			return ResponseEntity.status(HttpStatus.CREATED).body("Defect Editted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editting defect: " + e.getMessage());
		}
	}

}
