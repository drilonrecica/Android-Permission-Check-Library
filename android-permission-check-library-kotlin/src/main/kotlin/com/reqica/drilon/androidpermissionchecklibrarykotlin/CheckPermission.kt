package com.reqica.drilon.androidpermissionchecklibrarykotlin

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

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.text.TextUtils

import java.util.ArrayList
import java.util.Arrays

class CheckPermission(private val context: Context) {
	private val activity: Activity

	init {
		activity = context as Activity
	}

	fun checkOne(permission: String, dialogMessage: String?) {
		if (!TextUtils.isEmpty(dialogMessage)) {
			checkPermissionWithUserDialog(permission, dialogMessage!!)
		} else {
			checkPermission(permission)
		}
	}

	fun checkMultiple(permissions: Array<String>, dialogMessage: String?) {
		if (!TextUtils.isEmpty(dialogMessage)) {
			checkPermissionsWithUserDialog(permissions, dialogMessage!!)
		} else {
			checkPermissions(permissions)
		}
	}

	fun openPermissionsSettings(packageName: String) {
		context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
				Uri.parse("package:" + packageName)))
	}

	@TargetApi(Build.VERSION_CODES.M)
	private fun checkPermission(permission: String) {
		val hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission)

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			activity.requestPermissions(arrayOf(permission),
					Permission.REQUEST_CODE_ASK_PERMISSIONS)
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private fun checkPermissions(permissions: Array<String>) {
		var nonGrantedPermissions = 0
		for (permission in permissions) {
			if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
				nonGrantedPermissions++
			}
		}

		if (nonGrantedPermissions != 0) {
			val permissionsList = getNonGrantedPermissions(permissions)
			activity.requestPermissions(permissionsList, Permission.REQUEST_CODE_ASK_PERMISSIONS)
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private fun checkPermissionWithUserDialog(permission: String,
											  dialogMessage: String) {
		val hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission)

		if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
			showMessageDialog(dialogMessage,
					DialogInterface.OnClickListener { dialog, which ->
						activity.requestPermissions(arrayOf(permission),
								Permission.REQUEST_CODE_ASK_PERMISSIONS)
					})
		}
	}

	@TargetApi(Build.VERSION_CODES.M)
	private fun checkPermissionsWithUserDialog(permissions: Array<String>,
											   dialogMessage: String) {
		showMessageDialog(dialogMessage,
				DialogInterface.OnClickListener { dialog, which -> checkPermissions(permissions) })
	}

	@TargetApi(Build.VERSION_CODES.M)
	private fun getNonGrantedPermissions(permissions: Array<String>): Array<String> {
		val permissionList = ArrayList(Arrays.asList(*permissions))

		for (i in permissions.indices) {
			if (activity.checkSelfPermission(permissions[i]) == PackageManager.PERMISSION_GRANTED) {
				permissionList.removeAt(i)
			}
		}
		return permissionList.toTypedArray()
	}

	private fun showMessageDialog(message: String, okListener: DialogInterface.OnClickListener) {
		AlertDialog.Builder(context).setCancelable(true).setTitle("").setMessage(message).setPositiveButton(context.getString(android.R.string.ok), okListener).setNegativeButton(context.getString(android.R.string.cancel), null).create().show()
	}


}
