<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Hog</title>
</head>
<body>
<h1>CPU Hog</h1>
<div>
<form method="POST" action="/WebHog/CPUHogServlet"">	
	<p>
		<span>Analysis (method 1) count: </span><input type="text" name="count1"/>
	</p>
	<p>
		<span>Analysis (method 2) count: </span><input type="text" name="count2"/>
	</p>
	<p>
		<span>Print messages to console? </span><input type="text" name="sysout"/>
	</p>
	<p>
		<input type="submit" name="submit" value="submit" />
	</p>
</form>
</div>
<div>
Clicking on <a href="/WebHog/CPUHogServlet?threading=true">this link</a> will create multiple threads, one of which will hog the CPU big time.
</div>
</body>
</html>