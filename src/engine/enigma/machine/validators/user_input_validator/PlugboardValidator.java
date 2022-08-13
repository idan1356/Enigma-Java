package engine.enigma.machine.validators.user_input_validator;

import engine.enigma.machine.validators.Validator;

import static java.util.Arrays.stream;

public class PlugboardValidator implements Validator {
    private static void isEven(String plugboard){
        if (plugboard.length() % 2 == 0)
            throw new RuntimeException("illegal plugboard mapping- length of string provided is odd");
    }

    private static void validatePlugboardInABC(String plugBoard ,String ABC){
        boolean res = stream(plugBoard.split("(?!^)")).allMatch(ABC::contains);
        if (!res){
            throw new RuntimeException("one of the letters provided in plug-board string is not a valid char in ABC");
        }
    }

    private static void validatePlugBoardMapping(String plugBoard ,String ABC){
        boolean[] ABCboard = new boolean[ABC.length()];

        for(char plug : plugBoard.toCharArray()) {
            if (!ABCboard[ABC.indexOf(plug)])
                ABCboard[ABC.indexOf(plug)] = true;
            else
                throw new RuntimeException(
                        String.format("Illegal plug-board mapping - character %c was mapped twice\n" +
                                "please enter a new plug-board mapping ",plug)
                );
        }
    }

    public static void validate(String plugBoard ,String ABC){
        validatePlugboardInABC(plugBoard, ABC);
        validatePlugBoardMapping(plugBoard, ABC);
    }
}




