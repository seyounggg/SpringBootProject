package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "fabric_detail")
@Getter @Setter
public class FabricEntity {
  @Id
  private int no;
  private int review_cnt;
  private String poster,title,original_pri,sale,priced_sale,brand,delivery_pri,score,detailposters;
}
