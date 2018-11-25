package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class UserServiceClient {

    public static void main(String[] args){

        // 1. 컨테이너 구동
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        // 2. 컨테이너로부터 BoardServiceImpl object look up
        UserService service = (UserService) container.getBean("userService");

        // 3. test
        UserVO vo = new UserVO();
        vo.setId("seed");
        vo.setPassword("yoon");

        UserVO user= service.getUser(vo);

        if(user != null){
            System.out.println(user.getName() + " Welecome!!");
        }
        else {
            System.out.println("Not found User ID" + vo.getId());
        }

        // 5. exit
        container.close();

    }
}
