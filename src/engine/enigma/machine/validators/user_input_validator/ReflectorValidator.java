package engine.enigma.machine.validators.user_input_validator;

import engine.enigma.machine.validators.Validator;

public class ReflectorValidator implements Validator {

   private static void rangeValidate(int reflectorID, int reflectorNum){
        if( 1 > reflectorID || reflectorID > reflectorNum)
            throw new RuntimeException(
                    String.format("Invalid reflector ID provided, choose a number between 1-%d", reflectorNum));
    }
}
