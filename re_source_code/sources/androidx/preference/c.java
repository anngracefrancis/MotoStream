package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;

/* JADX INFO: compiled from: ListPreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends f {
    int n;
    private CharSequence[] o;
    private CharSequence[] p;

    /* JADX INFO: compiled from: ListPreferenceDialogFragmentCompat.java */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            c cVar = c.this;
            cVar.n = i2;
            cVar.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference k() {
        return (ListPreference) d();
    }

    public static c l(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString(RoomNotification.KEY, str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.f
    public void h(boolean z) {
        int i2;
        if (!z || (i2 = this.n) < 0) {
            return;
        }
        String string = this.p[i2].toString();
        ListPreference listPreferenceK = k();
        if (listPreferenceK.k(string)) {
            listPreferenceK.l1(string);
        }
    }

    @Override // androidx.preference.f
    protected void i(androidx.appcompat.app.c.a aVar) {
        super.i(aVar);
        aVar.t(this.o, this.n, new a());
        aVar.r(null, null);
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.n = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.o = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.p = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceK = k();
        if (listPreferenceK.g1() == null || listPreferenceK.i1() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.n = listPreferenceK.f1(listPreferenceK.j1());
        this.o = listPreferenceK.g1();
        this.p = listPreferenceK.i1();
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.n);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.o);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.p);
    }
}
