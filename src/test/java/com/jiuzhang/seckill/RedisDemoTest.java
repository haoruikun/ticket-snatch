package com.jiuzhang.seckill;

import com.jiuzhang.seckill.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RedisDemoTest {

    @Resource
    private RedisService redisService;

    @Test
    public void stockTest() {
        String value = redisService.setValue("stock:19", 10L).getValue("stock:19");
        assertEquals(value, Long.toString(10L));
    }

    @Test
    void stockDeductValidation() {
        redisService.setValue("test:1", 100L);
        boolean result =  redisService.stockDeductValidator("test:1");
        assertTrue(result);
        String value = redisService.getValue("test:1");
        assertEquals(new Long(value), 99L);
    }
}
