<%@page import="com.org.dao.userDao"%>
<%@page import="com.org.dto.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="additional/bootstrapCss.jsp"%>
<style type="text/css">
body {
	color: white;
	background: rgb(49, 103, 103);
	background: radial-gradient(circle, rgba(49, 103, 103, 1) 20%,
		rgba(2, 0, 36, 1) 69%, rgba(2, 0, 36, 1) 81%);
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.8);
	background-color: rgba(2, 0, 36, 1);
	color: orange;
}
</style>
</head>
<body>
	<%@ include file="additional/home_nav.jsp"%>
	<%
	user user1 = (user) session.getAttribute("userobj");
	%>

	<%
	userDao dao = new userDao();
	int id = Integer.parseInt(request.getParameter("id"));
	user user3 = dao.fetchUserById(id);
	%>

	<%
	if (user1 == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Details</p>
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value="<%=user3.getName()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" class="form-control" value="<%=user3.getAge()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control"
									value="<%=user3.getEmail()%>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="text" class="form-control" value="<%=user3.getMobile()%>"
									required>
							</div>
							<input name="id" type="hidden" value="<%=user3.getId()%>">
							<button type="submit"
								class="btn bg-secondary text-white col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>