package com.wildlife.conservation.app;

import com.wildlife.conservation.app.engine.Elevator;
import com.wildlife.conservation.app.engine.Processor;
import com.wildlife.conservation.app.entity.Request;
import com.wildlife.conservation.app.enums.ElevatorDirection;
import com.wildlife.conservation.app.enums.Source;

public class ElevatorSystem {

	public static void main(String[] args) throws InterruptedException {
		Elevator elevator = Elevator.getInstance();

        Request upRequest1 = new Request(elevator.getCurrentFloor(), 2, Source.INSIDE, ElevatorDirection.UP);
        Request upRequest2 = new Request(elevator.getCurrentFloor(), 4, Source.INSIDE, ElevatorDirection.UP);

        Request downRequest1 = new Request(elevator.getCurrentFloor(), 3, Source.INSIDE, ElevatorDirection.DOWN);
        Request downRequest2 = new Request(elevator.getCurrentFloor(), 1, Source.INSIDE, ElevatorDirection.DOWN);

        // Two requests from inside of the elevator to go up to floor 2 and 4.
        elevator.setupRequest(upRequest1);
        elevator.setupRequest(upRequest2);


        // Two requests from inside of the elevator to go down to floor 3 and 1.
        elevator.setupRequest(downRequest1);
        elevator.setupRequest(downRequest2);

        Thread requestProcessorThread = new Thread(new Processor(), "RequestProcessorThread");
        elevator.setRequestProcessorThread(requestProcessorThread);        
        requestProcessorThread.start();
        
        Thread.sleep(7000);
        
        // this is important case where the elevator is in mobility and someone pressed something either from inside or from outside
        elevator.add(new Request(5, 1, Source.OUTSIDE, ElevatorDirection.DOWN));
	}
}
