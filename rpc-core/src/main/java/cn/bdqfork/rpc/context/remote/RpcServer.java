package cn.bdqfork.rpc.context.remote;

import cn.bdqfork.rpc.Invoker;
import cn.bdqfork.rpc.Node;

/**
 * @author bdq
 * @since 2019-08-21
 */
public interface RpcServer extends Node {
    void start();

    void addInvoker(Invoker<?> invoker);
}