package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface DateSelector<S> extends Parcelable {
    String A(Context context);

    Collection<c.i.j.e<Long, Long>> D();

    int E0(Context context);

    boolean K0();

    Collection<Long> Q0();

    S V0();

    void f1(long j2);

    View t0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, k<S> kVar);
}
