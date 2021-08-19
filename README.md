# SHIRO-829
> In SpringBoot 1.X,when the BeanPostProcessor implements the PriorityOrdered interface and 
> is configured in the same configuration file as FactoryBean, it will cause FactoryBean's 
> dependent proxy to fail(including @Transactions,@Cache,@Aspect,etc.)

You can perform unit test for all projects,where _shiro-spring-issue_ and _simple-factory-bean-issue_ will fail.

The project with the simple-factory-bean prefix prefix is to show this problem and the current solution, and _shiro-spring-issue_ is to show how shiro triggers this problem in the project.



**shiro-spring-issue** show how shiro triggers this problem in the project

**simple-factory-bean-issue** restored this problem

**simple-factory-bean-solution-1** puts the BeanPostProcessor into a separate configuration class to avoid aop failure.

_change file_:
> FactoryBeanConfiguration.java

**simple-factory-bean-solution-2** removed the PriorityOrdered interface implemented by BeanPostProcessor.

_change file_:
> IdentityBeanPostProcessor.java

**simple-factory-bean-solution-3** modify the signature of ShiroFilterFactoryBean to declare that the generic type of FactoryBean is a concrete type.

_change file_:
> ShiroFilterFactoryBean.java
