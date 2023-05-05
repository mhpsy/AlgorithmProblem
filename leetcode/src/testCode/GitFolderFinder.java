package testCode;
/**
 * String folderPath = "D:\\Code\\now-chronic-phone";
 * String startTimeStr = "2023-04-20 19:00:00";
 * String endTimeStr = "2023-04-20 20:00:00";
 */

//String folderPath = "D:\\Code\\now-chronic-phone";String startTimeStr = "2023-04-20 19:00:00";String endTimeStr = "2023-04-20 20:00:00";

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GitFolderFinder {

    public static void main(String[] args) {
        String folderPath = "D:\\Code\\now-chronic-phone";
        String startTimeStr = "2023-04-20 19:00:00";
        String endTimeStr = "2023-04-20 20:00:00";
        String outputFilePath = "D:\\a\\result123.txt";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null, endTime = null;
        try {
            startTime = dateFormat.parse(startTimeStr);
            endTime = dateFormat.parse(endTimeStr);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        File folder = new File(folderPath);
        if (!folder.exists()) {
            System.out.println("Folder does not exist: " + folderPath);
            return;
        }

        File gitFolder = new File(folder, ".git");
        if (!gitFolder.exists() || !gitFolder.isDirectory()) {
            System.out.println(".git folder does not exist: " + gitFolder.getAbsolutePath());
            return;
        }

        File objectsFolder = new File(gitFolder, "objects");
        if (!objectsFolder.exists() || !objectsFolder.isDirectory()) {
            System.out.println("objects folder does not exist: " + objectsFolder.getAbsolutePath());
            return;
        }

        Set<String> printedFolders = new HashSet<>();
        try (FileWriter fileWriter = new FileWriter(outputFilePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            findGitObjects(objectsFolder, startTime, endTime, printedFolders, bufferedWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findGitObjects(File folder, Date startTime, Date endTime, Set<String> printedFolders, BufferedWriter bufferedWriter) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        //是文件夹 就递归进去
                        findGitObjects(file, startTime, endTime, printedFolders, bufferedWriter);
                    } else if (file.isFile() && file.lastModified() >= startTime.getTime() && file.lastModified() <= endTime.getTime()) {
                        String folderPath = folder.getAbsolutePath();
                        if (!printedFolders.contains(folderPath)) {
                            try {
//                                bufferedWriter.write("Found matching folder: " + folderPath);
//                                bufferedWriter.newLine();
                                File[] subFiles = folder.listFiles();
                                if (subFiles != null) {
                                    for (File subFile : subFiles) {
                                        String absolutePath = subFile.getAbsolutePath();
                                        //把	D:\Code\now-chronic-phone\.git\objects\01\7739f1e9c6931eb7b12d36c748bc060b7688e8
                                        //转换为 017739f1e9c6931eb7b12d36c748bc060b7688e8
                                        String[] split = absolutePath.split("\\\\");
                                        String result = split[split.length - 2] + split[split.length - 1];
                                        //写入文件
                                        bufferedWriter.write(result);
                                        bufferedWriter.newLine();
                                    }
                                }
                                printedFolders.add(folderPath);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
