package testCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitCatFile {
    public static void main(String[] args) throws IOException {
        // 遍历所有的 Git 对象
        Process process = Runtime.getRuntime().exec("find D:\\Code\\now-chronic-phone/.git/objects/ -type f");
        System.out.println(process);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            // 获取对象的 ID
            String objId = line.replaceAll(".git/objects/([0-9a-f]{2})/\\1([0-9a-f]{38})", "$1$2");

            // 查看对象的类型和内容
            Process typeProcess = Runtime.getRuntime().exec("git cat-file -t " + objId);
            BufferedReader typeReader = new BufferedReader(new InputStreamReader(typeProcess.getInputStream()));
            String type = typeReader.readLine();
            typeReader.close();
            if ("blob".equals(type)) {
                Process dataProcess = Runtime.getRuntime().exec("git cat-file -p " + objId);
                BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataProcess.getInputStream()));
                String data;
                boolean isVueOrTs = false;
                while ((data = dataReader.readLine()) != null) {
                    if (line.endsWith(".vue") || line.endsWith(".ts")) {
                        isVueOrTs = true;
                        break;
                    }
                }
                dataReader.close();

                if (isVueOrTs) {
                    System.out.println(objId + " " + line);
                }
            }
        }
        reader.close();
    }
}
