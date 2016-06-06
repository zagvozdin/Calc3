package calculation;

import java.util.Map;

/**
 * Created by zag on 02.06.2016.
 */
public class CmdDefineExt extends Cmd{

    @AnnotationPack(desc = "Class field annotation")
    private String[] cmdParts;

    @AnnotationPack(desc = "Class field annotation")
    Map<String, Double> defs;

    @AnnotationPack(desc = "method exec annotation")
    public void exec(String[] cmdParts) {
        // three words command
        if (cmdParts.length != 3) {
            System.out.println("Неверное количество аргументов для DEFINE");
            return;
        }
        // check that first parameter is a variable name
        if (!Character.isLetter(cmdParts[1].substring(0, 1).toCharArray()[0])) {
            System.out.println("Неверное имя переменной в DEFINE");
            return;
        }
        // add or replace variable in map
        try {
            if (defs.containsKey(cmdParts[1])) {
                defs.replace(cmdParts[1], Double.parseDouble(cmdParts[2]));
            } else {
                defs.put(cmdParts[1], Double.parseDouble(cmdParts[2]));
            }
        } catch (NumberFormatException nfe){
            System.out.println("Неверное значение переменной '" + cmdParts[1] + "' в DEFINE");
        }

    }

}
