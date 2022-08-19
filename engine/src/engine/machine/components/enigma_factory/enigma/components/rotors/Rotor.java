package engine.machine.components.enigma_factory.enigma.components.rotors;

import engine.machine.generated.CTEPositioning;
import engine.machine.generated.CTERotor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rotor implements Serializable {
    private final int notch;
    private int offset;
    private final int ID;
    private final List<String> left;
    private final List<String> right;
    private Rotor next;
    private Rotor prev;

    public Rotor(CTERotor rotor){
        notch = rotor.getNotch();
        ID = rotor.getId();
        left = new ArrayList<>();
        right = new ArrayList<>();
        offset = 0;

        for (CTEPositioning position : rotor.getCTEPositioning()) {
            right.add(position.getRight());
            left.add(position.getLeft());
        }
    }

    //TODO: what?
    public Rotor(Rotor rotor){
        this.notch =rotor.notch;
        this.offset=0;
        this.ID=rotor.ID;
        this.left=rotor.left;
        this.right=rotor.right;
        this.prev=null;
        this.next=null;
    }

    public void setPosition(char startPosition){
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

        if(next != null)
            return next.forward(leftInd);

        return leftInd;
    }

    public int backward(int input){
        int index = Math.floorMod(input + offset, left.size());
        String curChar = left.get(index);
        int rightInd = Math.floorMod(right.indexOf(curChar) - offset, right.size());

        if(prev != null)
            return prev.backward(rightInd);

        return rightInd;
    }

    public void setNext(Rotor next) {
        this.next = next;
    }

    public void setPrev(Rotor prev) {
        this.prev = prev;
    }

    public int getID() {
        return ID;
    }

    public int getNotch() {
        return notch;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize(){
        return right.size();
    }


}
