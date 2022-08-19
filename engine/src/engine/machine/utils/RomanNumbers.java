package engine.machine.utils;

public enum RomanNumbers {
    I {
        public int value() {return 1;};
    },
    II {
        public int value() {return 2;};
    },
    III {
        public int value() {return 3;};
    },
    IV {
        public int value() {return 4;};
    },
    V {
        public int value() {return 5;};
    };

    public abstract int value();
    public static RomanNumbers intToRomanNumber(int num){
        switch (num){
            case 1:
                return RomanNumbers.I;
            case 2:
                return RomanNumbers.II;
            case 3:
                return RomanNumbers.III;
            case 4:
                return RomanNumbers.IV;
            case 5:
                return RomanNumbers.V;
            default:
                throw new IllegalArgumentException("Cannot convert number to roman number, out of range");
        }
    }
}





