package menu.set_enigma;
import engine.EncryptionMachineEngine;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class EnigmaSetter {
    public static class getAwayException extends Exception {
        public getAwayException(String errorMessage) {
            super(errorMessage);
        }
    }

    private void setRotors(EncryptionMachineEngine engine, Scanner scan) throws getAwayException {
        int rotorsUsedCount = engine.getMachineSpecs().getMachineSpecs().getRotorsUsedCount();
        System.out.println("Please enter " + rotorsUsedCount + " numbers representing rotors separated by a comma in the following format:");
        System.out.println("example: '1,2,3' where 3 is the right edge of the machine");
        System.out.println(" To exit to main menu please press tab");

        while (true) {
            try {
                String res = scan.nextLine();
                wayOut(res);
                engine.setRotors(res.toUpperCase());

                return;
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void setReflector(EncryptionMachineEngine engine, Scanner scan) throws getAwayException {
        int reflectorsCount = engine.getMachineSpecs().getMachineSpecs().getReflectorsCount();
        List<String> enumNames = Arrays.asList("I", "II", "III", "IV", "V");

        System.out.println("Please choose an integer corresponding to the following roman numbers,");
        System.out.println("representing reflector ID");
        System.out.println(" To exit to main menu please press tab");
        for (int i = 1; i <= reflectorsCount; i++) {
            System.out.printf("%d. %s\n", i, enumNames.get(i - 1));
        }
        while (true) {
            try {
                String reflector = scan.nextLine();
                wayOut(reflector);
                engine.setReflectors(Integer.parseInt(reflector));
                return;
            } catch (NumberFormatException exception) {
                System.out.println("Not an integer");
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void setStartPosition(EncryptionMachineEngine engine, Scanner scan) throws getAwayException {
        int rotorsUsedCount = engine.getMachineSpecs().getMachineSpecs().getRotorsUsedCount();
        System.out.println("Please enter " + rotorsUsedCount + " characters from the ABC, for rotors start position");
        System.out.println("for example, with ABC A-F, and rotor count of 3: 'AEC'");
        System.out.println(" To exit to main menu please press tab");

        while (true) {
            try {
                String position = scan.nextLine().toUpperCase();
                wayOut(position);
                engine.setInitialPosition(position);
                return;
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
        private void setPlugBoard (EncryptionMachineEngine engine, Scanner scan){
            System.out.println("Please enter an even sized String representing Plugboard mapping, with no delimiter between the plugs");
            System.out.println("for example, if we want to plug A to E, and B to C we enter the following string: 'AEBC'");
            System.out.println(" To exit to main menu please press tab");

            while (true) {
                try {
                    String plugboard = scan.nextLine().toUpperCase();
                    wayOut(plugboard);
                    engine.setPlugboard(plugboard);
                    return;
                } catch (RuntimeException | getAwayException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
        public void setSetting (EncryptionMachineEngine engine, Scanner scan) throws getAwayException {
            try {
                setRotors(engine, scan);
                setStartPosition(engine, scan);
                setReflector(engine, scan);
                setPlugBoard(engine, scan);
            }
            catch (getAwayException ignored){}
            finally {
                engine.setEnigmaSettings();
                System.out.println("Enigma created successfully from user input");
            }
        }

        public void wayOut (String userinput) throws getAwayException {
            if (userinput.equals("\t"))
                throw new getAwayException("back to menu");
        }

        public void randomSettings (EncryptionMachineEngine engine){
            engine.setRandomEnigmaSettings();
            System.out.println("a Random Enigma machine was created");
        }

    }

