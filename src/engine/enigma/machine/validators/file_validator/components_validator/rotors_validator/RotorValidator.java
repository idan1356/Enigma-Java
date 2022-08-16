package engine.enigma.machine.validators.file_validator.components_validator.rotors_validator;
import engine.enigma.machine.validators.Validator;
import engine.enigma.machine.enigma.generated.CTERotor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RotorValidator implements Validator {

    private static void validateRotorMapping(CTERotor rotor, String ABC) {
        List<String>  left = new ArrayList<>();
        List<String> right = new ArrayList<>();;
        rotor.getCTEPositioning().forEach(ctePositioning -> {
          right.add(ctePositioning.getRight());
          left.add(ctePositioning.getLeft());
        });

        if(!(isMappingLegal(right) && isMappingLegal(left))){
            throw (new RuntimeException(String.format("illegal rotor mapping for rotor %d", rotor.getId())));
        }
    }

    // checks whether each letter appears just once in list
    private static boolean isMappingLegal(List<String> positionList){
        return  positionList.stream().collect(Collectors.groupingBy(s -> s))
                .values().stream().allMatch(s -> s.size() == 1);
    }

    private static void validateNotch(CTERotor rotor, String ABC) {
        int ABCLength = ABC.replaceAll("\\p{C}", "").length();
        if (rotor.getNotch() > ABCLength)
            throw (new RuntimeException(String.format("illegal notch positioning for rotor %d", rotor.getId())));
    }

    public static void validate(CTERotor rotor, String ABC) {
        validateRotorMapping(rotor,ABC);
        validateNotch(rotor,ABC);
    }
}
