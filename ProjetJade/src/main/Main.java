package main;

public class Main {
	public static void main(String[] args) {
		
		MainContainer MC = new MainContainer();
    	MC.startMainContainer();
    	
    	TrafficLightContainer TLC = new TrafficLightContainer();
    	TLC.startContainer();
    	
        //Manager manager = new Manager();
        //manager.gameLoop();
	}
}
