package source.turing.alphabet;

import source.turing.TuringCommandParser;

public class TuringCommand {
    private int numberCondition;
    private char newSymbol;
    private int move;

    public TuringCommand(int numberCondition, char newSymbol, char move) {
        this.numberCondition = numberCondition;
        this.newSymbol = newSymbol;
        this.move = TuringCommandParser.getMovement(move);
    }

    public int getNumberCondition() {
        return numberCondition;
    }

    public char getNewSymbol() {
        return newSymbol;
    }

    public int getMove() {
        return move;
    }
}
