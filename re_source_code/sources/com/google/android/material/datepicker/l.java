package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PickerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class l<S> extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final LinkedHashSet<k<S>> f18621f = new LinkedHashSet<>();

    l() {
    }

    boolean d(k<S> kVar) {
        return this.f18621f.add(kVar);
    }

    void e() {
        this.f18621f.clear();
    }
}
