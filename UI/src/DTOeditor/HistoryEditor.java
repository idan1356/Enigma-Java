package DTOeditor;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaHistory;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;
import DTO.DTO_machine.DTOMachineHistory;
import DTOeditor.DTO_enigma_editor.EnigmaEditor;

public class HistoryEditor {

    public void machineHistory(DTOMachineHistory history){
        history.getEnigmaHistories().forEach(this::enigmaHistory);
    }

    public void enigmaHistory(DTOEnigmaHistory enigmaHistory) {
        EnigmaEditor editor = new EnigmaEditor();
        System.out.println("Machine:");
        System.out.println("\t" + editor.getEnigmaSpecs(enigmaHistory.getSpecs()));
        System.out.println("Inputs Processed:");
        enigmaHistory.getEncodings().forEach(this::printEncoding);
        System.out.println("");
    }

    public void printEncoding(DTOencodeDecode cur){
        System.out.printf("\t<%s> --> <%s> (%d nano-seconds)%n",
                cur.getInput(), cur.getOutput(), cur.getNanoSec());
    }
}

