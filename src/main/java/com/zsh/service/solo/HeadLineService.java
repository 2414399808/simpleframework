package com.zsh.service.solo;

import com.zsh.pojo.bo.HeadLine;
import com.zsh.pojo.dto.Result;

import java.util.List;

public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,int pageIndex,int pageSize);
}
