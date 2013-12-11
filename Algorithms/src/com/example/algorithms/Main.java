package com.example.algorithms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
	Button bBubble, bExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bBubble = (Button) findViewById(R.id.bBubble);
		bExit = (Button) findViewById(R.id.bExit);
		bExit.setOnClickListener(this);
		bBubble.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bBubble:
			Intent intent1 = new Intent(Main.this, BubbleSort.class);
			startActivity(intent1);
			break;
		case R.id.bExit:
			finish();
			break;
		}

	}

}