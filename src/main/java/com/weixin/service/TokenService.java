package com.weixin.service;

import com.weixin.dao.LinShiBiaoMapper;
import com.weixin.entity.table.LinShiBiao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Autowired
    private LinShiBiaoMapper linShiBiaoMapper;

    public int insertLinShiBiao (String accessToken,int expiresIn){
        LinShiBiao linShiBiao = new LinShiBiao();
        linShiBiao.setId(1);
        linShiBiao.setValue(accessToken);
        linShiBiao.setColumn8(expiresIn);
        linShiBiao.setInserttime(new Date());
        linShiBiao.setUpdatetime(new Date());
        return linShiBiaoMapper.insertSelective(linShiBiao);
    }

    public LinShiBiao selectLinShiBiao (){
        return linShiBiaoMapper.selectByPrimaryKey(1);
    }

    public int updateLinShiBiao(String accessToken,int expiresIn){
        LinShiBiao linShiBiao = new LinShiBiao();
        linShiBiao.setId(1);
        linShiBiao.setValue(accessToken);
        linShiBiao.setColumn8(expiresIn);
        linShiBiao.setUpdatetime(new Date());
        return linShiBiaoMapper.updateByPrimaryKey(linShiBiao);
    }
}
