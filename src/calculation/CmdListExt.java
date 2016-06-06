package calculation;

import java.util.Stack;

/**
 * Created by zag on 02.06.2016.
 */
public class CmdListExt extends Cmd{

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {

        // if empty
        if (stck.size() == 0) {
            System.out.println("Стек пуст");
            return;
        }

        System.out.println(stck);
    }
}