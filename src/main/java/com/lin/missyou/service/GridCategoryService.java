/**
 * @作者 leokkzhang
 * @创建时间 2020/4/6 20:14
 */
package com.lin.missyou.service;

import com.lin.missyou.model.GridCategory;
import com.lin.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {

    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    public List<GridCategory> getGridCategoryList(){
        return gridCategoryRepository.findAll();
    }
}
