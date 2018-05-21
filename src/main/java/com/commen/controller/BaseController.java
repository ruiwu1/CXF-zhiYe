package com.commen.controller;

import com.commen.cst.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public Boolean isAdmin(HttpSession session){
        return (Boolean)session.getAttribute(Const.SESSION_IS_ADMIN);
    }
}
