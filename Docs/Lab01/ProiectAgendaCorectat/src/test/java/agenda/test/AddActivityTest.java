package agenda.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import agenda.model.base.Activity;
import agenda.model.repository.classes.RepositoryActivityMock;
import agenda.model.repository.interfaces.RepositoryActivity;

import org.junit.Before;
import org.junit.Test;

public class AddActivityTest {
	private Activity act1,act2,act3;
	private RepositoryActivity rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryActivityMock();
	}
	
	@Test
	public void testCase1()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);

			act1 = new Activity("Activity",
					df.parse("03/04/2002 10:00"),
					df.parse("03/04/2002 12:30"),
					null,
					"Lunch break");

			act2 = new Activity("Activity",
					df.parse("03/04/2002 14:00"),
					df.parse("03/04/2002 15:00"),
					null,
					"Lunch break");
			rep.addActivity(act2);
			rep.addActivity(act1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertTrue(2 == rep.count());
	}
	
	@Test
	public void testCase2()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			act3 = new Activity("Activity",
					df.parse("03/04/2002 15:50"),
					df.parse("03/04/2002 14:50"),
					null,
					"Lunch break");
			rep.addActivity(act3);

		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(0 == rep.count());
	}
	/*
	@Test
	public void testCase3()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:30"), 
					df.parse("03/20/2013 13:30"),
					null,
					"Lunch break");
			assertFalse(rep.addActivity(act));
		}
		catch(Exception e){}	
		assertTrue( 1 == rep.count());
		rep.saveActivities();
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}
	
	@Test
	public void testCase4()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 13:30"), 
					df.parse("03/20/2013 14:00"),
					null,
					"Curs");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 13:30"), 
					df.parse("03/20/2013 14:30"),
					null,
					"Lunch break");
			assertFalse(rep.addActivity(act));			
		}
		catch(Exception e){}	
		assertTrue( 2 == rep.count());
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}
	
	@Test
	public void testCase5()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			assertFalse(rep.addActivity(act));			
		}
		catch(Exception e){}	
		assertTrue( 1 == rep.count());
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}*/
}
