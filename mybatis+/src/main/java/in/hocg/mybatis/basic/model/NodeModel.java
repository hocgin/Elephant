package in.hocg.mybatis.basic.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by hocgin on 2018/12/9.
 * email: hocgin@gmail.com
 * <p>
 * 树节点专用
 * 来源: http://mikehillyer.com/articles/managing-hierarchical-data-in-mysql/
 *
 * @author hocgin
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class NodeModel<T extends Model> extends SuperModel<T> {
    @TableField("lft")
    private int lft;
    @TableField("rgt")
    private int rgt;
    
    @TableField(exist = false)
    private Integer depth;
    @TableField(exist = false)
    private List<NodeModel> children = Lists.newArrayList();
    
    public static final String LFT = "lft";
    
    public static final String RGT = "rgt";
    
    /**
     * 构建树
     *
     * @param root
     * @param nodes
     * @return
     */
    public static <T extends NodeModel> T buildTree(T root, List<T> nodes) {
        int rgt = root.getRgt();
        int lft = root.getLft();
        Integer depth = root.getDepth();
        nodes.parallelStream()
                .filter(node -> {
                    int nodeRgt = node.getRgt();
                    int nodeLft = node.getLft();
                    return depth == (node.getDepth() - 1)
                            && rgt > nodeRgt
                            && lft < nodeLft;
                })
                .forEach(node -> {
                    List<T> children = root.getChildren();
                    children.add(buildTree(node, nodes));
                });
        return root;
    }
}