<?php
include "connect.php";
class Sanpham{
   public $id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham;
   function __construct($id,$tensanpham,$giasanpham,$hinhanhsanpham,$motasanpham,$idsanpham){
      $this->id=$id;
      $this->tensanpham=$tensanpham;
      $this->giasanpham=$giasanpham;
      $this->hinhanhsanpham=$hinhanhsanpham;
      $this->motasanpham=$motasanpham;
      $this->idsanpham=$idsanpham;

   }
}

$page = $_GET['page'];
// $idsp=$_POST['idsanpham'];
$idsp=1;
$space=5;
$limit=($page-1)*$space;
$mangsanpham = array();
$query = "SELECT * FROM sanpham WHERE idsanpham = $idsp LIMIT $limit,$space";
$data = mysqli_query($conn,$query);

while($row=mysqli_fetch_assoc($data)){
   array_push($mangsanpham,new Sanpham(
      $row['id'],
      $row['tensanpham'],
      $row['giasanpham'],
      $row['hinhanhsanpham'],
      $row['motasanpham'],
      $row['idsanpham']
   ));
}
echo json_encode($mangsanpham);


?>