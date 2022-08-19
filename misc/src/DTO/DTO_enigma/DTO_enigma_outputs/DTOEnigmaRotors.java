package DTO.DTO_enigma.DTO_enigma_outputs;

import javafx.util.Pair;

import java.util.List;

public class DTOEnigmaRotors {
    private final String startPosition;
    private final List<Pair<Integer, Integer>> rotors;
    // < rotorID,distance of notch per rotor size>
    public DTOEnigmaRotors(List<Pair<Integer, Integer>> rotors, String startPosition){
        this.rotors = rotors;
        this.startPosition = startPosition;
    }
    public List<Pair<Integer, Integer>> getRotors() {
        return rotors;
    }

    public String getStartPosition() {
        return startPosition;
    }
}
