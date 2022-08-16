package DTO.machine.enigma;

public class DTOencodeDecode {
   private final long nanoSec;
   private final String encode;
   private final String decode;

   public DTOencodeDecode(long nanoSec,String encode,String decode){
       this.decode = decode;
       this.nanoSec = nanoSec;
       this.encode = encode;
   }
    public long getNanoSec() {
        return nanoSec;
    }

    public String getDecode() {
        return decode;
    }

    public String getEncode() {
        return encode;
    }
}
