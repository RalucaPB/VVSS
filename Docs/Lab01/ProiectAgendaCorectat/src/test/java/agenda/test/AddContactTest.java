package agenda.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import agenda.exceptions.InvalidFormatException;

import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.RepositoryContact;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryContactMock();
	}
	
	@Test
	public void testCase1()
	{
		try {
			con = new Contact("Monica", "strada Panselutei", "+12345","a@yahoo.com");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		//int n = rep.count();

		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertTrue(true);
				break;
			}
		//assertTrue(n+1 == rep.count());
	}
	
	@Test
	public void testCase2()
	{

		try {
			con = new Contact("Dan", "strada Panselutei", "+12345","a@yahoo.com");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		//int n = rep.count();

		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertTrue(true);
				break;
			}
	}
	
	@Test
	public void testCase3()
	{
		try {
			con = new Contact("Monica", "strada Panselutei", "12345","a@yahoo.com");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertFalse(false);
		}

		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertFalse(true);
				break;
			}
	}

	@Test
	public void testCase4()
	{
		try {
			con = new Contact("Ed", "strada Panselutei", "12345", "a@yahoo.com");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertFalse(false);
		}
		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertFalse(true);
				break;
			}
	}



}
