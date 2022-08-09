package engine.enigma.machine.components;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlugBoard {
    private int[] plugboard;
    public PlugBoard(String plugs, String ABC){
        plugboard = IntStream.rangeClosed(0, ABC.length()-1).toArray();;

        Arrays.stream(plugs.split(" ")).forEach(
                plug -> {
                    int left = ABC.indexOf(plug.charAt(0));
                    int right = ABC.indexOf(plug.charAt(1));
                    plugboard[left] = right;
                    plugboard[right] = left;
                }
        );
    }
    public int get(int curInd){
       return plugboard[curInd];
    }
}
