package machine.enigma.components;

import machine.enigma.generated.CTEPositioning;
import machine.enigma.generated.CTERotor;

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

    public Rotor(CTERotor rotor){
       notch = rotor.getNotch();
       offset = 0;
       ID = rotor.getId();
       left = new ArrayList<>();
       right = new ArrayList<>();

        for (CTEPositioning position : rotor.getCTEPositioning())
        {
            right.add(position.getRight());
            left.add(position.getLeft());
        }
    }

    public void step() {
        offset = (offset + 1) % left.size();
        if(offset == notch && next != null)
            next.step();
    }

    public String forward(String curChar){
        int index = right.indexOf(curChar);
        String out = left.get(index + offset);

        if(this.next != null)
            return this.next.forward(out);

        return out;
    }

    public String backward(String curChar){
        int index = left.indexOf(curChar);
        String out = right.get(index - offset);

        if(this.prev != null)
            return this.prev.backward(out);

        return out;
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
}