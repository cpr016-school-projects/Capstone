package antenatal.dao.domain;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import antenatal.dao.GenericDao;
import antenatal.dao.JsonDao;
import antenatal.models.Visit;

public class VisitDao {
	private GenericDao<String, Visit> visitDao;
	
	public VisitDao() {
		Type t = new TypeToken<Map<String, Visit>>(){}.getType();
		visitDao = new JsonDao<String, Visit>("visit.json", t);
	}
	
	public void add(Visit v) {
		visitDao.add(v.getVisitId(), v);
	}
	
	public void update(Visit v) {
		visitDao.update(v.getVisitId(), v);
	}
	
	public Visit find(String visitId) {
		return visitDao.find(visitId);
	}
	
	public List<Visit> list(){
		return visitDao.list();
	}
	
	public void remove(String visitId) {
		visitDao.remove(visitId);
	}
}