package DTOeditor;
import DTO.DTOSpecs;
import DTO.DTO_machine.DTOMachineSpecs;
import DTOeditor.DTO_enigma_editor.EnigmaEditor;

public class SpecsEditor {

    public void specs(DTOSpecs specs) {
        EnigmaEditor enigma = new EnigmaEditor();
        System.out.println("Machine Specs:");
        machineSpecs(specs.getMachineSpecs());

        if (specs.getInitialEnigmaSpecs() != null) {
            System.out.println("Initial Enigma Specs:");
            System.out.println("\t" + enigma.getEnigmaSpecs(specs.getInitialEnigmaSpecs()));
        }
        if (specs.getCurEnigmaSpecs() != null) {
            System.out.println("Current Enigma Specs:");
            System.out.println("\t" + enigma.getEnigmaSpecs(specs.getCurEnigmaSpecs()));
        }
    }

    public void  machineSpecs(DTOMachineSpecs machineSpecs){
        System.out.printf("\tNumber of rotors used out of total rotors given: %d/%d\n",
                machineSpecs.getRotorsUsedCount(), machineSpecs.getRotorsGivenCount());

        System.out.printf("\tNumber of reflectors given: %d\n", machineSpecs.getReflectorsCount());
        System.out.printf("\tTotal amount of messages processed: %d\n", machineSpecs.getEncodesCount());
    }
}
