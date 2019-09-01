package source.util;

import source.turing.TuringCommandParser;
import source.turing.TuringCommandTable;
import source.turing.alphabet.TuringCommand;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TuringCommandTableReader {
    public static TuringCommandTable readTable(String tsvFileName) throws Exception {
        FileReader reader = new FileReader(tsvFileName);
        Scanner scan = new Scanner(reader);

        String[] temp_alphabet = scan.nextLine().trim().split("\\s{2,}");
        char[] alphabet = new char[temp_alphabet.length];
        for (int index = 0; index < temp_alphabet.length; ++index) {
            if (temp_alphabet[index].length() != 1)
                throw new TuringTableReaderException(String.
                        format("Founded symbol %s cannot symbol of turing machine alphabet", temp_alphabet[index]));
            alphabet[index] = temp_alphabet[index].charAt(0);
        }
        Map<Integer, Map<Character, TuringCommand>> commands = new HashMap<Integer, Map<Character, TuringCommand>>();

        while (scan.hasNextLine()){
            String[] line = scan.nextLine().trim().split("\\s{2,}");
            int cond = Integer.parseInt(line[0]);
            if(commands.containsKey(cond))
                throw new TuringTableReaderException(String.format("Condition %d already included in command table!",
                        cond));
            Map<Character, TuringCommand> map = new HashMap<Character, TuringCommand>();
            commands.put(cond, map);
            for (int index = 1; index < line.length; ++index) {
                TuringCommand command = line[index].equals("-")? null : TuringCommandParser.parse(line[index]);
                map.put(alphabet[index - 1],command);
            }
        }
        scan.close();
        reader.close();
        return new TuringCommandTable(commands);
    }
}
