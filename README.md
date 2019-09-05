# Online-learning-website
## 1. 项目介绍

1. 类型：在线学习网站
2. 主要功能：课程浏览、课程评价、笔记管理、视频、登录注册、提问、推荐等。
3. 涉及技术：
    + SpringBoot、SpringCloud、MyBatis、
    + Redis、MongoDB、MySQL、
    + H5+CSS3+jQuery+Bootstrap、Vue、Thymeleaf、Nginx等
    + MVAEN、Eclipse、Git/SVN开发工具
4. 项目架构：微服务架构
    + 将原有单体应用进行分解，每个模块都是一个独立的子系统，他们可以分开独立部署，也可以远程系统功能调用。
5. 微服务架构优缺点
    + 优点：
        - 有利于开发分工和管理
        - 有利于技术选型
        - 有利于部署服务选型和扩容
        - 有利于系统维护和扩展
    + 缺点：
        - 开发服务间调用和测试复杂度高
        - 部署和维护难度高
        - 服务监控和容错难度大
        - 多服务业务事务完成性控制难度大
        - 微服务拆分难度高

## 2. 项目数据库设计
``` 
【方向表】-->【学科表】-->【课程表】-->【章节表】-->【视频表】-->【评价表】-->【评价点键表】
                            |                       |
                            |-->【课程收藏表】       |-->【问题表】-->【回复表】
                                                    |
                                                    |-->【笔记表】-->【笔记收藏表】
                                                    |
                                                    |-->【笔记点键表】
【用户表】
```


## 3. 项目环境搭建

### 3.1 数据库
MySQL数据库： (建表)导入sql数据文件
``` sql
create database ydma;
use ydma;
set names utf8;
source xxx.sql
```

### 3.2 Maven project
#### 3.2.1 Eclipse配置Maven环境
1. 打开Eclipse点击window --> prferences --> Maven[Installations] --> Add -->(选择Maven解压文件夹) --> finish
2. 打开Eclipse点击window --> prferences --> Maven[User Settings] --> (选择Maven解压文件夹/conf/settings.xml) --> apply

#### 3.2.2 项目业务拆分
1. 建立父工程
    - `ydma-parent` : 父工程、聚合工程

2. 微服务工程，服务拆分思想：按资源处理为单位，结合业务进行拆分。
    - `ydma-service-user` : user表
    - `ydma-service-course` : course、collect_course表
    - `ydma-service-direction` : direction、subject表
    - `ydma-service-note` : note、collect_note、note_like表
    - `ydma-service-issue` : issue、answer表
    - `ydma-service-evaluate`：evaluate、evaluation_like表
    - `ydma-service-video` : video、chapter表

2. web project（Web UI工程）
    - `ydma-ui-web` :（Thymeleaf替代JSP）

3. 微服务治理工程：引入SpringCloud技术和组件对微服务进行管理。
    - `ydma-cloud-eureka` (微服务注册中心)
    - `ydma-cloud-hystrix`（短路器，微服务异常的监控）
    - `ydma-cloud-zuul`（网关，外界访问eureka注册的微服务入口）
    - `ydma-cloud-config`（分布式统一配置中心）
    - 其他的SpringCloud组件还有`ribbon负载`、`feign接口服务调用`、`bus消息总线`等。
	

#### 3.2.3 SpringBoot环境搭建
- 为工程pom.xml添加jar定义
- 为工程定义application.properties
- 为工程添加RunXxxBoot启动类


### 3.3 使用MyBatisGenerator生成Entity、XML、Mapper代码
1. 引入mybatis、mybatis-generator、mysql驱动
``` xml
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.7</version>
</dependency>
```

