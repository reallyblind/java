package com.example.myfirstxm.nosql.mongodb.repository;

import com.example.myfirstxm.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 会员商品浏览历史Repository
 * @author blind
 * @create 2023-03-05-10:54
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒叙获取浏览记录
     * @param memberId 会员ID
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);

    @Query("{'memberId' : ?0 }")
    List<MemberReadHistory> findByMemberId(Long memberId);

}
