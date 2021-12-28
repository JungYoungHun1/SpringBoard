package org.example.springboard;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity);
    //public abstract 자동으로 들어감 - 추상메소드

    List<BoardEntity> selBoardList();
}
