package menu;

import machine.generated.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Menu {

    private final static String JAXB_XML_GAME_PACKAGE_NAME = "enigma.generated";

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\idan1\\IdeaProjects\\Enigma EXC1\\src\\resources\\ex1-sanity-small.xml"));
            CTEEnigma enigma123 = deserializeFrom(inputStream);
            System.out.println(enigma123);
            //  System.out.println("name of first country is: " + enigma.getCountry().get(0).getName());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static CTEEnigma deserializeFrom(InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }
}