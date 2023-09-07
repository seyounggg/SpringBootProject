package com.sist.web.dao;

import com.sist.web.entity.GaguEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaguDAO extends JpaRepository<GaguEntity,Integer> {
  @Query(value="SELECT * FROM gagu_detail WHERE sale LIKE '%\\%%'", nativeQuery = true)
  public List<GaguEntity> gaguSaleListData();

  @Query(value = "select * from gagu_detail where title like concat('%',:title,'%') limit :start,20", nativeQuery = true)
  public List<GaguEntity> gaguListData(@Param("start") Integer start, @Param("title") String title);

  @Query(value="select ceil(count(*)/20.0) from gagu_detail where title like concat('%',:title,'%')",nativeQuery = true)
  public int gaguTotalPage(String title);

  public GaguEntity findByNo(int no);
}
