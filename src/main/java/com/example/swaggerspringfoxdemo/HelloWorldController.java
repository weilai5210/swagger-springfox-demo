package com.example.swaggerspringfoxdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Api：用在请求的类上，表示对类的说明
 * - tags="说明该类的作用，可以在UI界面上看到的注解"
 * - value="该参数没什么意义，在UI界面上也看不到，所以不需要配置"
 *
 * @ApiOperation：用在请求的方法上，说明方法的用途、作用
 * - value="说明方法的用途、作用"
 * - notes="方法的备注说明"
 */
@Api(tags="hello类测试")
@RestController
public class HelloWorldController {

    /**
     * 访问：http://localhost:8080/helloWorld
     *
     * @return helloWorld
     */
    @ApiOperation("测试方法")
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }
}
