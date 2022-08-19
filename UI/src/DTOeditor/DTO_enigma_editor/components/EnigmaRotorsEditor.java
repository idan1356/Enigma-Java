package DTOeditor.DTO_enigma_editor.components;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaRotors;
import javafx.util.Pair;

public class EnigmaRotorsEditor {

    public String rotorsToString(DTOEnigmaRotors rotors){
        StringBuilder rotorsString = new StringBuilder("<");
        rotors.getRotors().forEach(rotor -> rotorsString.append(rotorToString(rotor)).append(","));
        rotorsString.setCharAt(rotorsString.length() - 1, '>');
        return rotorsString + "<" + rotors.getStartPosition() + ">";
    }

    private String rotorToString(Pair<Integer, Integer> rotor ){
        return String.format("%d(%d)", rotor.getKey(), rotor.getValue());
    }
}
