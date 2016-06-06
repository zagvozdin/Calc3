package calculation;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Admin on 12.05.2016.
 */
public class Calc3 {

    // Stack from Java
    private static Stack<Double> stckDbl = new Stack<Double>();

    public static void main(String[] args) {

        // in streams
        Scanner scn = null, scnMap = null;
        // file with commands mapping
        String mapFile = "map.txt";
        // scanner string
        String[] mapEntries;
        // base class instance with exec() interface
        Cmd mapEntryClass;

        try {
            if (args.length > 0) {
                scn = new Scanner(new File(args[0]));
            } else {
                scn = new Scanner(System.in);
                System.out.println("Ввод с клавиатуры:");
            }
        } catch (Exception e) {
            System.out.println("Проблема с файлом " + args[0]);
        }

        // scanned line
        String cmdIn;
        // splitted string
        String[] cmdParts;
        // defines map (for the stack)
        Map<String, Double> defs = new HashMap<String, Double>();

        // result of Math action
        double tmp;

        // current class
        Class cls;
        // fields set
        Field[] fld;
        // annotations
        AnnotationPack antPack;

        // map with command classes
        Map<String, Cmd> cmdMap = new HashMap<String, Cmd>();

        // open map command file
        try {
            scnMap = new Scanner(new File(mapFile));
        } catch (Throwable th) {
            System.out.println(th);
            return;
        }

        // scan map command file and fill map with their instances
        while (scnMap.hasNext()) {
            try {
                mapEntries = scnMap.nextLine().split(";");
                Class c = Class.forName(mapEntries[1]);
                // create instance of new class
                Cmd temp = (Cmd) c.newInstance();


                // init two fields for each instance of a class
                fld = c.getDeclaredFields(); // all fields, include private
                for (Field f : fld) {
                    antPack = f.getAnnotation(AnnotationPack.class);
                    if (antPack != null && f.getName().equals("stck")) {
                        try {
                            f.setAccessible(true); // allow access to private filed
                            f.set(temp, stckDbl);
                            //cmdMap.put(e.getKey(), e.getValue());
                        } catch (IllegalAccessException iae) {
                            System.out.println(iae);
                        }
                    }
                    if (antPack != null && f.getName().equals("defs")) {
                        try {
                            f.setAccessible(true); // allow access to private filed
                            f.set(temp, defs);
                        } catch (IllegalAccessException iae) {
                            System.out.println(iae);
                        }
                    }
                }
                // System.out.println(">> " + temp.toString());


                // put command & instance of a new class
                cmdMap.put(mapEntries[0], temp);
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
            } catch (Exception e)
            {
                System.out.println("хуйня какая-то при чтении " + mapFile);
            }
        }

        // lets's go
        while (true) {
            try {
                cmdIn = scn.nextLine();
                //System.out.println("line: " + cmdIn);
            } catch (Exception e) {
                // конец файла
                System.out.println("Окончание вычислений");
                break;
            }

            // empty string, continue
            if (cmdIn.equals("")) continue;

            cmdParts = cmdIn.split(" ");

            // empty string, exit
            if (cmdParts[0].equals("#")) continue;

            // execute command, if exists
            try {
                if (cmdMap.containsKey(cmdParts[0])) {
                    cmdMap.get(cmdParts[0]).exec(cmdParts);
                } else {
                    System.out.println("Неизвестная команда " + "'" + cmdParts[0] + "'");
                }
            } catch (Throwable th) {
                System.out.println("exec " + th);
            }
        }
    }
}


