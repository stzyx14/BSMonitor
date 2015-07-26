package gmcc.bsmonitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class PushService {
	
	protected static final Logger LOG = LoggerFactory.getLogger(PushService.class);
	private static final String appKey ="79f517233998cc4c0b976909";
	private static final String masterSecret = "782083dc07c402e3203807f9";
	private JPushClient jpushClient;
	private PushPayload payload;
	
	public PushService(){
		 jpushClient = new JPushClient(masterSecret, appKey, 3);
		 
	}
	
	public void sendPushMsg(){
		try {
			payload = buildPushMsgForAll("hello everyone");
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}
	
	public PushPayload buildPushMsgForAll(String msg) {
	    return PushPayload.alertAll(msg);
	}
	
	public PushPayload buildWarningMsg(){
		return null;
	}
}
