package com.xuecheng.content.mapper.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.dto.QueryCourseParamsDto;
import com.xuecheng.content.po.CourseBase;

public interface CourseBaseInfoService {

    /**
     * course paging query
     * @param pageParams paging query parameters
     * @param  courseParamsDto query condition
     * @return  query results
     */
    //search pagaing course
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto courseParamsDto);

}
