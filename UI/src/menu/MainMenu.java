package menu;

import DTO.DTOSpecs;
import DTO.DTO_enigma.DTO_enigma_outputs.DTOencodeDecode;

import DTOeditor.HistoryEditor;
import DTOeditor.SpecsEditor;
import engine.EncryptionMachineEngine;
import engine.EnigmaMachineEngine;
import menu.load_xml.XMLLoader;
import menu.set_enigma.EnigmaSetter;

import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class MainMenu {

    EncryptionMachineEngine engine = new EnigmaMachineEngine();
    Scanner scan = new Scanner(System.in);

    public void main() {
        String separator = "----------------------------------------";

        while (true) {
            printMainMenu();
            int option = inputFromUser();
            switch (option) {
                case 1:
                    XMLLoader loader = new XMLLoader(engine, scan);
                    break;
                case 2:
                    getMachineSpecs();
                    break;
                case 3:
                    EnigmaSetter enigmaSetter = new EnigmaSetter();
                    try {
                        enigmaSetter.setSetting(engine, scan);
                    }
                    catch (EnigmaSetter.getAwayException exception){
                        continue;
                    }
                    break;
                case 4:
                    enigmaSetter = new EnigmaSetter();
                    enigmaSetter.randomSettings(engine);
                    break;
                case 5:
                    encodeDecode();
                    break;
                case 6:
                    resetEnigma();
                    break;
                case 7:
                    HistoryAndStatistics();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid option selected, please choose an integer between 1-8");
            }
            System.out.println(separator);
        }
    }

    private int inputFromUser(){
        while(true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please type an integer");
            }
        }
    }

    public void printMainMenu() {
        System.out.println("1. Load system configuration from XML file");
        System.out.println("2. Show machine specs");
        System.out.println("3. Choose machine settings manually");
        System.out.println("4. Choose machine settings randomly");
        System.out.println("5. Encode/Decode input");
        System.out.println("6. Reset Enigma");
        System.out.println("7. Get history and statistics for current file");
        System.out.println("8. Exit");
    }


    public void getMachineSpecs() {
        SpecsEditor specsEditor = new SpecsEditor();
        DTOSpecs specs = engine.getMachineSpecs();
        specsEditor.specs(specs);
    }

    public void encodeDecode() {
        System.out.println("Please enter a string to be processed by the Enigma machine");
        System.out.println("All the characters of the string must be part of the ABC provided");
        try {
            DTOencodeDecode output = engine.processInput(scan.nextLine());
            System.out.println(output.getOutput());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void resetEnigma() {
        try {
            engine.resetMachine();
            System.out.println("Enigma was reset successfully ");
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }
    }
    public void HistoryAndStatistics(){
        HistoryEditor history = new HistoryEditor();
        history.machineHistory(engine.getMachineHistory());
    }

}

