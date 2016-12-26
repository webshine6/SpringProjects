package iteratordi;


public class Channel {

    // attributes
    private double frequency;

    private ChannelTypeEnum type;

    public Channel(double frequency, ChannelTypeEnum type) {
        this.frequency = frequency;
        this.type = type;
    }

    public double getFrequency() {
        return frequency;

    }

    public ChannelTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Frequency = " + frequency + ", type=" + type;
    }
}
