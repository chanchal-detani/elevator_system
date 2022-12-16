package com.wildlife.conservation.app.engine;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.wildlife.conservation.app.entity.Request;

import lombok.ToString;

@ToString
public class CustomQueue<Request> extends PriorityQueue<Request> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomQueue(Comparator<? super Request> comparator) {
        super(comparator);
    }

	@Override
	public boolean offer(Request request) {
		boolean isAdded = false;
        if(!super.contains(request))
        {
            isAdded = super.offer(request);
        }
        return isAdded;
	}
}
