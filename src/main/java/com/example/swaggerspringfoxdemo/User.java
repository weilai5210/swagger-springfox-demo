package com.example.swaggerspringfoxdemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ApiModel：用于响应类上，表示一个返回响应数据的信息
 * - value="响应类名称"
 * - description="响应类描述"
 */
@ApiModel("用户信息实体")
public class User {
    /**
     * @ApiModelProperty：用在属性上，描述响应类的属性
     * - value="属性说明"
     * - name="重写属性名"
     * - dataType="重写属性类型"
     * - required="是否必填"
     * - example="举例说明"
     */
    @ApiModelProperty("编码")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    /*get和set省略*/

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
