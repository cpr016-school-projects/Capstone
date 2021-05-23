package antenatal.dao.domain;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import antenatal.dao.GenericDao;
import antenatal.dao.JsonDao;
import antenatal.models.MonthlyReport;

public class MonthlyReportDao {
    
    private GenericDao<String,MonthlyReport> MonthlyReportDao;
    
    /**
     * Default constructor creates an Json file called MonthlyReport.json
     * TypeToken allows the GSON parser to map to/from JSON to objects
     */
    public MonthlyReportDao(String filename) {
        Type t = new TypeToken<Map<String, MonthlyReport>>(){}.getType(); 
        MonthlyReportDao = new JsonDao<String, MonthlyReport>(filename,t); 
    }
    public MonthlyReportDao()
    {
        Type t = new TypeToken<Map<String, MonthlyReport>>(){}.getType(); 
        MonthlyReportDao = new JsonDao<String, MonthlyReport>("MonthlyReport.json",t); 
    }
    
    /**
     * Add a MonthlyReport to the DAO repository
     * @param entity any MonthlyReport object
     */
    public void add(MonthlyReport entity)
    {
        MonthlyReportDao.add(entity.getID(), entity);
    }
    
    /**
     * Update a baseVisit in the DAO repository
     * @param entity any baseVisit object
     */
    public void update(MonthlyReport entity) 
    {
        MonthlyReportDao.update(entity.getID(), entity);
    }
    
    /**
     * Remove a baseVisit in the DAO repository
     * @param id of the baseVisit object to remove
     */

    public void remove(String id)
    {
        MonthlyReportDao.remove(id);
    }
    
    /**
     * Find a baseVisit in the DAO repository
     * @param id of the baseVisit object to locate
     * @return the baseVisit with id field equal to key
     */
    public MonthlyReport find(String key)
    {
        return MonthlyReportDao.find(key);
    }
    
    /**
     * Generate a list of baseVisits in the DAO repository
     * @return List of baseVisits 
     */
    public List<MonthlyReport> list() {
        return MonthlyReportDao.list();
    }
}
