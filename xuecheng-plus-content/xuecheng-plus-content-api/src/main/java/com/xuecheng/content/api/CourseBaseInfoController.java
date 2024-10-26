package com.xuecheng.content.api;


import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.dto.QueryCourseParamsDto;
import com.xuecheng.content.po.CourseBase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description TODO
 * @author Mr.M
 * @date 2022/9/6 14:02
 * @version 1.0
 */


@RestController//相当于@Controller和@responseBody
public class CourseBaseInfoController {

        @RequestMapping("/course/lsit")
        public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParamsDto){
                return null;
        }
}
