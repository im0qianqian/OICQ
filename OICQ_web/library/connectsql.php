<?php
//连接数据库
function functionconn() {
	header('content-type:text/html;charset=utf-8');
	//改参数
	define('USHost', 'localhost');
	define('DUSER', 'oicq');
	define('UPWD', 'im0qianqian');
	define('Dname', 'oicq');
	$conn = @mysql_connect(USHost, DUSER, UPWD) or die('failture connect' . mysql_errno());
	mysql_query('set names utf8');
	mysql_select_db(Dname, $conn);
	if (mysql_select_db(Dname, $conn) != 1)
		die('error:' . mysql_errno());
}
?>