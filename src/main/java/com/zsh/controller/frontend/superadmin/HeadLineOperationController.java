package com.zsh.controller.frontend.superadmin;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.dto.Result;
import com.zsh.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class HeadLineOperationController {

    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return headLineService.removeHeadLine(1);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return headLineService.queryHeadLine(null,1,100);
    }


}
