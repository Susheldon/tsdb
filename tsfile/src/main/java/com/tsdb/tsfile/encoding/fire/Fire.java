package com.tsdb.tsfile.encoding.fire;

/**
 * This class is used for Fast Integer REgression in Sprintz encoding method.Users can create a Fire
 * object and use it to train and predict the time-ordered integer-like data.
 */
public abstract class Fire<T extends Comparable<T>> {
    // Learning rate by binary shift
    protected int learnShift;
    // the bit width of the data to be predicted
    protected int bitWidth;
    // accumulate the regression loss
    protected int accumulator;
    // store the difference of predicted value and the real value temporarily
    protected T delta;

    public Fire(int learning_rate) {
        learnShift = learning_rate;
    }

    /**
     * predict the incoming integer using the last value
     *
     * @param value the last value
     * @return the predicted value
     */
    public abstract T predict(T value);

    /**
     * train the learning machine with the last prediction
     *
     * @param pre last value to be predicted
     * @param val current value to be predicted
     * @param err the predictive error of current value
     */
    public abstract void train(T pre, T val, T err);
}