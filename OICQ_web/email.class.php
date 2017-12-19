<?php
/**
* 邮件发送类
* 支持发送纯文本邮件和HTML格式的邮件，可以多收件人，多抄送，多秘密抄送
* @example
* $mail = new MySendMail();
* $mail->setServer("smtp.exmail. qq.com", "i@dreamwings.cn", "ZQ08671317txwtx"); 设置smtp服务器
* $mail->setFrom("i@dreamwings.cn"); 设置发件人
* $mail->setReceiver("1239277537@qq.com"); 设置收件人，多个收件人，调用多次
* $mail->setCc("XXXX"); 设置抄送，多个抄送，调用多次
* $mail->setBcc("XXXXX"); 设置秘密抄送，多个秘密抄送，调用多次
* $mail->setMailInfo("test", "<b>test</b>"); 设置邮件主题、内容
* $mail->sendMail(); 发送
*/
class MySendMail {
    /**
    * @var string 邮件传输代理用户名
    * @access private
    */
    private $_userName;
 
    /**
    * @var string 邮件传输代理密码
    * @access private
    */
    private $_password;
 
    /**
    * @var string 邮件传输代理服务器地址
    * @access protected
    */
    protected $_sendServer;
 
    /**
    * @var int 邮件传输代理服务器端口
    * @access protected
    */
    protected $_port=25;
 
    /**
    * @var string 发件人
    * @access protected
    */
    protected $_from;
 
    /**
    * @var string 收件人
    * @access protected
    */
    protected $_to;
 
    /**
    * @var string 抄送
    * @access protected
    */
    protected $_cc;
 
    /**
    * @var string 秘密抄送
    * @access protected
    */
    protected $_bcc;
 
    /**
    * @var string 主题
    * @access protected
    */
    protected $_subject;
 
    /**
    * @var string 邮件正文
    * @access protected
    */
    protected $_body;
 
    /**
    * @var string 附件
    * @access protected
    */
    protected $_attachment;
 
    /**
    * @var boolean 是否是纯文本邮件
    * @access protected
    */
    protected $_isPlain=false;
 
    /**
    * @var reource socket资源
    * @access protected
    */
    protected $_socket;
 
    /**
    * @var string 错误信息
    * @access protected
    */
    protected $_errorMessage;
 
 
    /**
    * 设置邮件传输代理
    * @access public
    * @param string $server 代理服务器的ip或者域名
    * @param string $username 认证账号
    * @param string $password 认证密码
    * @param int $port 代理服务器的端口，smtp默认25号端口
    * @return boolean
    */
    public function setServer($server, $username="", $password="", $port=25) {
        $this->_sendServer = $server;
        $this->_port = $port;
        if(!empty($username)) {
            $this->_userName = base64_encode($username);
        }
        if(!empty($password)) {
            $this->_password = base64_encode($password);
        }
        return true;
    }
 
    /**
    * 设置发件人
    * @access public
    * @param string $from 发件人地址
    * @return boolean
    */
    public function setFrom($from) {
        $this->_from = $from;
        return true;
    }
 
