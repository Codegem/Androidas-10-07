<?php

$username = "beretos";
$password = "Beretos123";
$hostname = "185.5.52.35";
$dbname = "beretos_octopopscat";

$connect = new mysqli ($username, $password, $hostname, @dbname);

if($connect->connect_error){
    die("Err".$connect->connect_error);
}

$postas = $_POST['action'];
if (!strcmp("insert", $postas)) {
$kaciumaistas = $_POST['kaciumaistas'];
$pristatymas = $_POST['pristatymas'];
$kaina = $_POST['kaina'];
$atsiskaitymas = $_POST['atsiskaitymas'];
$veisle = $_POST['veisle'];

$sql = "INSERT INTO octopops (kaciu_maistas, pristatyma, kaina, atsiskaitymas, veisle)";
if($connect->query($sql) === TRUE){
    echo "Success";
   }
   else{
    echo "Insert failed";
    }
   }
 $connect->close();