package agenda.model.validator;

import agenda.model.base.Contact;

public class ContactValidator implements Validator<Contact>{



    @Override
    public void validate(Contact contact) throws ValidatorException {
        String errMsg="";
        if (contact.getName().equals(""))
            errMsg+="Contactul nu are nume";
        if (contact.getAddress().equals(""))
            errMsg+="Contactul nu are adresa";
        if (contact.getTelefon().equals(""))
            errMsg+="Contactul nu are nr de telefon";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
    }

}