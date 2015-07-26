package gmcc.bsmonitor.servlet;

import gmcc.bsmonitor.task.PushTask;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PushContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		Timer timer = new Timer(true);
		PushTask pushTask = new PushTask();
		timer.schedule(pushTask, 0, 20000);
	}

}
