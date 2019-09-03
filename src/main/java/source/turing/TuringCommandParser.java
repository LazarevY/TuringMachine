package source.turing;

import source.turing.alphabet.TuringCommand;
import source.turing.exceptions.TuringCommandParserException;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * класс, реализующий разбор команд машины Тьюринга
 */
public class TuringCommandParser {
    private static final String commandRegex = "q\\((\\d+)\\)(.)([LRS])";
    private static final String commandTemplate = "<q(any non-negative number)><character><one sym from set{L,S,R}>";
    /**
     * Функция предназначена для разбора команды машины Тьюринга.<br>
     * В случае удачного разбора команды результат разбора будет записан во внутренние перемнные, в случае ошибки будет
     * выброшено исключение.
     * @param command разбираемая команда
     * @return команда машины Тьюринга
     */
    public static TuringCommand parse(String command) throws TuringCommandParserException {
        Matcher matcher = Pattern.compile(commandRegex).matcher(command);

        if(!matcher.matches()){
            throw new TuringCommandParserException("Invalid command: " + command + "\nCommand template: "+
                    commandTemplate + "\nExample: q(1)yR\n");
        }
        MatchResult result = matcher.toMatchResult();

        return new TuringCommand(Integer.parseInt(result.group(1)), result.group(2).charAt(0),
                result.group(3).charAt(0));
    }

    public static int getMovement(char movement){
        switch (movement){
            case 'L': return -1;
            case 'R': return 1;
            default: return 0;
        }
    }
}
