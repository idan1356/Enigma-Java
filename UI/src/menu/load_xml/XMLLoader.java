package menu.load_xml;

import engine.EncryptionMachineEngine;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class XMLLoader {

    public XMLLoader(EncryptionMachineEngine engine, Scanner scan){
        System.out.println("Please enter a path for a valid XML file, to exit to main menu press tab");

        while(true) {
            try {
                String XMLFilePath = scan.nextLine();

                if (Objects.equals(XMLFilePath, "\t"))
                    return;

                engine.loadXMLFile(XMLFilePath);
                System.out.println("File loaded successfully");
                return;

            } catch (IOException ioException) {
                System.out.println("File does not exists, please enter a path for a valid XML file");

            } catch (JAXBException exception) {
                System.out.println("XML File doesnt match XSD format, please enter a path for a valid XML file");
            }
            catch (RuntimeException exception)
            {
                System.out.println("Invalid XML file- " + exception.getMessage() + ", please enter a path for a valid XML file");
            }
        }
    }

}
