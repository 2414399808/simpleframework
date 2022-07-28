package com.zsh.pojo.dto;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.bo.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
