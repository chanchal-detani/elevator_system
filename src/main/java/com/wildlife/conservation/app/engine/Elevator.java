package com.wildlife.conservation.app.engine;

import java.util.PriorityQueue;

import com.wildlife.conservation.app.entity.Request;
import com.wildlife.conservation.app.enums.ElevatorDirection;
import com.wildlife.conservation.app.enums.Source;

import lombok.Data;

@Data
public class Elevator {

	int currentFloor = 0;
    ElevatorDirection direction = ElevatorDirection.IDLE;
    CustomQueue<Request> upQueue = new CustomQueue<>((a, b) -> a.getDestination() - b.getDestination());
    CustomQueue<Request> downQueue = new CustomQueue<>((a, b) -> b.getDestination() - a.getDestination());
    private static Elevator elevator = null;
    private Thread requestProcessorThread;

    public static Elevator getInstance() {
        if (elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }
    
    public void setupRequest(Request request) {
    	PriorityQueue<Request> queue = request.getDirection().equals(ElevatorDirection.UP) ? upQueue : downQueue;
        if (Source.OUTSIDE == request.getSource()) {
            // Go pick up the requester who is outside of the elevator
        	queue.offer(new Request(request.getCurrent(),
                request.getCurrent(),
                Source.OUTSIDE,
                request.getDirection()));
        }
        queue.offer(request);
    }
    
    public void setCurrentFloor(int currentFloor) throws InterruptedException {
        if (this.currentFloor > currentFloor) {
            setDirection(ElevatorDirection.DOWN);
        } else {
            setDirection(ElevatorDirection.UP);
        }
        this.currentFloor = currentFloor;
        Thread.sleep(3000);
    }
    
    
    /**
     * This method is to serve the request when the elevator is in mobility
     * 
     * @param request
     */
    public synchronized void add(Request request) {
        if(requestProcessorThread.getState() == Thread.State.WAITING){
            // Notify processor thread that a new request has come if it is waiting
        	setupRequest(request);
            notify();
        }else{
            // Interrupt Processor thread to check if new request should be processed before current request or not. 
            requestProcessorThread.interrupt();
            setupRequest(request);
        }
    }
}
