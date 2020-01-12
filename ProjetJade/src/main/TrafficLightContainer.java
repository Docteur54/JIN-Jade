package main;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import main.Manager;


public class TrafficLightContainer {
	
	AgentController agentControllerN;
	AgentController agentControllerS;
	AgentController agentControllerE;
	AgentController agentControllerW;
	AgentController environnementAgent;
	
	public void startContainer() {
		try {
			Runtime runtime = Runtime.instance();
			ProfileImpl profileImpl = new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
			
			AgentController agentControllerN=agentContainer.createNewAgent
					("trafficLightN", TrafficLightAgent.class.getName(), new Object[] {});
			agentControllerN.start();
			
			AgentController agentControllerS=agentContainer.createNewAgent
					("trafficLightS", TrafficLightAgent.class.getName(), new Object[] {});
			agentControllerS.start();
			
			AgentController agentControllerE=agentContainer.createNewAgent
					("trafficLightE", TrafficLightAgent.class.getName(), new Object[] {});
			agentControllerE.start();
			
			AgentController agentControllerW=agentContainer.createNewAgent
					("trafficLightW", TrafficLightAgent.class.getName(), new Object[] {});
			agentControllerW.start();
			
			AgentController environnementAgent=agentContainer.createNewAgent
					("environnementAgent", Manager.class.getName(), new Object[] {});
			 environnementAgent.start();
		
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}    
}
	
	
