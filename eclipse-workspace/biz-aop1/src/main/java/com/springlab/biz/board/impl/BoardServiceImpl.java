package com.springlab.biz.board.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardDO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDO vo) {
//		long start = System.currentTimeMillis();
		
		boardDAO.insertBoard(vo);
		
//		long end = System.currentTimeMillis();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
//		System.out.printf("%s - %s : %d msec elapsed\n", 
//				sdf.format(start), "insertBoard()", (end - start));		
	}

	@Override
	public void updateBoard(BoardDO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardDO vo) {
		boardDAO.deleteBoard(vo);
//		throw new IllegalArgumentException("잘못된 seq 번호입니다.");
	}

	@Override
	public BoardDO getBoard(BoardDO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardDO> listBoard() {
		return boardDAO.listBoard();
	}
}