2. 添加mybatis generator配置文件mbg.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
    PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
    "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!-- 指定驱动包 -->
    <classPathEntry location="D:/apache-maven-3.6.1/.m2/repository/mysql/mysql-connector-java/8.0.15/mysql-connector-java-8.0.15.jar" />

    <context id="DB2Tables" targetRuntime="MyBatis3">
    <!-- 指定数据库连接参数 -->
    <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
        connectionURL="jdbc:mysql://localhost:3306/ydma"
        userId="root"
        password="123456">
        <property name="nullCatalogMeansCurrent" value="true"/>
    </jdbcConnection>

    <javaTypeResolver >
        <property name="forceBigDecimals" value="false" />
    </javaTypeResolver>

    <!-- 指定 实体类  路径-->
    <javaModelGenerator targetPackage="top.chao.entity" targetProject="./src/main/java">
        <property name="enableSubPackages" value="true" />
        <property name="trimStrings" value="true" />
    </javaModelGenerator>

    <!-- 指定 SQL定义xml文件  路径-->
    <sqlMapGenerator targetPackage="top.chao.xmlsql"  targetProject="./src/main/resources">
        <property name="enableSubPackages" value="true" />
    </sqlMapGenerator>

    <!-- 指定 Mapper映射器（dao）文件  路径-->
    <javaClientGenerator type="ANNOTATEDMAPPER" targetPackage="top.chao.dao"  targetProject="./src/main/java">
        <property name="enableSubPackages" value="true" />
    </javaClientGenerator>

    <!-- 指定  数据库的 基本表-->
    <table tableName="%" enableSelectByExample="false" enableDeleteByExample="false" 
        enableCountByExample="false" enableUpdateByExample="false" 
        selectByExampleQueryId="flase">
        <property name="useActualColumnNames" value="true"/>
        <generatedKey column="ID" sqlStatement="mysql" identity="true" />
    </table>

    </context>
