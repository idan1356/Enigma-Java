package engine.enigma.machine;

import engine.enigma.generated.*;
import engine.enigma.machine.enigma.Enigma;
import engine.enigma.machine.enigma_settings.EnigmaSettings;
import engine.enigma.machine.enigma_settings.random.RandomSettings;
import engine.enigma.machine.validators.file_validator.FileValidator;
import engine.enigma.machine.enigma.components.Reflector;
import engine.enigma.machine.enigma.components.rotors.Rotor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Machine {
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "engine.enigma.generated";
    private final List<Reflector> reflectors;
    private final List<Rotor> rotors;
    private final int rotorsUsedCount;
    private final String ABC;

    public Machine(String XMLFilePath) throws JAXBException, IOException {
        InputStream inputStream = Files.newInputStream(new File(XMLFilePath).toPath());
        CTEMachine enigma = deserializeFrom(inputStream).getCTEMachine();

        FileValidator.validate(enigma);
        ABC = enigma.getABC().trim().toUpperCase();
        rotors = copyRotors(enigma.getCTERotors());
        reflectors = copyReflectors(enigma.getCTEReflectors(), ABC);
        rotorsUsedCount = enigma.getRotorsCount();
    }

    private static CTEEnigma deserializeFrom (InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }

    private List<Reflector> copyReflectors(CTEReflectors cteReflectors, String ABC){
        List<Reflector> reflectorList = new ArrayList<>();
        cteReflectors.getCTEReflector().forEach(
                    cteReflector -> reflectorList.add(new Reflector(cteReflector, ABC.length())
                    ));
        return reflectorList;
    }

    private List<Rotor> copyRotors(CTERotors cteRotors){
        List<Rotor> rotorList = new ArrayList<>();
        cteRotors.getCTERotor().forEach(rotor -> rotorList.add(new Rotor(rotor)));
        return rotorList;
    }

    public Enigma getRandom(){
        EnigmaSettings randomSettings = RandomSettings.randomSettings(rotors, reflectors, ABC, rotorsUsedCount);
        return new Enigma(randomSettings,rotors, reflectors, ABC);
    }
    public Enigma getEnigma(EnigmaSettings settings){
        return new Enigma(settings, rotors, reflectors, ABC);
    }
}

