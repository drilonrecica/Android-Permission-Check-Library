package com.reqica.drilon.androidpermissioncheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.reqica.drilon.androidpermissionchecklibrary.CheckPermission;
import com.reqica.drilon.androidpermissionchecklibrary.Permission;

public class OnePermissionCheck extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_permission_check);

		final CheckPermission checkPermission = new CheckPermission(this);

		Button checkWithMessageBtn = (Button) findViewById(R.id.with_message_btn);
		Button checkWithoutMessageBtn = (Button) findViewById(R.id.without_message_btn);
		Button revokePermissionBtn = (Button) findViewById(R.id.revoke_permission_btn);

		checkWithMessageBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkPermission.checkOne(Permission.CAMERA, "TestMessage");
			}
		});

		checkWithoutMessageBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkPermission.checkOne(Permission.CAMERA, null);
			}
		});

		revokePermissionBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkPermission.revokePermission(Permission.CAMERA);
			}
		});
	}
}
