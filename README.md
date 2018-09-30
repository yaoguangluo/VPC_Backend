# VPC5.0
在这里再次感谢高斯林先生。
这个项目是怎么来的？ 罗瑶光先生在2009年在印度花了300卢比，买了本java how to program 6书籍，然后在 项目中应用了开源java，对开源java有好感，在2012年接触了开源缓存服务器，在2014年一些项目中接触了开源spring， 在2015年一些项目中接触了开源angular1.2 和开源redis 在 2016年项目中接触了开源mokito 的高级应用，在2017年一些项目中接触了开源docker，于是将这数十个互联网开源项目整合起来，提取最人性化的开源组件和最完善的开源工作流理念，基于mvc和mvp的理念重新设计了VPC的架构。

VPC定义： c是控制器， p是处理机，v是观察模式，这种rest碎片化操作远胜mvc模式。又没有mvp复杂和细化

声明：
##  1.该架构开发软件基于intellij
##  2.所有代码基于开源java架构共享协议，不存在侵权，用户可以自由下载并自由修改集成到自己的程序中。
##  3.改程序不受版权保护，一切因java虚拟机引起的私人或者商业问题，本人不做任何解释。
架构核心技术后端基于springboot， 和前端angular， 基于国内市场比较生僻，遇到问题请搜索相关开源网站。
##  4.该架构数据库链接采用mybatis，测试采用mockspy 和kamar
##  5.代码api本地仓库使用 nexsus 和 gradle
##  6.可自由集成sonar测试
##  7.可docker部署
##  8.可jenkins发布
##  9.支持gitlab 版本控制做 CICD
##  10.服务器采用嵌入式Jetty部署

#注意：
We found a potential security vulnerability in one of your dependencies.
A dependency defined in …/static/package-lock.json has known security vulnerabilities and should be updated.

Only the owner of this repository can see this message.
Learn more about vulnerability alerts

里面的jason文件有个别安全漏洞，大家可以用最新的开源包替代， 谢谢。



作者
20180727
