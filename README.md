# OICQ

**UPD: 2019.04.15**

看到好多人 fork 简单说说如何开箱吧！

本项目基于 JDK8 + MySQL 开发

SQL 建表语句在[这里](https://github.com/im0qianqian/OICQ/blob/master/OICQ_server/src/com/oicq/database/create.sql)

有关服务端/客户端通讯地址及端口设置见 config 下的 ServerInfo.java（server/client 各有一份）

OICQ_web 是用 PHP 编写的一个简单的注册页面（忘记有没有 bug 了）

该项目仅供学习参考，其中很多安全问题并没有考虑到（可轻易 sql 注入），部分预留功能尚未实现（如修改密码/头像之类的），还望多多包涵！

---

**UPD: 2017.12.19**

大二第一学期的 Java 课程设计，开发时也是在 GitHub 中托管的，之后下线了好久，现重新上线，体验还不是很完美，忘多多包涵。



### Client

- [x] 登录部分
- [x] 单人聊天、多人聊天
- [ ] 匿名聊天
- [x] 获取个人信息及好友信息
- [ ] 设置个人信息
- [ ] 管理员部分（管理服务器、审计日志、管理用户信息）
- [ ] 更换主题等设置



### Server

- [x] 成功与客户端建立通讯
- [x] 登录请求部分
- [x] 返回个人信息、好友列表、群列表
- [x] 聊天数据交互
- [x] 聊天记录存入数据库
- [ ] GUI 界面
