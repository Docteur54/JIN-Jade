package main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class SecondTrafficLightAgent extends Agent {
	
	@Override
	protected void setup() {
		System.out.println("Demarrage");
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				ACLMessage aclMessage = receive();
				if (aclMessage != null) {
					System.out.println("Reception");
		//			sendDatas();
				}
			}
		});
	}
	
	protected void sendDatas() {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.addReceiver(new AID("trafficLightN",AID.ISLOCALNAME));
		aclMessage.addReceiver(new AID("trafficLightS",AID.ISLOCALNAME));
		send(aclMessage);
	}
	
	
	
}

