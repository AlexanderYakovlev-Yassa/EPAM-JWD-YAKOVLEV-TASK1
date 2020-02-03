package by.epam.yakovlev.task.util;

import by.epam.yakovlev.task.exception.FileUtileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public enum  FileUtil {

    INSTANCE;

    public ArrayList<String> readFile(File file) throws FileUtileException {

        if (file == null) {
            throw new FileUtileException("File is null");
        }

        ArrayList<String> fileContentByRows = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                    fileContentByRows.add(tmp);
            }
        } catch (IOException e) {
            throw new FileUtileException("File not found", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new FileUtileException("Can't close reader", e);
                }
            }
        }

        return fileContentByRows;
    }

    public static boolean rewriteFile(File file, ArrayList<String> newContent) throws FileUtileException {

        if (newContent == null){
            throw new FileUtileException("New content is null");
        }
        if (file == null){
            throw new FileUtileException("File is null");
        }

        boolean res = false;

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, false);
        } catch (IOException e) {
            throw new FileUtileException("File not found", e);
        }

        BufferedWriter bw = new BufferedWriter(fw);

        PrintWriter pw = new PrintWriter(bw);

        for (String s : newContent)
            pw.println(s);
        pw.close();

        return res;
    }

    public static void addRecordToFile(File file, String newRecord) throws FileUtileException {

        if (newRecord == null){
            throw new FileUtileException("New record is null");
        }
        if (file == null){
            throw new FileUtileException("File is null");
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            throw new FileUtileException("File not found", e);
        }
        BufferedWriter bw = new BufferedWriter(fw);

        PrintWriter pw = new PrintWriter(bw);

        pw.print("\n");
        pw.print(newRecord);
        pw.close();
    }
}
