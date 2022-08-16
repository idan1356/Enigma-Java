package DTO.machine;

import DTO.machine.enigma.DTOEnigmaHistory;

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
