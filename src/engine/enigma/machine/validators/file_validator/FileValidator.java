package engine.enigma.machine.validators.file_validator;

import engine.enigma.machine.validators.Validator;
import engine.enigma.machine.validators.file_validator.components_validator.reflectors_validator.ReflectorsValidator;
import engine.enigma.machine.enigma.generated.CTEMachine;
import engine.enigma.machine.validators.file_validator.components_validator.rotors_validator.RotorsValidator;

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
