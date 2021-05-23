package antenatal.dao.domain;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import antenatal.dao.GenericDao;
import antenatal.dao.JsonDao;
import antenatal.models.PatientInfoModel;

public class PatientInfoDao {
	
	private GenericDao<String,PatientInfoModel> patientInfoDao;
	
	/**
	 * Default constructor creates an Json file called medicalInfo.json
	 * TypeToken allows the GSON parser to map to/from JSON to objects
	 */
	public PatientInfoDao()
	{
        Type t = new TypeToken<Map<String, PatientInfoModel>>(){}.getType(); 
		patientInfoDao = new JsonDao<String, PatientInfoModel>("patientinformation.json",t); 
	}
	
	/**
	 * Add a MedicalInfoModel to the DAO repository
	 * @param entity any MedicalInfoModel object
	 */
	public void add(PatientInfoModel entity)
	{
		patientInfoDao.add(entity.getPatientId(), entity);
	}
	
	/**
	 * Update a baseVisit in the DAO repository
	 * @param entity any baseVisit object
	 */
	public void update(PatientInfoModel entity) 
	{
		patientInfoDao.update(entity.getPatientId(), entity);
	}
	
	/**
	 * Remove a baseVisit in the DAO repository
	 * @param id of the baseVisit object to remove
	 */

	public void remove(String id)
	{
		patientInfoDao.remove(id);
	}
	
	/**
	 * Find a baseVisit in the DAO repository
	 * @param id of the baseVisit object to locate
	 * @return the baseVisit with id field equal to key
	 */
	public PatientInfoModel find(String key)
	{
		return patientInfoDao.find(key);
	}
    
	/**
	 * Generate a list of baseVisits in the DAO repository
	 * @return List of baseVisits 
	 */
	public List<PatientInfoModel> list() {
		return patientInfoDao.list();
	}
}
