package engine.machine.components.enigma_factory;

import engine.machine.generated.*;
import engine.machine.components.enigma_factory.enigma.Enigma;
import engine.machine.components.enigma_factory.enigma_settings.EnigmaSettings;
import engine.machine.components.enigma_factory.enigma_settings.random.RandomSettings;
import engine.machine.components.enigma_factory.enigma.components.Reflector;
import engine.machine.components.enigma_factory.enigma.components.rotors.Rotor;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO: separate into EnigmaFactory and EnigmaPartsRepository
public class EnigmaFactory implements Serializable {
    private final List<Reflector> reflectors;
    private final List<Rotor> rotors;
    private final int rotorsUsedCount;
    private final String ABC;

    public EnigmaFactory(CTEMachine enigma) {
        ABC = enigma.getABC().trim().toUpperCase();
        rotors = copyRotors(enigma.getCTERotors());
        reflectors = copyReflectors(enigma.getCTEReflectors(), ABC);
        rotorsUsedCount = enigma.getRotorsCount();
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

    public Pair<Enigma, EnigmaSettings> getRandom(){
        EnigmaSettings randomSettings = RandomSettings.randomSettings(rotors, reflectors, ABC, rotorsUsedCount);
        return new Pair<>(new Enigma(randomSettings,rotors, reflectors, ABC), randomSettings);
    }

    public Enigma getEnigma(EnigmaSettings settings){
        return new Enigma(settings, rotors, reflectors, ABC);
    }
}


