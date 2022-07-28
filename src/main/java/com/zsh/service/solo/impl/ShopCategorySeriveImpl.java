package com.zsh.service.solo.impl;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.bo.ShopCategory;
import com.zsh.pojo.dto.Result;
import com.zsh.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;
@Service
public class ShopCategorySeriveImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<HeadLine> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
