package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;

import org.dbms.ks.util.DBUtil;

public class Owner extends BaseModel{
	
	public Owner(String json) throws ValidationException {
		super(json);
	}
	
	@Override
	protected void validate() throws ValidationException {
		
	}
	
	public static Owner load(String json) throws ValidationException{
		return new Owner(json);
	}
	
	public static Owner fetch(int ownerId) {
		return DBUtil.getFirst("get.owner", Owner.class, ownerId);
	}

	
	// GETTERS AND SETTERS
	
	public int getUserID() {
		return get(OWNER_UID, -1);
	}

	public int getOwnerID() {
		return get(OWNER_OID, -1);
	}

	public String getName() {
		return get(OWNER_USER_NAME);
	}
	
}
