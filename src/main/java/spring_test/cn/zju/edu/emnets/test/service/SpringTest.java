package spring_test.cn.zju.edu.emnets.test.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class SpringTest {
    public static void main(String[] args) {
//        工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        读取器和工厂绑定
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        绑定xml
        reader.loadBeanDefinitions("beans.xml");
//        从工厂中获取对象
        UserService userService = (UserService) factory.getBean("" +
                "" +
                "");
        userService.show();
    }
}
