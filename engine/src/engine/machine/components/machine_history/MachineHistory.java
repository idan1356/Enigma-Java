package engine.machine.components.machine_history;

import DTO.DTO_machine.DTOMachineHistory;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaHistory;
import engine.machine.components.enigma_factory.enigma.Enigma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MachineHistory implements Serializable {
    List<Enigma> enigmaList;

    public MachineHistory(){
        enigmaList = new LinkedList<>();
    }

    public void addEnigma(Enigma enigma){
        enigmaList.add(enigma);
    }

    public DTOMachineHistory getHistory(){
        List<DTOEnigmaHistory> enigmaHistAndStats = new ArrayList<>();
        enigmaList.forEach(enigma -> enigmaHistAndStats.add(enigma.getEncodingHistory()));
        return new DTOMachineHistory(enigmaHistAndStats);
    }
}
