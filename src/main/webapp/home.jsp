<%@page import="com.org.dto.user"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.userDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="additional/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card{
box-shadow: 0 0 10px 0 rgba(0,0,0,0.5);
background-color: rgba(2,0,36,1);
color:orange;
}
 body{
background: rgb(49,103,103);
background: radial-gradient(circle, rgba(49,103,103,1) 20%, rgba(2,0,36,1) 69%, rgba(2,0,36,1) 81%);
} 

th{
color:orange;
font-size: large;
}
td{
color:white;
}
</style>
</head>
<body>

	<% user user1=(user)session.getAttribute("userobj");
		if(user1==null){
			response.sendRedirect("login.jsp");
		}
		else{
	%>
	<%@ include file="additional/home_nav.jsp" %>
	<% userDao dao=new userDao();
		List<user> list= dao.fetchAllUsers();
	%>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<table class="table">
							<thead>
							<tr>
							<th>Name</th>
							<th>Age</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Action</th>
							</tr>
							</thead>
							<tbody>
							<% for(user user: list){
								if(user.getId()==user1.getId())
									continue;%>
								<tr>
								<td><%=user.getName() %></td>
								<td><%=user.getAge() %></td>
								<td><%=user.getEmail() %></td>
								<td><%=user.getMobile() %></td>
								<td><a class="btn  btn-md btn-primary" href="profile.jsp?id=<%=user.getId()%>">update</a>
								<a class="btn btn-md btn-danger" href="delete.jsp?id=<%= user.getId()%>">delete</a></td>
								<%  %>
								</tr>
							<%} %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>				
	</div>
	
	<%} %>
</body>
</html>