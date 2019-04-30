package agenda.model.repository.classes;

import agenda.model.base.Activity;
import agenda.model.repository.interfaces.RepositoryActivity;
import agenda.model.repository.interfaces.RepositoryContact;
import agenda.model.repository.interfaces.RepositoryUser;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class RepositoryActivityFileTest {


    private Activity act, act1, act2, act3, act4;
    private RepositoryActivity rep;
    RepositoryActivity activityRep;
    RepositoryActivityFile repoF;
    @Before
    public void setUp() throws Exception {
        rep = new RepositoryActivityMock();

        RepositoryContact contactRep = new RepositoryContactFile();
        RepositoryUser userRep = new RepositoryUserFile();
        activityRep = new RepositoryActivityFile(
                contactRep);
        repoF = new RepositoryActivityFile(contactRep);

    }


    @Test
    public void testCase1() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : repoF.getActivities())
                repoF.removeActivity(a);

            act = new Activity("Activity",
                    df.parse("03/04/2002 15:50"),
                    df.parse("03/04/2002 14:50"),
                    null,
                    "Lunch break");
            repoF.addActivity(act);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(0 == repoF.count());
    }


    @Test
    public void testCase2() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : repoF.getActivities())
                repoF.removeActivity(a);

            act1 = new Activity("Activity",
                    df.parse("03/04/2002 14:00"),
                    df.parse("03/04/2002 15:00"),
                    null,
                    "Lunch break");
            repoF.addActivity(act1);
            act2 = new Activity("Activity",
                    df.parse("03/04/2002 12:00"),
                    df.parse("03/04/2002 14:30"),
                    null,
                    "Lunch break");
            repoF.addActivity(act2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(1 == repoF.count());
    }

    @Test
    public void testCase3() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : repoF.getActivities())
                repoF.removeActivity(a);

            act3 = new Activity("Activity",
                    df.parse("03/04/2002 10:00"),
                    df.parse("03/04/2002 12:30"),
                    null,
                    "Lunch break");

            act4 = new Activity("Activity",
                    df.parse("03/04/2002 14:00"),
                    df.parse("03/04/2002 15:00"),
                    null,
                    "Lunch break");
            repoF.addActivity(act4);
            repoF.addActivity(act3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(2 == repoF.count());
    }

}