package com.zsh.service.solo;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.bo.ShopCategory;
import com.zsh.pojo.dto.Result;

import java.util.List;

public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    Result<Boolean> removeShopCategory(int shopCategoryId);

    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<HeadLine> queryShopCategoryById(int shopCategoryId);

    Result<List<HeadLine>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}

