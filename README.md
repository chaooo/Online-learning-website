# Online-learning-website
## 1. ��Ŀ����

1. ���ͣ�����ѧϰ��վ
2. ��Ҫ���ܣ��γ�������γ����ۡ��ʼǹ�����Ƶ����¼ע�ᡢ���ʡ��Ƽ��ȡ�
3. �漰������
    + SpringBoot��SpringCloud��MyBatis��
    + Redis��MongoDB��MySQL��
    + H5+CSS3+jQuery+Bootstrap��Vue��Thymeleaf��Nginx��
    + MVAEN��Eclipse��Git/SVN��������
4. ��Ŀ�ܹ���΢����ܹ�
    + ��ԭ�е���Ӧ�ý��зֽ⣬ÿ��ģ�鶼��һ����������ϵͳ�����ǿ��Էֿ���������Ҳ����Զ��ϵͳ���ܵ��á�
5. ΢����ܹ���ȱ��
    + �ŵ㣺
        - �����ڿ����ֹ��͹���
        - �����ڼ���ѡ��
        - �����ڲ������ѡ�ͺ�����
        - ������ϵͳά������չ
    + ȱ�㣺
        - �����������úͲ��Ը��Ӷȸ�
        - �����ά���Ѷȸ�
        - �����غ��ݴ��Ѷȴ�
        - �����ҵ����������Կ����Ѷȴ�
        - ΢�������Ѷȸ�

## 2. ��Ŀ���ݿ����
``` 
�������-->��ѧ�Ʊ�-->���γ̱�-->���½ڱ�-->����Ƶ��-->�����۱�-->�����۵����
                            |                       |
                            |-->���γ��ղر�       |-->�������-->���ظ���
                                                    |
                                                    |-->���ʼǱ�-->���ʼ��ղر�
                                                    |
                                                    |-->���ʼǵ����
���û���
```


## 3. ��Ŀ�����

### 3.1 ���ݿ�
MySQL���ݿ⣺ (����)����sql�����ļ�
``` sql
create database ydma;
use ydma;
set names utf8;
source xxx.sql
```

### 3.2 Maven project
#### 3.2.1 Eclipse����Maven����
1. ��Eclipse���window --> prferences --> Maven[Installations] --> Add -->(ѡ��Maven��ѹ�ļ���) --> finish
2. ��Eclipse���window --> prferences --> Maven[User Settings] --> (ѡ��Maven��ѹ�ļ���/conf/settings.xml) --> apply

#### 3.2.2 ��Ŀҵ����
1. ����������
    - `ydma-parent` : �����̡��ۺϹ���

2. ΢���񹤳̣�������˼�룺����Դ����Ϊ��λ�����ҵ����в�֡�
    - `ydma-service-user` : user��
    - `ydma-service-course` : course��collect_course��
    - `ydma-service-direction` : direction��subject��
    - `ydma-service-note` : note��collect_note��note_like��
    - `ydma-service-issue` : issue��answer��
    - `ydma-service-evaluate`��evaluate��evaluation_like��
    - `ydma-service-video` : video��chapter��

2. web project��Web UI���̣�
    - `ydma-ui-web` :��Thymeleaf���JSP��

3. ΢���������̣�����SpringCloud�����������΢������й���
    - `ydma-cloud-eureka` (΢����ע������)
    - `ydma-cloud-hystrix`����·����΢�����쳣�ļ�أ�
    - `ydma-cloud-zuul`�����أ�������eurekaע���΢������ڣ�
    - `ydma-cloud-config`���ֲ�ʽͳһ�������ģ�
    - ������SpringCloud�������`ribbon����`��`feign�ӿڷ������`��`bus��Ϣ����`�ȡ�
	

#### 3.2.3 SpringBoot�����
- Ϊ����pom.xml���jar����
- Ϊ���̶���application.properties
- Ϊ�������RunXxxBoot������


### 3.3 ʹ��MyBatisGenerator����Entity��XML��Mapper����
1. ����mybatis��mybatis-generator��mysql����
``` xml
<dependency>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-core</artifactId>
    <version>1.3.7</version>
</dependency>
```

