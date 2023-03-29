package com.example.rpc.server.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcServerBootstrap {

    @Autowired
    private RpcServerRunner rpcServerRunner;

    public void init() {
        // guide hrpc-server startup
        rpcServerRunner.run();
    }
}
