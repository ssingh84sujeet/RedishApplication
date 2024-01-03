package com.sujit.RedishApplication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedishConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
      /*  RedisStandaloneConfiguration standaloneConfiguration=new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName("localhost");
        standaloneConfiguration.setPort(6379);*/
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate<Object,Object> templateMethod(){
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
