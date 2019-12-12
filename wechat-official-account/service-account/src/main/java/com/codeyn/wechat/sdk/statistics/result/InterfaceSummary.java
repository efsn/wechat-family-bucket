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
package com.codeyn.wechat.sdk.statistics.result;

/**
 * Message Interface summary
 * 
 * @author Arthur
 *
 */
public class InterfaceSummary extends Summary<InterfaceSummary> {

    /**
     * 通过服务器配置地址获得消息后，被动回复用户消息的次数
     */
    private Integer callback_count;

    /**
     * 上述动作的失败次数
     */
    private Integer fail_count;

    /**
     * 总耗时，除以callback_count即为平均耗时
     */
    private Long total_time_cost;

    /**
     * 最大耗时
     */
    private Integer max_time_cost;

    public Integer getCallback_count() {
        return callback_count;
    }

    public void setCallback_count(Integer callback_count) {
        this.callback_count = callback_count;
    }

    public Integer getFail_count() {
        return fail_count;
    }

    public void setFail_count(Integer fail_count) {
        this.fail_count = fail_count;
    }

    public Long getTotal_time_cost() {
        return total_time_cost;
    }

    public Long getAvgTimeCost() {
        return total_time_cost / callback_count;
    }

    public void setTotal_time_cost(Long total_time_cost) {
        this.total_time_cost = total_time_cost;
    }

    public Integer getMax_time_cost() {
        return max_time_cost;
    }

    public void setMax_time_cost(Integer max_time_cost) {
        this.max_time_cost = max_time_cost;
    }

}
