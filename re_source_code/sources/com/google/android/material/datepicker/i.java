package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Iterator;

/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends BaseAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f18610f = o.l().getMaximum(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Month f18611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final DateSelector<?> f18612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    b f18613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final CalendarConstraints f18614j;

    i(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f18611g = month;
        this.f18612h = dateSelector;
        this.f18614j = calendarConstraints;
    }

    private void e(Context context) {
        if (this.f18613i == null) {
            this.f18613i = new b(context);
        }
    }

    int a(int i2) {
        return b() + (i2 - 1);
    }

    int b() {
        return this.f18611g.v();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i2) {
        if (i2 < this.f18611g.v() || i2 > h()) {
            return null;
        }
        return Long.valueOf(this.f18611g.x(i(i2)));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0061  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i2, View view, ViewGroup viewGroup) {
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.e.b.c.h.f21016h, viewGroup, false);
        }
        int iB = i2 - b();
        if (iB >= 0) {
            Month month = this.f18611g;
            if (iB >= month.f18560k) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i3 = iB + 1;
                textView.setTag(month);
                textView.setText(String.valueOf(i3));
                long jX = this.f18611g.x(i3);
                if (this.f18611g.f18558i == Month.u().f18558i) {
                    textView.setContentDescription(c.a(jX));
                } else {
                    textView.setContentDescription(c.c(jX));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        Long item = getItem(i2);
        if (item == null) {
            return textView;
        }
        if (!this.f18614j.f().F0(item.longValue())) {
            textView.setEnabled(false);
            this.f18613i.f18571g.d(textView);
            return textView;
        }
        textView.setEnabled(true);
        Iterator<Long> it = this.f18612h.Q0().iterator();
        while (it.hasNext()) {
            if (o.a(item.longValue()) == o.a(it.next().longValue())) {
                this.f18613i.f18566b.d(textView);
                return textView;
            }
        }
        if (o.j().getTimeInMillis() == item.longValue()) {
            this.f18613i.f18567c.d(textView);
            return textView;
        }
        this.f18613i.a.d(textView);
        return textView;
    }

    boolean f(int i2) {
        return i2 % this.f18611g.f18559j == 0;
    }

    boolean g(int i2) {
        return (i2 + 1) % this.f18611g.f18559j == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18611g.f18560k + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f18611g.f18559j;
    }

    int h() {
        return (this.f18611g.v() + this.f18611g.f18560k) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i2) {
        return (i2 - this.f18611g.v()) + 1;
    }

    boolean j(int i2) {
        return i2 >= b() && i2 <= h();
    }
}
