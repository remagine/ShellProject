package _230307;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteArrayPractice {

    public static void main(String[] args) {
//        - [ ]  ByteArrayInputStream 으로 내용을 읽는 코드를 작성합니다.
        // 읽을 내용 준비하기
        // 내용을 ByteArrayInputStream으로 받기
        // 출력
//        - IO 3가지 측면을 고려하여 코딩합니다.
        // 1. 인코딩/디코딩 2. 버퍼처리 3. 자원의 해제
//        - 출력은 System.out.println()으로 출력합니다.
//        - 틀리지 않고 한번에 코드가 완성되는지 점검합니다.
//        - 만약 한번이라도 틀렸으면 다시 싹다 지우고 안틀릴때까지 반복합니다.
        String source = "안녕하세요\n" +
                "hello world\n" +
                "안녕 wolrd\n" +
                "hello 세상";

        try (InputStream inputStream = new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
             InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);) {
            char[] buffer = new char[4096];
            while (true) {
                int len = inputStreamReader.read(buffer);
                if (len == -1){
                    break;
                }
                System.out.print(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
