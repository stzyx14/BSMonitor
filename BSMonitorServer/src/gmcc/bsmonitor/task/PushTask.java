package gmcc.bsmonitor.task;

import gmcc.bsmonitor.service.PushService;

import java.util.TimerTask;

public class PushTask extends TimerTask{

	private PushService pushService;
	
	public PushTask(){
		pushService = new PushService();
	}
	
	@Override
	public void run() {
		executeTask();
	}

	public void executeTask(){
		pushService.sendPushMsg();
	}
}
