package machine.enigma;

import machine.enigma.components.PlugBoard;
import machine.enigma.components.Reflector;
import machine.enigma.components.Rotors;
import machine.enigma.generated.CTEEnigma;
import machine.enigma.generated.CTEMachine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Enigma {
    String ABC;
    private Rotors rotors;
    private Reflector reflector;
    private PlugBoard plugboard;

    public Enigma(CTEEnigma enigma, List<Integer> rotorsChosen,
                  String reflectorID,String PlugboardString, String startingPositions){
        CTEMachine machine = enigma.getCTEMachine();
        ABC = machine.getABC();
        rotors = new Rotors(machine.getCTERotors(), rotorsChosen);
        reflector = new Reflector(machine.getCTEReflectors(), reflectorID, machine.getABC());
        plugboard = new PlugBoard(PlugboardString, ABC);
    }

    public String encodeDecode(String inputFromUser){
        int out;
        StringBuilder message = new StringBuilder();
        for (String curChar : inputFromUser.split("(?!^)")){
            out = ABC.indexOf(curChar);

            out = plugboard.get(out);
            out = rotors.forward(out);
            out = reflector.forward(out);
            out = rotors.backward(out);
            out = plugboard.get(out);

            message.append(ABC.charAt(out));
        }
        return message;
    }
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "machine.enigma.generated";


    public static void main(String[] args) {


    }

    public static CTEEnigma deserializeFrom(InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }
}
