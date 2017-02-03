package com.reqica.drilon.androidpermissioncheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.reqica.drilon.androidpermissionchecklibrary.CheckPermission;
import com.reqica.drilon.androidpermissionchecklibrary.Permission;

public class OnePermissionCheck extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_permission_check);

		CheckPermission checkPermission = new CheckPermission(this);

		checkPermission.checkOne(Permission.CAMERA, "Test");
	}
}
