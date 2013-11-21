package com.xross.tools.xstate.editor.io;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.w3c.dom.Document;

import com.xross.tools.xstate.editor.model.Event;
import com.xross.tools.xstate.editor.model.StateMachine;
import com.xross.tools.xstate.editor.model.StateMachineConstants;
import com.xross.tools.xstate.editor.model.StateMachineDiagram;
import com.xross.tools.xstate.editor.model.StateNode;
import com.xross.tools.xstate.editor.model.StateTransition;

public class StateMachineDiagramFactory implements StateMachineConstants{
	public static final String LOCATION = "location";
	public static final String X_COORDINATE = "x_coordinate";
	public static final String Y_COORDINATE = "x_coordinate";
	
	public static final String SIZE = "size";
	public static final String HEIGHT = "height";
	public static final String WIDTH = "width";
	
	public StateMachineDiagram getEmptyDiagram(){
		StateMachineDiagram smd = new StateMachineDiagram();
		smd.setName("StateMachineDiagram");	
		
		smd.getMachines().add(createStateMachine("state machine 1", 0));
		smd.getMachines().add(createStateMachine("state machine 2", 1));
		smd.getMachines().add(createStateMachine("state machine 3", 2));
		
		return smd;
	}
	
	private StateMachine createStateMachine(String name, int num){
		StateMachine sm = new StateMachine();
		sm.setName(name);
		
		StateNode a = new StateNode();
		a.setSize(new Dimension(100, 50));
		a.setLocation(new Point(0, 0));
		a.setName("start");
		sm.getNodes().add(a);

		for(int i = 0; i < num; i++)
		{
			StateNode b = new StateNode();
			b.setSize(new Dimension(100, 50));
			b.setLocation(new Point((i+1)* 200, 0));
			b.setName("state" + i);
			sm.getNodes().add(b);
			
			StateTransition t = new StateTransition(a, b);
			Event evt = new Event();
			evt.setName("event " + i);
			t.setEvent(evt);
			
			a = b;
		}		
		
		return sm;
	}
	
	private StateDiagramReader reader = new StateDiagramReader();
	private StateMachineDiagramWriter writer = new StateMachineDiagramWriter();
	public StateMachineDiagram getFromDocument(Document doc){
		return reader.getFromDocument(doc);
	}
	
	public Document writeToDocument(StateMachineDiagram model){
		return writer.writeToDocument(model);
	}
}