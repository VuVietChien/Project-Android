<?php
if (isset($_POST['email'], $_POST['password'], $_POST['fullname'], $_POST['phone_number'])) {
    require_once '../connect.php';
    require_once './validate.php';
//$email = "thuan@gmail.com";
//$password = "123";
//$fullname = "sd";
//$phone_number = "123";
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    $fullname = validate($_POST['fullname']);
    $phone_number = validate($_POST['phone_number']);
    $sql = "INSERT INTO users (fullname,email,phone_number,password)  values ('$fullname','$email','$phone_number','" . md5($password) . "')";
    $result = mysqli_query($conn, $sql);
    if ($result) {
        echo "Success";
    } else {
        echo "Failure";
    }

}



?>