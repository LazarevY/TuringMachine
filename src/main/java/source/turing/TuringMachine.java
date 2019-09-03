package source.turing;

import source.turing.alphabet.TuringCommand;

public class TuringMachine {
    private int condition;
    private boolean stopped = false;
    private TuringCommandTable commandTable;
    private Tape tape;


    public void step(){
        if(stopped) return;
        char symbol = tape.getLookingCharacter();
        TuringCommand command = commandTable.getCommand(condition, symbol);
        condition = command.getNumberCondition();
        tape.writeCharacter(command.getNewSymbol());
        tape.movePositionPointer(command.getMove());
        if(condition == 0)
            stopped = true;
    }

    public TuringMachine(int condition, TuringCommandTable commandTable, Tape tape, int tapePointer) {
        this.condition = condition;
        this.commandTable = commandTable;
        this.tape = tape;
        tape.setPositionPointer(tapePointer);
    }

    public boolean isStopped() {
        return stopped;
    }
}
