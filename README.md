# spring
##Spring基于注解方式的IOC
###常用注解
1、创建对象

2、注入数据

3、改变bean对象作用范围

4、控制bean对象的生命周期

xml实现方式

<bean id=\"" class=\"" scope=\"" init-method=\"" destroy-method=\"">

    <property name="" value/ref=""><\/property>
<\/bean>

注解方式实现

@Componet:把当前类存入spring容器中

@Controller

@Service

@Respository

@Controller、@Service、@Respository三个注解的作用与@Componet作用相似，是spring提供了三层架构而来，明确三层的对象。

@Autowired：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。

位置可以是变量，也可以是方法

注入时，如果容器中没有类型相同的bean对象，则会报错。

@Qualifier：在按照类型注入的基础上再按照bean对象的名称注入，通常与@Autowired注解同时使用。

@Resource：之u姐按照bean对象的id注入，可以单独使用

< font color=red>以上三个注解注入的bean对象类型只能是其他bean类型，不能注入基本类型和String类型，集合类型的注入只能是xml实现。

@Value：用于注入基本类型和String类型。属性：value，可以使用spring中的spel表达式注入：${表达式} 
