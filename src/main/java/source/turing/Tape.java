package source.turing;

import source.util.ListStack;

import java.util.Stack;

/**
 * Данный класс хранит в себе стеки с блоками лент
 * Это позволет переключаться между блоками лент во время работы машины
 */
public class Tape{
    private ListStack<TapeBlock> previousTapeBlocks;
    private ListStack<TapeBlock> nextTapeBlocks;
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

    private TapeBlock popStack(ListStack<TapeBlock> tapeBlocks){
        if(tapeBlocks.empty())
            return new TapeBlock();
        return tapeBlocks.pop();
    }

    public void addToNextBlocks(TapeBlock block){
        nextTapeBlocks.add(block);
    }

    public void addToPreviousBlock(TapeBlock block){
        previousTapeBlocks.add(block);
    }

    public Tape(TapeBlock currentBlock, int positionPointer) {
        this.currentBlock = currentBlock;
        this.positionPointer = positionPointer;
        nextTapeBlocks = new ListStack<>();
        previousTapeBlocks = new ListStack<>();
    }

    public Tape(TapeBlock currentBlock) {
        this.currentBlock = currentBlock;
        this.positionPointer = 0;
        nextTapeBlocks = new ListStack<>();
        previousTapeBlocks = new ListStack<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Stack<TapeBlock> reverse_previous = new Stack<>();
        for (TapeBlock t :
                previousTapeBlocks)
            reverse_previous.push(t);
        for(TapeBlock t :
                    reverse_previous)
            builder.append(t.toString());
        builder.append(currentBlock.toString());
        for(TapeBlock t :
                    nextTapeBlocks)
            builder.append(t.toString());
        return builder.toString();
    }

    public void setPositionPointer(int positionPointer) {
        this.positionPointer = positionPointer;
    }
}
