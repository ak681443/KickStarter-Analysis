package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.dbms.ks.util.DBUtil;
import org.dbms.ks.util.DBUtil.DBConnection;
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
	
	ArrayList<Backer> nearbyBackers = null;
	public List<Backer> getNearbyBackers() {
		if(nearbyBackers == null) {
			nearbyBackers = new ArrayList<>();
			DBConnection con = null;
			try {
				con = DBUtil.getConnection();
				con.prepareQuery("get.nearby.backers")
					.setQueryParam(1, getLocation().getLatitude())
					.setQueryParam(2, getLocation().getLatitude())
					.setQueryParam(3, getLocation().getLongitude())
					.setQueryParam(4, getLocation().getLatitude() - 3)
					.setQueryParam(5, getLocation().getLatitude() + 3)
					.setQueryParam(6, getLocation().getCountryCode())
					.setQueryParam(7, getUserID())
					.executeQuery();
				
				while(con.hasNext()) {
					nearbyBackers.add(con.getNext(Backer.class));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(con != null) con.safeClose();
			}
		}		
		return nearbyBackers;
	}
	
	ProfilePic profilePicture = null;
	public ProfilePic getProfilePicture() {
		if(profilePicture == null) {
			profilePicture = ProfilePic.fetch(getUserID());
		}
		return profilePicture;
	}
}
