package antenatal.dao.domain; 

import java.util.List;
import antenatal.dao.GenericDao;
import antenatal.dao.ObjectStreamDao;
import antenatal.models.PatientModel;

public class PatientDao {
	private GenericDao<Long, PatientModel> patientDao;
	
	public PatientDao() {
		patientDao = new ObjectStreamDao<Long,PatientModel>("patient.ser");
	}
	
	public PatientModel find(Long patientId) {
		return patientDao.find(patientId);
	}
	
	public void add(Long patientId, PatientModel pm) {
		patientDao.add(patientId, pm);
	}

}

