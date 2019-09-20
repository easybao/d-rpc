package cn.bdqfork.rpc.protocol.serializer;

import cn.bdqfork.rpc.context.remote.Serializer;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author bdq
 * @date 2019-03-01
 */
public class HessianSerializer implements Serializer {

    @Override
    public byte[] serialize(Object data) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
        hessianOutput.writeObject(data);
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(byteArrayInputStream);
        return (T) hessianInput.readObject(clazz);
    }
}
