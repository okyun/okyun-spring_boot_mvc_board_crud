package com.example.demo.CodingComfile.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class PythonCmd {
    private final static Logger logger = Logger.getGlobal();


    private StringBuffer buffer;
    private Process process;
    private BufferedReader successBufferedReader;
    private BufferedReader errorBufferReader;
    private StringBuffer readBuffer;
    public String inputCommand() {//1.
        String filename="print2";
        buffer = new StringBuffer();
        if (System.getProperty("os.name").indexOf("Windows") > -1) {
            logger.info("1111111111나는 윈도우 ");
            buffer.append("cmd.exe ");
            buffer.append("/c ");
            buffer.append("cd C:\\Compile2020\\python& "+"py "+filename+".py");
//            buffer.append("/c ");
//            buffer.append("dir ");


        } else {
            logger.info("222222222222나는 리눅스 ");
            buffer.append("/bin/sh");
            buffer.append("-c");

        }

        return buffer.toString();
    }

    public String execCommand(String cmd) {//2.
        try {
            process = Runtime.getRuntime().exec(cmd);
            successBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "MS949"));


            String line = null;
            readBuffer = new StringBuffer();

            while((line = successBufferedReader.readLine()) != null) {//컴파일 성공
                readBuffer.append(line);
                readBuffer.append("\n");
            }
            while((line = errorBufferReader.readLine()) != null) {//오류 발생
                logger.info("execCommand7");
                readBuffer.append(line);
                readBuffer.append("\n");
            }
            return readBuffer.toString();
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }
}
