# wechat-sdk
> 对微信接口进行了封装，简单易用，jre-version 1.7

## 微信Module
> 微信工程可以分为3个部分

1. wechat-admin，管理后台（PC端配置）
2. wechat-front，微站（移动端显示）
3. wechat-api，微信消息接口（将微信消息接口独立出来减轻front负载，同时提供对内、外部的接口）

#### 已实现接口
1. 消息接口
2. 微信网页开发
3. 素材管理
4. 用户管理
5. 账号管理
6. 微信多客服
7. 数据统计

#### Msg center
- 获取地理位置
- 认证事件推送


#### TODO
1. 消息接口
    获取公众号自动回复配置
5. 微信小店
6. 微信卡券
7. 微信门店
8. 微信智能接口
9. 微信多客服
    多客服会话控制
    获取客服聊天记录
    自定义插件
10. 微信摇一摇
11. 微信连WiFi
12. 微信扫一扫

**should callback**

> e.g

```java
    WxBase wxBase = WxCache.getWxBase(tenantId)
    TemplateMsgClient client = WxClientFactory.getClient(TemplateMsgClient.class, wxBase);
    TemplateMsgResult rs = client.send(WxCache.getAccessToken(tenantId), msg);
    // 回调校验accessToken是否有效
    WxCache.refreshAccessTokenIfInvalid(rs, tenantId);
```

> m2 central repository snapshot

```xml
<dependency>
  <groupId>com.codeyn</groupId>
  <artifactId>wechat-sdk</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

#### upgrade
1. local cache
2. extends template message
3. message center



