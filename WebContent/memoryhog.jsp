<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Hog</title>
</head>
<body>

<h1>Memory Hog</h1>

<h2>Fill the form below and submit to cause memory usage on the heap </h2>
<form method="POST" action="/WebHog/MemoryHogServlet">
	<p>
		<span>Long living objects</span><input type="text" name="llo"/>
	</p>
	<p>
		<span>Iterations</span><input type="text" name="iterations"/>
	</p>
	<p>
		<span>Objects Per Iterations</span><input type="text" name="objects"/>
	</p>
	<p>
		<input type="submit" name="submit" value="submit" />
	</p>
</form>

<h2>Notes</h2>
<p>
	<div>Start the JVM with the following option to ensure that the heap is dumped when an OOME occurs.</div>
	<div><code>-XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/path/to/file</code></div>
</p>
<p>
	<div>Start the JVM with the following option to view GC details.</div>
	<div><code>-verbose:gc -XX:+PrintGCTimeStamps -XX:+PrintGCDetails</code></div>
</p>
<p>
	<div>Start the JVM with the following option to change the young:old ratio</div>
	<code>-XX:NewRatio:3</code>
</p>
<p>
	<div>Start the JVM with the following option to set the maximum pause time for GC</div>
	<code>-XX:MaxGCPauseMillis=nnn</code>
</p>
<p>
	<div>Start the JVM with the following option to set a goal for the desired throughput</div>
	<code>-XX:GCTimeRatio=nnn</code>
</p>
</body>
</html>