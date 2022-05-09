<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Dati Persona da confermare</title>
</head>
<body>
	<h1>Controlla se i dati inseriti sono corretti:</h1>
	<div>Nome: ${persona.nome}</div>
	<div>Cognome: ${persona.cognome}</div>
	<form action="conferma" method="post">
		<div>
			<input type="submit" name="avanti" value="Conferma" />
		</div>
		<div>
			<input type="submit" name="indietro" value="Indietro" />
		</div>
	</form>
</body>
</html>