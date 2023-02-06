package gh2;

import deque.Deque;
import deque.LinkedListDeque;
import edu.princeton.cs.algs4.StdRandom;

public class Harp {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .990; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    public Harp(double frequency) {
        this.buffer = new LinkedListDeque<>();
        int capacity = (int) Math.round(SR / frequency) * 2;
        for (int i = 0; i < capacity; i++) {
            this.buffer.addLast(0d);
        }
    }

    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }
    }

    public void tic() {
        double first = buffer.removeFirst();
        double next = buffer.get(0);
        buffer.addLast((first + next) * 0.5 * DECAY);
    }

    public double sample() {
        return buffer.get(0);
    }
}
