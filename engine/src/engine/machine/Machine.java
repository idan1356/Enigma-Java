package engine.machine;

import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;
import DTO.DTO_machine.DTOMachineHistory;
import DTO.DTO_machine.DTOMachineSpecs;
import engine.machine.components.enigma_factory.EnigmaFactory;
import engine.machine.components.enigma_factory.enigma.Enigma;
import engine.machine.components.enigma_factory.enigma_settings.EnigmaSettings;

import engine.machine.components.machine_history.MachineHistory;
import engine.machine.components.machine_specs.MachineSpecs;
import engine.machine.generated.CTEEnigma;
import engine.machine.generated.CTEMachine;
import engine.machine.validators.file_validator.FileValidator;
import javafx.util.Pair;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;


public class Machine implements Serializable {
    private final EnigmaFactory enigmaFactory;
    private final MachineSpecs machineSpecs;
    private final MachineHistory machineHistory;
    private Enigma activeEnigma;
    private EnigmaSettings initialSettings;

    private final static String JAXB_XML_GAME_PACKAGE_NAME = "engine.machine.generated";

    public Machine(String XMLFilePath) throws IOException, JAXBException {
        InputStream inputStream = Files.newInputStream(new File(XMLFilePath).toPath());
        CTEMachine machine = deserializeFrom(inputStream).getCTEMachine();

        FileValidator.validate(machine);
        this.enigmaFactory = new EnigmaFactory(machine);
        this.machineSpecs = new MachineSpecs(machine);
        this.machineHistory = new MachineHistory();
    }

    private static CTEEnigma deserializeFrom (InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }

    public DTOMachineHistory getMachineHistory(){
        return machineHistory.getHistory();
    }

    public DTOMachineSpecs getMachineSpecs(){
        return machineSpecs.getSpecs();
    }

    public void createEnigma(EnigmaSettings settings){
        activeEnigma = enigmaFactory.getEnigma(settings);
        initialSettings = settings;
        machineHistory.addEnigma(activeEnigma);
    }

    public EnigmaSettings createRandomEnigma(){
        Pair<Enigma, EnigmaSettings> randomEnigma = enigmaFactory.getRandom();
        activeEnigma = randomEnigma.getKey();
        machineHistory.addEnigma(activeEnigma);
        initialSettings = randomEnigma.getValue();

        return initialSettings;
    }

    public DTOencodeDecode encodeDecode(String message){
        if (activeEnigma == null)
            throw new RuntimeException("No Enigma exists yet, please create a machine before encoding a message");
        machineSpecs.increaseEncodeCount();
        return activeEnigma.encodeDecode(message);
    }

    public void resetEnigma(){
        activeEnigma.resetEnigmaPositioning();
    }

    public DTOEnigmaSpecs getEnigmaSpecs() {return activeEnigma.specs();}

    public DTOEnigmaSpecs getInitialEnigmaSpecs() {
        return enigmaFactory.getEnigma(initialSettings).specs();
    }

    public boolean isEnigmaExists(){
        return activeEnigma != null;
    }

}
