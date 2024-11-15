package com.xuecheng.content.mapper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.dto.QueryCourseParamsDto;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.service.CourseBaseInfoService;
import com.xuecheng.content.po.CourseBase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @description TODO
 * @date 11/8/2024
 */
@Slf4j
@Service
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Autowired//base on type injection
    CourseBaseMapper courseBaseMapper;
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto courseParamsDto) {
        //详细进行分页查询的单元测试


        //Assemble query conditions
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        //create paging parameter object
        //like is fuzzy query,in sql assemble course_base.name like '%value%'
        queryWrapper.like(StringUtils.isNotEmpty(courseParamsDto.getCourseName()),CourseBase::getName,courseParamsDto.getCourseName());
        //according to course audit conditions audit_status = ?
        queryWrapper.eq(StringUtils.isNotEmpty(courseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,courseParamsDto.getAuditStatus());
        //todo:Query by course release status


        //create  paging parameter object.
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        //processing the paging query
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, queryWrapper);
        //data list
        List<CourseBase> items = pageResult.getRecords();
        //total records
        long total = pageResult.getTotal();
        //List<T> items, long counts, long page, long pageSize
        PageResult<CourseBase>courseBasePageResult = new PageResult<>(items,total,pageParams.getPageNo(), pageParams.getPageSize());
        return courseBasePageResult;
    }
}
