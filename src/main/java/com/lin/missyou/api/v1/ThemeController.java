/**
 * @作者 leokkzhang
 * @创建时间 2020/3/28 11:45
 */
package com.lin.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.lin.missyou.model.Theme;
import com.lin.missyou.service.ThemeService;
import com.lin.missyou.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("by/names")
    public List<ThemePureVO> getThemeGroupByNames(@RequestParam(name = "names") String names){
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByName(nameList);
        List<ThemePureVO> list = new ArrayList<>();
        themes.forEach(theme ->{
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO vo = mapper.map(theme,ThemePureVO.class);
            list.add(vo);
        });
        return list;
    }
}
