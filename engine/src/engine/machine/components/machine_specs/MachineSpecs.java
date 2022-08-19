package engine.machine.components.machine_specs;

import DTO.DTO_machine.DTOMachineSpecs;
import engine.machine.generated.CTEMachine;

import java.io.Serializable;

public class MachineSpecs implements Serializable {
    private final int rotorsGivenCount;
    private final int rotorsUsedCount;
    private final int reflectorsGivenCount;
    private final String ABC;
    private int encodesCount;

    public MachineSpecs(CTEMachine machine){
        this.rotorsGivenCount = machine.getCTERotors().getCTERotor().size();
        this.rotorsUsedCount = machine.getRotorsCount();
        this.reflectorsGivenCount = machine.getCTEReflectors().getCTEReflector().size();
        this.ABC = machine.getABC().trim();
        this.encodesCount = 0;
    }

    public void increaseEncodeCount(){
        encodesCount++;
    }

    public DTOMachineSpecs getSpecs(){
        return new DTOMachineSpecs(rotorsGivenCount, rotorsUsedCount, reflectorsGivenCount,
                encodesCount, ABC);
    }
}
