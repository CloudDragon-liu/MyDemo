package com.liuyunlong.androiddemo.activity;

import com.liuyunlong.androiddemo.R;
import com.liuyunlong.androiddemo.utils.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/** 
* @author  : liuyunlong
* @version ：2015-9-23 下午5:50:27 
* */
public class MenuActivity extends Activity {

	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu_layout);
		initView();
	}

	private void initView() {
		button = (Button) this.findViewById(R.id.context_menu_btn);
		registerForContextMenu(button);
	}

	/*************************optionMenu************************************/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu fileSubMenu = menu.addSubMenu("文件");
		SubMenu editMenu = menu.addSubMenu("编辑");
		fileSubMenu.add(Menu.NONE, Menu.FIRST + 1, 5, "del").setIcon(android.R.drawable.ic_menu_delete);
		fileSubMenu.add(Menu.NONE, Menu.FIRST + 2, 2, "save").setIcon(android.R.drawable.ic_menu_save);
		editMenu.add(Menu.NONE, Menu.FIRST + 3, 6, "help").setIcon(android.R.drawable.ic_menu_help);
		editMenu.add(Menu.NONE, Menu.FIRST + 4, 6, "restore").setIcon(android.R.drawable.ic_menu_help);
		// getMenuInflater().inflate(R.menu.mymenu, menu); // 从菜单配置文件中读取菜单项
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		Logger.showToast(this, "菜单显示前调用");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			Logger.showToast(this, "您选择的是删除菜单");
			break;
		case Menu.FIRST + 2:
			Logger.showToast(this, "您选择的是保存菜单");
			break;
		case Menu.FIRST + 3:
			Logger.showToast(this, "您选择的是帮助菜单");
			break;

		default:
			break;
		}
		return false;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		Logger.showToast(this, "菜单关闭了");
	}

	/******************************context menu***************************************/

	@Override
	// getMenuInflater().inflate(R.menu.mymenu, menu);同样也可以从菜单文件中读取
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("信息操作");
		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "添加联系人");
		menu.add(Menu.NONE, Menu.FIRST + 2, 2, "添加编辑");
		menu.add(Menu.NONE, Menu.FIRST + 3, 3, "另存为");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			Logger.showToast(this, "您选择的是添加联系人");
			break;
		case Menu.FIRST + 2:
			Logger.showToast(this, "您选择的是添加编辑");
			break;
		case Menu.FIRST + 3:
			Logger.showToast(this, "您选择的是另存为");
			break;

		default:
			break;
		}
		return false;
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		Logger.showToast(this, "菜单关闭了");
	}

}
