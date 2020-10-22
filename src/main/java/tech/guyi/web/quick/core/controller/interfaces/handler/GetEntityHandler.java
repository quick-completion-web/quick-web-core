package tech.guyi.web.quick.core.controller.interfaces.handler;

import java.util.List;
import java.util.Optional;

/**
 * @author guyi
 * 获取实体的处理器
 * @param <E> 实体类型
 * @param <ID> 实体ID类型
 */
public interface GetEntityHandler<E,ID> {

    /**
     * 根据ID获取实体
     * @param id 实体ID
     * @return 实体
     */
    Optional<E> getById(ID id);

    /**
     * 根据ID判断数据是否存在
     * @param id 实体ID
     * @return 是否存在
     */
    boolean existsById(ID id);

    /**
     * 当响应实体时触发
     * @param entity 实体
     * @return 实体
     */
    default E onResponseSingle(E entity){
        return entity;
    }

    /**
     * 获取所有数据
     * @return 数据集合
     */
    List<E> findAll();

}
