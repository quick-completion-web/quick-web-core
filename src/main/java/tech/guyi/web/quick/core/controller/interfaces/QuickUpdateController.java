package tech.guyi.web.quick.core.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.guyi.web.quick.core.controller.ResponseContent;
import tech.guyi.web.quick.core.controller.ResponseEntities;
import tech.guyi.web.quick.core.controller.interfaces.entry.QuickRequestEntity;
import tech.guyi.web.quick.core.controller.interfaces.handler.GetEntityHandler;
import tech.guyi.web.quick.core.controller.interfaces.handler.UpdateEntityHandler;

/**
 * @author guyi
 * 增删改控制器
 * @param <E> 实体类型
 */
public interface QuickUpdateController<E extends QuickRequestEntity<ID>, ID>
        extends GetEntityHandler<E,ID>, UpdateEntityHandler<E,ID> {

    /**
     * 更新或创建数据
     * @param entity 实体数据
     * @return 响应
     */
    @PostMapping
    default ResponseEntity<ResponseContent<E>> createOrUpdate(@RequestBody E entity){
        if (this.existsById(entity.getId())){
            entity = this.onUpdate(entity);
        }else{
            entity = this.onCreate(entity);
        }
        return ResponseEntities.ok(this.onResponseSingle(this.save(entity)));
    }

    /**
     * 根据ID删除数据
     * 当ID不存在时返回404
     * @param id 实体ID
     * @return 响应
     */
    @DeleteMapping("{id}")
    default ResponseEntity<ResponseContent<Boolean>> delete(@PathVariable("id") ID id){
        if (!this.existsById(id)){
            return ResponseEntities._404();
        }
        this.onDelete(id);
        this.deleteById(id);
        return ResponseEntities.ok(true);
    }

}
