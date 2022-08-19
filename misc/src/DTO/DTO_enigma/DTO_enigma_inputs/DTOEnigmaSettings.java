package DTO.DTO_enigma.DTO_enigma_inputs;

import java.util.List;

public class DTOEnigmaSettings {
    List<Integer> rotorsChosen;
    int reflectorID;
    String plugboardString;
    String startingPositions;

    DTOEnigmaSettings(List<Integer> rotorsChosen, int reflectorID,
                      String plugboardString, String startingPositions){
        this.rotorsChosen = rotorsChosen;
        this.reflectorID = reflectorID;
        this.plugboardString = plugboardString;
        this.startingPositions = startingPositions;
    }

    public String getStartingPositions() {
        return startingPositions;
    }

    public String getPlugboardString() {
        return plugboardString;
    }

    public List<Integer> getRotorsChosen() {
        return rotorsChosen;
    }

    public int getReflectorID() {
        return reflectorID;
    }
}
