<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>������ ����</title>
</head>

<body>
<form  action="/write" method="post">
    ���� : <input type="text" name="title"> <br>
    �ۼ��� : <input type="text" name="writer"> <br>
    <textarea name="content"></textarea><br>

    <input type="submit" value="���">
</form>
</body>



</html>
