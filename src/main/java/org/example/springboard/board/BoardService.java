package org.example.springboard.board;

import org.example.springboard.UserUtils;
import org.example.springboard.board.model.BoardEntity;
import org.example.springboard.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardService {

    @Autowired  //맞는 타입이 있으면 주소값 넣어줌
    private BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public int insBoard(BoardEntity entity) {
        int result = 0;

        try {
            entity.setWriter(userUtils.getLoginUserPk());
            result = mapper.insBoard(entity);
        } catch (Exception e) { e.printStackTrace(); }
        return result;
    }
    public List<BoardVO> selBoardList(){
        return mapper.selBoardList();
    }
    public BoardVO selBoard(BoardEntity entity){
        return mapper.selBoard(entity);
    }

    public int updBoard(BoardEntity entity){
        entity.setWriter(userUtils.getLoginUserPk());
        try{return mapper.updBoard(entity);}
        catch (Exception e){e.printStackTrace();}
        return 0;
    }
    public void updBoardHitsUp(BoardEntity entity){
        entity.setHit(1);
        mapper.updBoard(entity);
    }
    public int delBoard(BoardEntity entity){
        entity.setWriter(userUtils.getLoginUserPk());
        try {
            return mapper.delBoard(entity);
        }catch (Exception e){e.printStackTrace();}
        return 0;
    }
}