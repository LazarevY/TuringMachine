package source;

import source.turing.Tape;

import source.turing.TuringMachine;
import source.util.TapeManager;
import source.util.TuringCommandTableReader;


public class Main {
    public static void main(String[] args) {
        try {
            Tape tape = new TapeManager('0').read("src/main/resources/tape2.txt");
            System.out.println(tape.toString());
            TuringMachine machine = new TuringMachine(1, TuringCommandTableReader.
                    readTable("src/main/resources/table2.txt"),
                    tape, 2);
            while (!machine.isStopped())
                machine.step();
            System.out.println(tape.toString());
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
}
