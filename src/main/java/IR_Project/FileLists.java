package IR_Project;

import java.io.File;
import java.util.ArrayList;

public class FileLists extends FilterFiles{

    /**
     * Recursively traverses Folder Structure and adds txt and html files to list
     * @param startFolder
     * @return List of all txt and html Files in complete Folder Structure starting at start Folder
     */
    public static ArrayList<String> traverseFolderStructure(String startFolder){

        File folder = new File(startFolder);
        File[] directoryList = folder.listFiles();

        ArrayList<String> fileList = new ArrayList<String>();

        for (File f : directoryList) {
            if (f.isFile()) {
                if(isTextFile(f.getName()) || isHTMLFile(f.getName())) {

                    fileList.add(f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                fileList.addAll(traverseFolderStructure(f.getAbsolutePath()));
            }
        }

        return fileList;
    }
}
