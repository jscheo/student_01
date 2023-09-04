<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>학생등록 페이지</h1>
    <form action="/req1" method="post">
    학번: &nbsp;<input type="text" name= "StudentNumber" ><br>
    이름: &nbsp;<input type="text" name= "studentName"><br>
    학과: &nbsp;<input type="text" name= "studentMajor"><br>
    전화번호: <input type="text" name= "studentMobile"><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>