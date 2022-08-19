package engine.machine.components.enigma_factory.enigma.components;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PlugBoard implements Serializable {
    private final int[] plugboard;
    private final String plugs;

    public PlugBoard(String plugs, String ABC){
        this.plugboard = IntStream.rangeClosed(0, ABC.length()-1).toArray();;
        this.plugs = plugs;

        if (plugs.isEmpty())
            return;

        Arrays.stream(plugs.split(",")).forEach(
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

    public String getPlugs() {
        return plugs;
    }
}
