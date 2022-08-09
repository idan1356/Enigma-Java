package engine.enigma.enigma_loader.settings.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import engine.enigma.enigma_loader.settings.EnigmaSettings;
import engine.enigma.generated.CTEMachine;
import engine.enigma.generated.CTEReflectors;
import utils.RomanNumbers;

public class RandomSettings {
    public static EnigmaSettings randomSettings(CTEMachine machine){
        RomanNumbers reflectorID = randomReflectorID(machine.getCTEReflectors());
        List<Integer> rotorsList = randomRotors(machine);
        String startPos = randomStartPosition(machine);
        String plugboard = randomPlugboard(machine.getABC());

        return new EnigmaSettings(machine, rotorsList, reflectorID, plugboard, startPos);
    }

    private static RomanNumbers randomReflectorID(CTEReflectors reflectors){
        Random random = new Random();
        int givenReflectorsCount = reflectors.getCTEReflector().size();
        int chosenReflectorInd = random.nextInt(givenReflectorsCount) + 1;
        return RomanNumbers.intToRomanNumber(chosenReflectorInd);
    }

    private static List<Integer> randomRotors(CTEMachine machine){
        int rotorsToUse =machine.getRotorsCount();
        int givenRotorsCount = machine.getCTERotors().getCTERotor().size();

        return getRandomNIntegers(1,givenRotorsCount + 1,rotorsToUse);
    }

    private static String randomStartPosition(CTEMachine machine){
        StringBuilder position = new StringBuilder();
        String ABC = machine.getABC();
        int chosenRotorsCount = machine.getRotorsCount();

        getRandomNIntegers(0,ABC.length(),chosenRotorsCount).forEach(
                ind -> position.append(ABC.charAt(ind)) );

        return position.toString();
    }

    private static String randomPlugboard(String ABC){
        Random random = new Random();
        int ABCLength = ABC.length();
        int plugCount = 2 * random.nextInt( ABCLength / 2);
        StringBuilder plugBoard = new StringBuilder();

        getRandomNIntegers(0 ,ABC.length(),plugCount).forEach(
                ind -> plugBoard.append(ABC.charAt(ind))
        );

        //add space every 2 characters
        return plugBoard.toString().replaceAll("..", "$0 ");
    }

    private static List<Integer> getRandomNIntegers(int lowInclusive, int highExclusive, int listSize){
        List<Integer> range = IntStream.range(lowInclusive, highExclusive).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(range);
        return range.subList(0, listSize);
    }

}
