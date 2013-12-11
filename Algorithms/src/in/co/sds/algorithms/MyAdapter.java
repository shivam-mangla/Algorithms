package in.co.sds.algorithms;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context mContext;

	// references to our images
	private ArrayList<Integer> mAdapterContent;

	public MyAdapter(Context context) {
		mAdapterContent = new ArrayList<Integer>();
		mContext = context;
	}

	public int getCount() {
		return mAdapterContent.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			textView = new TextView(mContext);
			textView.setLayoutParams(new GridView.LayoutParams(85, 85));
			textView.setPadding(8, 8, 8, 8);
		} else {
			textView = (TextView) convertView;
		}
		textView.setText(mAdapterContent.get(position) + "");
		return textView;
	}

	public void setAdapterContent(ArrayList<Integer> sth) {
		mAdapterContent = sth;
	}
}
