package engine.machine.components.enigma_factory.enigma.components;

import engine.machine.generated.CTEReflector;
import engine.machine.utils.RomanNumbers;

import java.io.Serializable;

public class Reflector implements Serializable {
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

    public RomanNumbers getID() {
        return ID;
    }
}
