package source;

import source.turing.TuringCommandTable;
import source.turing.TuringMachine;
import source.util.TuringCommandTableReader;

public class Main {
    public static void main(String[] args) {
        try {
            TuringCommandTable t = TuringCommandTableReader.readTable("src/main/resources/table.txt");
            TuringMachine machine1 = new TuringMachine(1, t,
                    new char[]{'0','0','0','1','1','1','0'},
                    3);
            while (!machine1.isStopped()){
                machine1.step();
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
