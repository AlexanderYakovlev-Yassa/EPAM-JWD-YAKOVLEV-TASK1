package by.epam.yakovlev.task.util;

import by.epam.yakovlev.task.TestDataFiles;
import by.epam.yakovlev.task.exception.FileUtileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class FileUtilTest {

    private static FileUtil util = new FileUtil();
    private static File file = TestDataFiles.PHONE_PART.getFile();

    @Test
    public void readFileTest() {

        ArrayList<String> content = null;

        try {
            content = util.readFile(file);
        } catch (FileUtileException e) {
            // e.printStackTrace();
        }

        Assert.assertNotNull(content);
    }
}