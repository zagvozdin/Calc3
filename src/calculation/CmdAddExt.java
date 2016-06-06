package calculation;

import java.util.Stack;

/**
 * Created by zag on 18.05.2016.
 */

@AnnotationPack(desc = "class CmdAddExt annotation")
public class CmdAddExt extends Cmd {

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {
        // addition with two elements at least
        if (stck.size() < 2) {
            System.out.println("Недостатчоно аргументов для сложения");
            return;
        }
        stck.push(stck.pop() + stck.pop());
    }

}


