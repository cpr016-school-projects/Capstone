package antenatal.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import antenatal.controllers.VisitController.Pair;
import antenatal.models.Pregnancy;
import antenatal.models.Visit;
import antenatal.services.PregnancyService;
import antenatal.services.VisitService;
import antenatal.views.InitialVisitPanel;

public class TestVisitController {
	
	VisitController visitController;
	PregnancyService pregnancyService;
	VisitService visitService;
	List<String> pregnancyIds = new ArrayList<String>();
	List<String> visitIds = new ArrayList<String>();
	
	@Before
	public void setup() {
		visitController = new VisitController(new InitialVisitPanel());
		pregnancyService = new PregnancyService();
		visitService = new VisitService();
	}
	
	@Test
	public void testNewVisitBase() {
		// Test that we don't get any nulls
		Pair<Visit, Pregnancy> pair = visitController.newVisit("1"); // Id defintely doesn't exist in DB
		assertNotNull(pair); // Test pair
		assertNotNull(pair.visit); // test visit
		visitIds.add(pair.visit.getVisitId()); // gather id for cleanup
		assertNotNull(pair.pregnancy); // test pregnancy
		pregnancyIds.add(pair.pregnancy.getPregnancyId()); // gather id for cleanup
	}
	
	@Test
	public void testNewVisitForRecentPregnancy() {
		// Test to make sure the function is pulling latest pregnancy
		Pair<Visit, Pregnancy> pair = visitController.newVisit("2"); // Id definetly doesn't exist in DB
		assertEquals(pregnancyService.getActivePatientPregnancy("2").getPregnancyId(), pair.pregnancy.getPregnancyId());
		visitIds.add(pair.visit.getVisitId());
		pregnancyIds.add(pair.pregnancy.getPregnancyId());
	}
	
	@Test
	public void testNewVisitMakePregnancy() {
		// Test to validate it creates a pregnancy if none exist
		Pregnancy pregnancies = pregnancyService.getActivePatientPregnancy("3");
		assertEquals(pregnancies, null); // validate that no pregnancies exist for this id
		Pair<Visit, Pregnancy> pair = visitController.newVisit("3"); // Id definetly doesn't exist in DB
		pregnancies = pregnancyService.getActivePatientPregnancy("3");
		assertNotEquals(pregnancies, null); // validate there's now more than zero pregnancies
		visitIds.add(pair.visit.getVisitId());
		pregnancyIds.add(pregnancies.getPregnancyId());
	}
	
	@Test
	public void TestTerminateLatestPregnancy() {
		// Test to validate we terminate the latest active pregnancy
		Pregnancy pregnancy = visitController.getActivePregnancy("4");
		assertEquals(pregnancy, null); // Assert no active pregnancies exist
		Pair<Visit, Pregnancy> pair = visitController.newVisit("4");
		pregnancy = visitController.getActivePregnancy("4");
		assertNotEquals(pregnancy, null); // Make sure pregnancy got made
		assertEquals(pregnancy.getActive(), true); // Make sure it's active
		visitController.terminateLatestPregnancy("4"); // Terminate pregnancy
		pregnancy = visitController.getActivePregnancy("4"); // Get update active pregnancies
		assertEquals(pregnancy, null); // Make sure none exist
		pregnancyIds.add(pair.pregnancy.getPregnancyId());
	}
	
	@Test
	public void TestGetLatestPatientVisit() {
		// Test to validate that we get the latest visit by date
		Visit visit = new Visit("5", "5", "1980-01-01"); // Create earlier visit
		visitService.addItem(visit); // Add to repo
		visitIds.add(visit.getVisitId());
		visit = new Visit("5", "5", "2020-01-01"); // Create later visit
		visitIds.add(visit.getVisitId());
		visitService.addItem(visit); // Add to repo
		visit = visitController.getLatestPatientVisit("5");
		assertEquals(visit.getVisitId(), visitController.getLatestPatientVisit("5").getVisitId()); // Assert the most recent visit is the last one we made
	
		// Test reverse creation order in just to verify it's not based on data placement in repo
		visit = new Visit("5", "5", "2020-01-01"); // Create earlier visit
		String visitId = visit.getVisitId();
		visitService.addItem(visit); // Add to repo
		visitIds.add(visitId);
		visit = new Visit("5", "5", "1980-01-01"); // Create later visit
		visitIds.add(visit.getVisitId());
		visitService.addItem(visit); // Add to repo
		visit = visitController.getLatestPatientVisit("5");
		assertEquals(visitId, visitController.getLatestPatientVisit("5").getVisitId());
	}
	
	@Test
	public void TestGetLatestVisit() {
		Visit visit = new Visit("6", "6", "2020-02-02"); // Create one visit with one pregnancy Id
		visitService.addItem(visit);
		visitIds.add(visit.getVisitId());
		visit = new Visit("6", "7", "2020-02-02"); // Create a new visit with a different pregnancy id
		visitService.addItem(visit);
		visitIds.add(visit.getVisitId());
		assertEquals(visit.getVisitId(), visitController.getLatestVisit("6", "7").getVisitId()); // Assert that we got from the current active pregnancy
	
		// Test against other case
		visit = new Visit("6", "6", "2020-02-02"); // Create one visit with one pregnancy Id
		String visitId = visit.getVisitId();
		visitService.addItem(visit);
		visitIds.add(visitId);
		visit = new Visit("6", "7", "2020-02-02");
		visitService.addItem(visit);
		visitIds.add(visit.getVisitId());
		assertEquals(visitId, visitController.getLatestVisit("6", "6").getVisitId());
	}
	
	
	@After
	public void cleanUp() {
		// Clean up all the junk we just made
		for(String visitId : visitIds) {
			visitService.remove(visitId);
		}
		for(String pregnancyId : pregnancyIds) {
			pregnancyService.remove(pregnancyId);
		}
	}
}
