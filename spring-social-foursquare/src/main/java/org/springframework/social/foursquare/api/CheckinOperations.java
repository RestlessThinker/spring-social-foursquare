package org.springframework.social.foursquare.api;

import java.util.List;

public interface CheckinOperations {
	
	/**
	 * Retrieve a detailed checkin
	 * @param checkinId	Checkin ID
	 * @return	Checkin
	 */
	Checkin get(String checkinId);
	
	/**
	 * Retrieve a detailed checkin
	 * @param checkinId	Checkin ID
	 * @param signature Signature for third party services such as Twitter
	 * @return	Checkin
	 */
	Checkin get(String checkinId, String signature);
	
	/**
	 * Checkin the authenticated user to a specified venue
	 * @param params	Checkin parameters
	 * @return	The newly created Checkin
	 */
	Checkin add(CheckinParams params);
	
	/**
	 * Returns a list of recent checkins from friends of the authenticated user.
	 * @param latitude	Latitude
	 * @param longitude	Longitude
	 * @param afterTimestamp	Seconds after which to retrieve checkins
	 * @param limit	Result set limit
	 * @return	A list of checkins
	 */
	List<Checkin> getRecent(Double latitude, Double longitude, Long afterTimestamp, Integer limit);
	
	/**
	 * Add a comment to the specified checkin
	 * @param checkinId	Checkin ID
	 * @param text	Comment text
	 * @return	The created comment
	 */
	CheckinComment addComment(String checkinId, String text);
	
	/**
	 * Remove a comment on a checkin made by the authenticated user
	 * @param checkinId	Checkin ID
	 * @param commentId	Comment ID
	 * @return	The checkin object minus the specified comment
	 */
	Checkin deleteComment(String checkinId, String commentId);
	
	/**
	 * This endpoint is part of the Apps Platform. Reply to a user about a check-in. 
	 * This reply will only be visible to the owner of the check-in. 
	 * An application may only reply once per check-in.
	 * @param checkinId
	 * @param text
	 * @param url		Link for more details. This page will be opened in an embedded 
	 * web view in the foursquare application, unless contentId is specified and a native 
	 * link handler is registered and present. We support the following URL 
	 * schemes: http, https, foursquare, mailto, tel, and sms.
	 * @param contentId	Identifier for the reply to be used in a native link, up to 
	 * 50 characters. A url must also be specified in the request.
	 * @return
	 */
	String reply(String checkinId, String text, String url, String contentId);
	
	public static final String CHECKINS_ENDPOINT = "checkins/";
}
