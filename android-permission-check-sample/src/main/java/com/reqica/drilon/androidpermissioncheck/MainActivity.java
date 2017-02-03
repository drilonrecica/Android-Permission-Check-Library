package com.reqica.drilon.androidpermissioncheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button checkOnePermissionBtn =
				(Button) findViewById(R.id.check_one_permission_btn);
		Button checkMultiplePermissionsBtn =
				(Button) findViewById(R.id.check_multiple_permissions_btn);

		checkOnePermissionBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, OnePermissionCheck.class));
			}
		});

		checkMultiplePermissionsBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, MultiplePermissionCheck.class));
			}
		});
	}
}
