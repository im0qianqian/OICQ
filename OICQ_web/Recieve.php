<?php
include 'library/connectsql.php';
//连接数据库
functionconn();
if (isset($_POST["send"])) {
	$name = trim($_POST["nick_name"]);
	$email = trim($_POST["email"]);
	$password = $_POST["password"];
	$password2 =$_POST["password2"];
	if (strlen($name) < 3 || strlen($name) > 20) {
		//echo '用户名不能小于2位';
		//header("Location:a.php");
		echo "<script>alert('用户名不能小于两位或者大于二十位');history.back();</script>";
		exit ;
	}
	if($password != $password2){
		echo "<script>alert('请确保两次密码输入一致');history.back();</script>";
		exit;
	}

	//改参数
	$sql = "select user_name from dw_user where '".$email."'=user_email";
	$nick = mysql_query($sql);
	if (mysql_fetch_row($nick)) {
		echo "<script>alert('该邮箱已被注册');history.back();</script>";
		exit;
	}
	if (strlen($password) < 6) {
		echo "<script>alert('密码不能小于六位');history.back();</script>";
		exit ;
	}
	$pattern = "/^([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)$/i";
	if (preg_match_all($pattern, $email) != 1) {
		echo "<script>alert('邮箱格式错误');history.back();</script>";
		exit;
	}
	$sql = "insert into dw_user (user_name,user_password,user_email) values('".$name."',md5('".$password."'),'".$email."')";
	if(mysql_query($sql)){
		echo "<script>alert('注册成功');history.back();</script>";
		exit;
	}
} else {
	header("Location:index.php");
	exit ;
}
?>
