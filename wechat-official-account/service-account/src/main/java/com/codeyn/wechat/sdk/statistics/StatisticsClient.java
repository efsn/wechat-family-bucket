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
package com.codeyn.wechat.sdk.statistics;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.codeyn.wechat.sdk.core.WxClient;
import com.codeyn.wechat.sdk.core.model.WxBase;
import com.codeyn.wechat.sdk.statistics.result.ArticleSummary;
import com.codeyn.wechat.sdk.statistics.result.InterfaceSummary;
import com.codeyn.wechat.sdk.statistics.result.MsgSummary;
import com.codeyn.wechat.sdk.statistics.result.UserSummary;

/**
 * 数据统计分析
 * 
 * @author Arthur
 *
 */
public class StatisticsClient extends WxClient {

    public StatisticsClient(WxBase wxBase) {
        super(wxBase);
    }

    /**
     * 获取用户增减数据
     * @param accessToken
     * @param scope begin, end
     */
    public UserSummary getUserSummary(String accessToken, final String... scope) {
        handleDate(7, scope);
        if (scope == null) return null;
        return doPost(UserSummary.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }

        }, "/datacube/getusersummary?access_token=" + accessToken);
    }

    /**
     * 获取累计用户数据
     * @param accessToken
     * @param scope begin, end
     */
    public UserSummary getUserCumulate(String accessToken, final String... scope) {
        handleDate(7, scope);
        if (scope == null) return null;
        return doPost(UserSummary.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }

        }, "/datacube/getusercumulate?access_token=" + accessToken);
    }
    
    /**
     * 获取图文群发每日数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getArticleSummary(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {

            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }

        }, "/datacube/getarticlesummary?access_token=" + accessToken);
    }
    
    /**
     * 获取图文群发总数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getArticleTotal(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getarticletotal?access_token=" + accessToken);
    }
    
    /**
     * 获取图文统计数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getUserRead(String accessToken, final String... scope) {
        handleDate(3, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getuserread?access_token=" + accessToken);
    }
    
    /**
     * 获取图文统计分时数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getUserReadHour(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getuserreadhour?access_token=" + accessToken);
    }
    
    /**
     * 获取图文分享转发数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getUserShare(String accessToken, final String... scope) {
        handleDate(7, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getusershare?access_token=" + accessToken);
    }
    
    /**
     * 获取图文分享转发分时数据
     * @param accessToken
     * @param scope begin, end
     */
    public ArticleSummary getUserShareHour(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(ArticleSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getarticletotal?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送概况数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsg(String accessToken, final String... scope) {
        handleDate(7, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsg?access_token=" + accessToken);
    }
    
    /**
     * 获取消息分送分时数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsgHour(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsghour?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送周数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreaMsgWeek(String accessToken, final String... scope) {
        handleDate(30, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsgweek?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送月数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsgMonth(String accessToken, final String... scope) {
        handleDate(30, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsgmonth?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送分布数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsgDist(String accessToken, final String... scope) {
        handleDate(15, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsgdist?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送分布周数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsgDistWeek(String accessToken, final String... scope) {
        handleDate(30, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsgdistweek?access_token=" + accessToken);
    }
    
    /**
     * 获取消息发送分布月数据
     * @param accessToken
     * @param scope begin, end
     */
    public MsgSummary getUpstreamMsgDistMonth(String accessToken, final String... scope) {
        handleDate(30, scope);
        if (scope == null) return null;
        return doPost(MsgSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getupstreammsgdistmonth?access_token=" + accessToken);
    }
    
    /**
     * 获取接口分析数据
     * @param accessToken
     * @param scope begin, end
     */
    public InterfaceSummary getInterfaceSummary(String accessToken, final String... scope) {
        handleDate(30, scope);
        if (scope == null) return null;
        return doPost(InterfaceSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getinterfacesummary?access_token=" + accessToken);
    }
    
    /**
     * 获取接口分析分时数据
     * @param accessToken
     * @param scope begin, end
     */
    public InterfaceSummary getInterfaceSummaryHour(String accessToken, final String... scope) {
        handleDate(1, scope);
        if (scope == null) return null;
        return doPost(InterfaceSummary.class, new ParamService() {
            
            @Override
            public void init(Map<String, String> map) {
                map.put("begin_date", scope[0]);
                map.put("end_date", scope[1]);
            }
            
        }, "/datacube/getinterfacesummaryhour?access_token=" + accessToken);
    }
    
    /**
     * params verify
     * 
     * @param maxSpan unit day
     * @param scope begin, end
     */
    private String[] handleDate(int maxSpan, String... scope) {
        if (scope == null || scope.length < 1) {
            return null;
        }

        try {
            List<String> rt = Arrays.asList(scope[0]);
            Date now = new Date();
            String[] pattern = { "yyyy-MM-dd" };
            Date begin = DateUtils.parseDate(scope[0], pattern);
            Date end = scope.length > 1 ? DateUtils.parseDate(scope[1], pattern) : now;

            // not accuracy
            if (begin.after(end)) {
                return null;
            }

            Calendar cBegin = Calendar.getInstance();
            Calendar cEnd = Calendar.getInstance();
            Calendar cNow = Calendar.getInstance();
            cBegin.setTime(begin);
            cEnd.setTime(end);
            cNow.setTime(now);

            int b = cBegin.get(Calendar.DAY_OF_YEAR);
            int e = cEnd.get(Calendar.DAY_OF_YEAR);
            int n = cNow.get(Calendar.DAY_OF_YEAR);

            // correct end date
            if (e - b >= maxSpan) {
                cBegin.add(Calendar.DAY_OF_YEAR, 6);
                cEnd.setTime(cBegin.getTime());
            }

            // correct end date again
            if (e >= n) {
                cNow.add(Calendar.DAY_OF_YEAR, -1);
                cEnd.setTime(cNow.getTime());
            }

            rt.add(DateFormatUtils.format(cEnd.getTime(), pattern[0]));
            return rt.toArray(new String[0]);
        } catch (ParseException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
