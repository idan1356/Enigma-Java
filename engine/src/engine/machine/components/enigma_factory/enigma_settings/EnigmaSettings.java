package engine.machine.components.enigma_factory.enigma_settings;
import engine.machine.validators.user_input_components_validator.StartPositionValidator;
import engine.machine.validators.user_input_components_validator.PlugboardValidator;
import engine.machine.validators.user_input_components_validator.ReflectorValidator;
import engine.machine.validators.user_input_components_validator.RotorsValidators;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnigmaSettings implements Serializable {
    private List<Integer> rotorsChosen;
    private int reflectorID;
    private String PlugBoardString;
    private String startingPositions;

    public EnigmaSettings(){};
    public EnigmaSettings(List<Integer> rotorsChosen, int reflectorID,
                          String PlugboardString, String startingPositions){
        this.rotorsChosen = rotorsChosen;
        this.reflectorID = reflectorID;
        this.PlugBoardString = PlugboardString.toUpperCase();
        this.startingPositions = startingPositions.toUpperCase();
    }

    public void setPlugBoardString(String plugboardString, String ABC) {
        PlugboardValidator.validate(plugboardString, ABC);
        PlugBoardString = plugboardString;
    }

    public void setReflectorID(int reflectorID, int givenReflectorsCount) {
        ReflectorValidator.validate(reflectorID, givenReflectorsCount);
        this.reflectorID = reflectorID;
    }

    public void setStartingPositions(String startingPositions) {
        //validator
        this.startingPositions = startingPositions;
    }

    public void setRotorsChosen(String rotorsChosenString, int rotorsGivenCount, int rotorsUsedCount) {
        //split string by ',' and convert list of strings to list of integers
        List<Integer> rotorsChosen = Arrays.stream(rotorsChosenString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        RotorsValidators.validate(rotorsChosen, rotorsGivenCount, rotorsUsedCount);
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





