# spring
##Spring基于注解方式的IOC
###常用注解
1、创建对象

2、注入数据

3、改变bean对象作用范围

4、控制bean对象的生命周期

xml实现方式

<bean id=\"" class=\"" scope=\"" init-method=\"" destroy-method=\"">

    <property name="" value/ref=""></property>
<\/bean>

注解方式实现

@Component:把当前类存入spring容器中

@Controller

@Service

@Respository

@Controller、@Service、@Respository三个注解的作用与@Component作用相似，是spring提供了三层架构而来，明确三层的对象。

@Autowired：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。

位置可以是变量，也可以是方法

注入时，如果容器中没有类型相同的bean对象，则会报错。

@Qualifier：在按照类型注入的基础上再按照bean对象的名称注入，通常与@Autowired注解同时使用。

@Resource：之u姐按照bean对象的id注入，可以单独使用

< font color=red>以上三个注解注入的bean对象类型只能是其他bean类型，不能注入基本类型和String类型，集合类型的注入只能是xml实现。

@Value：用于注入基本类型和String类型。属性：value，可以使用spring中的spel表达式注入：${表达式} 

@Configuration：指定当前类是一个配置类

@ComponentScan：通过注解指定spring创建容器时要扫描的包，属性：value,它和basepackages的作用一样，指定要扫描的包

使用@ComponentScan注解相当于xml中配置了： <context:component-scan base-package="com.thought.it"></context:component-scan>

如果全部采用注解方式开发，当创建spring容器时：AnnotationConfigApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

@Bean：获取该方法的返回值对象并存放到spring容器中。

@Import：导入其他配置类，当我们使用Import注解之后，有Import注解的类为父配置类，其他导入的配置类均为子配置类。

@PropertySource：用于指定properties文件的位置。

##spring整合Junit
1、导入spring整合Junit的jar包

2、使用spring提供的注解把原有的main方法替换掉@RunWith

3、告知spring运行期，spring容器的创建是使用xml配置还是注解方式配置
@ContextConfiguration

属性：

location：指定xml文件的位置，并加上classpath关键字，表示在类路径下

classes：指定注解配置类的位置

注：当使用spring5.x版本的时候，要求junit的jar必须是4.12及以上