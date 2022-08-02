package machine.enigma;

import machine.generated.CTEMachine;

public class Rotor {
    int notch;
    int offset;
    int ID;
    char[] left;
    char[] right;

    public Rotor(CTEMachine machine){

    }

    @Override
    public char step() {
        return 0;
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
        return right.get(index + offset);
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