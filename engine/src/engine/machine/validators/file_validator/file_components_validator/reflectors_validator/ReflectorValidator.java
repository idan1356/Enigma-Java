package engine.machine.validators.file_validator.file_components_validator.reflectors_validator;

import engine.machine.validators.Validator;
import engine.machine.generated.CTEReflector;
import engine.machine.utils.RomanNumbers;

public class ReflectorValidator implements Validator {

    static private void validateID(CTEReflector reflector) {
        try {
            RomanNumbers.valueOf(reflector.getId());
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException("invalid Reflector ID value- not a legal roman number");
        }
    }
    static private void validateReflect(CTEReflector reflector){
        boolean mapToDiff = reflector.getCTEReflect()
                .stream()
                .allMatch(reflect -> reflect.getInput() != reflect.getOutput());
        if(!mapToDiff)
            throw new RuntimeException("illegal reflector mapping- input was mapped to same value in output");
    }
    static public void validate(CTEReflector reflect){
        validateID(reflect);
        validateReflect(reflect);
    }
}
