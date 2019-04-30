package agenda.test;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCase3BVA {
    private Contact con;
    private RepositoryContact rep;

    @Before
    public void setUp() throws Exception {
        rep = new RepositoryContactFile();
    }

    @Test
    public void testCase1() {
        try {
            con = new Contact("Ana", "strada Panselutei", "+", "a@yahoo.com");
            rep.addContact(con);
        } catch (InvalidFormatException e) {
            assertFalse(false);
        }
        //int n = rep.count();


        //assertTrue(n+1 == rep.count());
    }
}