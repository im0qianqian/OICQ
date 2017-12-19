<!DOCTYPE html>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <title>HULIAO Refind password</title> 
  <style>
body {
    font-family: "Helvetica Neue",sans-serif;
    font-size: 14px;
    line-height: 1.4285;
    color: #333;
    background-color: #fff;
}

.form-control {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.4285;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	box-shadow: inset 0px 1px 1px rgba(0,0,0,0.075);
	-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}

.btn {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.4285;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
}

.btn-primary {
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}

.btn.focus, .btn:focus, .btn:hover {
	color: #333;
	text-decoration: none;
}

.btn-primary.focus, .btn-primary:focus {
	color: #fff;
	background-color: #286090;
	border-color: #122b40;
}

.btn-primary:hover {
	color: #fff;
	background-color: #286090;
	border-color: #204d74;
}

.main {
	padding-top: 80px;
	width: 30%;
	margin: 0 auto;
}

.form-group {
	margin-bottom: 15px;
	padding-top: 25px;
	padding-bottom: 25px;
}

.control-label {
	padding-top: 12px;
	text-align: right;
}

label {
	display: inline-block;
	max-width: 100%;
	margin-bottom: 5px;
	font-weight: 700;
	padding-right: 15px;
}

.col-md-2 {
	width: 12%;
}

.col-md-10 {
	width: 82%;
}

.col-md-2,.col-md-10 {
	float: left;
	position: relative;
	min-height: 1px;
}
  </style> 
 </head> 
 <body> 
  <div class="main"> 
   <h1 align="center">HULIAO refind password</h1> 
   <h2 align="center">这是一个颜值贬低的QQ</h2> 
   <form action="refindSend.php" method="post"> 
    <div class="form-group"> 
     <label class="col-md-2 control-label">Email: </label> 
     <div class="col-md-10"> 
      <input type="text" name="email" class="form-control"/> 
     </div> 
    </div> 
    <div class="form-group"> 
     <div class="col-md-10 col-md-offset-2" style="padding:20px 14.5%"> 
      <input type="submit" class="btn btn-primary btn-bg" value="发送邮件找回密码" name="send" /> 
     </div> 
    </div> 
   </form> 
  </div>   
 </body>
</html>
<?php

?>