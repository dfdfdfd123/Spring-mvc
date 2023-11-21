package com.springlab.biz.board;

import java.util.List;

public interface BoardService {

	void insertBoard(BoardDO vo);

	void updateBoard(BoardDO vo);

	void deleteBoard(BoardDO vo);

	BoardDO getBoard(BoardDO vo);

	List<BoardDO> listBoard();
	
}
