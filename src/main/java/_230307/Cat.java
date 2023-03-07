package _230307;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Cat {
    /* - [ ]  Cat 명령어를 구현합니다.
     - 기존에 작성된 Cat class는 삭제합니다.
     - IO 3가지 측면 고려하여 코딩합니다.
             - 효율적으로 출력하는 방법을 고민하여 코딩합니다.
         - new 연산자는 최소한으로 사용합니다.
         - 통신비용을 최대한 아낍니다. 아래 요소들을 고민해봅니다.
             - flush 횟수
             - 인코딩/디코딩을 굳이해야 하는지*/
    public void execute(List<String> fileNames) {
        OutputStream outputStream = System.out;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        byte[] buffer = new byte[8192];
        for (String fileName : fileNames) {
            File file = new File(fileName);
            try (InputStream inputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
            ) {
                while (true) {
                    int len = bufferedInputStream.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    bufferedOutputStream.write(buffer, 0, len);
                }
            } catch (IOException e) {
                System.out.println(fileName + ": (No such file or directory) ");
            }
        }
        try {
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
