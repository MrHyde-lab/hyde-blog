package com.hyde.service.impl;

import com.hyde.entity.UserTest;
import com.hyde.mapper.UserTestMapper;
import com.hyde.service.UserTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hyde
 * @since 2024-06-13
 */
@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements UserTestService {

    @Autowired
    private UserTestMapper mapper;


    @Override
    public Page<UserTest> selectPage(Long current, Long size) {
        Page<UserTest> page = new Page<>();
        if (current != null && size != null) {
            page.setCurrent(current);
            page.setSize(size);
        }
        Page<UserTest> pageUserTest = page(page);
        return pageUserTest;
    }
}
