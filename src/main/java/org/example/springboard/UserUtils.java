package org.example.springboard;

import org.example.springboard.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component //bean 등록 - 클래스를 객체화시킴
public class UserUtils {
    @Autowired //주소값 달라고 요청
    private HttpSession session;

    public int getLoginUserPk() {
        return getLoginUser().getIuser();
    }

    public UserEntity getLoginUser() {
        return (UserEntity) session.getAttribute(Const.LOGIN_USER);
    }
}