2. ���mybatis generator�����ļ�mbg.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
    PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
    "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!-- ָ�������� -->
    <classPathEntry location="D:/apache-maven-3.6.1/.m2/repository/mysql/mysql-connector-java/8.0.15/mysql-connector-java-8.0.15.jar" />

    <context id="DB2Tables" targetRuntime="MyBatis3">
    <!-- ָ�����ݿ����Ӳ��� -->
    <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
        connectionURL="jdbc:mysql://localhost:3306/ydma"
        userId="root"
        password="123456">
        <property name="nullCatalogMeansCurrent" value="true"/>
    </jdbcConnection>

    <javaTypeResolver >
        <property name="forceBigDecimals" value="false" />
    </javaTypeResolver>

    <!-- ָ�� ʵ����  ·��-->
    <javaModelGenerator targetPackage="top.chao.entity" targetProject="./src/main/java">
        <property name="enableSubPackages" value="true" />
        <property name="trimStrings" value="true" />
    </javaModelGenerator>

    <!-- ָ�� SQL����xml�ļ�  ·��-->
    <sqlMapGenerator targetPackage="top.chao.xmlsql"  targetProject="./src/main/resources">
        <property name="enableSubPackages" value="true" />
    </sqlMapGenerator>

    <!-- ָ�� Mapperӳ������dao���ļ�  ·��-->
    <javaClientGenerator type="ANNOTATEDMAPPER" targetPackage="top.chao.dao"  targetProject="./src/main/java">
        <property name="enableSubPackages" value="true" />
    </javaClientGenerator>

    <!-- ָ��  ���ݿ�� ������-->
    <table tableName="%" enableSelectByExample="false" enableDeleteByExample="false" 
        enableCountByExample="false" enableUpdateByExample="false" 
        selectByExampleQueryId="flase">
        <property name="useActualColumnNames" value="true"/>
        <generatedKey column="ID" sqlStatement="mysql" identity="true" />
    </table>

    </context>
