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
package com.codeyn.wechat.sdk.menu;

import java.util.Map;

import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.core.model.WxResult;
import com.codeyn.wechat.sdk.menu.result.Menu;

/**
 * @author Arthur
 */
public class MenuClient extends WxClient{

    public MenuClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 查询菜单
     */
    public Menu getMenu(final String accessToken) {
        return doGet("menu", Menu.class, new ParamService(){

            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
            }
            
        }, "/cgi-bin/menu/get");
    }

    /**
     * 创建菜单
     */
    public WxResult createMenu(String accessToken, final String jsonStr) {
        return doPost(WxResult.class, new ParamService(){

            @Override
            public void init(Map<String, String> map) {
                map.put(KEY, jsonStr);
            }
            
        }, "/cgi-bin/menu/create?access_token=" + accessToken);
    }

    /**
     * 删除菜单
     */
    public WxResult deleteMenu(final String accessToken) {
        return doGet(WxResult.class, new ParamService(){

            @Override
            public void init(Map<String, String> map) {
                map.put("access_token", accessToken);
            }
            
        }, "/cgi-bin/menu/delete");
    }
    
}
