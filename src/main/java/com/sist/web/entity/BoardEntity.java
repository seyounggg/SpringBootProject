package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity @Table(name="reactBoard")
@Getter @Setter
public class BoardEntity {
  @Id
  private int no;
  private int hit;
  private String name, subject, content, pwd;
  private Date regdate;
}
