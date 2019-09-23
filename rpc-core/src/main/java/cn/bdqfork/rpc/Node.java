package cn.bdqfork.rpc;

import cn.bdqfork.common.URL;

/**
 * @author bdq
 * @since 2019-09-02
 */
public interface Node {

    URL getUrl();

    boolean isAvailable();

    /**
     * destroy.
     */
    void destroy();
}
