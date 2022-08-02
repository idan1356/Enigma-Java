package machine.enigma;

import machine.generated.CTEMachine;

public class Rotor implements Layer{
    int notch;
    int offset;
    int ID;
    char[] left;
    char[] right;

    public Rotor(CTEMachine machine){

    }

    @Override
    public char reverse() {
        return 0;
    }

    @Override
    public char step() {
        return 0;
    }
}
