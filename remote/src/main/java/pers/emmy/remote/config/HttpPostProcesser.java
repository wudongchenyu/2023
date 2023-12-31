package pers.emmy.remote.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpPostProcesser implements ResourceLoaderAware, BeanDefinitionRegistryPostProcessor{

	private ResourceLoader resourceLoader;
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		try {
            //获取指定目录下的class文件
            Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:pers/emmy/remote/service/*.class");
            //根据resources创建数据读取工厂
            MetadataReaderFactory metaReader = new CachingMetadataReaderFactory(resourceLoader);
            for (Resource resource : resources) {
                //获取元数据
                MetadataReader metadataReader = metaReader.getMetadataReader(resource);
                //判断是否存在HttpExchange注解(是否为http interface的接口调用)
                if (metadataReader.getAnnotationMetadata().hasAnnotation(HttpExchange.class.getName())) {
                    //利用类的全限定名通过Class.forName获取class对象并利用http服务的代理工厂创建出代理对象
                    Object client = beanFactory.getBean(HttpServiceProxyFactory.class).createClient(Class.forName(metadataReader.getClassMetadata().getClassName()));
                    //将创建出来的代理对象放到io容器当中
                    beanFactory.registerSingleton(metadataReader.getClassMetadata().getClassName(), client);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	@Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
 
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
 
    }
	
}
