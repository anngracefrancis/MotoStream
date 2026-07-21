package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect a(Activity activity, Intent intent, int i2) {
        return new a(intent, activity, i2);
    }

    public static DialogRedirect b(Fragment fragment, Intent intent, int i2) {
        return new b(intent, fragment, i2);
    }

    public static DialogRedirect c(LifecycleFragment lifecycleFragment, Intent intent, int i2) {
        return new c(intent, lifecycleFragment, i2);
    }

    protected abstract void d();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            d();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
