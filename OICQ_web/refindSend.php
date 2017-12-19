<?php
include 'library/connectsql.php';
//连接数据库
functionconn();
if (isset($_POST["send"])) {
	$email = $_POST["email"];
	$pattern = "/^([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)$/i";
	if (preg_match_all($pattern, $email) != 1) {
		echo "<script>alert('邮箱格式错误');history.back();</script>";
		exit;
	}

} else {
	header("Location:refindPass.php");
	exit ;
}
?>
