package org.huifer.seata.product.controller;

import io.seata.core.context.RootContext;
import org.huifer.seata.product.entity.TestTx;
import org.huifer.seata.product.mapper.TestTxMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private TestTxMapper testTxMapper;
    @Autowired
    private DataSource dataSource;

    /**
     * 创建一条数据
     */
    @GetMapping("/ins")
    @Transactional
    public void ins() {
        TestTx testTx = new TestTx();
        testTx.setIntValue(1);

        testTxMapper.insert(testTx);

    }

    /**
     * 对id 为1的进行 +1 操作
     */
    @GetMapping("/test")
    @Transactional(rollbackFor = Exception.class)
    public void test() throws Exception {
        logger.info("分布式事务id = {}", RootContext.getXID());
        testTxMapper.addOne(1);
        throw new Exception("error ");
    }
}
