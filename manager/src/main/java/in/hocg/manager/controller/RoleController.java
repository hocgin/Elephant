package in.hocg.manager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import in.hocg.manager.model.po.RolePageQuery;
import in.hocg.manager.service.RoleService;
import in.hocg.mybatis.basic.condition.GetCondition;
import in.hocg.mybatis.basic.condition.PostCondition;
import in.hocg.mybatis.module.system.entity.Role;
import in.hocg.scaffold.support.basis.BaseController;
import in.hocg.scaffold.support.http.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hocgin on 2018/12/16.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController extends BaseController {
    private final RoleService roleService;
    
    /**
     * GET /roles
     * 查找所有角色列表
     *
     * @param condition
     * @return
     */
    @GetMapping
    public ResponseEntity get(GetCondition condition) {
        IPage<Role> all = roleService.page(condition);
        return Result.success(all)
                .asResponseEntity();
    }
    
    
    /**
     * POST /roles/_search
     * 查找所有角色列表
     *
     * @param condition
     * @return
     */
    @PostMapping("/_search")
    public ResponseEntity post(@RequestBody PostCondition<RolePageQuery> condition) {
        IPage<Role> all = roleService.page(condition);
        return Result.success(all).asResponseEntity();
    }
    
    
}
