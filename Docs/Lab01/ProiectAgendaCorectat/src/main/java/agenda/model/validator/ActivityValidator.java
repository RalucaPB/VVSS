package agenda.model.validator;

import agenda.model.base.Activity;

import java.util.List;

public class ActivityValidator implements Validator<Activity> {



    @Override
    public void validate(Activity activity ) throws ValidatorException {
        String errMsg="";
        if (activity.getName().equals(""))
            errMsg+="Activitatea nu are nume";
        if (activity.getDescription().equals(""))
            errMsg+="Activitatea nu are descriere";
        if (activity.getDuration().equals(""))
            errMsg+="Durata nu poate fi goala!";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
    }

}