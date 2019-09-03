package source.turing;

import java.util.Arrays;

/**
 * класс, реализующий часть ленты
 */
public class TapeBlock {
    public static final int TAPE_CAPACITY = 10;
    private char[] tapeBody;

    /**
     * Записывает в ячейку с индексом <b>position</b> символ <b>symbol</b>
     */
    public void rewriteSymbol(char symbol, int position){
        tapeBody[position] = symbol;
    }

    /**
     * По указанному индексу возвращает записанный в ячейке ленты символ.<br>
     * В случае если индекс указан неверно, будет выброшено исключение.
     */
    public char getSymbolAt(int position){
        return tapeBody[position];
    }

    public TapeBlock(char[] tapeBody) {
        this.tapeBody = Arrays.copyOf(tapeBody, TAPE_CAPACITY);
        for (int i = tapeBody.length; i < TAPE_CAPACITY; ++i) {
            this.tapeBody[i] = '0';
        }
    }

    public TapeBlock(){
        tapeBody = new char[TAPE_CAPACITY];
        Arrays.fill(tapeBody, '0');
    }

    @Override
    public String toString() {
        return new String(tapeBody);
    }
}
