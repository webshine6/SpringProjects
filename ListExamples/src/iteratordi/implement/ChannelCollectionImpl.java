package iteratordi.implement;

import iteratordi.Channel;
import iteratordi.ChannelCollection;
import iteratordi.ChannelIterator;
import iteratordi.ChannelTypeEnum;

import java.util.ArrayList;

public class ChannelCollectionImpl implements ChannelCollection {

    private ArrayList<Channel> channelsList;

    public ChannelCollectionImpl() {
        channelsList = new ArrayList<Channel>();
    }

    public void addChannel(Channel c) {
        this.channelsList.add(c);
    }

    @Override
    public void removeChannel(Channel c) {
        this.channelsList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, this.channelsList);
    }
}
