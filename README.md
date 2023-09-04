# OICQ

**UPD: 2020.07.01**

本项目配置教程已出炉，观看链接：[https://www.bilibili.com/video/BV1Fb411V7yP?p=2](https://www.bilibili.com/video/BV1Fb411V7yP?p=2)

OICQ_web 演示出错的原因是 PHP 7.0 已经废弃掉当时使用的函数了，估计 5.6 版本正常。

欢迎大家 star，或者去 bilibili 一键三连~ 也欢迎大家提 pr 来修复项目中的 bug。

---

**UPD: 2019.04.20**

突然想把以前为这个程序录制视频的作业发布在 bilibili 上啦~

于是，就有了 [【开发向】OICQ（一款仿 QQ 的聊天程序）](https://www.bilibili.com/video/av49842257)

嗯~ 当时因为有时间限制，所以视频做了加速处理~ 希望不要嫌弃千千啦~ 嘤~

---

**UPD: 2019.04.15**

看到好多人 fork 简单说说如何开箱吧！

本项目基于 JDK 8 + MySQL 开发

SQL 建表语句在[这里](https://github.com/im0qianqian/OICQ/blob/master/OICQ_server/src/com/oicq/database/create.sql)

带数据的建表语句在[这里](https://github.com/im0qianqian/OICQ/blob/master/OICQ_server/src/com/oicq/database/create_with_data.sql)，数据为课设时测试所用，账户为 `10001`（可参考 SQL 内容），密码为 `123456`

有关服务端/客户端通讯地址及端口设置见 config 下的 ServerInfo.java（server/client 各有一份）

OICQ_web 是用 PHP 编写的一个简单的注册页面（忘记有没有 bug 了）

该项目仅供学习参考，其中很多安全问题并没有考虑到（可轻易 sql 注入），部分预留功能尚未实现（如修改密码/头像之类的），还望多多包涵！

---

**UPD: 2017.12.19**

大二第一学期的 Java 课程设计，开发时也是在 GitHub 中托管的，之后下线了好久，现重新上线，体验还不是很完美，望多多包涵。



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

### Star History

[![Star History Chart](https://api.star-history.com/svg?repos=im0qianqian/OICQ&type=Date)](https://star-history.com/#im0qianqian/OICQ&Date)
