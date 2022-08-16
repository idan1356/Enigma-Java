package DTO.machine.enigma;

import javafx.util.Pair;

import java.util.List;

public class DTOEnigmaRotors {
    private final List<Pair<Integer, Integer>> rotors;

    public DTOEnigmaRotors(List<Pair<Integer, Integer>> rotors){
        this.rotors = rotors;
    }
    public List<Pair<Integer, Integer>> getRotors() {
        return rotors;
    }
}
