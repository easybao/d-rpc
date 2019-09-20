package cn.bdqfork.rpc.protocol.netty;

import cn.bdqfork.common.constant.Const;
import cn.bdqfork.rpc.context.remote.Request;
import cn.bdqfork.rpc.context.remote.Response;
import cn.bdqfork.rpc.context.remote.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author bdq
 * @since 2019-02-21
 */
public class DataEncoder extends MessageToByteEncoder<Object> {
    private Serializer serializer;

    public DataEncoder(Serializer serializer) {
        this.serializer = serializer;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        //magic
        out.writeByte(Const.MAGIC);
        if (msg instanceof Request) {
            //flage
            out.writeByte(Const.REQUEST_FLAGE);
            Request request = (Request) msg;
            //id
            out.writeLong(request.getId());
            //status
            out.writeInt(Response.OK);

            byte[] data = serializer.serialize(request.getData());
            //length
            out.writeInt(data.length);
            //body
            out.writeBytes(data);
        } else if (msg instanceof Response) {
            //flage
            out.writeByte(Const.RESPOSE_FLAGE);
            Response response = (Response) msg;
            //id
            out.writeLong(response.getId());
            //status
            out.writeInt(response.getStatus());

            byte[] data = serializer.serialize(response.getData());
            //length
            out.writeInt(data.length);
            //body
            out.writeBytes(data);
        }
    }
}
