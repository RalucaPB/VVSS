package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryActivityFile;
import agenda.model.repository.classes.RepositoryActivityMock;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.classes.RepositoryUserFile;
import agenda.model.repository.interfaces.RepositoryActivity;
import agenda.model.repository.interfaces.RepositoryContact;
import agenda.model.repository.interfaces.RepositoryUser;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BigBang {
    private Contact con;
    private RepositoryContact rep;
    private Activity act1,act2;
    RepositoryActivity activityRep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryContactFile();

        rep = new RepositoryContactFile();
        RepositoryUser userRep = new RepositoryUserFile();
        activityRep = new RepositoryActivityFile(
                rep);
    }

    @Test
    public void testCase1()
    {
        try {
            con = new Contact("Monica", "strada Panselutei", "+12345","a@yahoo.com");
        } catch (InvalidFormatException e) {
            assertTrue(false);
        }
        //int n = rep.count();
        rep.addContact(con);
        for(Contact c : rep.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
        //assertTrue(n+1 == rep.count());
    }
    @Test
    public void testCase2() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : activityRep.getActivities())
                activityRep.removeActivity(a);

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
            activityRep.addActivity(act2);
            activityRep.addActivity(act1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(2 == activityRep.count());
    }
    @Test
    public void testCase3() {
        for (Activity act : activityRep.getActivities())
            activityRep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 - 1, 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3 - 1, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        activityRep.addActivity(act);

        c.set(2013, 3 - 1, 20);

        List<Activity> result = activityRep.activitiesOnDate("name1", c.getTime());
        assertTrue(result.size() == 1);
    }
    @Test
    public void testCase4() {
        try {
            con = new Contact("Monica", "strada Panselutei", "+12345","a@yahoo.com");
        } catch (InvalidFormatException e) {
            assertTrue(false);
        }
        //int n = rep.count();
        rep.addContact(con);
        for(Contact c : rep.getContacts())
            if (c.equals(con))
            {
                assertTrue(true);
                break;
            }
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : activityRep.getActivities())
                activityRep.removeActivity(a);

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
            activityRep.addActivity(act2);
            activityRep.addActivity(act1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(2 == activityRep.count());
        for (Activity act : activityRep.getActivities())
            activityRep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 - 1, 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3 - 1, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        activityRep.addActivity(act);

        c.set(2013, 3 - 1, 20);

        List<Activity> result = activityRep.activitiesOnDate("name1", c.getTime());
        assertTrue(result.size() == 1);
    }


}
