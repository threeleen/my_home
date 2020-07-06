package com.review.myre.dao.mapper;

import com.review.myre.entity.ReviewUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ReviewUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReviewUser record);

    int insertSelective(ReviewUser record);

    ReviewUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReviewUser record);

    int updateByPrimaryKey(ReviewUser record);

    ReviewUser selectByUsername(String usename);
}