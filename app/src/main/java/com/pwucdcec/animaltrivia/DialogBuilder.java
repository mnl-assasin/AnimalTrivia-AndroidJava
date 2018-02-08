package com.pwucdcec.animaltrivia;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by mykelneds on 08/02/2018.
 */

public class DialogBuilder {

    public static void createAlertDialog(Context ctx, String title, String message, DialogInterface.OnClickListener clickListener) {

        AlertDialog.Builder builder = getAlertDialog(ctx);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", clickListener);
        builder.show();


    }

    private static AlertDialog.Builder getAlertDialog(Context ctx) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        return new AlertDialog.Builder(ctx);
    }
}
