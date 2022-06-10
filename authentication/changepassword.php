<?php
if (isset($_POST['email'], $_POST['oldPassword'], $_POST['newPassword'], $_POST['reNewPassword'])) {
    require_once '../connect.php';
    require_once './validate.php';
    $email = validate($_POST['email']);
    $oldPassword = validate($_POST['oldPassword']);
    $newPassword = validate($_POST['newPassword']);
    $reNewPassword = validate($_POST['reNewPassword']);
    $sql = "SELECT * FROM users WHERE email='$email' AND password='" . md5($oldPassword) . "'";
    $result = array();
    $response = mysqli_query($conn, $sql);
    if (mysqli_num_rows($response) > 0) {
        $result['status'] = 'success';
        $sql1 = "UPDATE users SET password='" . md5($newPassword) . "' WHERE email='$email'";
        $response = mysqli_query($conn, $sql1);
        echo json_encode($result);
        mysqli_close($conn);
    } else {
        $result['status'] = 'error';
        echo json_encode($result);
        mysqli_close($conn);
    }
}


