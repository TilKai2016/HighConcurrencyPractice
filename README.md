# HighConcurrencyPractice

## SpringBoot 官方2.0.4文档

[SpringBoot 官方2.0.4文档](https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#boot-features-custom-log-configuration)

## 使用模板模式定义通用缓存key的封装

`接口` -> `抽象类` -> `实现类`

一般的使用接口来定义契约, 使用抽象类定义共通的实现, 将特殊的实现交给实现类实现.

## 使用两次MD5加密

客户端进行一次对明文密码的md5加密(使用固定的salt)后, 将一次加密的密码传输给服务器端;
服务器端对一次加密的密文做二次加密(使用随机的salt), 之后将二次加密的密码和该随机salt写入到数据库当中;

## JSR303参数校验

JSR303参数校验基本已经成为一种行业标准, 依赖为

```groovy
compile('org.springframework.boot:spring-boot-starter-validation')
```

除了使用已有的`@NotNull`, `@Length`等注解外, 可以自定义校验注解, 实现与业务匹配的校验.

如自定义`@IsMobile`注解, 配合自定义`ConstraintValidator`的实现类, 实现自定义校验.

## 异常处理

如何将异常优雅的抛出到前台, 从而友好的提示用户呢.
可以使用`@ControllerAdvice`注解来标注一个异常处理类, 这其实是一个AOP处理, 在该异常处理类中定义一个可以拦截处理指定异常的异常处理方法, 
该方法或该方法所在的类使用`@ResponBody`进行标注, 向客户端返回友好的异常提示信息.

你也可以通过自定义继承于RuntimeException的自定义异常来满足自己的业务需求.
