//package com.tfjybj.ftdp.config;
//
//import com.tfjybj.ftdp.utils.JSONUtils;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author quinn
// * @version 创建时间：2018/10/11 14:09
// */
//@Configuration
//@EnableCaching
//public class RedisCacheConfig {
//
//    /**
//     * jackson ObjectMapper
//     *
//     * @return
//     */
//    @Bean
//    public ObjectMapper objectMapper() {
//        return JSONUtils.getObjectMapper();
//    }
//
//    /**
//     * jackson 序列化器
//     *
//     * @param om
//     * @return
//     */
//    @Bean
//    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer(ObjectMapper om) {
//        return new GenericJackson2JsonRedisSerializer(om);
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        return RedisCacheManager.builder(connectionFactory).build();
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//
//        // key value序列化
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//
//        // hash key value 序列化
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
