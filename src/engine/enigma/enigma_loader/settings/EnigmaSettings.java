package engine.enigma.enigma_loader.settings;

import engine.enigma.generated.CTEEnigma;
import engine.enigma.generated.CTEMachine;
import utils.RomanNumbers;

import java.util.List;

public class EnigmaSettings {
    private final CTEMachine generatedEnigma;
    private final List<Integer> rotorsChosen;
    private final RomanNumbers reflectorID;
    private final String PlugboardString;
    private final String startingPositions;

    public EnigmaSettings(CTEMachine generatedEnigma, List<Integer> rotorsChosen,
                          RomanNumbers reflectorID, String PlugboardString, String startingPositions){
        this.generatedEnigma = generatedEnigma;
        this.rotorsChosen = rotorsChosen;
        this.reflectorID = reflectorID;
        this.PlugboardString = PlugboardString;
        this.startingPositions = startingPositions;
    }

    public CTEMachine getGeneratedEnigma() {
        return generatedEnigma;
    }

    public List<Integer> getRotorsChosen() {
        return rotorsChosen;
    }

    public String getPlugboardString() {
        return PlugboardString;
    }

    public RomanNumbers getReflectorID() {
        return reflectorID;
    }

    public String getStartingPositions() {
        return startingPositions;
    }
}





