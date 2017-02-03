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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class CheckPermission {

	private Context context;

	public CheckPermission(@NonNull Context context) {
		this.context = context;
	}

	public void checkOne(@NonNull String permission, @Nullable String dialogMessage) {
		if (dialogMessage != null) {
			//TODO Display Messages in Dialog
		} else {
			//TODO Display System default Messages in Dialog
		}
	}

	public void checkMultiple(@NonNull String[] permissions, @Nullable String dialogMessages) {
		if (dialogMessages != null) {
			//TODO Display Messages in Dialogs
		} else {
			//TODO Display System default Messages in Dialogs
		}
	}
}
