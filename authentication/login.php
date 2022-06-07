<?php
if (isset($_POST['email'], $_POST['password'])) {
    require_once '../connect.php';
    require_once './validate.php';
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    $sql = "SELECT * FROM users WHERE email='$email' AND password='" . md5($password) . "'";
    $result = mysqli_query($conn,$sql);
    if ($result) {
        echo "Success";
    }else{
        echo "Failure";
    }

}


?>