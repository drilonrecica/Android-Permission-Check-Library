/*
        MIT License

        Copyright (c) 2016 Drilon Reçica

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

package com.reqica.drilon.androidmpermissioncheck;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

public class CreatePermissionDialog {

    Context context;
    Activity activity;

    public CreatePermissionDialog (Context context){
        this.context = context;
        activity = (Activity) context;
    }

    public void checkMPermission (final String permission , String dialogMessage) {

        int hasSpecificPermission = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);
        }
        if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!activity.shouldShowRequestPermissionRationale(permission)) {
                    showMessageOKCancel(dialogMessage,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        activity.requestPermissions(new String[] {permission},
                                                PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.requestPermissions(new String[]{permission},
                        PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }
    }

//    public void checkMPermissions (final String [] permissions , String dialogMessage) {
//
//        int [] hasSpecificPermission = new int[permissions.length];
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            for (int i = 0 ; i < permissions.length ; i++){
//                hasSpecificPermission[i] = ContextCompat.checkSelfPermission(context, permissions[i]);
//            }
//        }
//        if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (!activity.shouldShowRequestPermissionRationale(permissions)) {
//                    showMessageOKCancel(dialogMessage,
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                        activity.requestPermissions(permissions,
//                                                PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
//                                    }
//                                }
//                            });
//                    return;
//                }
//            }
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                activity.requestPermissions(permissions,
//                        PERMISSIONS.REQUEST_CODE_ASK_PERMISSIONS);
//            }
//            return;
//        }
//    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
