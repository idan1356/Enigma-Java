package DTO.DTO_enigma.DTO_enigma_outputs;

public class DTOencodeDecode {
   private final String input;
   private final String output;
   private final long nanoSec;


    public DTOencodeDecode(String input, String output, long nanoSec){
       this.output = output;
       this.input = input;
       this.nanoSec = nanoSec;
    }
    public long getNanoSec() {
        return nanoSec;
    }

    public String getOutput() {
        return output;
    }

    public String getInput() {
        return input;
    }
}
