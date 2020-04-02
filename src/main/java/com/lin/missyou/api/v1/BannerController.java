/**
 * @作者 leokkzhang
 * @创建时间 2020/2/22 16:15
 */
package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.model.Banner;
import com.lin.missyou.sample.BaseHero;
import com.lin.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable String name){
        Banner banner =  bannerService.getByName(name);
        if(banner == null){
            throw new NotFoundException(30005);
        }
        return banner;
    }

//    @PostMapping("/test/{id}")
//    public PersonDTO test(@PathVariable @Max(10) Integer id, @RequestParam String name,
//                          @RequestBody @Validated PersonDTO person) throws Exception {
//        baseHero.skill1();
//        PersonDTO person1 = PersonDTO.builder().
//                name("zhangke").
//                age(19).
//                build();
//        return person1;
//    }


}
