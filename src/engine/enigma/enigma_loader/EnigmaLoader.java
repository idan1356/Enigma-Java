package engine.enigma.enigma_loader;

import engine.enigma.enigma_loader.settings.EnigmaSettings;
import engine.enigma.enigma_loader.validators.file_validator.FileValidator;
import engine.enigma.generated.CTEEnigma;
import engine.enigma.generated.CTEMachine;
import engine.enigma.machine.Enigma;
import utils.RomanNumbers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;

public class EnigmaLoader {
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "engine.enigma.generated";

    public EnigmaLoader(String XMLfilePath) throws JAXBException, IOException {
        InputStream inputStream = Files.newInputStream(new File(XMLfilePath).toPath());
        CTEMachine enigma = deserializeFrom(inputStream).getCTEMachine();

        FileValidator.validate(enigma);
    }

    private static CTEEnigma deserializeFrom (InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }


}

