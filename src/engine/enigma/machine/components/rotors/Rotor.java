package engine.enigma.machine.components.rotors;

import engine.enigma.generated.CTEPositioning;
import engine.enigma.generated.CTERotor;

import java.util.ArrayList;
import java.util.List;

public class Rotor {
    int notch;
    int offset;
    int ID;
    List<String> left;
    List<String> right;
    Rotor next;
    Rotor prev;

    public Rotor(CTERotor rotor , char startPosition){
       notch = rotor.getNotch();
       ID = rotor.getId();
       left = new ArrayList<>();
       right = new ArrayList<>();

        for (CTEPositioning position : rotor.getCTEPositioning()) {
            right.add(position.getRight());
            left.add(position.getLeft());
        }

        offset = right.indexOf(String.valueOf(startPosition));
    }

    public void step() {
        offset = (offset + 1) % left.size();

        if(offset == notch - 1 && next != null)
            next.step();
    }

    public int forward(int input){
        int index = (input + offset) % left.size();
        String curChar = right.get(index);
        int leftInd = Math.floorMod(left.indexOf(curChar) - offset, left.size());

        if(this.next != null)
            return this.next.forward(leftInd);

        return leftInd;
    }

    public int backward(int input){
        int index = Math.floorMod(input + offset, left.size());
        String curChar = left.get(index);
        int rightInd = Math.floorMod(right.indexOf(curChar) - offset, right.size());

        if(this.prev != null)
            return this.prev.backward(rightInd);

        return rightInd;
    }

    public void setNext(Rotor next) {
        this.next = next;
    }

    public void setPrev(Rotor prev) {
        this.prev = prev;
    }
}