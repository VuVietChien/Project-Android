<?php
if (isset($_POST['fullname']) && $_POST['phone_number'] && $_POST['email']) {
    require_once '../connect.php';
    require_once './validate.php';
    $fullname = validate($_POST['fullname']);
    $phone_number = validate($_POST['phone_number']);
    $email = validate($_POST['email']);
    $sql = "SELECT * FROM users WHERE email='$email'";
    $result = array();
    $response = mysqli_query($conn, $sql);
    if (mysqli_num_rows($response) > 0) {
        $result['status'] = 'success';
        $sql1 = "UPDATE users SET fullname='$fullname',phone_number='$phone_number' WHERE email='$email'";
        $response = mysqli_query($conn, $sql1);
        echo json_encode($result);
        mysqli_close($conn);
    } else {
        $result['status'] = 'error';
        echo json_encode($result);
        mysqli_close($conn);
    }
}


