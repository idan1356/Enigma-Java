package engine.enigma.machine.enigma.components;

import engine.enigma.generated.CTEReflector;
import engine.enigma.generated.CTEReflectors;
import engine.enigma.machine.enigma_settings.random.RandomSettings;
import utils.RomanNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class Reflector {
    private final int[] reflector;
    private final RomanNumbers ID;

    public Reflector(CTEReflector cteReflector, int ABCSize){
        ID = RomanNumbers.valueOf(cteReflector.getId());
        reflector = new int[ABCSize];
        cteReflector.getCTEReflect().forEach(
                reflect-> {reflector[reflect.getInput() - 1] = reflect.getOutput() - 1;
                           reflector[reflect.getOutput() - 1] = reflect.getInput() - 1;
                });
    }

    public int forward(int input){
        return reflector[input];
    }

}
