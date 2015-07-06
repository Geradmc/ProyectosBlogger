<?php
	echo "Variables Globales y locales<br/><br/>";
	/*Variable Global*/
	$x=0;

	function asignX(){
		/*Variable local*/
		$x=10;
		echo $x."<br/>";
	}
	asignX();
	$x++;
	echo $x."<br/>";
	echo "<br/>";
?>

<?php
	echo "Condicionales: if y switch <br/><br/>";
	/*Condicionales*/
	/*if else*/

	$y=0;
	if($y==0){
		echo "if: y es igual a 0<br/>";
	} else if($y==1){
		echo "if: y es igual a 1<br/>";
	} else if($y==2){
		echo "if: y es igual a 2<br/>";
	}

	/*switch*/
	$y=1;
	switch ($y) {
		case 0:
			echo "switch: y es igual a 0<br/>";
		break;
		case 1:
			echo "switch: y es igual a 1<br/>";
		break;
		case 2:
			echo "switch: y es igual a 2<br/>";
		break;
	}
	echo "<br/>";
?>

<?php
	echo "Ciclos: for, while y do while.<br/><br/>";
	/*ciclos*/
	/*for*/
	echo "ciclo for<br/>";
	for($i=0; $i<10; $i++){
		echo "iteracion ".$i."<br/>";
	}
	echo "<br/><br/>";

	/*while*/
	echo "ciclo while<br/>";
	$i=0;
	while($i<10){
		echo "iteracion ".$i."<br/>";
		$i++;	
	}
	echo "<br/><br/>";

	/*do while*/
	$i=0;
	echo "ciclo do while<br/>";
	do{
		echo "iteracion ".$i."<br/>";
		$i++;
	}while($i<10);
	echo "<br/><br/>";
?>

<?php
	/*funciones*/
	function cInt(){
		$i=10;
		return $i;
	}

	function cString(){
		$cadena="hola mundo";
		return $cadena;
	}

	function cFloat(){
		$decimales=3.141595;
		return $decimales;
	}

    function cDatos($datos, $i){
    	for($j=0; $j<$i; $j++){
    		echo $datos." ".$j."<br/>";
    	}
    }

	echo "funcion que regresa entero: ".cInt()."<br/>";
	echo "funcion que regresa cadena: ".cString()."<br/>";
	echo "funcion que regresa números con decimales: ".cFloat()."<br/>";
	echo "funcion que no regresa nada y recibe argumentos: <br/>";
	cDatos("hola mundo",5);
	echo "<br/><br/>";
?>