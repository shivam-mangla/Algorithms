package com.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

public class BubbleSort extends Activity implements OnClickListener {
	ImageButton iBubbleBack, iBubble;
	GridView gvBubbleSort;
	TextView tvBubble;
	Integer[] a = { 54, 31, 92, 11, 62, 36, 29, 43 };
	int len = a.length;
	MyAdapter adapter = new MyAdapter(this);
	final Handler handler = new Handler();
	final Handler handler1 = new Handler();
	final long delay = 2000;
	int j = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bubblesort);
		tvBubble = (TextView) findViewById(R.id.tvBubble);
		iBubble = (ImageButton) findViewById(R.id.iBubble);
		iBubbleBack = (ImageButton) findViewById(R.id.iBubbleBack);
		iBubble.setOnClickListener(this);
		iBubbleBack.setOnClickListener(this);
		gvBubbleSort = (GridView) findViewById(R.id.gvBubble);
		adapter.setAdapterContent(new ArrayList<Integer>(Arrays.asList(a)));
		gvBubbleSort.setAdapter(adapter);
		writealgo();

	}

	private void writealgo() {
		// TODO Auto-generated method stub
		String newline = Html.fromHtml("<br/>").toString();
		String tab = "     ";
		String algo = "for(i=0;i<n;i++) {" + newline + tab
				+ "for(j=0;j<n;j++) {" + newline + tab + tab
				+ "if(a[j]>a[j+1]) {" + newline + tab + tab + tab
				+ "swap(a[j],a[j+1])" + newline + tab + tab + "}" + newline
				+ tab + "}" + newline + "}";
		tvBubble.setText(algo);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iBubble:
			startBubbleSort(0);
			break;
		case R.id.iBubbleBack:
			finish();
		}
	}

	private void startBubbleSort(final int start) {
		// TODO Auto-generated method stub

		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i;
				i = start;
				sort(i);
				i++;
				if (i < len - 2) {
					startBubbleSort(i);
				}
			}

			private void sort(final int i) {
				// TODO Auto-generated method stub

				handler1.postDelayed(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub

						// compares the adjacent elements
						if (gvBubbleSort.getChildAt(j + 1) != null) {
							gvBubbleSort.getChildAt(j).setBackgroundColor(
									getResources().getColor(R.color.red));
							gvBubbleSort.getChildAt(j + 1).setBackgroundColor(
									getResources().getColor(R.color.green));
						}

						if (a[j] > a[j + 1]) {

							// swapping
							int temp = a[j];
							a[j] = a[j + 1];
							a[j + 1] = temp;

							adapter.setAdapterContent(new ArrayList<Integer>(
									Arrays.asList(a)));
							gvBubbleSort.setAdapter(adapter);

						}
						j++;
						if (gvBubbleSort.getChildAt(j) != null) {
							gvBubbleSort.getChildAt(j - 1).setBackgroundColor(
									getResources().getColor(R.color.white));
						}
						// take next pair of elements
						if (j < len - 1) {
							sort(j);
						}
						// again start from beginning
						if (j == len - 1) {
							j = 0;
						}
					}
				}, delay);
			}
		}, delay);
	}

}
