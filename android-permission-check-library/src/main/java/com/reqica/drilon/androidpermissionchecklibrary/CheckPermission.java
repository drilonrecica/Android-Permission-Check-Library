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

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class CheckPermission {

	private Context context;

	public CheckPermission(@NonNull Context context) {
		this.context = context;
	}

	public void checkOne(@NonNull final String permission, @Nullable final String dialogMessage) {
		if (dialogMessage != null) {
			//TODO Display Messages in Dialog
			showMessageDialog(dialogMessage, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					checkPermission(permission);
				}
			});
		} else {
			//TODO Display System default Messages in Dialog
			checkPermission(permission);
		}
	}

	public void checkMultiple(@NonNull String[] permissions, @Nullable String dialogMessages) {
		if (dialogMessages != null) {
			//TODO Display Messages in Dialogs
			for (int i = 0; i < permissions.length; i++) {

			}
		} else {
			//TODO Display System default Messages in Dialogs
		}
	}

	private void checkPermission(@NonNull String permission) {
		Toast.makeText(context, permission, Toast.LENGTH_SHORT).show();
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
