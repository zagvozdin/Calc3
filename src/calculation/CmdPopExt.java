package calculation;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by zag on 02.06.2016.
 */
public class CmdPopExt extends Cmd{

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {
        try {
            stck.pop();
        } catch (EmptyStackException ese) {
            System.out.println("Стек пуст");
        }
    }
}
