package optional.domain;

import java.io.Serializable;
import java.util.Comparator;



import domain.Transmitter;

public class TransmitterDifficultyComparator implements Comparator<Transmitter>, Serializable {

    private static final Comparator<Transmitter> COMPARATOR = Comparator.comparingInt(Transmitter::getRequiredNumberOfFrequency)
            .thenComparingLong(Transmitter::getId);

    @Override
    public int compare(Transmitter a, Transmitter b) {
        return COMPARATOR.compare(a, b);
    }

}
