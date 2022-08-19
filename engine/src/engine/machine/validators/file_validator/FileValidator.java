package engine.machine.validators.file_validator;

import engine.machine.validators.Validator;
import engine.machine.validators.file_validator.file_components_validator.reflectors_validator.ReflectorsValidator;
import engine.machine.generated.CTEMachine;
import engine.machine.validators.file_validator.file_components_validator.rotors_validator.RotorsValidator;

public class FileValidator implements Validator {

    public static void validate(CTEMachine machine) {
            validateABC(machine);
            ReflectorsValidator.validate(machine.getCTEReflectors());
            RotorsValidator.validate(machine);
    }
    private static void validateABC(CTEMachine machine){
        int ABCLength = machine.getABC().replaceAll("\\p{C}", "").length();
        if (ABCLength % 2 != 0)
            throw (new RuntimeException("ABC given is odd"));
    }
}
