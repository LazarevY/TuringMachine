package source.turing;

import java.util.Stack;

/**
 * Данный класс хранит в себе стеки с блоками лент
 * Это позволет переключаться между блоками лент во время работы машины
 */
public class Tape{
    private Stack<TapeBlock> previousTapeBlocks;
    private Stack<TapeBlock> nextTapeBlocks;
    private TapeBlock currentBlock;
    private int positionPointer;

    public char getLookingCharacter(){
        return currentBlock.getSymbolAt(positionPointer);
    }

    public void movePositionPointer(int movement){
        positionPointer += movement;
        if(positionPointer < 0){
            positionPointer = TapeBlock.TAPE_CAPACITY - 1;
            nextTapeBlocks.push(currentBlock);
            currentBlock = popStack(previousTapeBlocks);
        }
        else if(positionPointer >= TapeBlock.TAPE_CAPACITY){
            positionPointer = 0;
            previousTapeBlocks.push(currentBlock);
            currentBlock = popStack(nextTapeBlocks);
        }
    }

    public void writeCharacter(char character){
        currentBlock.rewriteSymbol(character, positionPointer);
    }

    private TapeBlock popStack(Stack<TapeBlock> tapeBlocks){
        if(tapeBlocks.empty())
            return new TapeBlock();
        return tapeBlocks.pop();
    }

    public Tape(TapeBlock currentBlock, int positionPointer) {
        this.currentBlock = currentBlock;
        this.positionPointer = positionPointer;
        nextTapeBlocks = new Stack<TapeBlock>();
        previousTapeBlocks = new Stack<TapeBlock>();

    }
}
