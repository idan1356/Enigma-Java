package machine.enigma.components;

import machine.enigma.generated.*;
import java.util.*;
import java.util.stream.Collectors;

public class Reflector {
    int[] reflector;

    public Reflector(CTEReflectors reflectors, String reflectorID, String ABC){
        ABC = ABC.replaceAll("\\p{C}", "");
        reflector = new int[ABC.length()];

        //TODO: find a way to directly fetch index without creating list
        CTEReflector chosenReflector = reflectors.getCTEReflector().stream()
                .filter(reflector -> Objects.equals(reflector.getId(), reflectorID))
                .collect(Collectors.toList()).get(0);

        chosenReflector.getCTEReflect().forEach(
                reflect-> {reflector[reflect.getInput() - 1] = reflect.getOutput() - 1;
                           reflector[reflect.getOutput() - 1] = reflect.getInput() - 1;
                });
    }

    public int forward(int input){
        return reflector[input];
    }

}
