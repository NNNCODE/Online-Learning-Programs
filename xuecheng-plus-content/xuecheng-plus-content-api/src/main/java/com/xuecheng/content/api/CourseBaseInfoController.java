package com.xuecheng.content.api;


import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.dto.QueryCourseParamsDto;
import com.xuecheng.content.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @description TODO
 * @author Mr.M
 * @date 2022/9/6 14:02
 * @version 1.0
 */

@Api(value = "course message management interface",tags = "course message management interface")
@RestController
public class CourseBaseInfoController {

        @ApiOperation("course search interface")
        @PostMapping("/course/list")
        public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required=false) QueryCourseParamsDto queryCourseParams){

                CourseBase courseBase = new CourseBase();
                courseBase.setName("Testing Title");
                courseBase.setCreateDate(LocalDateTime.now());
                List<CourseBase> courseBases = new ArrayList();
                courseBases.add(courseBase);
                PageResult pageResult = new PageResult<CourseBase>(courseBases,10,1,10);
                return pageResult;


        }

}

