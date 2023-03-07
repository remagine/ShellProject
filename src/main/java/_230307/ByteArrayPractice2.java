package _230307;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteArrayPractice2 {
    public static void main(String[] args) {
        String source = "안녕하세요\n" +
                "hello world\n" +
                "안녕 wolrd\n" +
                "hello 세상";
        try (InputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
             InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);) {
            char[] buffer = new char[3];
            while (true) {
                int len = inputStreamReader.read(buffer);
                if (len == -1) {
                    break;
                }
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
