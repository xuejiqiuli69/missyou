/**
 * @作者 leokkzhang
 * @创建时间 2020/3/17 0:32
 */
package com.lin.missyou.service;


import com.lin.missyou.model.Banner;
import com.lin.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;

    public Banner getByName(String name){
        return bannerRepository.findOneByName(name);

    }
}
