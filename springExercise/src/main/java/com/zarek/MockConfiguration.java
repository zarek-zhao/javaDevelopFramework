package com.zarek;

import com.zarek.mybatis.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhao
 * @date 2021/3/10 10:22
 */

@Configuration
public class MockConfiguration {

    @Bean
    public Student student(){
        return new Student();
    }

}
