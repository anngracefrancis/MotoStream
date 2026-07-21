package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Dialog f11624f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DialogInterface.OnCancelListener f11625g = null;

    public static ErrorDialogFragment a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.f11624f = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.f11625g = onCancelListener;
        }
        return errorDialogFragment;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f11625g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f11624f == null) {
            setShowsDialog(false);
        }
        return this.f11624f;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
