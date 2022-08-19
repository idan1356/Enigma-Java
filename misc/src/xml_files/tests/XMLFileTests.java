package xml_files.tests;

import engine.EncryptionMachineEngine;
import engine.EnigmaMachineEngine;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class XMLFileTests {
    public static void main(String[] args) {
        String[] fileNames;
        String folderPath="src/resources/xml_files/tests/test_files/" ;

        File f = new File(folderPath);
        // Populates the array with names of files and directories
        fileNames=f.list();
        assert fileNames != null;
        Arrays.sort(fileNames);

        EncryptionMachineEngine engine= new EnigmaMachineEngine();

        int i=0;
        // For each pathname in the pathnames array
        for (String fileName : fileNames) {
            try{
                System.out.println((++i) +" # "+fileName+":");

                engine.loadXMLFile(folderPath+fileName);//enter your implement
            }
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            } catch (JAXBException | IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
