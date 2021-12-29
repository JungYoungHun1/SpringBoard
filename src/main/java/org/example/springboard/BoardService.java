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
    public BoardEntity selBoard(BoardEntity entity){
        return mapper.selBoard(entity);
    }

    public int updBoard(BoardEntity entity){
        return mapper.updBoard(entity);
    }
    public void updBoardHitsUp(BoardEntity entity){
        entity.setHits(1);
        updBoard(entity);
    }
    public int delBoard(BoardEntity entity){
        return mapper.delBoard(entity);
    }
}