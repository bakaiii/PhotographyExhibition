# PhotographyExhibition APIServer

## 待解决的问题

- [ ] 如果没有redis，或者获取redis连接失败就使用本地缓存（map）作为替代方案
    
    - [x] 添加本地缓存管理工具 com.cc.pic.api.utils.sys.CacheUtil 目前只能算是个半成品，后续需对其进行封装以更适用于SpringBoot，详见下方几点
    
    - [ ] 调整本地缓存类，使其更好的集成SpringBoot；有两种方案。
        
        - 方案1：在原有的RedisUtil中的每个方法中，或者首次加载时（建议使用前者在每个方法中判断，因为redis每次执行时都会获取连接，他没有池的概念，每次都是直接请求Redis，所以配置也是实时的，而不是如Mysql或Oracle一样；虽然可能有效率问题，但是这样准确性更高些）判断是否有连接，redis是否正常，可通过执行一个命令看是否报错，或者看有没有获取连接状态的方法来判断。如果正常就用redis即可，否则就以静态方式调用CacheUtil。
        
        - 方案2：添加一个接口，里面定义RedisUtil中的所有方法；使RedisUtil实现此接口，其中的方法不用改变；再使CacheUtil也实现此接口，根据原有代码再根据接口方法具体实现方法，此时它不再是静态方法了，而是可以被Spring IOC注册的Bean；此时就有两个类实现了这个接口，注入时使用接口引用的方式注入，并通过Conditional来进行条件注入，条件即方案一一样的判断方式，择优选择。

- [ ] 针对查询数据库返回数据时，对返回值中为空的字段进行默认值设置，这样的好处是可减少前端过多的非空校验（经过百度暂无思路）

- [ ] com.cc.pic.api.utils.sys.MybatisPlusCodeGenerator 完善Mybatis逆向工程

