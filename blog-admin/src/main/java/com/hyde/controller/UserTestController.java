package com.hyde.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.hyde.common.R;
import com.hyde.common.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.PathVariable;
import com.hyde.service.UserTestService;
import com.hyde.entity.UserTest;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyde
 * @since 2024-06-13
 */
@RestController
@RequestMapping("/userTest")
        public class UserTestController {
    
@Autowired
private UserTestService userTestService;

// 新增或者更新
/***********************************
 * 用途说明:
 * @return R
 ***********************************/
@PostMapping("add")
public R add(@RequestBody UserTest userTest) {
    boolean result = userTestService.save(userTest);
    if (result) {
        return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
    } else {
        return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
    }
}

/***********************************
 * 用途说明:
 * @param id
 * 返回值说明:
 * @return R
 ***********************************/
@DeleteMapping("/{id}")
public R delete(@PathVariable Integer id) {
    boolean result = userTestService.removeById(id);
    if (result) {
        return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
    } else {
        return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
    }
}

/***********************************
 * 用途说明:
 * @param ids
 * 返回值说明:
 * @return R
 ***********************************/
@PostMapping("/del/batch")
public R deleteBatch(@RequestBody List<Integer> ids) {
    boolean result = userTestService.removeByIds(ids);
    if (result) {
        return R.ok().message(ResultCodeEnum.SUCCESS.getMessage());
    } else {
        return R.error().message(ResultCodeEnum.UPDATE_ERROR.getMessage());
    }
}

/***********************************
 * 用途说明:
 * @param:
 * 返回值说明:
 * @return R
 ***********************************/
@GetMapping
public R findAll() {
    return R.ok().data("data", userTestService.list());
}

/***********************************
 * 用途说明:
 * @param id
 * 返回值说明:
 * @return R
 ***********************************/
@GetMapping("/{id}")
public R findOne(@PathVariable Integer id) {
    return R.ok().data("data", userTestService.getById(id));
}

/***********************************
 * 用途说明:
 * @param pageNum pageSize userTest
 * 返回值说明:
 * @return R
 ***********************************/
@PostMapping("/page")
public R findPage(@RequestParam Integer pageNum,
                  @RequestParam Integer pageSize,
                  @RequestBody UserTest userTest) {
    QueryWrapper<UserTest> queryWrapper = new QueryWrapper<>();
    queryWrapper.orderByDesc("id");
    return R.ok().data("data", userTestService.page(new Page<>(pageNum, pageSize), queryWrapper));
}
}

