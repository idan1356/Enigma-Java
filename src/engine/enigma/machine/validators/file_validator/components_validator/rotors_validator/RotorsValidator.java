package engine.enigma.machine.validators.file_validator.components_validator.rotors_validator;

import engine.enigma.machine.validators.Validator;
import engine.enigma.machine.enigma.generated.CTEMachine;
import engine.enigma.machine.enigma.generated.CTERotor;

import java.util.Comparator;
import java.util.List;

public class RotorsValidator implements Validator {

    private static void validateRotorsCount(CTEMachine machine){
        int usedRotorsCount = machine.getRotorsCount();
        int givenRotorsCount = machine.getCTERotors().getCTERotor().size();
        if( usedRotorsCount > givenRotorsCount || usedRotorsCount < 2)
            throw (new RuntimeException("Not enough rotors to use"));
    }

    private static void validateRotorsID(CTEMachine machine){
        List<CTERotor> givenRotors = machine.getCTERotors().getCTERotor();
        givenRotors.sort(Comparator.comparing(CTERotor::getId));

        //TODO: maybe change
        int curID = 1;
        for(CTERotor rotor : givenRotors){
            if (rotor.getId() != curID)
                throw (new RuntimeException("Rotor IDs are not unique or not naturally ordered"));
            curID++;
        }
    }

    private static void validateRotors(CTEMachine machine){
        machine.getCTERotors().getCTERotor().forEach(
                (cteRotor -> RotorValidator.validate(cteRotor, machine.getABC())));

    }

    public static void validate(CTEMachine machine){
        validateRotorsCount(machine);
        validateRotorsID(machine);
        validateRotors(machine);
    }

}
