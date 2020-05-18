package com.example.demo.CodingComfile;

import java.io.*;
import java.util.logging.Logger;

public class JavaFileInOutPut {
    private final static Logger logger = Logger.getGlobal();

    public void Input(String str) {//3.파일 데이터 저장하기
        try {
            String filename="test";
            OutputStream output = new FileOutputStream("C:/Compile2020/javac/"+filename+".java");

            byte[] by = str.getBytes();
            output.write(by);
            logger.info("file output");

        } catch (Exception e) {
            e.getStackTrace();
            logger.info("FAIL");
        }

    }

    public void Output() {//4.파일 데이터 가져오기
        try{
            String output="Output";
            //파일 객체 생성
            File file = new File("C:/Compile2020/javac/"+output+".java");

            //입력 스트림 생성
            FileReader file_reader = new FileReader(file);
            int cur = 0;
            while((cur = file_reader.read()) != -1){
                System.out.print((char)cur);
            }
            file_reader.close();
        }catch (FileNotFoundException e) {
            e.getStackTrace();
        }catch(IOException e){
            e.getStackTrace();
        }

    }
}