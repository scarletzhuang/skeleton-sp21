package gh2;

import deque.ArrayDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {

    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        ArrayDeque<GuitarString> guitarStrings = new ArrayDeque<>();
        for (int i = 0; i < keyboard.length(); i++) {
            guitarStrings.addLast(new GuitarString(440.0 * Math.pow(2, (i - 24) / 12.0)));
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index == -1) {
                    continue;
                } else {
                    guitarStrings.get(index).pluck();
                }
            }

            double sample = 0;
            for (GuitarString gs : guitarStrings) {
                sample = sample + gs.sample();
            }

            StdAudio.play(sample);

            for (GuitarString gs : guitarStrings) {
                gs.tic();
            }
        }
    }
}
