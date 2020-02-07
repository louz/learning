package io.jasonlu.spring.unittest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 声明该类为Spring配置类，作用类似xml配置文件中的beans节点
@ComponentScan  // 默认扫描该类所在包及其子包下所有的@Component、@Service、@Repository、@Controller
// @ComponentScan(basePackages = {"io.jasonlu.learning"}) 可显式指定扫描的根目录
public class Config {
}
