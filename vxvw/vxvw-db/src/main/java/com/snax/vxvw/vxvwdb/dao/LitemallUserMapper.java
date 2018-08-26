package com.snax.vxvw.vxvwdb.dao;

import com.snax.vxvw.vxvwdb.domain.LitemallUser;
import com.snax.vxvw.vxvwdb.domain.LitemallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    long countByExample(LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int deleteWithVersionByExample(@Param("version") Integer version, @Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int deleteWithVersionByPrimaryKey(@Param("version") Integer version, @Param("key") Integer key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int insert(LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int insertSelective(LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallUser selectOneByExample(LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallUser selectOneByExampleSelective(@Param("example") LitemallUserExample example, @Param("selective") LitemallUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallUser> selectByExampleSelective(@Param("example") LitemallUserExample example, @Param("selective") LitemallUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    List<LitemallUser> selectByExample(LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    LitemallUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int updateWithVersionByExample(@Param("version") Integer version, @Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int updateWithVersionByExampleSelective(@Param("version") Integer version, @Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallUser record, @Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int updateWithVersionByPrimaryKey(@Param("version") Integer version, @Param("record") LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int updateWithVersionByPrimaryKeySelective(@Param("version") Integer version, @Param("record") LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") LitemallUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}