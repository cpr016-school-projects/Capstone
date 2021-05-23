package antenatal.dao.domain;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import antenatal.controllers.MonthlyReportController;
import antenatal.services.MonthlyReportService;

public class TestMonthlyReportDao {
    
    MonthlyReportDao dao;
    MonthlyReportController mrc;
    MonthlyReportService service;
    
    @Before
    public void setup() {
        dao = new MonthlyReportDao("TestMonthlyReport.json");
        service = new MonthlyReportService(dao);
        mrc = new MonthlyReportController(service);
    }
    
    @Test
    public void testAddingOne() {
        int currentSize = dao.list().size(); //before size
        mrc.generate("JSON", 3, 2020); //add new report
        int newSize = dao.list().size(); //new size
        assertTrue(currentSize+1 == newSize); //assert we added one
        
    }

}
