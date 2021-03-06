package cn.bdqfork.rpc;


import cn.bdqfork.common.Invoker;

/**
 * @author bdq
 * @since 2019-03-05
 */
public interface Exporter<T> {

    void undoExport();

    Invoker<T> getInvoker();
}
