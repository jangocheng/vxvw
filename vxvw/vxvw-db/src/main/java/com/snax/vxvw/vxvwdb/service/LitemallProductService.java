package com.snax.vxvw.vxvwdb.service;

import com.github.pagehelper.PageHelper;
import com.snax.vxvw.vxvwdb.dao.LitemallProductMapper;
import com.snax.vxvw.vxvwdb.domain.LitemallProduct;
import com.snax.vxvw.vxvwdb.domain.LitemallProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallProductService {
    @Resource
    private LitemallProductMapper productMapper;

    public List<LitemallProduct> queryByGid(Integer gid) {
        LitemallProductExample example = new LitemallProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return productMapper.selectByExample(example);
    }

    public LitemallProduct findById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public void updateById(LitemallProduct product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    public void deleteById(Integer id) {
        productMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallProduct product) {
        productMapper.insertSelective(product);
    }

    public int count() {
        LitemallProductExample example = new LitemallProductExample();
        example.or().andDeletedEqualTo(false);

        return (int)productMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        LitemallProductExample example = new LitemallProductExample();
        example.or().andGoodsIdEqualTo(gid);
        productMapper.logicalDeleteByExample(example);
    }
}
