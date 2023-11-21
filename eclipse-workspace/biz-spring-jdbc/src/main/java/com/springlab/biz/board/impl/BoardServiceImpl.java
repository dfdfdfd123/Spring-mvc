package com.springlab.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardDAO")
	@Transactional(rollbackfor= { Exception.class})
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
//		long start = System.currentTimeMillis();
		
		// vo.setSeq(1000);
		// boardDAO.insertBoard(vo);
		
		
		boardDAO.insertBoard(vo);
		
//		long end = System.currentTimeMillis();
//		System.out.println("insertBoard() : " + (end - start) + " msec");		
	}

	
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		vo.setSeq(1000);
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
//		throw new IllegalArgumentException("잘못된 seq 번호입니다.");
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> listBoard() {
		return boardDAO.listBoard();
	}
}
