package com.sist.web.controller;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.BoardEntity;
import com.sist.web.entity.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("board/")
@CrossOrigin("http://localhost:3000")
public class BoardRestController {
  @Autowired
  private BoardDAO dao;

  @RequestMapping("board_list")
  public List<BoardEntity> boardListData(String page, String title){
    int curpage=Integer.parseInt(page);
    int rowSize=10;
    int start=(rowSize*curpage)-rowSize;

    List<BoardEntity> list = dao.boardListData(start, title);
    return list;
  }

  @GetMapping("board_page_react")
  public PageDTO boardTotalPage(String title, int page){
    int totalpage = dao.boardTotalPage(title);
    final int BLOCK = 5;
    int startPage = ((page-1)/BLOCK*BLOCK)+1;
    int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;

    PageDTO dto = new PageDTO();
    dto.setCurpage(page);
    dto.setTotalpage(totalpage);
    dto.setStartPage(startPage);
    dto.setEndPage(endPage);

    return dto;
  }
}
