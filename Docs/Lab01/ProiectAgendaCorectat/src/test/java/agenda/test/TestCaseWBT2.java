package agenda.test;


import agenda.model.base.Activity;
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

import static org.junit.Assert.assertTrue;

public class TestCaseWBT2 {
    private Activity act1,act2;
    private RepositoryActivity rep;
    RepositoryActivity activityRep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryActivityMock();

        RepositoryContact contactRep = new RepositoryContactFile();
        RepositoryUser userRep = new RepositoryUserFile();
        activityRep = new RepositoryActivityFile(
                contactRep);

    }


    @Test
    public void testCase1() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            for (Activity a : activityRep.getActivities())
                activityRep.removeActivity(a);

            act1 = new Activity("Activity",
                    df.parse("03/04/2002 14:00"),
                    df.parse("03/04/2002 15:00"),
                    null,
                    "Lunch break");
            activityRep.addActivity(act1);
            act2 = new Activity("Activity",
                    df.parse("03/04/2002 12:00"),
                    df.parse("03/04/2002 14:30"),
                    null,
                    "Lunch break");
            activityRep.addActivity(act2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(1 == activityRep.count());
    }
}