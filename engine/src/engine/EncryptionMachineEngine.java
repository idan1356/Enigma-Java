package engine;

import DTO.DTOSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;
import DTO.DTO_machine.DTOMachineHistory;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface EncryptionMachineEngine {
    public void loadXMLFile(String XMLFilePath) throws JAXBException, IOException;

    public void setRotors(String rotors);
    public void setPlugboard(String plugboard);
    public void setInitialPosition(String positions);
    public void setReflectors(int reflector);
    public void setEnigmaSettings();
    public void setRandomEnigmaSettings();
    public void resetMachine();
    public DTOencodeDecode processInput(String message);
    public DTOSpecs getMachineSpecs();
    public DTOMachineHistory getMachineHistory();

}
