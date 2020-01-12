package main;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EnvironnementAgent extends Agent {
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
				}
			}
		});
	}
}
