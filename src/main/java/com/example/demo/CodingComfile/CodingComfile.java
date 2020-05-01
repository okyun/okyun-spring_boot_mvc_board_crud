package com.example.demo.CodingComfile;

public class CodingComfile {//여기다가 컴파일 시험하고, 도커도 시험한다.
    public static void main(String args[]) {
//        1.
       JavaCmd javaCmd = new JavaCmd();
       CCmd cCmd=new CCmd();
//
//        //1.
       String command = cCmd.inputCommand();//코드 넣고
////        //2.
        String result = cCmd.execCommand(command);//코드 결과 받아오기
////
       System.out.println(result);
////

//        JavaFileInOutPut javaFileInOutPut=new JavaFileInOutPut();
//        javaFileInOutPut.Output();
        
        //(1)-content를 .c로 저장하기
        //(2)-.c를 컴파일 하기
        //a.out 파일을 contentresult에 불러오기

    }
}
