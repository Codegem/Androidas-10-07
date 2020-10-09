<?php

//$username = "root";
//$password = "";
//$hostname = "localhost";
//$dbname = "dbandroid";
$username = "epiz_26857436";
$password = "Evaldaskis123";
$hostname = "sql309.epizy.com";
$dbname = "epiz_26857436_db";


$mysqli = new mysqli($hostname, $username, $password, $dbname);

// Check connection
if ($mysqli -> connect_errno) {
  echo "Failed to connect to MySQL: " . $mysqli -> connect_error;
  exit();
}
else {
    echo "success";
}

//$postas = $_POST['action'];
//if (!strcmp('insert', $postas)) {
$kaciumaistas = $_POST['kaciumaistas'];
$pristatymas = $_POST['pristatymas'];
$kaina = $_POST['KAINA'];
$atsiskaitymas = $_POST['atsiskaitymas'];
$veisle = $_POST['veisle'];

$mysqli = "INSERT INTO octopop (kaciumaistas, pristatymas, KAINA, atsiskaitymas, veisle) VALUES ('$kaciumaistas', '$pristatymas', '$kaina', '$atsiskaitymas', '$veisle')";
if ($connect->query($sql) === TRUE){
    echo "Success";
   }
   else{
    echo "Insert failed";
	}
//}
 $mysqli->close();

 ?>



