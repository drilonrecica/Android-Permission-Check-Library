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
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

public class CheckPermission {

	private Context context;
	private Activity activity;

	public CheckPermission(@NonNull final Context context) {
		this.context = context;
		activity = (Activity) context;
	}

	public void checkOne(@NonNull final String permission, @Nullable final String dialogMessage) {
		if (!TextUtils.isEmpty(dialogMessage)) {
//			//TODO Display Messages in Dialog
			checkPermissionWithUserDialog(permission, dialogMessage);
		} else {
			//TODO Display System default Messages in Dialog
			checkPermission(permission);
		}
	}

	public void checkMultiple(@NonNull final String[] permissions, @Nullable final String[] dialogMessages) {
		if (dialogMessages != null) {
			//TODO Display Messages in Dialogs
		} else {
			//TODO Display System default Messages in Dialogs
		}
	}

	public void revokePermission(@NonNull final String permission) {

	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermission(@NonNull final String permission) {
		int hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			activity.requestPermissions(new String[]{permission},
					Permission.REQUEST_CODE_ASK_PERMISSIONS);
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private void checkPermissionWithUserDialog(@NonNull final String permission, @NonNull final String dialogMessage) {

		int hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			if (!activity.shouldShowRequestPermissionRationale(permission)) {
				showMessageDialog(dialogMessage,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								activity.requestPermissions(new String[]{permission},
										Permission.REQUEST_CODE_ASK_PERMISSIONS);
							}
						});
			}
		}
	}

	private void showMessageDialog(@NonNull String message, @NonNull DialogInterface.OnClickListener okListener) {
		new AlertDialog.Builder(context)
				.setCancelable(false)
				.setTitle(message)
				.setMessage(message)
				.setPositiveButton(context.getString(android.R.string.ok), okListener)
				.setNegativeButton(context.getString(android.R.string.cancel), null)
				.create()
				.show();
	}
}
