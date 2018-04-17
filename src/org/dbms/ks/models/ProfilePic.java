package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;

import org.dbms.ks.util.DBUtil;
import org.json.JSONObject;

public class ProfilePic extends BaseModel{
	
	private ProfilePic(JSONObject json) throws ValidationException {
		super(json);
	}
	
	@Override
	protected void validate() throws ValidationException {
		
	}
	
	public static ProfilePic load(JSONObject json) throws ValidationException{
		return new ProfilePic(json);
	}
	
	public static ProfilePic fetch(int ownerId) {
		return DBUtil.getFirst("get.profilepic", ProfilePic.class, ownerId);
	}

	
	// GETTERS AND SETTERS
	
	public int getUserID() {
		return get(PROFILE_PIC_UID, -1);
	}

	public String getPhotoURL() {
		return get(PROFILE_PIC_URL);
	}
}
