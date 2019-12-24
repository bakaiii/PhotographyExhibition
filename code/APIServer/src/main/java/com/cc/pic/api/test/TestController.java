package com.cc.pic.api.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProJectName APIServer
 * @FileName TestController
 * @Description
 * @Author CandyMuj
 * @Date 2019/12/23 16:19
 * @Version 1.0
 */
@RestController
@Api(tags = "测试专用Controller")
public class TestController {

    @ApiOperation("测试专用接口")
    @RequestMapping("/test")
    public String test(
            @ApiParam(required = true, name = "参数1") @RequestParam(defaultValue = "默认值") String par1,
            @ApiParam(required = false, name = "参数2") String par2
    ) {

        return "Hello World！";
    }

}