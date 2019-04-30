package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCase2ECP {
    private Contact con;
    private RepositoryContact rep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryContactFile();
    }

    @Test
    public void testCase1()
    {
        try {
            con = new Contact("Marian", "strada Panselutei", "+12345","a@yahoo.com");
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


}