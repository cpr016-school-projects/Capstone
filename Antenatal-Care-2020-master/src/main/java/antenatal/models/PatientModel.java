package antenatal.models;

import java.io.Serializable;

public class PatientModel implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	private long patientId, clinicId, outPatientNumber, NHISNumber;
	private String firstName, lastName, address;
	int age; 
	char gender;
	
	public PatientModel() {
		patientId = clinicId= outPatientNumber = NHISNumber = 0;
		firstName = lastName = address = "";
		int age = -1;
		char gender = 'n';
	}
	
	public PatientModel(long patientId, String firstName, String lastName, String address, int age, char gender,
			long clinicId, long OPNumber, long NHISNumber) 
	{
		this.patientId = patientId;
		this.clinicId = clinicId;
		outPatientNumber = OPNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender; 
		this.NHISNumber = NHISNumber;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	
}
