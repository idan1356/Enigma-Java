package menu;

import engine.machine.generated.CTEEnigma;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

public class main {
    private final static String JAXB_XML_GAME_PACKAGE_NAME = "engine.machine.generated";

    public static void main(String[] args) throws JAXBException, IOException {
        test();
    }
    public static void test() throws IOException, JAXBException {
        MainMenu menu = new MainMenu();
        menu.main();
    }

    private static CTEEnigma deserializeFrom (InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (CTEEnigma) u.unmarshal(in);
    }


}
