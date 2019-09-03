package source.util;

import source.turing.Tape;
import source.turing.TapeBlock;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import static source.turing.TapeBlock.TAPE_CAPACITY;

public class TapeManager {

    private char nullCharacter;

    public Tape read(String fileName) throws IOException {
        FileReader reader = new FileReader(new File(fileName));
        char[] buffer = new char[TAPE_CAPACITY];
        Arrays.fill(buffer, nullCharacter);
        int countChars = reader.read(buffer);
        Tape tape = new Tape(new TapeBlock(Arrays.copyOf(buffer,TAPE_CAPACITY)) , 0);
        countChars = reader.read(buffer);
        while (countChars > 0){
            if (countChars < TAPE_CAPACITY) {
                Arrays.fill(buffer, countChars, TAPE_CAPACITY - 1, nullCharacter);
                tape.addToNextBlocks(new TapeBlock(buffer));
                break;
            }
            tape.addToNextBlocks(new TapeBlock(Arrays.copyOf(buffer,TAPE_CAPACITY)));
            countChars = reader.read(buffer);
        }
        return tape;
    }

    public void writeTape(String outPath, Tape tape) throws IOException {
        FileWriter writer = new FileWriter(outPath);
        writer.write(tape.toString());
        writer.flush();
        writer.close();
    }

    public TapeManager(char nullCharacter) {
        this.nullCharacter = nullCharacter;
    }

    public char getNullCharacter() {
        return nullCharacter;
    }

    public void setNullCharacter(char nullCharacter) {
        this.nullCharacter = nullCharacter;
    }
}
