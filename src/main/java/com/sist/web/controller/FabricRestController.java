package com.sist.web.controller;

import com.sist.web.dao.FabricDAO;
import com.sist.web.entity.FabricEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fabric/")
@CrossOrigin("http://localhost:3000")
public class FabricRestController {
  @Autowired
  private FabricDAO dao;

  @RequestMapping("fablic_sale_list_react")
  public List<FabricEntity> fabric_sale(){
    List<FabricEntity> list=dao.fabricSaleListData();

    return list;
  }
}