    /**
    * 设置收件人，多个收件人，连续调用多次.
    * @access public
    * @param string $to 收件人地址
    * @return boolean
    */
    public function setReceiver($to) {
        if(isset($this->_to)) {
            if(is_string($this->_to)) {
                $this->_to = array($this->_to);
                $this->_to[] = $to;
                return true;
            }
            elseif(is_array($this->_to)) {
                $this->_to[] = $to;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            $this->_to = $to;
            return true;
        }
    }
 
    /**
    * 设置抄送，多个抄送，连续调用多次.
    * @access public
    * @param string $cc 抄送地址
    * @return boolean
    */
    public function setCc($cc) {
        if(isset($this->_cc)) {
            if(is_string($this->_cc)) {
                $this->_cc = array($this->_cc);
                $this->_cc[] = $cc;
                return true;
            }
            elseif(is_array($this->_cc)) {
                $this->_cc[] = $cc;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            $this->_cc = $cc;
            return true;
        }
    }
 
    /**
    * 设置秘密抄送，多个秘密抄送，连续调用多次
    * @access public
    * @param string $bcc 秘密抄送地址
    * @return boolean
    */
    public function setBcc($bcc) {
        if(isset($this->_bcc)) {
            if(is_string($this->_bcc)) {
                $this->_bcc = array($this->_bcc);
                $this->_bcc[] = $bcc;
                return true;
            }
            elseif(is_array($this->_bcc)) {
                $this->_bcc[] = $bcc;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            $this->_bcc = $bcc;
            return true;
        }
    }
 
    /**
    * 设置邮件信息
    * @access public
    * @param string $body 邮件主题
    * @param string $subject 邮件主体内容
    * @param boolean $isPlain 是否是纯文本邮件，默认否
    * @param string $attachment 附件，文件地址
    * @return boolean
    */
    public function setMailInfo($subject, $body, $isPlain=false, $attachment="") {
        $this->_subject = $subject;
        $this->_body = $body;
        $this->_isPlain = $isPlain;
        if(!empty($attachment)) {
            $this->_attachment = $attachment;
        }
        return true;
    }
 
    /**
    * 发送邮件
    * @access public
    * @return boolean
    */
    public function sendMail() {
        $command = $this->getCommand();
        $this->socket();
         
        //print_r($command);exit;
        foreach ($command as $value) {
            if($this->sendCommand($value[0], $value[1])) {
                continue;
            }
            else{
                return false;
            }
        }
         
        $this->close(); //其实这里也没必要关闭，smtp命令：QUIT发出之后，服务器就关闭了连接，本地的socket资源会自动释放
        echo 'Mail OK!';
        return true;
    }
 
    /**
    * 返回错误信息
    * @return string
    */
    public function error(){
        if(!isset($this->_errorMessage)) {
            $this->_errorMessage = "";
        }
        return $this->_errorMessage;
    }
 
    /**
    * 返回mail命令
    * @access protected
    * @return array
    */
    protected function getCommand() {
        $command = array(
                array("HELO sendmail\r\n", 250),
                array("AUTH LOGIN\r\n", 334),
                array($this->_userName . "\r\n", 334),
                array($this->_password . "\r\n", 235),
                array("MAIL FROM:<" . $this->_from . ">\r\n", 250)
                );
 
        //邮件头
        $header = "MIME-Version:1.0\r\n";
        if($this->_isPlain) {
            $header .= "Content-type:text/plain;charset=utf-8\r\n";
        }
        else{
            $header .= "Content-type:text/html;charset=utf-8\r\n";
        }
 
        //设置发件人
        $header .= "FROM:test<" . $this->_from . ">\r\n";
 
        //设置收件人
        if(is_array($this->_to)) {
            $count = count($this->_to);
            for($i=0; $i<$count; $i++){
                $command[] = array("RCPT TO:<" . $this->_to[$i] . ">\r\n", 250);
                $header .= "TO:<" . $this->_to[$i] . ">\r\n";
            }
        }
        else{
            $command[] = array("RCPT TO:<" . $this->_to . ">\r\n", 250);
            $header .= "TO:<" . $this->_to . ">\r\n";
        }
 
        //设置抄送
        if(isset($this->_cc)) {
            if(is_array($this->_cc)) {
                $count = count($this->_cc);
                for($i=0; $i<$count; $i++){
                    $command[] = array("RCPT TO:<" . $this->_cc[$i] . ">\r\n", 250);
                    $header .= "CC:<" . $this->_cc[$i] . ">\r\n";
                }
            }
            else{
                $command[] = array("RCPT TO:<" . $this->_cc . ">\r\n", 250);
                $header .= "CC:<" . $this->_cc . ">\r\n";
            }
        }
 
        //设置秘密抄送
        if(isset($this->_bcc)) {
            if(is_array($this->_bcc)) {
                $count = count($this->_bcc);
                for($i=0; $i<$count; $i++){
                    $command[] = array("RCPT TO:<" . $this->_bcc[$i] . ">\r\n", 250);
                    $header .= "BCC:<" . $this->_bcc[$i] . ">\r\n";
                }
            }
            else{
                $command[] = array("RCPT TO:<" . $this->_bcc . ">\r\n", 250);
                $header .= "BCC:<" . $this->_bcc . ">\r\n";
            }
        }
 
        $header .= "Subject:" . $this->_subject ."\r\n\r\n";
        $body= $this->_body . "\r\n.\r\n";
        $command[] = array("DATA\r\n", 354);
        $command[] = array($header, "");
        $command[] = array($body, 250);
        $command[] = array("QUIT\r\n", 221);
 
        return $command;
    }
 
    /**
    * @access protected
    * @param string $command 发送到服务器的smtp命令
    * @param int $code 期望服务器返回的响应吗
    * @param boolean
    */
    protected function sendCommand($command, $code) {
        echo 'Send command:' . $command . ',expected code:' . $code . '<br />';
        //发送命令给服务器
        try{
            if(socket_write($this->_socket, $command, strlen($command))){
 
                //当邮件内容分多次发送时，没有$code，服务器没有返回
                if(empty($code))  {
                    return true;
                }
 
                //读取服务器返回
                $data = trim(socket_read($this->_socket, 1024));
                echo 'response:' . $data . '<br /><br />';
 
                if($data) {
                    $pattern = "/^".$code."/";
                    if(preg_match($pattern, $data)) {
                        return true;
                    }
                    else{
                        $this->_errorMessage = "Error:" . $data . "|**| command:";
                        return false;
                    }
                }
                else{
                    $this->_errorMessage = "Error:" . socket_strerror(socket_last_error());
                    return false;
                }
            }
            else{
                $this->_errorMessage = "Error:" . socket_strerror(socket_last_error());
                return false;
            }
        }catch(Exception $e) {
            $this->_errorMessage = "Error:" . $e->getMessage();
        }
    }
}
$mail = new MySendMail();
$mail->setServer("smtp.exmail. qq.com", "i@dreamwings.cn", "ZQ08671317txwtx");
$mail->setFrom("i@dreamwings.cn");
$mail->setReceiver("1239277537@qq.com");
$mail->setReceiver("1239277537@qq.com");
//$mail->setCc("XXXXXX");
//$mail->setCc("XXXXXX");
$mail->setBcc("XXXXX");
$mail->setBcc("XXXXX");
$mail->setMailInfo("test", "<b>test</b>");
$mail->sendMail();
?>