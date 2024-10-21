<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 body{
background: rgb(49,103,103);
background: radial-gradient(circle, rgba(49,103,103,1) 20%, rgba(2,0,36,1) 69%, rgba(2,0,36,1) 81%);
color:white;
} 
div{
display: flex;
justify-content: center;
align-items: center;
}
a{
text-decoration: none;
color:white;

}
button{
background-color: rgba(2,0,36,1);
padding: 6px;
margin: 10px;
border-radius: 10px;
}
button:hover{
background-color: green;

}
h1{
text-align: center;
}
</style>
</head>
<body>

<h1>Are You sure to delete the data ??</h1>
<div>
<%	int id =Integer.parseInt(request.getParameter("id")); %>
 <button> <a href="del?id=<%= id %>">Yes</a></button>
 <button> <a href="home.jsp">No</a> </button>
</div>
</body>
</html>