<%@ taglib tagdir="/WEB-INF/tags" prefix="data"%>

<html>
<head>
	<link href="css/jquery.css" rel="stylesheet"/>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
</head>
<body>
	<form action="sistema" method="POST">
		Nome  : <input type="text" name="nome"/><br/>
		Idade : <input type="text" name="email"/><br/>
		Endereço : <input type="text" name="endereco"/><br/>
		Data de nascimento : <data:campoData id="DATA"/><br/>
		
	<input type="submit" value="Enviar"/>
	</form>
</body>
</html>