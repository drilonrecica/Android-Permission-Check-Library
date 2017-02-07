package com.reqica.drilon.androidpermissionchecklibrary;

/*
		MIT License

		Copyright (c) 2017 Drilon Reçica

		Permission is hereby granted, free of charge, to any person obtaining a copy
		of this software and associated documentation files (the "Software"), to deal
		in the Software without restriction, including without limitation the rights
		to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
		copies of the Software, and to permit persons to whom the Software is
		furnished to do so, subject to the following conditions:

		The above copyright notice and this permission notice shall be included in all
		copies or substantial portions of the Software.

		THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
		IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
		FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
		AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
		LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
		OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
		SOFTWARE.

*/

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static com.reqica.drilon.androidpermissionchecklibrary.Permission.REQUEST_CODE_ASK_PERMISSIONS;

public class CheckPermission {

	private Context context;
	private Activity activity;

	public CheckPermission(@NonNull final Context context) {
		this.context = context;
		activity = (Activity) context;
	}

	public void checkOne(@NonNull final String permission, @Nullable final String dialogMessage) {
		if (!TextUtils.isEmpty(dialogMessage)) {
			checkPermissionWithUserDialog(permission, dialogMessage);
		} else {
			checkPermission(permission);
		}
	}

	public void checkMultiple(@NonNull final String[] permissions, @Nullable final String dialogMessage) {
		if (!TextUtils.isEmpty(dialogMessage)) {
			checkPermissionsWithUserDialog(permissions, dialogMessage);
		} else {
			checkPermissions(permissions);
		}
	}

	public void openPermissionsSettings(@NonNull String packageName) {
		context.startActivity(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
				Uri.parse("package:" + packageName)));
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermission(@NonNull final String permission) {
		int hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			activity.requestPermissions(new String[]{permission},
					REQUEST_CODE_ASK_PERMISSIONS);
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermissions(@NonNull final String[] permissions) {
		int nonGrantedPermissions = 0;
		for (String permission : permissions) {
			if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
				nonGrantedPermissions++;
			}
		}

		if (nonGrantedPermissions != 0) {
			final String[] permissionsList = getNonGrantedPermissions(permissions);
			activity.requestPermissions(permissionsList, Permission.REQUEST_CODE_ASK_PERMISSIONS);
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermissionWithUserDialog(@NonNull final String permission,
											   @NonNull final String dialogMessage) {
		int hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			showMessageDialog(dialogMessage,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							activity.requestPermissions(new String[]{permission},
									REQUEST_CODE_ASK_PERMISSIONS);
						}
					});
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermissionsWithUserDialog(@NonNull final String[] permissions,
												@NonNull final String dialogMessage) {
		showMessageDialog(dialogMessage,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						checkPermissions(permissions);
					}
				});
	}

	@TargetApi(Build.VERSION_CODES.M)
	private String[] getNonGrantedPermissions(@NonNull String[] permissions) {
		ArrayList<String> permissionList = new ArrayList<>(Arrays.asList(permissions));

		for (int i = 0; i < permissions.length; i++) {
			if (activity.checkSelfPermission(permissions[i]) == PackageManager.PERMISSION_GRANTED) {
				permissionList.remove(i);
			}
		}
		return permissionList.toArray(new String[permissionList.size()]);
	}

	private void showMessageDialog(@NonNull String message, @NonNull DialogInterface.OnClickListener okListener) {
		new AlertDialog.Builder(context)
				.setCancelable(true)
				.setTitle("")
				.setMessage(message)
				.setPositiveButton(context.getString(android.R.string.ok), okListener)
				.setNegativeButton(context.getString(android.R.string.cancel), null)
				.create()
				.show();
	}


}
