package engine.enigma.machine.validators.file_validator.components_validator.reflectors_validator;

import engine.enigma.machine.validators.Validator;
import engine.enigma.generated.CTEReflector;
import engine.enigma.generated.CTEReflectors;
import utils.RomanNumbers;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReflectorsValidator implements Validator {

    private static void validateReflectorsOrder(CTEReflectors reflectors){
        //TODO: make less ugly
        List<CTEReflector> givenReflectors = reflectors.getCTEReflector();
        List<Integer> IDList = new LinkedList<>();
        givenReflectors.forEach(reflector -> {
            IDList.add(RomanNumbers.valueOf(reflector.getId()).value());
        });

        boolean isNaturallyOrdered = IDList.equals(IntStream.range(1, givenReflectors.size() + 1).boxed().collect(Collectors.toList()));
        if (!isNaturallyOrdered)
            throw new RuntimeException("invalid Reflector ID values- IDs are not in a natural order");
    }

    private static void validateReflectorsID(CTEReflectors reflectors) {
        reflectors.getCTEReflector().forEach(ReflectorValidator::validate);
    }

    public static void validate(CTEReflectors reflectors){
        validateReflectorsID(reflectors);
        validateReflectorsOrder(reflectors);
    }
}
