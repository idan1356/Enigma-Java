package engine.enigma.machine.validators.user_input_validator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RotorsValidators {

    private static void validateRotorsIDinRange(List<Integer> rotorsChosen, int rotorsGivenCount) {
        boolean valid = rotorsChosen.stream().allMatch(rotor -> 1 <= rotor && rotor <= rotorsGivenCount);
        if (!valid)
            throw new RuntimeException("one of the rotors provided doesnt exist, please choose a valid set of rotors");

    }
    private static void validateNumOfRotors(List<Integer> rotorsChosen, int rotorsUsedCount){
        if(rotorsChosen.size()!=rotorsUsedCount)
            throw new RuntimeException(
                    String.format("invalid number of rotors given, please choose %d rotors", rotorsUsedCount));
    }

    private static void validateUniqueId(List<Integer> rotorsChosen){
        boolean res = rotorsChosen.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .allMatch(count -> count == 1);

        if (res)
            throw new RuntimeException("one of the rotor IDs given was not unique, please choose a valid set of rotors");

    }

    public static void validate(List<Integer> rotorsChosen, int rotorsGivenCount, int rotorsUsedCount){
        validateRotorsIDinRange(rotorsChosen, rotorsGivenCount);
        validateNumOfRotors(rotorsChosen, rotorsUsedCount);
        validateUniqueId(rotorsChosen);
    }
}
