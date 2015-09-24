package com.liuyunlong.androiddemo.activity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

import com.liuyunlong.androiddemo.R;

/** 
* @author  : liuyunlong
* @version ：2015-9-23 下午4:27:30 
* */
public class GalleryActivity extends Activity {

	private Gallery gallery;

	private ImageSwitcher switcher;

	private SimpleAdapter adapter;

	private List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.grallery);
		initView();
	}

	private void initView() {
		initAdapter();
		gallery = (Gallery) this.findViewById(R.id.gallery1);
		switcher = (ImageSwitcher) this.findViewById(R.id.imageSwitcher1);
		switcher.setFactory(new ViewFactoryImp());
		gallery.setAdapter(adapter);
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Map<String, Integer> map = (Map<String, Integer>) adapter.getItem(position);
				switcher.setImageResource(map.get("img"));
			}
		});
	}

	private void initAdapter() {
		Field[] fields = R.drawable.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) { // 获取所有以gallery开头的图片
			if (fields[i].getName().startsWith("gallery")) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				try {
					map.put("img", fields[i].getInt(R.drawable.class));
				} catch (Exception e) {
					e.printStackTrace();
				}
				list.add(map);
			}
		}
		adapter = new SimpleAdapter(this, list, R.layout.grallery_layout, new String[] { "img" }, new int[] { R.id.grallery_img });
	}

	private class ViewFactoryImp implements ViewFactory {
		@Override
		public View makeView() {
			ImageView imageView = new ImageView(GalleryActivity.this);
			imageView.setScaleType(ImageView.ScaleType.CENTER);
			imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			return imageView;
		}

	}

}
