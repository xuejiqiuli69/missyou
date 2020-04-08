/**
 * @作者 leokkzhang
 * @创建时间 2020/4/8 23:35
 */
package com.lin.missyou.service;

import com.lin.missyou.model.Theme;
import com.lin.missyou.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;


    public List<Theme> findByName(List<String> names) {
        return themeRepository.findByNames(names);
    }

    public Optional<Theme> findByName(String name) {
        return themeRepository.findByName(name);
    }
}
