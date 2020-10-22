package tech.guyi.web.quick.core.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.guyi.web.quick.core.controller.ResponseContent;
import tech.guyi.web.quick.core.controller.ResponseEntities;
import tech.guyi.web.quick.core.controller.interfaces.entry.QuickRequestEntity;
import tech.guyi.web.quick.core.controller.interfaces.handler.GetEntityHandler;

import java.util.List;

/**
 * @author guyi
 * 实体查询控制器
 * @param <E> 实体类型
 */
public interface QuickQueryController<E extends QuickRequestEntity<ID>, ID> extends GetEntityHandler<E,ID> {

    /**
     * 根据ID获取数据
     * 不存在则返回404
     * @param id 实体ID
     * @return 响应
     */
    @GetMapping("{id}")
    default ResponseEntity<ResponseContent<E>> get(@PathVariable("id") ID id){
        return this.getById(id)
                .map(this::onResponseSingle)
                .map(ResponseEntities::ok)
                .orElseGet(ResponseEntities::_404);
    }

    /**
     *查询所有管理员数据
     * @return 响应
     */
    @GetMapping("all")
    default ResponseEntity<ResponseContent<List<E>>> all(){
        return ResponseEntities.ok(this.findAll());
    }



}
