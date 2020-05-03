package com.example.demo.CodingComfile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class JavaCmd {

    private final static Logger logger = Logger.getGlobal();

    private StringBuffer buffer;
    private Process process;
    private BufferedReader bufferedReader;
    private StringBuffer readBuffer;

    public String inputCommand() {//1.

        buffer = new StringBuffer();

        if (System.getProperty("os.name").indexOf("Windows") > -1) {
            logger.info("1111111111나는 윈도우 ");
            buffer.append("cmd.exe ");
            buffer.append("/c ");
            buffer.append("cd C:\\Compile2020\\javac& "+"javac test.java&"+"java test");
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
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"MS949"));

            String line = null;
            readBuffer = new StringBuffer();

            while((line = bufferedReader.readLine()) != null) {
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
