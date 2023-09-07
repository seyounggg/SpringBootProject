package com.sist.web.dao;

import com.sist.web.entity.FabricEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FabricDAO extends JpaRepository<FabricEntity,Integer> {
  @Query(value="select * from fabric_detail where sale like '%\\%%'",nativeQuery = true)
  public List<FabricEntity> fabricSaleListData();

  @Query(value="select * from fabric_detail where title like concat('%',:title,'%') limit :start,20", nativeQuery = true)
  public List<FabricEntity> fabricListData(@Param("title") String title, @Param("start") Integer start);

  @Query(value="select ceil(count(*)/20.0) from fabric_detail where title Like concat('%'.:title.'%')",nativeQuery = true)
  public int fabricTotalPage(String title);

  public FabricEntity findByNo(int no);
}
