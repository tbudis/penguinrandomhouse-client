package com.tbudis.penguinrandomhouse.consumer.model;

/**
 * POJO representing array of Work elements.
 *
 * @author titus
 * @since 2020-01-20
 */
public class Works {

    /** Array of Work, can be null or empty */
    private Work[] work;

    /** Default contructor. */
    public Works() {
    }

    /*
     * Standard getter and setter methods.
     */

    public Work[] getWork() {
        return work;
    }

    public void setWork(Work[] work) {
        this.work = work;
    }
}
