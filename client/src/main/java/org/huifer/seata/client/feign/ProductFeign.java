package org.huifer.seata.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo-product")
public interface ProductFeign {
    @GetMapping("test")
    void test();
}
