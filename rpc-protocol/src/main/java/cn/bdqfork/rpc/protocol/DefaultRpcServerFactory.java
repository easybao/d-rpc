package cn.bdqfork.rpc.protocol;

import cn.bdqfork.rpc.Invoker;
import cn.bdqfork.rpc.config.ProtocolConfig;
import cn.bdqfork.rpc.protocol.netty.provider.NettyRpcServer;
import cn.bdqfork.rpc.remote.RpcServer;
import cn.bdqfork.rpc.remote.RpcServerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author bdq
 * @since 2019-08-21
 */
public class DefaultRpcServerFactory implements RpcServerFactory {

    @Override
    public RpcServer createProviderServer(ProtocolConfig protocolConfig, List<Invoker<?>> invokers) {
        if ("netty".equals(protocolConfig.getServer())) {
            return new NettyRpcServer(protocolConfig, invokers);
        }
        return null;
    }
}