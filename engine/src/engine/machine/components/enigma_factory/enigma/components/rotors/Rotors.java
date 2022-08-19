package engine.machine.components.enigma_factory.enigma.components.rotors;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaRotors;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Rotors implements Serializable {
    private final List<Rotor> rotorList = new LinkedList<>();
    private final String startPosition;
    public Rotors(List<Rotor> rotors, List<Integer> rotorsChosen,String startPosition) {
        //TODO: change code so no reverse needed
        List<Integer> rotorsChosenReversed = new ArrayList<>(rotorsChosen);
        Collections.reverse(rotorsChosenReversed);
        this.startPosition = startPosition;
        Rotor tail = null;
        for (Integer curRotorID : rotorsChosenReversed){
            Rotor curRotor = new Rotor(rotors.get(curRotorID - 1));
            curRotor.setPrev(tail);

            if (tail != null)
                tail.setNext(curRotor);

            tail = curRotor;
            rotorList.add(curRotor);
        }
        resetPosition();
    }

    public void resetPosition(){
        for(int i = 0; i < rotorList.size(); i++){
            rotorList.get(i).setPosition(startPosition.charAt(i));
        }
    }

    public int forward(int input){
        rotorList.get(0).step();
        return rotorList.get(0).forward(input);
    }

    public int backward(int input){
        return rotorList.get(rotorList.size() - 1).backward(input);
    }
    public DTOEnigmaRotors rotorsListDTO() {
        List<Pair<Integer, Integer>> rotors = new ArrayList<>();

        rotorList.forEach(rotor -> {
            int distance = Math.floorMod(rotor.getOffset()- rotor.getNotch(),rotor.getSize());
            Pair<Integer, Integer> curPair = new Pair<>(rotor.getID(), distance);
            rotors.add(curPair);
        });

        Collections.reverse(rotors);
        return new DTOEnigmaRotors(rotors, startPosition);
    }

    public String getStartPosition() {
        return startPosition;
    }
}


