package engine.machine.components.enigma_factory.enigma_settings.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import engine.machine.components.enigma_factory.enigma.components.Reflector;
import engine.machine.components.enigma_factory.enigma.components.rotors.Rotor;
import engine.machine.components.enigma_factory.enigma_settings.EnigmaSettings;

public class RandomSettings {

    public static EnigmaSettings randomSettings(List<Rotor> rotors, List<Reflector> reflectors, String ABC ,int rotorsUsedCount){
         int reflectorID = randomReflectorID(reflectors);
        List<Integer> rotorsList = randomRotors(rotors,rotorsUsedCount);
        String startPos = randomStartPosition(ABC,rotorsUsedCount);
        String plugBoard = randomPlugBoard(ABC);

        return new EnigmaSettings(rotorsList, reflectorID, plugBoard, startPos);
    }

    private static int randomReflectorID(List<Reflector> reflectors){
        Random random = new Random();
        int givenReflectorsCount = reflectors.size();
        return random.nextInt(givenReflectorsCount) + 1;
    }

    private static List<Integer> randomRotors(List<Rotor> rotors, int rotorsUsedCount){
        return getRandomNIntegers(1,rotors.size() + 1, rotorsUsedCount);
    }

    private static String randomStartPosition(String ABC, int rotorsUsedCount){
        StringBuilder position = new StringBuilder();

        getRandomNIntegers(0,ABC.length(),rotorsUsedCount).forEach(
                ind -> position.append(ABC.charAt(ind)) );

        return position.toString();
    }

    private static String randomPlugBoard(String ABC){
        Random random = new Random();
        int ABCLength = ABC.length();
        int plugCount = 2 * random.nextInt( ABCLength / 2);
        StringBuilder plugBoard = new StringBuilder();

        getRandomNIntegers(0 ,ABC.length(),plugCount).forEach(
                ind -> plugBoard.append(ABC.charAt(ind))
        );

        return plugBoard.toString();
    }

    // returns a random list of length 'listSize', in range of [lowInclusive, highExclusive)
    private static List<Integer> getRandomNIntegers(int lowInclusive, int highExclusive, int listSize){
        List<Integer> range = IntStream.range(lowInclusive, highExclusive).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(range);
        return range.subList(0, listSize);
    }

}
