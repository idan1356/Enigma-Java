package DTO.DTO_machine;

public class DTOMachineSpecs {
    private final int rotorsGivenCount;
    private final int rotorsUsedCount;
    private final int reflectorsCount;
    private final int encodesCount;
    private final String ABC;

    public DTOMachineSpecs(int rotorsGivenCount, int rotorsUsedCount,
                           int reflectorsCount, int encodesCount, String ABC){
        this.reflectorsCount = reflectorsCount;
        this.encodesCount = encodesCount;
        this.rotorsGivenCount = rotorsGivenCount;
        this.rotorsUsedCount = rotorsUsedCount;
        this.ABC = ABC;
    }

    public int getEncodesCount() {
        return encodesCount;
    }

    public int getReflectorsCount() {
        return reflectorsCount;
    }

    public int getRotorsGivenCount() {
        return rotorsGivenCount;
    }

    public int getRotorsUsedCount() {
        return rotorsUsedCount;
    }

    public String getABC() {
        return ABC;
    }
}
