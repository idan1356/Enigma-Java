package machine.enigma;

import machine.enigma.components.PlugBoard;
import machine.enigma.components.Reflector;
import machine.enigma.components.Rotors;
import machine.enigma.generated.CTEEnigma;
import machine.enigma.generated.CTEMachine;

import java.util.List;
import java.util.Map;

public class Enigma {
    String ABC;
    private Rotors rotors;
    private Reflector reflector;
    private PlugBoard plugboard;

    public Enigma(CTEEnigma enigma, List<Integer> rotorsChosen, String reflectorID, Map<String, String> plugboardMap){
        CTEMachine machine = enigma.getCTEMachine();
        ABC = machine.getABC();
        rotors = new Rotors(machine.getCTERotors(), rotorsChosen);
        reflector = new Reflector(machine.getCTEReflectors(), reflectorID, machine.getABC());
        plugboard = new PlugBoard(plugboardMap);
    }

    public String encodeDecode(String inputFromUser){
        String out, message = "";
        for (String curChar : inputFromUser.split("(?!^)")){
            out = plugboard.get(curChar);
            out = rotors.forward(out);
            out = reflector.forward(out);
            out = rotors.backward(out);
            out = plugboard.get(out);
            message.concat(out);
        }
        return message;
    }


    public static void main(String[] args) {


    }
}
