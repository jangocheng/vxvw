package com.snax.vxvw.vxvwdb.service;

import com.github.pagehelper.PageHelper;
import com.snax.vxvw.vxvwdb.dao.LitemallGoodsAttributeMapper;
import com.snax.vxvw.vxvwdb.domain.LitemallGoodsAttribute;
import com.snax.vxvw.vxvwdb.domain.LitemallGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallGoodsAttributeService {
    @Resource
    private LitemallGoodsAttributeMapper goodsAttributeMapper;

    public List<LitemallGoodsAttribute> queryByGid(Integer goodsId) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void updateById(LitemallGoodsAttribute goodsAttribute) {
        goodsAttributeMapper.updateByPrimaryKeySelective(goodsAttribute);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallGoodsAttribute goodsAttribute) {
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public LitemallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        LitemallGoodsAttributeExample example = new LitemallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
