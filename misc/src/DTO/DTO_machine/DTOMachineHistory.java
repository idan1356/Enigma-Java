package DTO.DTO_machine;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaHistory;

import java.util.List;

public class DTOMachineHistory {
    private final List<DTOEnigmaHistory> enigmaHistories;

    public DTOMachineHistory(List<DTOEnigmaHistory> enigmaHistories){
        this.enigmaHistories = enigmaHistories;
    }

    public List<DTOEnigmaHistory> getEnigmaHistories() {
        return enigmaHistories;
    }
}