</generatorConfiguration>
```

3. 加载mbg.xml配置文件启动
``` java
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
public class RunMBG {
    public static void main(String[] args) throws Exception {
           List<String> warnings = new ArrayList<>();
           boolean overwrite = true;
           File configFile = new File("src/main/resources/mbg.xml");
           ConfigurationParser cp = new ConfigurationParser(warnings);
           Configuration config = cp.parseConfiguration(configFile);
           DefaultShellCallback callback = new DefaultShellCallback(overwrite);
           MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
           myBatisGenerator.generate(null);
    }
}
```



## 4. 用户模块服务开发
1. 统一返回Json结果的格式`{code:"",msg:"",data:""}`
    + ResultJson实体类封装返回内容

2. 统一返回结果含义，提高统一性和代码可读性、可维护性
    + 定义枚举类ResultEnum

3. junit+spring-test测试
    + junit:单元测试工具
    + spring-test:集成了junit4，测试spring容器组件和MVC处理流程。

4. 密码加密
    + 密码采用：MD5(密码+随机盐)
    + RSA加密算法


## 5. 登录设计
1. 主要逻辑：将用户输入的用户名和密码与数据库进行比对，相同登录成功。
2. 详细业务：需要将用户输入的密码进行MD5+盐，然后再与数据库比对。
3. 扩展业务：带验证码（3次错误后出现）；输错6次锁定24小时；避免重复登录；SSO单点登录；基于token方式身份验证

### 5.1 输错锁定实现逻辑
1. 用户表需要追加用户状态、出错次数、锁定时间等字段
2. 可以定时调用一个Task任务，用于24小时后自动解锁

### 5.2 避免重复登录实现逻辑
1. 方案一：使用application保存用户登录列表，再次登录如果发现application存在就属于重复登录（单体应用可以使用）
2. 方案二：使用数据表保存用户登录状态，如果登录发现已经是登录状态就属于重复登录（单体或分布式可以使用）
3. 方案三：使用Redis缓存保存用户登录状态（单体或分布式可以使用）

### 5.3 SSO
Single sign On 单点登录，在分布式架构中，用于访问其中一个系统进行登录，然后访问其他系统登录不需要再进行登录。
1. 将用户认证系统独立，负责登录、注册、修改密码、颁发令牌、令牌校验
2. 用户登录成功，用户认证中心给用户颁发一个令牌返回，用户客户端保存起来（Cookie、H5本地存储）
3. 用户携带令牌访问其他系统，其他系统通过拦截器拦截请求，截取令牌，调用认证系统进行检测
4. 拦截器令牌检测通过，允许继续执行，未通过定位到用户认证登录界面

### 5.4 用户身份验证方案
1. 使用session保存用户信息（单体应用，单体集群需要考虑session同步）
2. 使用Redis缓存保存用户信息）（单体应用或分布式可用）
3. 使用JWT方案生成token，不需要服务端存储状态

### 5.5 JWT标准
1. Json Web Token，基于json格式信息一种token令牌。
2. JWT token 包含三部分，第一部分header、第二部分payload、第三部分签证
    1. 第一部分： Header：声明令牌的类型（typ）和使用的算法（alg）
    2. 第二部分： Payload：也称为JWT Claims，包含用户的一些信息
        + 系统保留的声明（Reserved claims）：
            - iss (issuer)：签发人
            - exp (expiration time)：过期时间
            - sub (subject)：主题
            - aud (audience)：受众用户
            - nbf (Not Before)：在此之前不可用
            - iat (Issued At)：签发时间
            - jti (JWT ID)：JWT唯一标识，能用于防止JWT重复使用
        + 公共的声明(public)：
            - 见 http://www.iana.org/assignments/jwt/jwt.xhtml
        + 私有的声明(private claims)：
            - 根据业务需要自己定义的数据
    3. 第三部分： Signature：签名（需要一个secret秘钥，不对外公开）
        + 签名格式：`HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)`
        + 示例：`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJVc2VySWQiOjEyMywiVXNlck5hbWUiOiJhZG1pbiJ9.Qjw1epD5P6p4Yy2yju3-fkq28PddznqRj3ESfALQy_U`

3. JWT的特点：
    + JWT默认是不加密的，不能把用户敏感类信息放在Payload部分。
    + JWT 不仅可以用于认证，也可以用于交换信息。
    + JWT的最大缺点是服务器不保存会话状态，所以在使用期间不可能取消令牌或更改令牌的权限。
    + JWT本身包含认证信息，为了减少盗用，JWT的有效期不宜设置太长。
    + 为了减少盗用和窃取，JWT不建议使用HTTP协议来传输代码，而是使用加密的HTTPS协议进行传输。
    + * 首次生成token比较慢，比较耗CPU，在高并发的情况下需要考虑CPU占用问题。
    + * 生成的token比较长，可能需要考虑流量问题。
4. 认证原理：
+ 客户端向服务器申请授权，服务器认证以后，生成一个token字符串并返回给客户端，此后客户端在请求受保护的资源时携带这个token，服务端进行验证再从这个token中解析出用户的身份信息。
5. JWT的使用方式：
    1. 一种做法是放在HTTP请求的头信息Authorization字段里面，格式如下：
        + `Authorization: <token>`
        + 需要将服务器设置为接受来自所有域的请求，用Access-Control-Allow-Origin: *
    2. 另一种做法是，跨域的时候，JWT就放在POST请求的数据体里面。
6. 对JWT实现token续签的做法：
    1. 额外生成一个refreshToken用于获取新token，refreshToken需存储于服务端，其过期时间比JWT的过期时间要稍长。
    2. 用户携带refreshToken参数请求token刷新接口，服务端在判断refreshToken未过期后，取出关联的用户信息和当前token。
    3. 使用当前用户信息重新生成token，并将旧的token置于黑名单中，返回新的token。


### 5.6 Java-JWT工具包
- java-jwt工具包提供了**jwt算法的封装**。



## 6. MyBatis扩展
+ 对单表的CRUD操作
+ 分页处理
+ SQL定义(XML、注解)
+ resultMap自定义映射
+ 动态SQL
+ 关联查询映射
+ 缓存

### 6.1 动态SQL
XML版本
``` xml
<select id="findSelective" parameterType="cn.xdl.ydma.entity.User">
    select * from user
    <where>
        <if test="name != null">
            name=#{name,jdbcType=VARCHAR},
        </if>
        <if test="nickName != null">
            and nick_name=#{nickName,jdbcType=VARCHAR},
        </if>
        <if test="sex != null">
            and sex=#{sex,jdbcType=VARCHAR},
        </if>
    </where>
