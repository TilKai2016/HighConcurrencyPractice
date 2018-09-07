# HighConcurrencyPractice

## SpringBoot 官方2.0.4文档

[SpringBoot 官方2.0.4文档](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#boot-features-custom-log-configuration)

## 使用模板模式定义通用缓存key的封装

`接口` -> `抽象类` -> `实现类`

一般的使用接口来定义契约, 使用抽象类定义共通的实现, 将特殊的实现交给实现类实现.

## 使用两次MD5加密

客户端进行一次对明文密码的md5加密(使用固定的salt)后, 将一次加密的密码传输给服务器端;
服务器端对一次加密的密文做二次加密(使用随机的salt), 之后将二次加密的密码和该随机salt写入到数据库当中;
