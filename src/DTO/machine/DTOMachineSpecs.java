package DTO.machine;

import DTO.machine.enigma.DTOEnigmaSpecs;

public class DTOMachineSpecs {
    private final int rotorsGivenCount;
    private final int rotorsUsedCount;
    private final int reflectorsCount;
    private final int encodesCount;
    DTOEnigmaSpecs initialEnigmaSpecs;
    DTOEnigmaSpecs currentEnigmaSpecs;

    public DTOMachineSpecs(int rotorsGivenCount, int rotorsUsedCount, int reflectorsCount, int encodesCount,
        DTOEnigmaSpecs initialEnigmaSpecs, DTOEnigmaSpecs currentEnigmaSpecs){
        this.reflectorsCount = reflectorsCount;
        this.encodesCount = encodesCount;
        this.rotorsGivenCount = rotorsGivenCount;
        this.rotorsUsedCount = rotorsUsedCount;
        this.initialEnigmaSpecs = initialEnigmaSpecs;
        this.currentEnigmaSpecs = currentEnigmaSpecs;
    }

    public int getEncodesCount() {
        return encodesCount;
    }

    public int getReflectorsCount() {
        return reflectorsCount;
    }

    public int getRotorsGivenCount() {
        return rotorsGivenCount;
    }

    public int getRotorsUsedCount() {
        return rotorsUsedCount;
    }
}
