package com.reqica.drilon.androidpermissioncheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.reqica.drilon.androidpermissionchecklibrary.CheckPermission;
import com.reqica.drilon.androidpermissionchecklibrary.Permission;

public class MultiplePermissionCheck extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_permission_check);

		//java implementation
		final CheckPermission checkPermission = new CheckPermission(this);
		//kotlin implementation
//		final com.reqica.drilon.androidpermissionchecklibrarykotlin.CheckPermission checkPermissionKotlin =
//				new com.reqica.drilon.androidpermissionchecklibrarykotlin.CheckPermission(this);

		Button checkWithMessageBtn = (Button) findViewById(R.id.with_message_btn);
		Button checkWithoutMessageBtn = (Button) findViewById(R.id.without_message_btn);
		Button revokePermissionBtn = (Button) findViewById(R.id.revoke_permission_btn);

		final String[] permissions = {Permission.CAMERA,
				Permission.CALL_PHONE,
				Permission.RECEIVE_SMS};

		checkWithMessageBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//kotlin implementation
//				checkPermissionKotlin.checkMultiple(permissions, "You need to give permissions for usage");
				//java implementation
				checkPermission.checkMultiple(permissions, "You need to give permissions for usage");
			}
		});

		checkWithoutMessageBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//kotlin implementation
//				checkPermissionKotlin.checkMultiple(permissions, null);
				//java implementation
				checkPermission.checkMultiple(permissions, null);
			}
		});

		revokePermissionBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//kotlin implementation
//				checkPermissionKotlin.openPermissionsSettings(getApplicationContext().getPackageName());
				//java implementation
				checkPermission.openPermissionsSettings(getApplicationContext().getPackageName());
			}
		});
	}
}
