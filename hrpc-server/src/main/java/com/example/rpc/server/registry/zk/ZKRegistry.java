package com.example.rpc.server.registry.zk;

import com.example.rpc.annotation.HrpcService;
import com.example.rpc.server.registry.RpcRegistry;
import com.example.rpc.spring.SpringBeanFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class ZKRegistry implements RpcRegistry {

    @Autowired
    private ServerZKit zKit;

    @Override
    public void serviceRegistry() {
        // get annotation with HrpcService from container
        Map<String, Object> beanListByAnnotationClass = SpringBeanFactory.getBeanListByAnnotationClass(HrpcService.class);
        if (!beanListByAnnotationClass.isEmpty()) {
            log.info("bean list with HrpcService annotation in container: {}", beanListByAnnotationClass);
            zKit.createRootNode();
            //todo
        }
    }
}
