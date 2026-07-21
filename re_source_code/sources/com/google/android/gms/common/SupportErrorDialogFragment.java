package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public class SupportErrorDialogFragment extends androidx.fragment.app.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Dialog f11646f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DialogInterface.OnCancelListener f11647g = null;

    public static SupportErrorDialogFragment d(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f11646f = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f11647g = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f11647g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f11646f == null) {
            setShowsDialog(false);
        }
        return this.f11646f;
    }

    @Override // androidx.fragment.app.c
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
