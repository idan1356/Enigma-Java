package DTOeditor.DTO_enigma_editor;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaSpecs;
import DTOeditor.DTO_enigma_editor.components.EnigmaRotorsEditor;
import engine.machine.utils.RomanNumbers;

public class EnigmaEditor {
    private String plugBoardEditor(String plugBoard){
        StringBuilder plugBoardString = new StringBuilder("<");
        for(int i=0 ; i < plugBoard.length() ;i++)
        {
            char curChar = (i % 2 == 0) ? '|' : ',';
            plugBoardString.append(plugBoard.charAt(i));
            plugBoardString.append(curChar);
        }
        plugBoardString.setCharAt(plugBoardString.length() - 1, '>');
        return plugBoardString.toString();
    }

    private String reflectorEditor(RomanNumbers reflectorID) {
            return String.format("<%s>", reflectorID.toString());
    }

    public String getEnigmaSpecs(DTOEnigmaSpecs enigma){
        EnigmaRotorsEditor rotorsEditor = new EnigmaRotorsEditor();
        return rotorsEditor.rotorsToString(enigma.getRotorIDandNotch()) +
                reflectorEditor(enigma.getReflectorID()) + plugBoardEditor(enigma.getPlugBoard());
    }
}
