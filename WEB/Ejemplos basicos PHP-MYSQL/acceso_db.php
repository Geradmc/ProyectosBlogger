<?php
	$host_db="localhost";
	$usuario_db="root";
	$clave_db="mypass";
	$nombre_db="biblio";
	
	mysql_connect($host_db,$usuario_db,$clave_db);
	mysql_select_db($nombre_db);

	$q="select * from libro;";
	$res = mysql_query($q);
	if($row=mysql_fetch_array($res)){
		echo "Consulta realizada correctamente";
		echo "<br/>ISBN: ".$row['ISBN']." | titulo: ".$row['titulo']." | autor: ".$row['autor'];
	}
?>
