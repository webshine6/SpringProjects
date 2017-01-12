package iteratordi.test;

import iteratordi.Channel;
import iteratordi.ChannelCollection;
import iteratordi.ChannelIterator;
import iteratordi.ChannelTypeEnum;
import iteratordi.implement.ChannelCollectionImpl;

public class IteratorPatternTest {

    public static void main(String[] args) {

        ChannelCollection channels = populateChannels();
        ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);

        while (baseIterator.hasNext()) {
            Channel channel = baseIterator.next();
            System.out.println(channel);
        }

        System.out.println("----------- HINDI channel type iterator -----------");
        ChannelIterator hindiIterator = channels.iterator(ChannelTypeEnum.ENGLISH);
        while (hindiIterator.hasNext()) {
            Channel hindiChannel = hindiIterator.next();
            System.out.println(hindiChannel);
        }

        System.out.println("----------- FRENCH channel type iterator -----------");
        ChannelIterator frenchIterator = channels.iterator(ChannelTypeEnum.FRENCH);
        while (frenchIterator.hasNext()) {
            Channel frenchChannel = frenchIterator.next();
            System.out.println(frenchChannel);
        }


    }


    private static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();

        channels.addChannel(new Channel(98, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.88, ChannelTypeEnum.HIDNI));
        channels.addChannel(new Channel(99.54, ChannelTypeEnum.ALL));
        channels.addChannel(new Channel(104.55, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(74.55, ChannelTypeEnum.HIDNI));
        channels.addChannel(new Channel(89.65, ChannelTypeEnum.FRENCH));
        return channels;

    }

}
