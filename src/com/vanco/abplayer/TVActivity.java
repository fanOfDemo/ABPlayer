package com.vanco.abplayer;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;

import com.vanco.abplayer.fragment.OnlineFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TVActivity extends ActionBarActivity{
	private View backButton;
	private TextView titleText;
	private OnlineFragment online = new OnlineFragment();
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		 requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_video_info);
	        
	        if (savedInstanceState == null) {
	            getSupportFragmentManager().beginTransaction()
	                    .add(R.id.container, online)
	                    .commit();
	        }
	        backButton = findViewById(R.id.logobutton);
			titleText = (TextView) findViewById(R.id.textViewTitle);
			titleText.setText("网络电视");
			backButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					finish();
				}
			});
	              
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    @Override
	    public void onBackPressed() {
			if (online.onBackPressed())
				return;
			else
				super.onBackPressed();
	    }
}
