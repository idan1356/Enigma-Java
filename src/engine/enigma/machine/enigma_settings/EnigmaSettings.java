package engine.enigma.machine.enigma_settings;

import engine.enigma.generated.CTEMachine;
import utils.RomanNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnigmaSettings {
    private List<Integer> rotorsChosen;
    private int reflectorID;
    private String PlugBoardString;
    private String startingPositions;

    public EnigmaSettings(List<Integer> rotorsChosen, int reflectorID, String PlugboardString, String startingPositions){
        this.rotorsChosen = rotorsChosen;
        this.reflectorID = reflectorID;
        this.PlugBoardString = PlugboardString.toUpperCase();
        this.startingPositions = startingPositions.toUpperCase();
    }
    public EnigmaSettings(){};

    public void setPlugBoardString(String plugboardString) {
        //validator
        PlugBoardString = plugboardString;
    }

    public void setReflectorID(int reflectorID) {
        //RomanNumbers romanNumber = RomanNumbers.intToRomanNumber(reflectorID);
        //validator
        this.reflectorID = reflectorID;
    }

    public void setStartingPositions(String startingPositions) {
        //validator
        this.startingPositions = startingPositions;
    }


    public void setRotorsChosen(String rotorsChosenString) {
        //split string by ',' and convert list of strings to list of integers
        List<Integer> rotorsChosen = Arrays.stream(rotorsChosenString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //validator
        this.rotorsChosen = rotorsChosen ;
    }

    public List<Integer> getRotorsChosen() {
        return rotorsChosen;
    }

    public String getPlugBoardString() {
        return PlugBoardString;
    }

    public int getReflectorID() {
        return reflectorID;
    }

    public String getStartingPositions() {
        return startingPositions;
    }
}





