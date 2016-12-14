package Utilities;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1289824382707307089L;
	
	public String Type;
	public Object[] Objects;
	
	public Message(String type, Object ...objects  ){
		this.Type = type;
		this.Objects = objects;
	}
}
