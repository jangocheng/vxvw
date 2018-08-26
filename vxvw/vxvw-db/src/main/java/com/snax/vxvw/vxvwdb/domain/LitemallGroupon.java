package com.snax.vxvw.vxvwdb.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class LitemallGroupon {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean NOT_DELETED = false;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean IS_DELETED = true;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.order_id
     *
     * @mbg.generated
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.groupon_id
     *
     * @mbg.generated
     */
    private Integer grouponId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.rules_id
     *
     * @mbg.generated
     */
    private Integer rulesId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.creator_user_id
     *
     * @mbg.generated
     */
    private Integer creatorUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.share_url
     *
     * @mbg.generated
     */
    private String shareUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.payed
     *
     * @mbg.generated
     */
    private Boolean payed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column litemall_groupon.version
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.id
     *
     * @return the value of litemall_groupon.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.id
     *
     * @param id the value for litemall_groupon.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.order_id
     *
     * @return the value of litemall_groupon.order_id
     *
     * @mbg.generated
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.order_id
     *
     * @param orderId the value for litemall_groupon.order_id
     *
     * @mbg.generated
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.groupon_id
     *
     * @return the value of litemall_groupon.groupon_id
     *
     * @mbg.generated
     */
    public Integer getGrouponId() {
        return grouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.groupon_id
     *
     * @param grouponId the value for litemall_groupon.groupon_id
     *
     * @mbg.generated
     */
    public void setGrouponId(Integer grouponId) {
        this.grouponId = grouponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.rules_id
     *
     * @return the value of litemall_groupon.rules_id
     *
     * @mbg.generated
     */
    public Integer getRulesId() {
        return rulesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.rules_id
     *
     * @param rulesId the value for litemall_groupon.rules_id
     *
     * @mbg.generated
     */
    public void setRulesId(Integer rulesId) {
        this.rulesId = rulesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.user_id
     *
     * @return the value of litemall_groupon.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.user_id
     *
     * @param userId the value for litemall_groupon.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.creator_user_id
     *
     * @return the value of litemall_groupon.creator_user_id
     *
     * @mbg.generated
     */
    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.creator_user_id
     *
     * @param creatorUserId the value for litemall_groupon.creator_user_id
     *
     * @mbg.generated
     */
    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.add_time
     *
     * @return the value of litemall_groupon.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.add_time
     *
     * @param addTime the value for litemall_groupon.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.share_url
     *
     * @return the value of litemall_groupon.share_url
     *
     * @mbg.generated
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.share_url
     *
     * @param shareUrl the value for litemall_groupon.share_url
     *
     * @mbg.generated
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.payed
     *
     * @return the value of litemall_groupon.payed
     *
     * @mbg.generated
     */
    public Boolean getPayed() {
        return payed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.payed
     *
     * @param payed the value for litemall_groupon.payed
     *
     * @mbg.generated
     */
    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.deleted
     *
     * @return the value of litemall_groupon.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.deleted
     *
     * @param deleted the value for litemall_groupon.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column litemall_groupon.version
     *
     * @return the value of litemall_groupon.version
     *
     * @mbg.generated
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column litemall_groupon.version
     *
     * @param version the value for litemall_groupon.version
     *
     * @mbg.generated
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", grouponId=").append(grouponId);
        sb.append(", rulesId=").append(rulesId);
        sb.append(", userId=").append(userId);
        sb.append(", creatorUserId=").append(creatorUserId);
        sb.append(", addTime=").append(addTime);
        sb.append(", shareUrl=").append(shareUrl);
        sb.append(", payed=").append(payed);
        sb.append(", deleted=").append(deleted);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LitemallGroupon other = (LitemallGroupon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGrouponId() == null ? other.getGrouponId() == null : this.getGrouponId().equals(other.getGrouponId()))
            && (this.getRulesId() == null ? other.getRulesId() == null : this.getRulesId().equals(other.getRulesId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreatorUserId() == null ? other.getCreatorUserId() == null : this.getCreatorUserId().equals(other.getCreatorUserId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getShareUrl() == null ? other.getShareUrl() == null : this.getShareUrl().equals(other.getShareUrl()))
            && (this.getPayed() == null ? other.getPayed() == null : this.getPayed().equals(other.getPayed()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGrouponId() == null) ? 0 : getGrouponId().hashCode());
        result = prime * result + ((getRulesId() == null) ? 0 : getRulesId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreatorUserId() == null) ? 0 : getCreatorUserId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getShareUrl() == null) ? 0 : getShareUrl().hashCode());
        result = prime * result + ((getPayed() == null) ? 0 : getPayed().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table litemall_groupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        orderId("order_id", "orderId", "INTEGER", false),
        grouponId("groupon_id", "grouponId", "INTEGER", false),
        rulesId("rules_id", "rulesId", "INTEGER", false),
        userId("user_id", "userId", "INTEGER", false),
        creatorUserId("creator_user_id", "creatorUserId", "INTEGER", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        shareUrl("share_url", "shareUrl", "VARCHAR", false),
        payed("payed", "payed", "BIT", false),
        deleted("deleted", "deleted", "BIT", false),
        version("version", "version", "INTEGER", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table litemall_groupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}