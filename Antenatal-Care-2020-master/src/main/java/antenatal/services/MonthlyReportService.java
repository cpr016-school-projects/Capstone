package antenatal.services;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import antenatal.dao.domain.MonthlyReportDao;
import antenatal.services.VisitService;
import antenatal.services.PatientInfoService;
import antenatal.dao.domain.VisitDao;
import antenatal.dao.domain.PatientInfoDao;
import antenatal.models.MonthlyReport;
import antenatal.models.PatientInfoModel;
import antenatal.models.Visit;

import edu.usm.cos420.consultingregister.service.search.*;
import edu.usm.cos420.consultingregister.domain.*;


public class MonthlyReportService {
    
    MonthlyReportDao mrDao;
    VisitService vService;
    PatientInfoService miService;
    PatientSearch patientSearch;
    
    public MonthlyReportService() {
        this.mrDao = new MonthlyReportDao();
        this.vService = new VisitService();
        this.miService = new PatientInfoService();
        this.patientSearch = new PatientSearch();
    }
    
    public MonthlyReportService(MonthlyReportDao mrDao) {
        this.mrDao = mrDao;
        this.vService = new VisitService();
        this.miService = new PatientInfoService();
        this.patientSearch = new PatientSearch();
    }

    public void addItem(MonthlyReport mr) { //add a new BaseMonthlyReport to the dao
        mrDao.add(mr);
    }

    public MonthlyReport findItem(String id) { //retrieve a BaseMonthlyReport based on its ID
        return mrDao.find(id);
    }

    public void remove(String id) { //remove a BaseMonthlyReport
        mrDao.remove(id);
    }

    public void updateItem(MonthlyReport updated) { //update a BaseMonthlyReport
        mrDao.update(updated);
    }
    
    public List<MonthlyReport> getAll(){ //get all monthly reports
        return mrDao.list();
    }
    

}
