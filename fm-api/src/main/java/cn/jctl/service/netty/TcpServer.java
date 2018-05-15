package cn.jctl.service.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by majiangtao on 2018/3/29.
 */
//@Component
public class TcpServer {
    private static final Logger log = LoggerFactory.getLogger(TcpServer.class);
    private static TcpServer tcpServer; //声明tcpserver单例对象
    private static ServerBootstrap server;
    private static EventLoopGroup boss;
    private static EventLoopGroup worker;
    private static ChannelFuture channelFuture;

    private TcpServer(){
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();
            server = new ServerBootstrap();
            server.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new TcpServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 1024) //允许最大连接数
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
    }

    public static TcpServer getInstance(){
        if (tcpServer == null){
            tcpServer = new TcpServer();
        }
        return tcpServer;
    }

    //启动server
//    @PostConstruct
    public boolean start() {
        try {
            channelFuture = server.bind(41568).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("tcp端口被占用");
        }
        return  channelFuture.isSuccess();
    }

    //关闭server
    public void close(){
        channelFuture.channel().close();
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
