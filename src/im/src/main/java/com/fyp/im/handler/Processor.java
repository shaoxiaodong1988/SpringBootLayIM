package com.fyp.im.handler;

import com.fyp.im.MsgType;
import com.fyp.im.processor.AbstractMsgProcessor;
import com.fyp.im.processor.ClientToClientProcessor;
import com.fyp.im.processor.ClientToGroupProcessor;
import org.springframework.context.NoSuchMessageException;
import org.tio.core.ChannelContext;

import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

public class Processor {
    /**
     * 消息处理入口
     */
    public static Object process(ChannelContext channelContext, byte[] body) {
        getProcessor(body).process(channelContext, body);
        return null;
    }

    private static AbstractMsgProcessor getProcessor(byte[] body) {
        MsgType type = MsgType.valueOf(body[4]);
        switch (type) {
            case clientToClient:
                return new ClientToClientProcessor();
            case clientToGroup:
                return new ClientToClientProcessor();
        }
        return null;
    }
}