package com.sist.web.controller;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("gagu/")
@CrossOrigin("http://localhost:3000")
public class GaguRestController {
  @Autowired
  private GaguDAO dao;

  @RequestMapping("gagu_sale_list_react")
  public List<GaguEntity> gagu_sale(){
    List<GaguEntity> list=dao.gaguSaleListData();

    return list;
  }

  @RequestMapping("gagu_list_react")
  public List<GaguEntity> gagu_list(String page,String title){
    int curpage = Integer.parseInt(page);
    int rowSize = 20;
    int start = (rowSize*curpage)-rowSize;

    List<GaguEntity> list=dao.gaguListData(start,title);

    for(GaguEntity vo:list){
      String temp = vo.getTitle();
      if (temp.length() > 15) {
        temp = temp.substring(0, 13) + "...";
      }
      vo.setTitle(temp);
    }

    return list;
  }

  @RequestMapping("gagu_page_react")
  public PageDTO gagu_page(int page,String title){
    int totalpage = dao.gaguTotalPage(title);

    final int BLOCK = 10;
    int startPage=((page-1)/BLOCK*BLOCK)+1;
    int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;

    if(endPage > totalpage)
      endPage = totalpage;

    PageDTO dto=new PageDTO();
    dto.setCurpage(page);
    dto.setEndPage(endPage);
    dto.setStartPage(startPage);
    dto.setTotalpage(totalpage);

    return dto;
  }

  @GetMapping("gagu_detail_react")
  public GaguEntity gagu_detail(int no){
    GaguEntity dto = new GaguEntity();
    dto = dao.findByNo(no);
    return dto;
  }
}
