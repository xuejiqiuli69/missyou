/**
 * @作者 leokkzhang
 * @创建时间 2020/4/4 23:18
 */
package com.lin.missyou.api.v1;


import com.lin.missyou.model.Category;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.vo.CategoryAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public CategoryAllVO getAll() {
        Map<Integer, List<Category>> categories = categoryService.findAll();
        return new CategoryAllVO(categories);
    }

}
