package com.wildlife.conservation.app.engine;

import java.util.PriorityQueue;

import com.wildlife.conservation.app.entity.Request;
import com.wildlife.conservation.app.enums.ElevatorDirection;

public class Processor implements Runnable {

	@Override
	public void run() {
		Elevator elevator = Elevator.getInstance();
		while(true) {
			try {
				PriorityQueue<Request> upQueue = elevator.getUpQueue();
				PriorityQueue<Request> downQueue = elevator.getDownQueue();
				while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
					process(elevator);
				}
			} catch(InterruptedException e){
				// Need to check following things 
				// 1. if the current request is already processed or else we need to serve the request
				// 2. if it is in the queue then ignore or else put it in the queue
				System.out.println("Interrupted");
			}
		}
	}

	private void process(Elevator elevator) throws InterruptedException {
        if (elevator.getDirection() == ElevatorDirection.UP || elevator.getDirection() == ElevatorDirection.IDLE) {
        	processRequest(elevator, ElevatorDirection.UP);
        	processRequest(elevator, ElevatorDirection.DOWN);
        } else {
        	processRequest(elevator, ElevatorDirection.DOWN);
        	processRequest(elevator, ElevatorDirection.UP);
        }
    }
    private void processRequest(Elevator elevator, ElevatorDirection direction) throws InterruptedException {
    	
    	PriorityQueue<Request> servingQueue = direction.equals(ElevatorDirection.UP) ? elevator.getUpQueue() : elevator.getDownQueue();
    	PriorityQueue<Request> otherQueue = direction.equals(ElevatorDirection.UP) ? elevator.getDownQueue() : elevator.getUpQueue();
    	ElevatorDirection otherDirection = direction.equals(ElevatorDirection.UP) ? ElevatorDirection.DOWN : ElevatorDirection.UP;
    	
        while (!servingQueue.isEmpty()) {
            Request upRequest = servingQueue.poll();
            System.out.println("Source floor: "+elevator.getCurrentFloor()+", Destination: "+upRequest.getDestination());
            // here actually we need to communicate with hardware either by RMI or by using Rest Invocation
            elevator.setCurrentFloor(upRequest.getDestination());
            System.out.println("Processing requests. Elevator stopped at floor " + elevator.getCurrentFloor() + ".");
        }
        if (!otherQueue.isEmpty()) {
        	elevator.setDirection(otherDirection);
        } else {
            elevator.setDirection(ElevatorDirection.IDLE);
        }
    }
}
