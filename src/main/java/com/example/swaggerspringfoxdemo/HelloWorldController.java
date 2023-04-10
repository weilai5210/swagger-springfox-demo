package com.example.swaggerspringfoxdemo;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Api：用在请求的类上，表示对类的说明
 * - tags="说明该类的作用，可以在UI界面上看到的注解"
 * - value="该参数没什么意义，在UI界面上也看不到，所以不需要配置"
 */
@Api(tags = "hello类测试")
@RestController
public class HelloWorldController {

    /**
     * 访问：http://localhost:8080/helloWorld
     *
     * @return helloWorld
     *
     * @ApiOperation：用在请求的方法上，说明方法的用途、作用
     * - value="说明方法的用途、作用"
     * - notes="方法的备注说明"
     */
    @ApiOperation("测试方法")
    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    /**
     * @ApiImplicitParams：用在请求的方法上，表示一组参数说明
     * - @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     *   - name：参数名
     *   - value：参数的汉字说明、解释
     *   - required：参数是否必须传值
     *   - paramType：参数放在哪个地方
     *      - header：参数在【header】=》请求参数的获取：@RequestHeader
     *      - query：参数在【query】=》请求参数的获取：@RequestParam
     *      - path：（用于restful接口）=》求参数的获取：@PathVariable
     *      - body（不常用）
     *      - form（不常用）
     *   - dataType：参数类型，默认String，其它值比如：dataType="Integer"
     *   - defaultValue：参数的默认值（优点搞不懂，测试不生效）
     *
     */
    @GetMapping("query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "query", dataType = "Integer")
    })
    @ApiOperation("测试查询")
    public String search(String name, Integer age) {
        return name + ":" + age;
    }

    @PostMapping("add")
    @ApiOperation("测试添加")
    public String add(User user){
        return user.getName()+":"+user.getAge();
    }

    /**
     * @ApiResponses：用于表示一组响应
     * - @ApiResponse：用在 @ApiResponses 中，一般用于表达一个错误的响应信息
     *  - code：数字，例如400
     *  - message：信息，例如"请求参数没填好"
     *  - response：抛出异常的类
     */
    @GetMapping("/user/{id}")
    @ApiOperation("根据ID获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value = "用户编号",required = true,paramType ="path")})
    @ApiResponses({
            @ApiResponse(code=408,message = "错误1" ),
            @ApiResponse(code=400,message = "错误2" ),
            @ApiResponse(code=404,message = "错误3" )
    })
    public User load(@PathVariable("id") Integer id){
        return new User(id,"jack",32);
    }
}
