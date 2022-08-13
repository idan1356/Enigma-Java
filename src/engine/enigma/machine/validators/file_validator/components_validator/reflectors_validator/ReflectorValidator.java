package engine.enigma.machine.validators.file_validator.components_validator.reflectors_validator;

import engine.enigma.machine.validators.Validator;
import engine.enigma.generated.CTEReflector;
import utils.RomanNumbers;

public class ReflectorValidator implements Validator {

    static private void validateID(CTEReflector reflector) {
        try {
            RomanNumbers.valueOf(reflector.getId());
        } catch (IllegalArgumentException exception) {
            throw new RuntimeException("invalid Reflector ID value- not a legal roman number");
        }
    }
    static private void validateReflect(CTEReflector reflector){
        boolean legal = reflector.getCTEReflect()
                .stream()
                .allMatch(reflect -> reflect.getInput() != reflect.getOutput());
        if(!legal)
            throw new RuntimeException("illegal reflector mapping- input was mapped to same value in output");
    }
    static public void validate(CTEReflector reflect){
        validateID(reflect);
        validateReflect(reflect);
    }
}
