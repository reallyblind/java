package com.example.myfirstxm.service;

import com.example.myfirstxm.common.api.CommonResult;

/**
 * 会员管理service
 * @author blind
 * @create 2023-02-26-13:48
 */
public interface UmsMemberService {
    /**
     * 生成验证吗
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号吗是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
