package main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import main.Light.Color;
import main.Light.Way;

public class TrafficLightAgent extends Agent {
	
    private Way way;
    private int vehicleNb;
    private int timeSinceLastColorChange;
    private Color color;
	
    
    public static enum Color {
        GREEN,
        RED
    }

    public static enum Way {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }
    
    //Constructeur (Not jade friendly)
/*    public TrafficLightAgent(Way way, Color color) {
        this.way = way;
        this.color = color;
        timeSinceLastColorChange = 0;
        vehicleNb = 0;
    }
*/
    
    //Fonctions d'accès aux variables
    public int getVehicleNb() {
        return vehicleNb;
    }

    public void setVehicleNb(int vehicleNb) {
        this.vehicleNb = vehicleNb;
    }

    public int getTimeSinceLastColorChange() {
        return timeSinceLastColorChange;
    }

    public void setTimeSinceLastColorChange(int timeSinceLastColorChange) {
        this.timeSinceLastColorChange = timeSinceLastColorChange;
    }

    public Color getColor() {
        return color;
    }

    public void switchColor() {
        color = color == Color.RED ? Color.GREEN : Color.RED;
    }

    public Way getWay() {
        return way;
    }
    
    
    /**Jade**/
    @Override
	protected void setup() {
		System.out.println("demarrage de " + getAID().getName());
		
		addBehaviour(new TickerBehaviour(this,1000) {
			
			@Override
			//Loop function
			protected void onTick() {
				
				//Partie du code lorsque l'agent est le feu au Nord
				if (getAID().getName().startsWith("trafficLightN")) {
					
					ACLMessage aclMessage = receive();
					
					trafficLightN(aclMessage);
				}
				
				//Partie du code lorsque l'agent est le feu au Sud
				if (getAID().getName().startsWith("trafficLightS")) {
					
					ACLMessage aclMessage = receive();
					
					trafficLightS(aclMessage);
				}
				
				//Partie du code lorsque l'agent est le feu à l'Est
				if (getAID().getName().startsWith("trafficLightE")) {
					
					ACLMessage aclMessage = receive();
					
					trafficLightE(aclMessage);
				}
				
				//Partie du code lorsque l'agent est le feu à l'Ouest
				if (getAID().getName().startsWith("trafficLightW")) {
					
					ACLMessage aclMessage = receive();
					
					trafficLightW(aclMessage);
				}
			}
		});
	}
	
    
    protected void askVehicleNb(String receiver) {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
		aclMessage.addReceiver(new AID(receiver,AID.ISLOCALNAME));
		aclMessage.setOntology("askVehicleNb");
		send(aclMessage);
    }
    
    protected void doChange(String receiver) {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.addReceiver(new AID(receiver,AID.ISLOCALNAME));
		aclMessage.setOntology("doChange");
		send(aclMessage);
    }
    
	protected void sendVehicleNb(String receiver) {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
		aclMessage.addReceiver(new AID(receiver,AID.ISLOCALNAME));
		aclMessage.addUserDefinedParameter("vehicleNb", Integer.toString(vehicleNb));
		aclMessage.setOntology("vehicleNb");
		send(aclMessage);
	}
	
	protected void requestChange(String receiver) {
		ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
		aclMessage.addReceiver(new AID(receiver,AID.ISLOCALNAME));
		aclMessage.setOntology("requestChange");
		send(aclMessage);		
	}
	
	/**
	 * TODO What North Light do
	 */
	protected void trafficLightN(ACLMessage messageReceived) {
		
		if (messageReceived != null) {
			if (messageReceived.getSender().getName().startsWith("trafficLightS")){
				System.out.println("ReceptionMessageFromLightS");
			}
				
			if (messageReceived.getSender().getName().startsWith("trafficLightE")) {
				System.out.println("ReceptionMessageFromLightE");
			}
		}
	}
	
	/**
	 * TODO What South Light do
	 */
	protected void trafficLightS(ACLMessage messageReceived) {

		if (messageReceived != null) {

		}		
	}
	
	/**
	 * TODO What East Light do
	 */
	protected void trafficLightE(ACLMessage messageReceived) {
		
		if (messageReceived != null) {
			
			if (messageReceived.getSender().getName().startsWith("trafficLightN"))
				System.out.println("ReceptionMessageFromLightN");
			
			if (messageReceived.getSender().getName().startsWith("trafficLightW"))
				System.out.println("ReceptionMessageFromLightW");
		}
	}
	
	/**
	 * TODO What West Light do
	 */
	protected void trafficLightW(ACLMessage messageReceived) {
		if (messageReceived != null) {
			
		}
	}
	
	
    /**
     * This function is the startpath where the light wants to change color or not
     */
    public void compute() {}
}

