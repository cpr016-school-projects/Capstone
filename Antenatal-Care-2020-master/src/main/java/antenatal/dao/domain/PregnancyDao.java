package antenatal.dao.domain;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import antenatal.dao.GenericDao;
import antenatal.dao.JsonDao;
import antenatal.models.Pregnancy;

public class PregnancyDao {
	
	private GenericDao<String, Pregnancy> pregnancyDao;
	
	
	public PregnancyDao() {
		Type t = new TypeToken<Map<String, Pregnancy>>(){}.getType();
		pregnancyDao = new JsonDao<String, Pregnancy>("pregnancy.json", t);
	}
	
	public void add(Pregnancy p) {
		pregnancyDao.add(p.getPregnancyId(), p);
	}
	
	public void update(Pregnancy p) {
		pregnancyDao.update(p.getPregnancyId(), p);
	}
	
	public Pregnancy find(String pregId) {
		return pregnancyDao.find(pregId);
	}
	
	public List<Pregnancy> list(){
		return pregnancyDao.list();
	}
	
	public void remove(String pregId) {
		pregnancyDao.remove(pregId);
	}
}