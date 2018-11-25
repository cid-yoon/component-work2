package com.springbook.biz.board.impl;

import com.springbook.biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class BoardDAOSpring {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String BOARD_INSERT =
            "insert into board(title, writer, content) values(?,?,?)";

    private final String BOARD_UPDATE =
            "update board set title=?, content=? where seq=?";

    private final String BOARD_DELETE =
            "delete from board where seq=?";

    private final String BOARD_GET =
            "select * from board where seq=?";

    private final String BOARD_LIST =
            "select * from board order by seq desc";


    // crud
    public void insertBoard(BoardVO vo){
        System.out.println("JDBC Insert Board()");
        jdbcTemplate.update(BOARD_INSERT,
                vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    public void updateBoard(BoardVO vo){
        System.out.println("JDBC Update Board()");
        jdbcTemplate.update(BOARD_UPDATE, vo.getSeq());
    }

    public void deleteBoard(BoardVO vo){
        System.out.println("JDBC Delete Board()");
        jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
    }

    public BoardVO getBoard(BoardVO vo){
        System.out.println("JDBC Read Board Single()");

        Object[] args = {vo.getSeq()};
        return jdbcTemplate.queryForObject(BOARD_GET,
                args, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("JDBC Read Board Multiple()");
        return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());


    }


    class BoardRowMapper implements RowMapper<BoardVO> {
        public BoardVO mapRow(ResultSet resultSet, int i) throws SQLException {

            BoardVO board = new BoardVO();
            board.setSeq(resultSet.getInt("SEQ"));
            board.setTitle(resultSet.getString("TITLE"));
            board.setWriter(resultSet.getString("WRITER"));
            board.setContent(resultSet.getString("CONTENT"));
            board.setRegDate(resultSet.getDate("REGDATE"));
            board.setCnt(resultSet.getInt("CNT"));
            return board;

        }
    }
}
