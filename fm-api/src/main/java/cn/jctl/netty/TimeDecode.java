package cn.jctl.netty;

import cn.jctl.netty.util.TimeDecodeUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by majiangtao on 2018/5/10.
 */
@Component
@Qualifier("timeDecode")
public class TimeDecode extends ByteToMessageDecoder {
    private static final Logger log = LoggerFactory.getLogger(TimeDecode.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        String requestMsg = ByteBufUtil.hexDump(in).toUpperCase().replace(" ","");
        log.info("requestMsg-length:"+requestMsg.length());
        if (requestMsg.indexOf("bye") != -1) {
            log.info("requestMsg is null,channel close!");
            ctx.channel().close();
            return;
        }
        log.info("Client-->Server---msg:"+requestMsg);
        System.out.println("Client-->Server---msg:"+requestMsg);
        in.clear();
        String clientIdToLong = ctx.channel().id().asLongText();
        log.info("client long id:" + clientIdToLong);
        String clientIdToShort = ctx.channel().id().asShortText();
        log.info("client short id:" + clientIdToShort);
        if (!requestMsg.equals("44540D0A")) {
            out.add(requestMsg);
        }


    }
}
