package engine.machine.validators.user_input_components_validator;

import engine.machine.validators.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PlugboardValidator implements Validator {
    private static void isEven(String plugboard){
        if (plugboard.length() % 2 == 0)
            throw new RuntimeException("illegal plugboard mapping- length of string provided is odd");
    }

    private static void validatePlugboardInABC(String plugBoard ,String ABC){
        // get list of all invalid characters if there are any
        List<String> invalidChars = stream(plugBoard.split("(?!^)"))
                .filter(chr -> !ABC.contains(chr))
                .collect(Collectors.toList());

        // turns list of strings into one big string with delimiter
        if (!invalidChars.isEmpty()){
            throw new RuntimeException(
                    String.format("Plugboard string contains characters not in ABC- %s",
                            String.join(", ", invalidChars)
                    )
            );
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




