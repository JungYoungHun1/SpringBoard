package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired  //맞는 타입이 있으면 주소값 넣어줌
    private BoardMapper mapper;

    public int insBoard(BoardEntity entity){
        return mapper.insBoard(entity);
    }
    public List<BoardEntity> selBoardList(){
        return mapper.selBoardList();
    }
}