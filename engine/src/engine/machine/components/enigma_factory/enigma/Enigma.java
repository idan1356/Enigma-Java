package engine.machine.components.enigma_factory.enigma;


import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaHistory;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOEnigmaSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;
import engine.machine.components.enigma_factory.enigma.components.PlugBoard;
import engine.machine.components.enigma_factory.enigma.components.Reflector;
import engine.machine.components.enigma_factory.enigma.components.rotors.Rotor;
import engine.machine.components.enigma_factory.enigma.components.rotors.Rotors;
import engine.machine.components.enigma_factory.enigma_settings.EnigmaSettings;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Enigma implements Serializable {
    private final String ABC;
    private final Rotors rotors;
    private final Reflector reflector;
    private final PlugBoard plugboard;
    private final List<DTOencodeDecode> encodingHistory;

    public Enigma(EnigmaSettings settings, List<Rotor> rotors, List<Reflector> reflectors, String ABC){
        this.rotors = new Rotors(rotors,settings.getRotorsChosen(),settings.getStartingPositions());
        this.reflector = reflectors.get(settings.getReflectorID() - 1);
        this.plugboard = new PlugBoard(settings.getPlugBoardString(), ABC);
        this.ABC = ABC;
        this.encodingHistory = new LinkedList<>();
    }

    private void validateInput(String inputFromUser){
        StringBuilder illegalChars = new StringBuilder();
        Arrays.stream(inputFromUser.toUpperCase().split("(?!^)")).forEach(
                chr -> {if (!ABC.contains(chr)) {illegalChars.append(chr).append(",");}}
        );

        if (!illegalChars.toString().isEmpty())
            throw new RuntimeException(
                    String.format("Chars %s are not part of ABC", illegalChars)
            );
    }

    public DTOencodeDecode encodeDecode(String inputFromUser){
        validateInput(inputFromUser);

        StringBuilder message = new StringBuilder();
        long beginTimeMeasure = System.nanoTime();

        for (String curChar : inputFromUser.
                toUpperCase().split("(?!^)")){
            int out = ABC.indexOf(curChar);
            out = plugboard.get(out);
            out = rotors.forward(out);
            out = reflector.forward(out);
            out = rotors.backward(out);
            out = plugboard.get(out);

            message.append(ABC.charAt(out));
        }

        long endTimeMeasure = System.nanoTime();
        DTOencodeDecode output = new DTOencodeDecode(inputFromUser, message.toString(), endTimeMeasure-beginTimeMeasure);
        encodingHistory.add(output);

        return output;
    }

    public DTOEnigmaHistory getEncodingHistory() {
        return new DTOEnigmaHistory(this.specs(), encodingHistory);
    }

    public DTOEnigmaSpecs specs(){
        return new DTOEnigmaSpecs(rotors.rotorsListDTO(), rotors.getStartPosition(),
                plugboard.getPlugs(), reflector.getID());
    }

    public void resetEnigmaPositioning(){
        rotors.resetPosition();
    }
}
