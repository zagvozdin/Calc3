package calculation;

import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 19.05.2016.
 */
public class CmdDivideExt extends Cmd{

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {
        // addition with two elements at least
        if ( stck.size()<2 ) {
            System.out.println("Недостатчоно аргументов для деления");
            return;
        }
        stck.push( stck.pop() / stck.pop() );
    }

}
