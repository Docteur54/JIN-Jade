package main;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by immoskyl on 07/01/20.
 */
public class Light extends Agent{
	
	/**Variables**/
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
    
    /**Constructeur**/
    public Light(Way way, Color color) {
        this.way = way;
        this.color = color;
        timeSinceLastColorChange = 0;
        vehicleNb = 0;
    }

    
    /**Fonctions d'accès aux variables**/
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
		System.out.println("Demarrage");
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				ACLMessage aclMessage = receive();
				if (aclMessage != null) {
					System.out.println("Reception");
					//sendDatas();
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

	
	
    /**
     * This function is the startpath where the light wants to change color or not
     */
    public void compute() {}

}
