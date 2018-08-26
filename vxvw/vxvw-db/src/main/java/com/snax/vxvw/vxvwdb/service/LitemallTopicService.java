package com.snax.vxvw.vxvwdb.service;

import com.github.pagehelper.PageHelper;
import com.snax.vxvw.vxvwdb.dao.LitemallTopicMapper;
import com.snax.vxvw.vxvwdb.domain.LitemallTopic;
import com.snax.vxvw.vxvwdb.domain.LitemallTopic.Column;
import com.snax.vxvw.vxvwdb.domain.LitemallTopicExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LitemallTopicService {
    @Resource
    private LitemallTopicMapper topicMapper;
    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.picUrl, Column.readCount};

    public List<LitemallTopic> queryList(int offset, int limit) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public LitemallTopic findById(Integer id) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<LitemallTopic> queryRelatedList(Integer id, int offset, int limit) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<LitemallTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit);
        }
        LitemallTopic topic = topics.get(0);

        example = new LitemallTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<LitemallTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit);
    }

    public List<LitemallTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        LitemallTopicExample example = new LitemallTopicExample();
        LitemallTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int countSelective(String title, String subtitle, Integer page, Integer size, String sort, String order) {
        LitemallTopicExample example = new LitemallTopicExample();
        LitemallTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        return (int) topicMapper.countByExample(example);
    }

    public void updateById(LitemallTopic topic) {
        LitemallTopicExample example = new LitemallTopicExample();
        example.or().andIdEqualTo(topic.getId());
        topicMapper.updateByExampleWithBLOBs(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(LitemallTopic topic) {
        topicMapper.insertSelective(topic);
    }


}
