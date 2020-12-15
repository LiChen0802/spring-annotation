import com.li.bean.Person;
import com.li.config.MainConfig;
import com.li.config.MainConfigOfAutowired;
import com.li.config.MainConfigOfLifeCycle;
import com.li.config.MainConfigOfPropertyValues;
import com.li.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(bean.toString());
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
//        beanNamesForType.foreach(s -> System.out.println(s+"   " ));
        for (String s :
                beanNamesForType) {
            System.out.println(s + "   ");

        }
    }

    @SuppressWarnings("resourse")
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person == person2);
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        // 多实例时 在获取Bean时调用初始化方法  不会进行销毁
        applicationContext.getBean("car");
        //关闭容器 会调用销毁方法
        applicationContext.close();
    }

    @Test
    public void test04() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        //关闭容器 会调用销毁方法
        applicationContext.close();
    }


    @Test
    public void test05() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        printBean(applicationContext);
        System.out.println("===========");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    private void printBean(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        String[] definitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("----" + name + "----");
        }
    }

    @Test
    public void test06() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        printBean(applicationContext);
    }
}
