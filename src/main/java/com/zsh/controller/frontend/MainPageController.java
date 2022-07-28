package com.zsh.controller.frontend;


import com.zsh.pojo.dto.MainPageInfoDTO;
import com.zsh.pojo.dto.Result;
import com.zsh.service.combine.HeadLineShopCategoryCombineSerivice;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class MainPageController {

    private HeadLineShopCategoryCombineSerivice headLineShopCategoryCombineSerivice;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        return headLineShopCategoryCombineSerivice.getMainPageInfo();
    }
}
