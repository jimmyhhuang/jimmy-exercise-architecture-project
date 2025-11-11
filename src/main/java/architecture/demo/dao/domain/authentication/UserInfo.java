package architecture.demo.dao.domain.authentication;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户信息实体类（MyBatis-Plus版本）
 */
@Data
@TableName("user_info")
public class UserInfo {
    
    /**
     * 用户ID - 主键
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 性别（0:女, 1:男）
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间 - 插入时自动填充
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人ID - 插入时自动填充
     */
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    private String createId;

    /**
     * 更新时间 - 插入和更新时自动填充
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新人ID - 插入和更新时自动填充
     */
    @TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
    private String updateId;

    /**
     * 启用状态（1:启用, 0:禁用）
     */
    @TableField("enabled")
    private Integer enabled = 1;

}