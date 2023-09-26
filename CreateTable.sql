CREATE DATABASE BugTrackerDB;

CREATE TABLE IF NOT EXISTS BugTrackerDB.Defects(
    DefectNum INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DefectName VARCHAR(200) NOT NULL,
    DefectDescription TEXT,
    DefectDateTime TIMESTAMP,
    CreatedBy VARCHAR(200),
    AssignedTo VARCHAR(200),
    DefectStatus ENUM('Open', 'In Progress', 'Closed'),
    Attachments BLOB
);

CREATE TABLE IF NOT EXISTS BugTrackerDB.Users(
    UserID INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(200),
    LastName VARCHAR(200),
    AdminRole ENUM('Admin', 'User')    
);

INSERT INTO BugTrackerDB.Defects(DefectName, DefectDescription, DefectDateTime, CreatedBy, 
    AssignedTo, DefectStatus)
Values ('Test001', 'This is a first test at adding a defect into the Defects table', NOW(), 'Josh', 'Michael', 'Open');

INSERT INTO BugTrackerDB.Users(FirstName, LastName, AdminRole)
Values ('Josh', 'Pester', 'Admin');

ALTER TABLE BugTrackerDB.Defects
RENAME COLUMN DefectNum TO DefectID;

SELECT * FROM `BugTrackerDB`.`Defects`;
SELECT * FROM `BugTrackerDB`.`Users`;