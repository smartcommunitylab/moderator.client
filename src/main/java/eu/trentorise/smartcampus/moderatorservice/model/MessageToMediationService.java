package eu.trentorise.smartcampus.moderatorservice.model;

import java.io.Serializable;

public class MessageToMediationService implements Serializable {
	
	
	private String _id;
	private boolean parseApproved;
	private Stato mediationApproved;
	public Stato getMediationApproved() {
		return mediationApproved;
	}

	public void setMediationApproved(Stato mediationApproved) {
		this.mediationApproved = mediationApproved;
	}

	private long timestamp;
	private String webappname;
	private int entityId;
	private String entityTesto;
	private String note;
	private String userid;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageToMediationService(String webappname, int entityId,
			String entityTesto, String userid) {
		this.setWebappname(webappname);
		this.timestamp = System.currentTimeMillis();
		this.mediationApproved = Stato.WAITING;
		this.parseApproved = true;
		this.setEntityId(entityId);
		this.setEntityTesto(entityTesto);
		this.setUserid(userid);
	}

	public boolean isParseApproved() {
		return parseApproved;
	}

	public void setParseApproved(boolean parseApproved) {
		this.parseApproved = parseApproved;
	}

	public String getWebappname() {
		return webappname;
	}

	public void setWebappname(String webappname) {
		this.webappname = webappname;
	}

	

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityTesto() {
		return entityTesto;
	}

	public void setEntityTesto(String entityTesto) {
		this.entityTesto = entityTesto;
	}

	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}