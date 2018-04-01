package org.dbms.ks.models;

public class Project extends BaseModel{

	private Project(String json) throws ValidationException{
		super(json);
		validate();
	}
	
	public static Project load(String json) throws ValidationException{
		return new Project(json);
	}
		
	@Override
	protected void validate() {
		
	}
	
	// GETTERS & SETTERS
	
}
