package antenatal.controllers;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import antenatal.dao.domain.VisitDao;
import antenatal.models.Visit;
import antenatal.services.VisitService;


public class TestMonthlyReportController{
    
    MonthlyReportController mrc;    
    
    @Test
    public void testNullAges() {
        mrc = new MonthlyReportController();
        int[] ageCounts = mrc.getAgeCounts(-1, -1); //month and year will get no data from visit, patient info, etc.   
        for(int i = 0; i < ageCounts.length;i++) {
            assertNotNull("Index is not null.",ageCounts[i]);
        }
        
    }
    
    @Test
    public void testNullHemoglobin() {
        mrc = new MonthlyReportController();
        int[] hg = mrc.getHemoglobinCounts(-1, -1); //month and year will get no data from visit, patient info, etc.   
        for(int i = 0; i < hg.length;i++) {
            assertNotNull("Index is not null.",hg[i]);
        }
        
    }
    
    @Test
    public void testGetAllVisits() {
        mrc = new MonthlyReportController();
        List<Visit> visits = mrc.getAllVisits(-1, -1); //again should have no visits
        assertEquals("Visit model/dao is empty, so should the list.",visits.size(),0);
    }
    
    
}
