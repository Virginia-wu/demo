package com.virginia.going.merry.web;


import com.virginia.going.merry.web.servicce.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void contextLoads() {
        Assert.assertEquals(new Integer(3), demoService.demo());
    }
}
