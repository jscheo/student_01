<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <h1>학생정보 수정</h1>
        <form action="/update" method="post">
        <input type="hidden" name="id" value="${student.id}"><br>
        학번: &nbsp;<input type="text" name= "StudentNumber" value="${student.studentNumber}" readonly><br>
        이름: &nbsp;<input type="text" name= "studentName" value="${student.studentName}" readonly><br>
        학과: &nbsp;<input type="text" name= "studentMajor" value="${student.studentMajor}"><br>
        전화번호: <input type="text" name= "studentMobile" value="${student.studentMobile}"><br>
            <input type="submit" value="수정">
        </form>
</body>
</html>