package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<S> extends l<S> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DateSelector<S> f18608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CalendarConstraints f18609h;

    /* JADX INFO: compiled from: MaterialTextInputPicker.java */
    class a extends k<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.k
        public void a(S s) {
            Iterator<k<S>> it = h.this.f18621f.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    static <T> h<T> f(DateSelector<T> dateSelector, CalendarConstraints calendarConstraints) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        hVar.setArguments(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f18608g = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f18609h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f18608g.t0(layoutInflater, viewGroup, bundle, this.f18609h, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f18608g);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f18609h);
    }
}
