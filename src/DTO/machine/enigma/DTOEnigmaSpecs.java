package DTO.machine.enigma;

import javafx.util.Pair;
import utils.RomanNumbers;

import java.util.List;

public class DTOEnigmaSpecs {
    private final DTOEnigmaRotors rotorIDandNotch;
    private final String initialPosition;
    private final String plugBoard;
    private final RomanNumbers reflectorID;

    public DTOEnigmaSpecs(DTOEnigmaRotors rotors,
                          String initialPosition, String plugboard, RomanNumbers reflectorID){
        this.rotorIDandNotch = rotors;
        this.initialPosition = initialPosition;
        this.plugBoard = plugboard;
        this.reflectorID = reflectorID;
    }

    public DTOEnigmaRotors getRotorIDandNotch() {
        return rotorIDandNotch;
    }

    public RomanNumbers getReflectorID() {
        return reflectorID;
    }

    public String getInitialPosition() {
        return initialPosition;
    }

    public String getPlugBoard() {
        return plugBoard;
    }
}
