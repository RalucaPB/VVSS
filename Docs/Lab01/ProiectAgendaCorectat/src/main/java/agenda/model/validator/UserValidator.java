package agenda.model.validator;

import agenda.model.base.User;

public class UserValidator implements Validator<User>{


    @Override
    public void validate(User user) throws ValidatorException {

     String errMsg="";
        if (user.getName().equals(""))
    errMsg+="Userul nu are nume";
        if (user.getUsername().equals(""))
    errMsg+="Userul nu are username";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
}
}