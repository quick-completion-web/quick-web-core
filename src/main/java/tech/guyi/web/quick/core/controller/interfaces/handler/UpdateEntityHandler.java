package tech.guyi.web.quick.core.controller.interfaces.handler;

/**
 * 更新实体处理器
 * @param <E> 实体类型
 * @param <ID> 实体ID类型
 */
public interface UpdateEntityHandler<E,ID> {

    /**
     * 保存实体
     * @param entity 实体
     * @return 保存后的实体
     */
    E save(E entity);

    /**
     * 根据ID删除实体
     * @param id 实体ID
     */
    void deleteById(ID id);

    /**
     * 当更新实体时触发
     * @param entity 实体
     * @return 实体
     */
    default E onUpdate(E entity){
        return entity;
    }

    /**
     * 当保存实体时触发
     * @param entity 实体
     * @return 实体
     */
    default E onCreate(E entity){
        return entity;
    }

    /**
     * 当删除数据时触发
     * @param id 实体ID
     */
    default void onDelete(ID id){

    }

}
