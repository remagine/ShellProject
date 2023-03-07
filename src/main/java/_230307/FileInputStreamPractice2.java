package _230307;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputStreamPractice2 {
    private File readFile(String path) {
        File file = new File(path);
        return file;
    }

    public void printFile(String path) {
        /*- [ ]  FileInputStream으로 읽는 코드를 작성합니다.
        - IO 3가지 측면 고려하여 코딩합니다.
        - 출력은 OutputStream으로 콘솔출력을 시도합니다.
        - 틀리지 않고 한번에 코드가 완성되는지 점검합니다.
        - 만약 한번이라도 틀렸으면 다시 싹다 지우고 안틀릴때까지 반복합니다.*/
        File file = readFile(path);

        // 파일에서 Stream을 받아온다
        // 버퍼처리
        // reader (디코딩)
        OutputStream outputStream = System.out; // 닫으면 안되는 아웃풋 스트림
        try(InputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8)){
            char[] buffer = new char[4096];
            while(true){
                int len = inputStreamReader.read(buffer);
                if(len == -1){
                    break;
                }
                outputStreamWriter.write(buffer,0,len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
