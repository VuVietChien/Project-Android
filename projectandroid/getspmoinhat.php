<?php
include "connect.php";
class Sanphammoinhat{
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

$mangspmoinhat=array();
//ORDER BY ID DESC LIMIT 6
$query = "SELECT * FROM sanpham ";

$data=mysqli_query($conn,$query);
while($row=mysqli_fetch_assoc($data)){
   array_push($mangspmoinhat,new Sanphammoinhat(
      $row['id'],
      $row['tensanpham'],
      $row['giasanpham'],
      $row['hinhanhsanpham'],
      $row['motasanpham'],
      $row['idsanpham']
   ));
}

echo json_encode($mangspmoinhat);


?>