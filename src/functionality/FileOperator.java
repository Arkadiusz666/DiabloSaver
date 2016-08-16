package functionality;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by AKrzos on 2016-08-16.
 */
public class FileOperator {
    private static String applicationPath= System.getProperty("user.dir");

    public static File[] listFilesInDirectory(String folderRelativePath) {
        File[] files = new File(applicationPath+folderRelativePath).listFiles();
        return files;
    }

    public static void testPrintFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public static void saveStash(String folderPath) {
        Path from = Paths.get(applicationPath+folderPath+"/"+"_LOD_SharedStashSave.sss");
        Path to = Paths.get(applicationPath+folderPath+"/"+"backup/_LOD_SharedStashSave.sss");
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadStash(String folderPath) {
        Path from = Paths.get(applicationPath+folderPath+"/"+"backup/_LOD_SharedStashSave.sss");
        Path to = Paths.get(applicationPath+folderPath+"/"+"_LOD_SharedStashSave.sss");
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeBackup() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        String backupName = dateFormat.format(date)+"";//todo filename



    }
}
