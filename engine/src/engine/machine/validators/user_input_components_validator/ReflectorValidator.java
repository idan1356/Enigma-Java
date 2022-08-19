package engine.machine.validators.user_input_components_validator;

import engine.machine.validators.Validator;

public class ReflectorValidator implements Validator {

   private static void rangeValidate(int reflectorID, int reflectorNum){
        if( 1 > reflectorID || reflectorID > reflectorNum)
            throw new RuntimeException(
                    String.format("Invalid reflector ID provided, choose a number between 1-%d", reflectorNum));
    }

//TODO check size of reflectors- ABC/2
    public static void validate(int reflectorID, int reflectorNum){
       rangeValidate(reflectorID, reflectorNum);
    }
}
