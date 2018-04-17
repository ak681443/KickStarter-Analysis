package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;

import org.dbms.ks.util.DBUtil;
import org.json.JSONObject;

public class Backer extends BaseModel{
	
	private Backer(JSONObject json) throws ValidationException {
		super(json);
	}
	
	@Override
	protected void validate() throws ValidationException {
		
	}
	
	public static Backer load(JSONObject json) throws ValidationException{
		return new Backer(json);
	}
	
	public static Backer fetch(int ownerId) {
		return DBUtil.getFirst("get.backer", Backer.class, ownerId);
	}

	
	// GETTERS AND SETTERS
	
	public int getUserID() {
		return get(OWNER_UID, -1);
	}

	public String getName() {
		return get(OWNER_USER_NAME);
	}
	
	public int getNumberOfBackings() {
		return get(OWNER_OID, -1);
	}
	
	Location location = null;
	public Location getLocation() {
		if(location == null){
			location = DBUtil.getFirst("get.location", Location.class, get(OWNER_LOCATION_ID));
		}
		return location;
	}
	
}
