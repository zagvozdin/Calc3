package calculation;

import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 18.05.2016.
 */
public class CmdSQRTExt extends Cmd {

    @AnnotationPack(desc = "Class field annotation")
    private Stack<Double> stck; // local instance of stack

    public void exec(String[] cmdParts) {
        // addition with two elements at least
        if ( stck.size()<1 ) {
            System.out.println("Недостатчоно аргументов для извлечения квадратного корня");
            return;
        }
        stck.push( Math.sqrt(stck.pop()) );
    }

}


