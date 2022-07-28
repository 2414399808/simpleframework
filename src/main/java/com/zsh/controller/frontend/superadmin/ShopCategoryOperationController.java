package com.zsh.controller.frontend.superadmin;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.bo.ShopCategory;
import com.zsh.pojo.dto.Result;
import com.zsh.service.solo.HeadLineService;
import com.zsh.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class ShopCategoryOperationController {

    private ShopCategoryService shopCategoryService;

    public Result<Boolean> addShopCategory(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    public Result<Boolean> removeShopCategory(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return shopCategoryService.removeShopCategory(1);
    }

    public Result<Boolean> modifyShopCategory(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    public Result<HeadLine> queryShopCategoryById(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return shopCategoryService.queryShopCategoryById(1);
    }

    public Result<List<HeadLine>> queryShopCategory(HttpServletRequest req , HttpServletResponse resp){
        //TODO 参数校验以及请求转化
        return shopCategoryService.queryShopCategory(null,1,100);
    }
}
