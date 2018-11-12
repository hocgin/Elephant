package in.hocg.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import in.hocg.basic.model.SuperModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * [权限模块] 角色-员工 关联表
 * </p>
 *
 * @author hocgin
 * @since 2018-10-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RbacRoleResource extends SuperModel<RbacRoleResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色 ID
     */
    @TableField("role_id")
    private String roleId;
    /**
     * 员工 ID
     */
    @TableField("staff_id")
    private String staffId;


    public static final String ROLE_ID = "role_id";

    public static final String STAFF_ID = "staff_id";

}