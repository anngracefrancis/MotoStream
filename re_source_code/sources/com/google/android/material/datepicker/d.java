package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Calendar f18574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f18576i;

    static {
        f18573f = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public d() {
        Calendar calendarL = o.l();
        this.f18574g = calendarL;
        this.f18575h = calendarL.getMaximum(7);
        this.f18576i = calendarL.getFirstDayOfWeek();
    }

    private int b(int i2) {
        int i3 = i2 + this.f18576i;
        int i4 = this.f18575h;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i2) {
        if (i2 >= this.f18575h) {
            return null;
        }
        return Integer.valueOf(b(i2));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18575h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.e.b.c.h.f21017i, viewGroup, false);
        }
        this.f18574g.set(7, b(i2));
        textView.setText(this.f18574g.getDisplayName(7, f18573f, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(e.e.b.c.j.m), this.f18574g.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
