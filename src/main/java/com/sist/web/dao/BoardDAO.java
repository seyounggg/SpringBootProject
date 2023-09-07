package com.sist.web.dao;

import com.sist.web.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BoardDAO {
  @Query(value="select * from reactBoard where title like concat('%',:title,'%') limit :start, 10", nativeQuery = true)
  public List<BoardEntity> boardListData(@Param("start") Integer start, @Param("title") String title);

  @Query(value="select ceil(count(*)/10.0) from reactBoard where title like concat('%',:title,'%')", nativeQuery = true)
  public int boardTotalPage(@Param("title") String title);
}
