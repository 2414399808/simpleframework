package com.zsh.service.combine.impl;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.bo.ShopCategory;
import com.zsh.pojo.dto.MainPageInfoDTO;
import com.zsh.pojo.dto.Result;
import com.zsh.service.combine.HeadLineShopCategoryCombineSerivice;
import com.zsh.service.solo.HeadLineService;
import com.zsh.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineSerivice {

    private HeadLineService headLineService;
    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        HeadLine headLineCondition=new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        ShopCategory shopCateGoryCondition =new ShopCategory();
        Result<List<HeadLine>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCateGoryCondition, 1, 100);
        Result<MainPageInfoDTO> result =mergeMainPageInfoResult(headLineResult,shopCategoryResult);
        return result;
    }

    public Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult,Result<List<HeadLine>> shopCategoryResult){
        return null;
    }


}
