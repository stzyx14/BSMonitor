package gmcc.bsmonitor.activity;

import gmcc.bsmonitor.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class LoginActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    			super.onCreate(savedInstanceState);
    			requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏项目标题
    	//		 this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    	//	        		WindowManager.LayoutParams.FLAG_FULLSCREEN);
    			this.setContentView(R.layout.login);
    }
}