package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args){

        // 1. 컨테이너 구동
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        // 2. 컨테이너로부터 BoardServiceImpl object look up
        BoardService service = (BoardService)container.getBean("boardService");

        // 3. test
        BoardVO vo = new BoardVO();
        vo.setTitle("temp");
        vo.setWriter("seed");
        vo.setContent("dummy...");
        service.insertBoard(vo);

        // 4. verify
        List<BoardVO> boardList = service.getBoardList(vo);

        for (BoardVO b : boardList){
            System.out.println(b.toString());
        }

        // 5. exit
        container.close();

    }
}
