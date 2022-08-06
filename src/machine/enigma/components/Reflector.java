package machine.enigma.components;

import machine.enigma.generated.*;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

import static menu.Menu.deserializeFrom;

public class Reflector {
    Map<String,String> reflector = new HashMap<String,String>();

    public Reflector(CTEReflectors reflectors, String reflectorID, String ABC){
        CTEReflector chosenReflector = reflectors.getCTEReflector().stream()
                .filter(reflector -> Objects.equals(reflector.getId(), reflectorID))
               .collect(Collectors.toList()).get(0);

        String replaced = ABC.replaceAll("\\p{C}", "");
        for (CTEReflect reflect : chosenReflector.getCTEReflect()) {
            Character input = replaced.charAt(reflect.getInput() - 1);
            Character output = replaced.charAt(reflect.getOutput() - 1);

            reflector.put(input.toString(), output.toString());
            reflector.put(output.toString(), input.toString());
        }
    }

    public String forward(String curChar){
        return reflector.get(curChar);
    }

}
