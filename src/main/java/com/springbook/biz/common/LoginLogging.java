package com.springbook.biz.common;

import com.springbook.biz.user.UserVO;
import org.aspectj.lang.JoinPoint;

public class LoginLogging {

    public void log(JoinPoint jp, Object returnObj){

        String method = jp.getSignature().getName();

        if(returnObj instanceof UserVO){
            UserVO vo = (UserVO)returnObj;
            System.out.println("=========================");
            System.out.println(" [사용자 접근 logging] 사용자 ID + " + vo.getId());
            System.out.println(" [사용자 접근 logging] 사용자의 접근 함수 + " + method);
            System.out.println("=========================");
        }
    }
}
