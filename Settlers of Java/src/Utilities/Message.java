package Utilities;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * class exists to package objects for sending over the network and updating clients.
	 * messages consist of a string to identify the purpose of the message, and a generic
	 * array of objects to store any data, and can be cast on the receiving end to the correct
	 * types based on what the purpose of the message is.
	 */
	private static final long serialVersionUID = -1289824382707307089L;
	
	public String Type;
	public Object[] Objects;
	
	public Message(String type, Object ...objects  ){
		this.Type = type;
		this.Objects = objects;
	}
}
