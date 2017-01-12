package iteratordi.implement;

import iteratordi.Channel;
import iteratordi.ChannelIterator;
import iteratordi.ChannelTypeEnum;

import java.util.ArrayList;

public class ChannelIteratorImpl implements ChannelIterator {

    private ChannelTypeEnum type;

    private ArrayList<Channel> channels;

    private int position;

    public ChannelIteratorImpl(ChannelTypeEnum type, ArrayList<Channel> channels) {
        this.type = type;
        this.channels = channels;
    }

    @Override
    public boolean hasNext() {

        while (position < channels.size()) {
            Channel channel = channels.get(position);

            if (channel.getType().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
                return true;
            }
            next();
        }

        return false;
    }

    @Override
    public Channel next() {
        Channel channel = channels.get(position);
        position++;

        return channel;

    }
}
