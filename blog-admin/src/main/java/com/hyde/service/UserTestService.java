package com.hyde.service;

import com.hyde.entity.UserTest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hyde
 * @since 2024-06-13
 */
public interface UserTestService extends IService<UserTest> {

    Page<UserTest> selectPage(Long current, Long size);

}