</generatorConfiguration>
```

3. ����mbg.xml�����ļ�����
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



## 4. �û�ģ����񿪷�
1. ͳһ����Json����ĸ�ʽ`{code:"",msg:"",data:""}`
    + ResultJsonʵ�����װ��������

2. ͳһ���ؽ�����壬���ͳһ�Ժʹ���ɶ��ԡ���ά����
    + ����ö����ResultEnum

3. junit+spring-test����
    + junit:��Ԫ���Թ���
    + spring-test:������junit4������spring���������MVC�������̡�

4. �������
    + ������ã�MD5(����+�����)
    + RSA�����㷨


## 5. ��¼���
1. ��Ҫ�߼������û�������û��������������ݿ���бȶԣ���ͬ��¼�ɹ���
2. ��ϸҵ����Ҫ���û�������������MD5+�Σ�Ȼ���������ݿ�ȶԡ�
3. ��չҵ�񣺴���֤�루3�δ������֣������6������24Сʱ�������ظ���¼��SSO�����¼������token��ʽ�����֤

### 5.1 �������ʵ���߼�
1. �û�����Ҫ׷���û�״̬���������������ʱ����ֶ�
2. ���Զ�ʱ����һ��Task��������24Сʱ���Զ�����

### 5.2 �����ظ���¼ʵ���߼�
1. ����һ��ʹ��application�����û���¼�б��ٴε�¼�������application���ھ������ظ���¼������Ӧ�ÿ���ʹ�ã�
2. ��������ʹ�����ݱ����û���¼״̬�������¼�����Ѿ��ǵ�¼״̬�������ظ���¼�������ֲ�ʽ����ʹ�ã�
3. ��������ʹ��Redis���汣���û���¼״̬�������ֲ�ʽ����ʹ�ã�

### 5.3 SSO
Single sign On �����¼���ڷֲ�ʽ�ܹ��У����ڷ�������һ��ϵͳ���е�¼��Ȼ���������ϵͳ��¼����Ҫ�ٽ��е�¼��
1. ���û���֤ϵͳ�����������¼��ע�ᡢ�޸����롢�䷢���ơ�����У��
2. �û���¼�ɹ����û���֤���ĸ��û��䷢һ�����Ʒ��أ��û��ͻ��˱���������Cookie��H5���ش洢��
3. �û�Я�����Ʒ�������ϵͳ������ϵͳͨ���������������󣬽�ȡ���ƣ�������֤ϵͳ���м��
4. ���������Ƽ��ͨ�����������ִ�У�δͨ����λ���û���֤��¼����

### 5.4 �û������֤����
1. ʹ��session�����û���Ϣ������Ӧ�ã����弯Ⱥ��Ҫ����sessionͬ����
2. ʹ��Redis���汣���û���Ϣ��������Ӧ�û�ֲ�ʽ���ã�
3. ʹ��JWT��������token������Ҫ����˴洢״̬

### 5.5 JWT��׼
1. Json Web Token������json��ʽ��Ϣһ��token���ơ�
2. JWT token ���������֣���һ����header���ڶ�����payload����������ǩ֤
    1. ��һ���֣� Header���������Ƶ����ͣ�typ����ʹ�õ��㷨��alg��
    2. �ڶ����֣� Payload��Ҳ��ΪJWT Claims�������û���һЩ��Ϣ
        + ϵͳ������������Reserved claims����
            - iss (issuer)��ǩ����
            - exp (expiration time)������ʱ��
            - sub (subject)������
            - aud (audience)�������û�
            - nbf (Not Before)���ڴ�֮ǰ������
            - iat (Issued At)��ǩ��ʱ��
            - jti (JWT ID)��JWTΨһ��ʶ�������ڷ�ֹJWT�ظ�ʹ��
        + ����������(public)��
            - �� http://www.iana.org/assignments/jwt/jwt.xhtml
        + ˽�е�����(private claims)��
            - ����ҵ����Ҫ�Լ����������
    3. �������֣� Signature��ǩ������Ҫһ��secret��Կ�������⹫����
        + ǩ����ʽ��`HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)`
        + ʾ����`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJVc2VySWQiOjEyMywiVXNlck5hbWUiOiJhZG1pbiJ9.Qjw1epD5P6p4Yy2yju3-fkq28PddznqRj3ESfALQy_U`

3. JWT���ص㣺
    + JWTĬ���ǲ����ܵģ����ܰ��û���������Ϣ����Payload���֡�
    + JWT ��������������֤��Ҳ�������ڽ�����Ϣ��
    + JWT�����ȱ���Ƿ�����������Ự״̬��������ʹ���ڼ䲻����ȡ�����ƻ�������Ƶ�Ȩ�ޡ�
    + JWT���������֤��Ϣ��Ϊ�˼��ٵ��ã�JWT����Ч�ڲ�������̫����
    + Ϊ�˼��ٵ��ú���ȡ��JWT������ʹ��HTTPЭ����������룬����ʹ�ü��ܵ�HTTPSЭ����д��䡣
    + * �״�����token�Ƚ������ȽϺ�CPU���ڸ߲������������Ҫ����CPUռ�����⡣
    + * ���ɵ�token�Ƚϳ���������Ҫ�����������⡣
4. ��֤ԭ��
+ �ͻ����������������Ȩ����������֤�Ժ�����һ��token�ַ��������ظ��ͻ��ˣ��˺�ͻ����������ܱ�������ԴʱЯ�����token������˽�����֤�ٴ����token�н������û��������Ϣ��
5. JWT��ʹ�÷�ʽ��
    1. һ�������Ƿ���HTTP�����ͷ��ϢAuthorization�ֶ����棬��ʽ���£�
        + `Authorization: <token>`
        + ��Ҫ������������Ϊ���������������������Access-Control-Allow-Origin: *
    2. ��һ�������ǣ������ʱ��JWT�ͷ���POST��������������档
6. ��JWTʵ��token��ǩ��������
    1. ��������һ��refreshToken���ڻ�ȡ��token��refreshToken��洢�ڷ���ˣ������ʱ���JWT�Ĺ���ʱ��Ҫ�Գ���
    2. �û�Я��refreshToken��������tokenˢ�½ӿڣ���������ж�refreshTokenδ���ں�ȡ���������û���Ϣ�͵�ǰtoken��
    3. ʹ�õ�ǰ�û���Ϣ��������token�������ɵ�token���ں������У������µ�token��


### 5.6 Java-JWT���߰�
- java-jwt���߰��ṩ��**jwt�㷨�ķ�װ**��



## 6. MyBatis��չ
+ �Ե����CRUD����
+ ��ҳ����
+ SQL����(XML��ע��)
+ resultMap�Զ���ӳ��
+ ��̬SQL
+ ������ѯӳ��
+ ����

### 6.1 ��̬SQL
XML�汾
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

ע��汾
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


### 6.2 ������ѯӳ��
ע��汾��ʹ��one=@One��many=@Many���ع��������ݣ�
1. ������Ҫ��ʵ�����У�׷�ӹ������ԣ����ڴ洢���������ݣ�
``` java
public class Direction {
    private Integer id;
    private String name;
    //���ڴ洢������ѧ������
    private List subjects;
    //set��get����		
}
```

2. Ȼ���ٲ�ѯ����У��Թ�������ʹ��@One��@Many����ӳ��;
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
// SubjectMapper�е�selectByDirectionId��������
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

XML�汾: 
1. n+1��SQL����
``` xml
<select id="selectAll" resultMap="BaseResultMap1">
    select 
    <include refid="Base_Column_List" />
    from direction
