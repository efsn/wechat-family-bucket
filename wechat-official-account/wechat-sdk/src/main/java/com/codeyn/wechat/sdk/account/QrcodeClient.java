/**
 * Copyright (c) 2016 Arthur Chan 陈 (codeyn@163.com).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.codeyn.wechat.sdk.account;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.codeyn.wechat.sdk.account.model.Qrcode;
import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.core.model.WxResult;

/**
 * 生成带参数的二维码
 */
public class QrcodeClient extends WxClient {

    public QrcodeClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 创建二维码
     * 
     * @param scene
     *            临时是Integer，永久是String
     */
    public Qrcode create(String accessToken, final Object sceneId, final boolean isForever) {
        return doPost(Qrcode.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                JSONObject actionInfo = new JSONObject();
                JSONObject scene = new JSONObject();
                // 有效时间，最大不超过604800秒（即7天）
                if (!isForever) {
                    json.put("expire_seconds", 2592000);
                    json.put("action_name", "QR_SCENE");
                    scene.put("scene_id", sceneId);
                } else {
                    json.put("action_name", "QR_LIMIT_STR_SCENE");
                    scene.put("scene_str", sceneId);
                }
                actionInfo.put("scene", scene);
                json.put("action_info", actionInfo);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/qrcode/create?access_token=" + accessToken);
    }

    /**
     * 获取二维码
     */
    public WxResult showQrcode(final String ticket) {
        return doService(WxResult.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("ticket", ticket);
            }

        }, "https://mp.weixin.qq.com/cgi-bin/showqrcode");
    }

    /**
     * 长链接转短链接接口
     */
    public Qrcode longToShort(String accessToken, final String longUrl) {
        return doPost(Qrcode.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                JSONObject json = new JSONObject();
                json.put("action", "long2short");
                json.put("long_url", longUrl);
                map.put(KEY, json.toJSONString());
            }

        }, "/cgi-bin/shorturl?access_token=" + accessToken);
    }

}
