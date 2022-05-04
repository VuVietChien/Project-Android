<?php
$host="localhost";
$user="root";
$pass="";
$database="thietbi";

$conn=mysqli_connect($host,$user,$pass,$database);
mysqli_query($conn, "SET NAMES 'utf8'");

if($conn){
   //code...
  
}
?>