package agenda.model.repository.classes;

import java.util.LinkedList;
import java.util.List;

import agenda.model.base.Contact;
import agenda.model.repository.interfaces.RepositoryContact;
import agenda.exceptions.InvalidFormatException;
import agenda.model.validator.ContactValidator;
import agenda.model.validator.ValidatorException;

public class RepositoryContactMock implements RepositoryContact {

private List<Contact> contacts;
private ContactValidator validator;
	
	public RepositoryContactMock() {
		contacts = new LinkedList<Contact>();
		try {
			Contact c = new Contact("Monica", "str. Panselutelor", "+4071122334455","monica@gmail.com");
			contacts.add(c);
			c = new Contact("Marian", "str. Rovinelor", "+4071122334466", "marian@gmail.com");
			contacts.add(c);
			c = new Contact("Edi", "str Marea Unire", "+4071122338866", "ed@yahoo.com");
			contacts.add(c);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> getContacts() {
		return new LinkedList<Contact>(contacts);
	}

	@Override
	public void addContact(Contact contact) {
		/*try {
			validator.validate(contact);
		} catch (ValidatorException e) {
			e.printStackTrace();
		}
*/
		contacts.add(contact);
	}

	@Override
	public boolean removeContact(Contact contact) {
		int index = contacts.indexOf(contact);
		if (index < 0) return false;
		else contacts.remove(index);
		return true;
	}

	@Override
	public boolean saveContracts() {
		return true;
	}

	@Override
	public int count() {
		return contacts.size();
	}

	@Override
	public Contact getByName(String string) {
		for(Contact c : contacts)
			if (c.getName().equals(string)) return c;
		return null;
	}
	
}
