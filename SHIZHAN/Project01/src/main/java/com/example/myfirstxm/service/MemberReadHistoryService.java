package com.example.myfirstxm.service;

import com.example.myfirstxm.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 *
 * @author blind
 * @create 2023-03-05-14:59
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);

}
