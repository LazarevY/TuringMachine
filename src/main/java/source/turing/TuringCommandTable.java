package source.turing;

import source.turing.alphabet.TuringCommand;

import java.util.HashMap;
import java.util.Map;

public class TuringCommandTable {

    private Map<Integer, Map<Character, TuringCommand>> commandMap;

    public TuringCommand getCommand(int condition, char symbol) {
        if(commandMap.containsKey(condition) && commandMap.get(condition).containsKey(symbol))
                return commandMap.get(condition).get(symbol);

        else  return null;
    }

    public void setCommand(int condition, char symbol, TuringCommand command){
        if(!commandMap.containsKey(condition))
            commandMap.put(condition, new HashMap<Character, TuringCommand>());
        commandMap.get(condition).put(symbol, command);
    }

    public TuringCommandTable()
    {
        commandMap = new HashMap<Integer, Map<Character, TuringCommand>>();
    }
    public TuringCommandTable(Map<Integer, Map<Character, TuringCommand>> commandMap) {
        this.commandMap = commandMap;
    }
}
