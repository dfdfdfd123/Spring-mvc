package com.springlab.jdbctest.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardJdbcDAO")
	private BoardDAO dao;

	@Override
	public void insertBoard(BoardDO board) {
		dao.insertBoard(board);

	}

	@Override
	public void updateBoard(BoardDO board) {
		dao.updateBoard(board);

	}

	@Override
	public void deleteBoard(BoardDO board) {
		dao.deleteBoard(board);

	}

	@Override
	public BoardDO getBoard(BoardDO board) {
		return dao.getBoard(board);

	}

	@Override
	public List<BoardDO> listBoard() {
		
		return dao.listBoard();
		
		
	}

}
