package engine.enigma.machine;

import engine.enigma.enigma_loader.settings.EnigmaSettings;
import engine.enigma.enigma_loader.settings.random.RandomSettings;
import engine.enigma.enigma_loader.validators.file_validator.FileValidator;
import engine.enigma.generated.CTEEnigma;
import engine.enigma.generated.CTEMachine;
import engine.enigma.machine.components.PlugBoard;
import engine.enigma.machine.components.Reflector;
import engine.enigma.machine.components.rotors.Rotors;
import utils.RomanNumbers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Enigma {
    String ABC;
    private Rotors rotors;
    private Reflector reflector;
    private PlugBoard plugboard;

    public Enigma(CTEEnigma generatedEnigma, List<Integer> rotorsChosen,
                  String reflectorID, String PlugboardString, String startingPositions){
        CTEMachine machine = generatedEnigma.getCTEMachine();
        ABC = machine.getABC().replaceAll("\\p{C}", "");
        rotors = new Rotors(machine.getCTERotors(), rotorsChosen, startingPositions);
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
        return message.toString();
    }

}
