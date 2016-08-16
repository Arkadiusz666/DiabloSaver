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
import java.util.Date;
import java.util.List;

/**
 * Created by AKrzos on 2016-08-16.
 */
public class FileOperator {
    private static String saveFolderPath = "C:\\Program Files (x86)\\Diablo II\\save";
    private static String selectedChar;

    public static List<String> listCharsInDirectory() {
        File[] files = new File(saveFolderPath).listFiles();
        List<String> characterList =new ArrayList<String>();

        for (File file : files) {
            if (file.getName().substring(file.getName().length() - 4).equals(".d2s")) {
                characterList.add(file.getName().substring(0,file.getName().length()-4));
            }
        }
        return characterList;
    }

    public static void saveSharedStash() {
        Path from = Paths.get(saveFolderPath +"/"+"_LOD_SharedStashSave.sss");
        Path to = Paths.get(saveFolderPath +"/"+"backup/_LOD_SharedStashSave.sss");
        FileOperator.makeBackup("_LOD_SharedStashSave.sss"); //todo
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadSharedStash() {
        Path from = Paths.get(saveFolderPath +"/backup/_LOD_SharedStashSave.sss");
        Path to = Paths.get(saveFolderPath +"/"+"_LOD_SharedStashSave.sss");
        FileOperator.makeBackup("_LOD_SharedStashSave.sss");

        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePersonalStash() {
        Path from = Paths.get(saveFolderPath +"/" + selectedChar+".d2x");
        Path to = Paths.get(saveFolderPath +"/backup/" + selectedChar+".d2x");
        makeBackup(selectedChar+".d2x");
    }

    public static void loadPersonalStash() {
        Path from = Paths.get(saveFolderPath +"/backup/" + selectedChar+".d2x");
        Path to = Paths.get(saveFolderPath +"/" + selectedChar+".d2x");
        makeBackup(selectedChar+".d2x");
    }

    public static void saveCharFile() {
        Path from = Paths.get(saveFolderPath +"/" + selectedChar+".d2s");
        Path to = Paths.get(saveFolderPath +"/backup/" + selectedChar+".d2s");
        makeBackup(selectedChar+".d2s");
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadCharFile() {
        Path from = Paths.get(saveFolderPath +"/backup/" + selectedChar+".d2s");
        Path to = Paths.get(saveFolderPath +"/" + selectedChar+".d2s");
        makeBackup(selectedChar+".d2s"); //todo
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeBackup(String fileName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
        //get current date time with Date()
        Date date = new Date();
        String backupName = dateFormat.format(date)+fileName;
        Path from = Paths.get(saveFolderPath +"/"+fileName);
        Path to = Paths.get(saveFolderPath +"/backup/"+backupName);
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSaveFolderPath() {
        return saveFolderPath;
    }

    public static String getSelectedChar() {
        return selectedChar;
    }

    public static void setSaveFolderPath(String saveFolderPath) {

        FileOperator.saveFolderPath = saveFolderPath;
    }

    public static void setSelectedChar(String selectedChar) {
        FileOperator.selectedChar = selectedChar;
    }
}
