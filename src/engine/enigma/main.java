package engine.enigma;

import engine.enigma.machine.Machine;
import engine.enigma.machine.enigma.Enigma;
import engine.enigma.machine.enigma_settings.EnigmaSettings;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws JAXBException, IOException {
        List<Integer> rotors =Arrays.asList(2, 1);
        String startingPos = "CC";
        int reflector = 1;
        String plugboard = "AF";

        EnigmaSettings settings = new EnigmaSettings(rotors, reflector, plugboard, startingPos);
        Machine machine = new Machine("src/resources/ex1-sanity-small.xml");
        Enigma enigma = machine.getEnigma(settings);
        System.out.println(enigma.encodeDecode("AABBCCDDEEFF"));
    }
}
