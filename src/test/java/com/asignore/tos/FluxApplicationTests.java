package com.asignore.tos;

import com.asignore.tos.controller.FluxController;
import com.asignore.tos.service.FluxService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FluxApplicationTests {

    @Autowired
    private FluxController controller;

    @Autowired
    private FluxService service;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(controller);
        Assert.assertNotNull(service);
    }

}
