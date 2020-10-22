package tech.guyi.web.quick.core.controller.interfaces.entry;

/**
 * @author guyi
 * 实体基础接口
 * 如果要使用Controller相关接口，其实体必须实现此接口
 * @param <ID> 实体ID类型
 */
public interface QuickRequestEntity<ID> {

    /**
     * 获取ID
     * @return ID
     */
    ID getId();

}
