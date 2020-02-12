package com.cc.pic.api.annotations;

import java.lang.annotation.*;

/**
 * @ProJectName APIServer
 * @FileName Ann
 * @Description 作用于接口上的注解，一些自定义的配置 如此接口是否需要鉴权;
 * 接口鉴权还有如下的思路可选
 * 1、如之前的项目做一个鉴权库，但是使用注解的效率显然使最高的，这无疑是最优的选择
 * 2、和1的方式一样，只是对鉴权库的定义方式不同
 *  * 可以是关系型数据库
 *  * 非关系型数据库
 *  * 代码中的yml、properties、json等格式化的配置文件做配置代码中做解析或者再做个缓存这个缓存又可以考虑是否使用非关系型数据库做（不建议使用关系型数据库，因为他本来就不适合做缓存）
 *  * 直接在代码中硬编码，建立一个java文件，使用容器对象（map、list、jsonobject...）进行存储，缓存也都不用考虑了，因为这样做本身就是一个缓存
 * 总结：  上诉的四种鉴权库的定义方式，各有优缺点，根据实际的应用场景择优选择，比如没有条件使用非关系型数据库那么就可以排除2、3方案
 *      如果关系型数据库也没条件，那么4方案无疑是最佳的。
 *        但是无论怎么弄鉴权库，如思路1所说，没有鉴权库直接使用注解才是最优的选择，对于编码和使用时最便捷的，唯一缺点就是无法做到统一管理，但是其他方面他都是最优的。
 *      并且大部分情况下并不需要做统一管理，只要能够方便修改接口是否需要鉴权的状态即可,显然，这一点是可以做到的，只要找到接口修改其注解的鉴权配置即可（某些情况下删除注解则表示无需鉴权，如果只有一个配且为鉴权的话）
 *
 * @Author CandyMuj
 * @Date 2019/12/25 16:54
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Ann {

    // 此接口是否需要登录鉴权
    boolean au() default true;

}
