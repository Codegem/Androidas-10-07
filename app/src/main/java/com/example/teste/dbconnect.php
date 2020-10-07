<?php

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

// $postas = $_POST['action'];
// if (!strcmp("insert", $postas)) {
$kaciumaistas = $_POST['kaciumaistas'];
$pristatymas = $_POST['pristatymas'];
$kaina = $_POST['KAINA'];
$atsiskaitymas = $_POST['atsiskaitymas'];
$veisle = $_POST['veisle'];

$sql = "INSERT INTO octopop (kaciumaistas, pristatymas, KAINA, atsiskaitymas, veisle) VALUES ('$kaciumaistas', '$pristatymas', '$kaina', '$atsiskaitymas', '$veisle')";
if($mysqli->query($sql) === TRUE){
    echo "Success";
   }
   else{
    echo "Insert failed";
    }
//    }
 $connect->close();


 ?>

http://androidoapsas.epizy.com/?$kaciumaistas='maistas'&$pristatymas='prist'&$KAINA='2'&$atsiskaitymas='ats'&$veisle='kate'

http://androidoapsas.epizy.com/?atsiskaitymas=0&pristatymas=Taip&veisle=0&kaciumaistas=Aatas+Cat+Creamy+Chicken+andTuna+80+g+&KAINA=2.0&action=insert


