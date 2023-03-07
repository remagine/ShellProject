package com.shell;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Cat {
    public void execute(List<String> fileNames) {
        // 특정 파일 경로 받아서 출력하기
//        char[] buffer = new char[4096];
        byte[] buffer = new byte[8192];
        /*String errorMsg = "cat: : No such file or directory";*/
        OutputStream outputStream = System.out;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        for (String fileName : fileNames) {
            File file = new File(fileName);
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
            ) {
                while (true) {
                    int len = bufferedInputStream.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    bufferedOutputStream.write(buffer,0,len);
                }
            } catch (IOException e) {
                String errorMsg = "cat:" + fileName + ": No such file or directory";
                System.out.println(errorMsg);
            }
            /*System.out.println();*/
        }
        try {
            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // new 연산자는 비용이다.
        // 템플릿 코딩
        // 스트림에 대한 이해를 기반으로 코딩이 되야한다
        // 스트림은 무한 데이터, 바이트 어레이
        // 안틀릴려고 노력해야됨.
        // 암기를 해도 제대로
        //
    }
}
