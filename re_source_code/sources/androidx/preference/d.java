package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends f {
    Set<String> n = new HashSet();
    boolean o;
    CharSequence[] p;
    CharSequence[] q;

    /* JADX INFO: compiled from: MultiSelectListPreferenceDialogFragmentCompat.java */
    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
            if (z) {
                d dVar = d.this;
                dVar.o = dVar.n.add(dVar.q[i2].toString()) | dVar.o;
            } else {
                d dVar2 = d.this;
                dVar2.o = dVar2.n.remove(dVar2.q[i2].toString()) | dVar2.o;
            }
        }
    }

    private MultiSelectListPreference k() {
        return (MultiSelectListPreference) d();
    }

    public static d l(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString(RoomNotification.KEY, str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // androidx.preference.f
    public void h(boolean z) {
        if (z && this.o) {
            MultiSelectListPreference multiSelectListPreferenceK = k();
            if (multiSelectListPreferenceK.k(this.n)) {
                multiSelectListPreferenceK.i1(this.n);
            }
        }
        this.o = false;
    }

    @Override // androidx.preference.f
    protected void i(androidx.appcompat.app.c.a aVar) {
        super.i(aVar);
        int length = this.q.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = this.n.contains(this.q[i2].toString());
        }
        aVar.k(this.p, zArr, new a());
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.n.clear();
            this.n.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.o = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.p = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.q = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceK = k();
        if (multiSelectListPreferenceK.f1() == null || multiSelectListPreferenceK.g1() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.n.clear();
        this.n.addAll(multiSelectListPreferenceK.h1());
        this.o = false;
        this.p = multiSelectListPreferenceK.f1();
        this.q = multiSelectListPreferenceK.g1();
    }

    @Override // androidx.preference.f, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.n));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.o);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.p);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.q);
    }
}
