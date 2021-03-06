package com.snax.vxvw.vxvwdb.service;

import com.github.pagehelper.PageHelper;
import com.snax.vxvw.vxvwdb.dao.LitemallBrandMapper;
import com.snax.vxvw.vxvwdb.domain.LitemallBrand;
import com.snax.vxvw.vxvwdb.domain.LitemallBrand.Column;
import com.snax.vxvw.vxvwdb.domain.LitemallBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallBrandService {
    @Resource
    private LitemallBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<LitemallBrand> query(int offset, int limit) {
        LitemallBrandExample example = new LitemallBrandExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return brandMapper.selectByExample(example);
    }

    public List<LitemallBrand> queryVO(int offset, int limit) {
        LitemallBrandExample example = new LitemallBrandExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotalCount() {
        LitemallBrandExample example = new LitemallBrandExample();
        example.or().andDeletedEqualTo(false);
        return (int) brandMapper.countByExample(example);
    }

    public LitemallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<LitemallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LitemallBrandExample example = new LitemallBrandExample();
        LitemallBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return brandMapper.selectByExample(example);
    }

    public int countSelective(String id, String name, Integer page, Integer size, String sort, String order) {
        LitemallBrandExample example = new LitemallBrandExample();
        LitemallBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        return (int) brandMapper.countByExample(example);
    }

    public void updateById(LitemallBrand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallBrand brand) {
        brandMapper.insertSelective(brand);
    }

    public List<LitemallBrand> all() {
        return brandMapper.selectByExample(new LitemallBrandExample());
    }
}
