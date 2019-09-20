package cn.bdqfork.rpc;

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
