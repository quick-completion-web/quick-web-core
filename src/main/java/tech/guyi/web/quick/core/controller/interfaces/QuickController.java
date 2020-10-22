package tech.guyi.web.quick.core.controller.interfaces;

import tech.guyi.web.quick.core.controller.interfaces.entry.QuickRequestEntity;

/**
 * @author guyi
 * 实现了基本增删改查的实体控制器
 * @param <E> 实体类型
 * @param <ID> 实体ID类型
 */
public interface QuickController<E extends QuickRequestEntity<ID>, ID>
        extends QuickQueryController<E,ID>,  QuickUpdateController<E,ID>{

}
