package machine.enigma.components;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlugBoard {
    private Map<String, String> plugboard;

    public PlugBoard(Map<String, String> plugboardMap){
        plugboard = plugboardMap;
    }

    public String get(String curChar){
        String res = plugboard.get(curChar);
        if (res == null)
            return curChar;
        return res;
    }
}