</select>
<resultMap id="BaseResultMap1" type="cn.xdl.ydma.entity.Direction">
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="name" jdbcType="VARCHAR" property="name" />
    <!-- ����subjects�������Եļ��� -->
    <collection property="subjects" javaType="java.util.List" column="id"
        select="cn.xdl.dyma.dao.SubjectMapper.selectByDirectionId">
    </collection>
</resultMap>
```

2. 1��join SQL����
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

> @Many�ȼ���< collection>���ã�@One�ȼ���< association>��< association>ʹ�÷�����< collection>���ơ�



### 6.3 MyBatis����
- MyBatis������������һ��������SqlSession����ģ�����������SqlSessionFactory����ġ�
- MyBatis������Բ�ѯ��Ч��������ɾ��ͬ�����档������̭����ʹ�õ����������ʹ��ԭ��LRU��

1. SqlSessionһ�����棨Ĭ���ǿ�����
    + ʹ��ͬһ��SqlSessionִ��sql��Σ�ֻ��ѯDBһ�Σ��������ӻ����ȡ����������Ƕ���sql������ͬ���ѯDB��

``` java
@Test
public void test3() {
    SqlSession sqlSession = factory.openSession();
    DirectionMapper dao = sqlSession.getMapper(DirectionMapper.class);
    Direction d1 = dao.selectByPrimaryKey(1);
    System.out.println(d1);
    //sqlSession.clearCache();//�������
    Direction d2 = dao.selectByPrimaryKey(1);
    System.out.println(d2);
    sqlSession.close();
}
```

2. SqlSessionFactory�������棨Ĭ���ǹرգ�
    + һ�����������ͬһ��sqlsession����������ͬ��sqlsession�����ѯ��Ч�������Ҫ�ڶ����ͬ��sqlsession����֮�乲�������ݣ����Կ����������档
``` xml
    <settings>
        <setting name="cacheEnabled" value="true"/>
    </settings>
```

    + ��SQL�����ļ������
``` xml
//XML SQLʹ��
<cache></cache>
//ע��SQLʹ��
@CacheNamespace//�ȼ���XML��ʹ�ö��������<cache>���
```

> ��ʾ��SpringBootĬ���Ѿ����˶�������Ŀ������ã������ٶ���< setting>�����ˡ�








