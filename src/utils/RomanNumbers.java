package utils;

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
}





