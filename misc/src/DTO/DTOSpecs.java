package DTO;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaSpecs;
import DTO.DTO_machine.DTOMachineSpecs;

public class DTOSpecs {
    DTOMachineSpecs machineSpecs;
    DTOEnigmaSpecs curEnigmaSpecs;
    DTOEnigmaSpecs initialEnigmaSpecs;

    public DTOSpecs(DTOMachineSpecs machineSpecs, DTOEnigmaSpecs curEnigmaSpecs, DTOEnigmaSpecs initialEnigmaSpecs){
        this.machineSpecs = machineSpecs;
        this.curEnigmaSpecs = curEnigmaSpecs;
        this.initialEnigmaSpecs = initialEnigmaSpecs;
    }

    public DTOEnigmaSpecs getCurEnigmaSpecs() {
        return curEnigmaSpecs;
    }

    public DTOEnigmaSpecs getInitialEnigmaSpecs() {
        return initialEnigmaSpecs;
    }

    public DTOMachineSpecs getMachineSpecs() {
        return machineSpecs;
    }
}
