package com.example.core.lifecycle;

import com.example.core.scope.PrototypeTest;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;


import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);

        ac.close();
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean{
//        private final PrototypeBean prototypeBean;

        // ObjectProvider는 더 많은 기능을 제공함
        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

        // ObjectFactory는 이전에 사용하던 방식임
//        @Autowired
//        private ObjectFactory<PrototypeBean> prototypeBeanFactory;

//        @Autowired
//        ApplicationContext applicationContext;

//        @Autowired
//        public ClientBean(PrototypeBean prototypeBean){
//            this.prototypeBean = prototypeBean;
//        }

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count ++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init : " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy : " + this);
        }
    }
}
