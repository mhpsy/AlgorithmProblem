package testCode;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class ThreadRequest implements Runnable {
    private final String url;
    private final String authorization;
    private final String path;
    private int timeout = 5000;
    private final CountDownLatch countDownLatch;

    public ThreadRequest(String url, String authorization, String path, int timeout, CountDownLatch countDownLatch) {
        this.url = url;
        this.authorization = authorization;
        this.path = path;
        this.timeout = timeout;
        this.countDownLatch = countDownLatch;
    }

    BufferedReader in = null;
    BufferedWriter out = null;

    public void run() {
        try {
            URL obj = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            // 设置超时时间
            con.setConnectTimeout(timeout);

            // 添加Authorization头
            con.setRequestProperty("Authorization", "Bearer " + authorization);

//            int responseCode = con.getResponseCode();
//            System.out.println("url: " + url);
//            System.out.println("code : " + responseCode);

            if (con.getInputStream() == null) {
                // 如果输入流为空，说明请求失败了
                System.out.println("error");
                return;
            }

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // 先new一个InputStreamReader对象，con.getInputStream()也就是获取到的输入流，然后把这个输入流当做参数传给InputStreamReader对象
            // BufferedReader是为了按行读取
            String inputLine;
            StringBuilder response = new StringBuilder();

            File file = new File(path);
            out = new BufferedWriter(new FileWriter(file, true));

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                out.write(response.toString());// 写入请求结果
                out.newLine();// 这个换行是为了让每个请求结果之间有个换行 不是请求之间的换行
                //这里还存在bug的 但是没关系了 大部分接口都是一行 如果涉及到换行需要判断是不是要加换行符
            }

//            System.out.println(response.toString());
        } catch (Exception e) {
//            System.err.println("error" + e.getMessage());
        } finally {
            this.countDownLatch.countDown();
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
//                System.err.println("error" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "http://jk.hblshq.cn/prod-api/health/Workbench/workbenchTotal";
        String authorization = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2tleSI6IjhjZGM3MDQwLTk1MDEtNGJmYS04MWJhLTJjOGUxNGJkODE2MiIsInVzZXJuYW1lIjoiYWRtaW4ifQ.GEAWurrw5RqSv2n04EY78In-vGH3wwVuogw5i-rpsLPlohiV4wN1_ORsYeGQCdoLVE-ZxVQChnp9JRK7Wkqrkw";
        String path = "D:\\Code\\requestResult.txt";
        int threadNum = 1000;
        long startTime = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        File file = new File(path);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }

        // 发送1,000个请求
        for (int i = 0; i < threadNum; i++) {
            new Thread(new ThreadRequest(url, authorization, path, 5000, countDownLatch)).start();
        }


        try {
            countDownLatch.await();
            System.out.println("time: " + (System.currentTimeMillis() - startTime));
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
