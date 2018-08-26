package com.snax.vxvw.vxvwdb.service;

import com.github.pagehelper.PageHelper;
import com.snax.vxvw.vxvwdb.dao.LitemallAdminMapper;
import com.snax.vxvw.vxvwdb.domain.LitemallAdmin;
import com.snax.vxvw.vxvwdb.domain.LitemallAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallAdminService {
    @Resource
    private LitemallAdminMapper adminMapper;

    public List<LitemallAdmin> findAdmin(String username) {
        LitemallAdminExample example = new LitemallAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    private final LitemallAdmin.Column[] result = new LitemallAdmin.Column[]{LitemallAdmin.Column.id, LitemallAdmin.Column.username, LitemallAdmin.Column.avatar};
    public List<LitemallAdmin> querySelective(String username, Integer page, Integer limit, String sort, String order) {
        LitemallAdminExample example = new LitemallAdminExample();
        LitemallAdminExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        
        PageHelper.startPage(page, limit);
        return adminMapper.selectByExampleSelective(example, result);
    }

    public int countSelective(String username, Integer page, Integer size, String sort, String order) {
        LitemallAdminExample example = new LitemallAdminExample();
        LitemallAdminExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        return (int)adminMapper.countByExample(example);
    }

    public void updateById(LitemallAdmin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallAdmin admin) {
        adminMapper.insertSelective(admin);
    }

    public LitemallAdmin findById(Integer id) {
        return adminMapper.selectByPrimaryKeySelective(id, result);
    }
}
