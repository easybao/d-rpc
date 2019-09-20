package cn.bdqfork.rpc.context.remote;

import cn.bdqfork.rpc.URL;

/**
 * @author bdq
 * @since 2019-08-21
 */
public interface RpcServerFactory {
    RpcServer getServer(URL url);
}