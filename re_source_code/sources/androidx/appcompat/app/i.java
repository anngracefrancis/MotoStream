package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: compiled from: AppCompatDialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends androidx.fragment.app.c {
    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new h(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.c
    public void setupDialog(Dialog dialog, int i2) {
        if (!(dialog instanceof h)) {
            super.setupDialog(dialog, i2);
            return;
        }
        h hVar = (h) dialog;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        hVar.d(1);
    }
}
