package agenda.model.validator;


public interface Validator<T> {

    void validate (T e ) throws ValidatorException;

}