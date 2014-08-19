<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<p>Please choose a fruit from below list</p>
	<form action="/fruitPicker" method="post">
	<#list favouriteFruits as fruits>
		<p>
			<input type="radio" name="fruit" value="${fruits}">${fruits}</input>
		</p>
	</#list>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>