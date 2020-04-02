/**
 * @作者 leokkzhang
 * @创建时间 2020/2/22 16:15
 */
package com.lin.missyou.api.v1;

import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Spu;
import com.lin.missyou.service.SpuService;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.vo.PagingDozer;
import com.lin.missyou.vo.SpuSimplifyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {


    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = spuService.getSpu(id);
        if(spu == null){
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/id/{id}/simplify")
    public SpuSimplifyVo getSimplifySpu(@PathVariable @Positive(message = "{id.positive}") Long id) {
        Spu spu = spuService.getSpu(id);
        SpuSimplifyVo vo = new SpuSimplifyVo();
        BeanUtils.copyProperties(spu, vo);
        return vo;
    }


    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVo> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                                            @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVo.class);
    }


    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVo> getByCategoryId(@PathVariable @Positive(message = "{id.positive}") Long id,
                                                           @RequestParam(name = "is_root",defaultValue = "false") Boolean isRoot,
                                                           @RequestParam(defaultValue = "0") Integer start,
                                                           @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVo.class);
    }
}