</select>
```

注解版本
``` java
public String findSelective(User record) {
    SQL sql = new SQL();
    sql.SELECT("*");
    sql.FROM("user");
    if(record.getName() != null) {
        sql.WHERE("name = #{name,jdbcType=VARCHAR}");
    }
    if(record.getNickName() != null) {
        sql.WHERE("nick_name=#{nickName,jdbcType=VARCHAR}");
    }
    if(record.getSex() != null) {
        sql.WHERE("sex=#{sex,jdbcType=VARCHAR}");
    }
    return sql.toString();
}
```


### 6.2 关联查询映射
注解版本：使用one=@One或many=@Many加载关联表数据，
1. 首先需要在实体类中，追加关联属性，用于存储关联表数据；
``` java
public class Direction {
    private Integer id;
    private String name;
    //用于存储关联的学科数据
    private List subjects;
    //set和get方法		
}
```

2. 然后再查询语句中，对关联属性使用@One或@Many描述映射;
``` java
@Select({
    "select",
    "id, name",
    "from direction"
})
@Results({
    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
    @Result(property="subjects",javaType=List.class,column="id",
        many=@Many(select="cn.xdl.ydma.dao.SubjectMapper.selectByDirectionId"))
})
List<Direction> selectAll();
// SubjectMapper中的selectByDirectionId方法定义
@Select({
    "select",
    "id, name, direction_id",
    "from subject",
    "where direction_id = #{direction_id,jdbcType=INTEGER}"
})
@Results({
    @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
    @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
    @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER)
})
List<Subject> selectByDirectionId(Integer direction_id);
```

XML版本: 
1. n+1个SQL加载
``` xml
<select id="selectAll" resultMap="BaseResultMap1">
    select 
    <include refid="Base_Column_List" />
    from direction
</select>
<resultMap id="BaseResultMap1" type="cn.xdl.ydma.entity.Direction">
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="name" jdbcType="VARCHAR" property="name" />
    <!-- 描述subjects关联属性的加载 -->
    <collection property="subjects" javaType="java.util.List" column="id"
        select="cn.xdl.dyma.dao.SubjectMapper.selectByDirectionId">
    </collection>
</resultMap>
```

2. 1个join SQL加载
``` xml
<select id="selectAll1" resultMap="BaseResultMap2">
    select d.id did,d.name dname,s.id sid,s.name sname,s.direction_id
from direction d join subject s on(d.id=s.direction_id)
</select>
<resultMap id="BaseResultMap1" type="cn.xdl.ydma.entity.Direction">
    <id column="did" jdbcType="INTEGER" property="id" />
    <result column="dname" jdbcType="VARCHAR" property="name" />
    <collection property="subjects" javaType="java.util.List" 
        ofType="cn.xdl.ydma.entity.Subject">
        <id column="sid" jdbcType="INTEGER" property="id" />
        <result column="sname" jdbcType="VARCHAR" property="name" />
        <result column="direction_id" jdbcType="VARCHAR" property="directionId" />
    </collection>
</resultMap>
```

> @Many等价于< collection>作用，@One等价于< association>。< association>使用方法与< collection>相似。



### 6.3 MyBatis缓存
- MyBatis缓存有两级，一级缓存是SqlSession级别的，二级缓存是SqlSessionFactory级别的。
- MyBatis缓存针对查询有效，对于增删改同步缓存。缓存淘汰策略使用的是最近最少使用原则LRU。

1. SqlSession一级缓存（默认是开启）
    + 使用同一个SqlSession执行sql多次，只查询DB一次，其他都从缓存获取。（缓存的是对象，sql参数不同会查询DB）

``` java
@Test
public void test3() {
    SqlSession sqlSession = factory.openSession();
    DirectionMapper dao = sqlSession.getMapper(DirectionMapper.class);
    Direction d1 = dao.selectByPrimaryKey(1);
    System.out.println(d1);
    //sqlSession.clearCache();//清除缓存
    Direction d2 = dao.selectByPrimaryKey(1);
    System.out.println(d2);
    sqlSession.close();
}
```

2. SqlSessionFactory二级缓存（默认是关闭）
    + 一级缓存必须是同一个sqlsession对象，遇到不同的sqlsession对象查询无效。如果需要在多个不同的sqlsession对象之间共享缓存数据，可以开启二级缓存。
``` xml
    <settings>
        <setting name="cacheEnabled" value="true"/>
    </settings>
```

    + 在SQL定义文件中添加
``` xml
//XML SQL使用
<cache></cache>
//注解SQL使用
@CacheNamespace//等价于XML中使用二级缓存的<cache>标记
```

> 提示：SpringBoot默认已经打开了二级缓存的开启设置，不用再定义< setting>参数了。








