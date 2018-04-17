package org.dbms.ks.models;
import static org.dbms.ks.models.ColumnConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.dbms.ks.util.DBUtil;
import org.dbms.ks.util.DBUtil.DBConnection;
import org.json.JSONObject;

public class Owner extends BaseModel{
	
	private Owner(JSONObject json) throws ValidationException {
		super(json);
	}
	
	@Override
	protected void validate() throws ValidationException {
		
	}
	
	public static Owner load(JSONObject json) throws ValidationException{
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
	
	Location location = null;
	public Location getLocation() {
		if(location == null){
			location = DBUtil.getFirst("get.location", Location.class, get(OWNER_LOCATION_ID));
		}
		return location;
	}
	
	ArrayList<Owner> nearbyOwners = null;
	public List<Owner> getNearbyOwners() {
		if(nearbyOwners == null) {
			nearbyOwners = new ArrayList<>();
			DBConnection con = null;
			try {
				con = DBUtil.getConnection();
				con.prepareQuery("get.nearby.owners")
					.setQueryParam(1, getLocation().getLatitude())
					.setQueryParam(2, getLocation().getLatitude())
					.setQueryParam(3, getLocation().getLongitude())
					.setQueryParam(4, getLocation().getLatitude() - 3)
					.setQueryParam(5, getLocation().getLatitude() + 3)
					.setQueryParam(6, getLocation().getCountryCode())
					.setQueryParam(7, getUserID())
					.executeQuery();
				
				while(con.hasNext()) {
					nearbyOwners.add(con.getNext(Owner.class));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(con != null) con.safeClose();
			}
		}		
		return nearbyOwners;
	}
	
}
