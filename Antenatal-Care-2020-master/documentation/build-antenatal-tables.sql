CREATE TABLE IF NOT EXISTS PatientInfo (
	patientId INT NOT NULL PRIMARY KEY,
	parity INT,
	bloodGroup VARCHAR(5),
	venerealDiseaseLab BOOLEAN, 
	
	sicklingStatus BOOLEAN,
	sicklingType VARCHAR(5),
	
	ttFirstDoseGiven BOOLEAN,
	ttSecondDoseGiven BOOLEAN,
	ttThirdDoseGiven BOOLEAN,
	ttFourthDoseGiven BOOLEAN,
	ttFifthDoseGiven BOOLEAN,
	ttPreviouslyProtected BOOLEAN,
	
	iptFirstDoseGiven BOOLEAN,
	iptSecondDoseGiven BOOLEAN,
	iptThirdDoseGiven BOOLEAN,
	
	height FLOAT, 
	pmtctPretestCounseling BOOLEAN,
	pmtctTestResult BOOLEAN, 
	pmtctPosttestCounseling BOOLEAN,
	pmtctAntiretroviralDrugsGiven BOOLEAN
);
	
CREATE TABLE IF NOT EXISTS Pregnancy (
	pregnancyId VARCHAR(50) NOT NULL PRIMARY KEY,
	patientId INT NOT NULL,
	gestation INT,
	expectedDeliveryDate VARCHAR(50),
	hemoglobin0 FLOAT,
	hemoglobin36 FLOAT,
	isActive BOOLEAN
);
	
	
	
	
	
	
	