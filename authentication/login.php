<?php

if (isset($_POST['email'], $_POST['password'])) {
    require_once '../connect.php';
    require_once './validate.php';
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    $sql = "SELECT * FROM users WHERE email='$email' AND password='" . md5($password) . "'";
    $result = array();
    $result['data'] = array();
    $response = mysqli_query($conn, $sql);
    if (mysqli_num_rows($response) === 1) {
        $row = mysqli_fetch_assoc($response);
        $ds['fullname'] = $row['fullname'];
        $ds['phone_number'] = $row['phone_number'];
        $ds['email'] = $row['email'];
        $result['status'] = 'success';
        array_push($result['data'], $ds);
        echo json_encode($result);
        mysqli_close($conn);
    } else {
        $result['status'] = 'error';
        echo json_encode($result);
        mysqli_close($conn);
    }
}


?>