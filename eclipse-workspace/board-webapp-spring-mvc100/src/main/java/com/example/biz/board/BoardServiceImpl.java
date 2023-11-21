package com.example.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("boardService")
@Transactional(rollbackFor = { Exception.class })
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public void insertBoard(BoardDO board) {
//		long start = System.currentTimeMillis();

		dao.insertBoard(board);
//		dao.insertBoard(board);
		
//		long end = System.currentTimeMillis();
//		
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		System.out.printf("%s - insertBoard(): %d msec가 걸림\n", 
//				dayTime.format(new Date(start)), end - start);
	}

	public void updateBoard(BoardDO board) {
		dao.updateBoard(board);
	}

	public void deleteBoard(BoardDO board) {
		dao.deleteBoard(board);
	}

	@Transactional(readOnly=true)
	public BoardDO getBoard(BoardDO board) {
		return dao.getBoard(board);
	}

	@Transactional(readOnly=true)
	public List<BoardDO> listBoard() {
		return dao.listBoard();
	}

}
