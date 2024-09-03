package com.example.core1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 맨 위의 COnfiguration 붙으면서 기존 예제 AppConfig 배제하는 설정
        // 예제 코드 남기기 위한 설정, 실무에서는 잘 사용 안함
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

}