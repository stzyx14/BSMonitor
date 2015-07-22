package gmcc.bsmonitor.activity;

import gmcc.bsmonitor.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏项目标题
   //     this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
   //     		WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        startSplashAvtivity(); 
    }
    private void startSplashAvtivity() { 
    	new Handler().postDelayed(new Runnable() { 
    	public void run() { 
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
			}
		}, 1000);
    }
}