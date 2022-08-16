package engine.enigma.machine.enigma.components.rotors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Rotors {
    private final List<Rotor> rotorList = new LinkedList<>();
    private final String startPosition;
    public Rotors(List<Rotor> rotors, List<Integer> rotorsChosen,String startPosition)
    {
        //TODO: change code so no reverse needed
        Collections.reverse(rotorsChosen);

        Rotor tail = null;
        for (Integer curRotorID : rotorsChosen){

            Rotor curRotor = new Rotor(rotors.get(curRotorID - 1));
            curRotor.setPrev(tail);

            if (tail != null) {
                tail.setNext(curRotor);
            }

            tail = curRotor;
            rotorList.add(curRotor);
        }
    }

    public void setPosition(String positionString){
        for(int i = 0; i < rotorList.size(); i++){
            rotorList.get(i).setPosition(positionString.charAt(i));
        }
    }

    public int forward(int input){
        rotorList.get(0).step();
        return rotorList.get(0).forward(input);
    }

    public int backward(int input){
        return rotorList.get(rotorList.size() - 1).backward(input);
    }

}


