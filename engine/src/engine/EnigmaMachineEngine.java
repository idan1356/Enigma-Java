package engine;

import DTO.DTOSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;
import DTO.DTO_machine.DTOMachineHistory;
import DTO.DTO_machine.DTOMachineSpecs;
import engine.machine.Machine;
import engine.machine.components.enigma_factory.enigma_settings.EnigmaSettings;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

public class EnigmaMachineEngine implements EncryptionMachineEngine, Serializable {
    Machine machine;
    EnigmaSettings settings;

    public EnigmaMachineEngine(){
        settings = new EnigmaSettings();
    }
    @Override
    public void loadXMLFile(String XMLFilePath) throws JAXBException, IOException {
        machine = new Machine(XMLFilePath);
        settings = new EnigmaSettings();
    }

    @Override
    public void setRotors(String rotors) throws RuntimeException {
        isMachineExists();
        DTOMachineSpecs specs = machine.getMachineSpecs();
        settings.setRotorsChosen(rotors,specs.getRotorsGivenCount(),specs.getRotorsUsedCount());
    }

    @Override
    public void setPlugboard(String plugboard) throws RuntimeException {
        isMachineExists();
        DTOMachineSpecs specs = machine.getMachineSpecs();
        settings.setPlugBoardString(plugboard,specs.getABC());
    }

    @Override
    public void setInitialPosition(String positions) throws RuntimeException {
        isMachineExists();
        DTOMachineSpecs specs = machine.getMachineSpecs();
        settings.setStartingPositions(positions,specs.getRotorsUsedCount(),specs.getABC());
    }

    @Override
    public void setReflectors(int reflector) throws RuntimeException {
        isMachineExists();
        DTOMachineSpecs specs = machine.getMachineSpecs();
        settings.setReflectorID(reflector,specs.getReflectorsCount());
    }

    private void isMachineExists(){
        if (machine == null)
            throw new RuntimeException("a valid XML file was not loaded yet, please load a valid XML file into the engine");
    }

    @Override
    public void setEnigmaSettings() {
        machine.createEnigma(settings);
    }

    @Override
    public void setRandomEnigmaSettings() {
        isMachineExists();
        settings = machine.createRandomEnigma();
    }

    @Override
    public void resetMachine() {
        isMachineExists();
        machine.resetEnigma();
    }

    @Override
    public DTOencodeDecode processInput(String message) {
        isMachineExists();
        return machine.encodeDecode(message);
    }

    @Override
    public DTOSpecs getMachineSpecs() {
        DTOMachineSpecs machineSpecs = machine.getMachineSpecs();
        DTOEnigmaSpecs curEnigmaSpecs = null;
        DTOEnigmaSpecs initEnigmaSpecs = null;

        if (machine.isEnigmaExists()){
            curEnigmaSpecs = machine.getEnigmaSpecs();
            initEnigmaSpecs = machine.getInitialEnigmaSpecs();
        }
        return new DTOSpecs(machineSpecs, curEnigmaSpecs, initEnigmaSpecs);
    }

    @Override
    public DTOMachineHistory getMachineHistory() {
        isMachineExists();
        return machine.getMachineHistory();
    }


}
