<?php

//$username = "root";
//$password = "";
//$hostname = "localhost";
//$dbname = "dbandroid";
$username = "epiz_26857436";
$password = "Evaldaskis123";
$hostname = "sql309.epizy.com";
$dbname = "epiz_26857436_db";

$conn = new mysqli($hostname, $username, $password, $dbname);

// Check connection
if ($conn -> connect_errno) {
  echo "Failed to connect to MySQL: " . $conn -> connect_error;
  exit();
}
else {
    echo "success";
}

$postas = $_POST['action'];
//if (!strcmp("insert", $postas)) {
$regusername = $_POST['username'];
$regpassword = $_POST['password'] ;
$regemaile = $_POST['email'] ;

$sql = "INSERT INTO users (username, password, email)
        VALUES ('$regusername', '$regpassword', '$regemaile')";
if ($conn->query($sql) === TRUE){
    echo "Success insertion";
   }
   else{
    echo "Insert failed";
	}
//}
 $conn->close();
 
 ?>



