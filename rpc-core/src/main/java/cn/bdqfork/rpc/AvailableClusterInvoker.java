package cn.bdqfork.rpc;

import cn.bdqfork.common.exception.RpcException;
import cn.bdqfork.rpc.remote.RpcResponse;

import java.util.List;

/**
 * @author bdq
 * @since 2019-08-28
 */
public class AvailableClusterInvoker<T> extends AbstractClusterInvoker<T> {
    public AvailableClusterInvoker(Directory<T> directory) {
        super(directory);
    }

    @Override
    protected RpcResponse doInvoke(Invocation invocation, List<Invoker<T>> invokers, LoadBalance loadBalance) throws RpcException {
        for (Invoker<T> invoker : invokers) {
            if (invoker.isAvailable()) {
                return invoker.invoke(invocation);
            }
        }
        throw new RpcException("No provider available in " + invokers);
    }


}
