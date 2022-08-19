package DTO.DTO_enigma.DTO_enigma_outputs;

import java.util.List;

public class DTOEnigmaHistory {
    private final DTOEnigmaSpecs specs;
    private final List<DTOencodeDecode> encodings;

    public DTOEnigmaHistory(DTOEnigmaSpecs specs, List<DTOencodeDecode> encodings){
        this.specs = specs;
        this.encodings = encodings;
    }

    public DTOEnigmaSpecs getSpecs() {
        return specs;
    }

    public List<DTOencodeDecode> getEncodings() {
        return encodings;
    }
}
