package org.huifer.seata.client.controller;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.huifer.seata.client.feign.ProductFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class ClientController {
    private final static Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ProductFeign productFeign;


    @GetMapping("/client")
    @GlobalTransactional(rollbackFor = Exception.class)
    public void client() {
        logger.info("分布式事务id = {}", RootContext.getXID());

        productFeign.test();


    }
}
