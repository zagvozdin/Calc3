package calculation;

import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 19.05.2016.
 */

public class CmdSubtractExt extends Cmd {

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    public void exec(String[] cmdParts) {
        // addition with two elements at least
        if ( stck.size()<2 ) {
            System.out.println("Недостатчоно аргументов для вычитания");
            return;
        }
        stck.push( stck.pop() - stck.pop() );
    }

}
