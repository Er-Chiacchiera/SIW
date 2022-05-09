<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>SIW servlet es3</title>
</head>
<body>
	<form action="persona" method="post">
		<div>Nome: <input type="text" name="nome" /></div>
		<div>Cognome: <input type="text" name="cognome" /></div>
		<div><input type="submit" 
			name="sumbit" value="invia" /></div>
	</form>
	<div>${messaggiErrore["nome"] }</div>
	<div>${messaggiErrore["cognome"] }</div>
</body>
</html>