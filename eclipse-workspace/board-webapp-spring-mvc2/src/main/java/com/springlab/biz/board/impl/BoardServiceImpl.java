package com.springlab.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardService;
import com.springlab.biz.board.BoardVO;

@Service("boardService")
@Transactional(rollbackFor= {Exception.class})
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardDAObyJdbcTemplate")
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
//		long start = System.currentTimeMillis();
		
		boardDAO.insertBoard(vo);
//		boardDAO.insertBoard(vo);
		
//		long end = System.currentTimeMillis();
//		System.out.println("insertBoard() : " + (end - start) + " msec");		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	@Transactional(readOnly=true)
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BoardVO> listBoard() {
		return boardDAO.listBoard();
	}
}
