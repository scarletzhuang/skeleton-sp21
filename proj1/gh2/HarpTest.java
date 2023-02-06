package gh2;

import edu.princeton.cs.introcs.StdAudio;

import org.junit.Test;

public class HarpTest {

    @Test
    public void testPluckTheAString() {
        Harp harpString = new Harp(GuitarHeroLite.CONCERT_A);
        harpString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(harpString.sample());
            harpString.tic();
        }
    }
}
