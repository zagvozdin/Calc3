package calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 02.06.2016.
 */
public class CmdPushExt extends Cmd {

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    @AnnotationPack(desc = "Class field annotation")
    private String[] cmdParts;

    @AnnotationPack(desc = "Class field annotation")
    Map<String, Double> defs;

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {
        // two words command
        if (cmdParts.length != 2) {
            System.out.println("Неверное количество аргументов для PUSH");
            return;
        }

        try {
            stck.push(Double.parseDouble(cmdParts[1])); // number will push here
        } catch (Exception e) {
            // it's a variable
            if (defs.get(cmdParts[1]) == null) { // define not found
                System.out.println("Переменная " + cmdParts[1] + " не определена");
            } else { // define found
                stck.push(defs.get(cmdParts[1]));
            }
        }

    }

}
