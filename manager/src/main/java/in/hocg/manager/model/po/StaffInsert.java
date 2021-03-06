package in.hocg.manager.model.po;

import in.hocg.scaffold.support.basis.parameter.BaseParameter;
import lombok.Data;
import lombok.ToString;

/**
 * Created by hocgin on 2018/12/18.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ToString
public class StaffInsert implements BaseParameter {
    private String nickname;
    private String username;
    private String password;
    private String avatarUri;
    private int gender;
}
