package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.u;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends RecyclerView.g<b> {
    private final CalendarConstraints a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateSelector<?> f18615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.l f18616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f18617d;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f18618f;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f18618f = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (this.f18618f.getAdapter().j(i2)) {
                j.this.f18616c.a(this.f18618f.getAdapter().getItem(i2).longValue());
            }
        }
    }

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.c0 {
        final TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f18620b;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(e.e.b.c.f.m);
            this.a = textView;
            u.j0(textView, true);
            this.f18620b = (MaterialCalendarGridView) linearLayout.findViewById(e.e.b.c.f.f21006i);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    j(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, e.l lVar) {
        Month monthJ = calendarConstraints.j();
        Month monthG = calendarConstraints.g();
        Month monthI = calendarConstraints.i();
        if (monthJ.compareTo(monthI) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthI.compareTo(monthG) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f18617d = (i.f18610f * e.s(context)) + (f.s(context) ? e.s(context) : 0);
        this.a = calendarConstraints;
        this.f18615b = dateSelector;
        this.f18616c = lVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return this.a.j().F(i2).E();
    }

    Month h(int i2) {
        return this.a.j().F(i2);
    }

    CharSequence i(int i2) {
        return h(i2).y();
    }

    int j(Month month) {
        return this.a.j().G(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i2) {
        Month monthF = this.a.j().F(i2);
        bVar.a.setText(monthF.y());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f18620b.findViewById(e.e.b.c.f.f21006i);
        if (materialCalendarGridView.getAdapter() == null || !monthF.equals(materialCalendarGridView.getAdapter().f18611g)) {
            i iVar = new i(monthF, this.f18615b, this.a);
            materialCalendarGridView.setNumColumns(monthF.f18559j);
            materialCalendarGridView.setAdapter((ListAdapter) iVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.e.b.c.h.f21019k, viewGroup, false);
        if (!f.s(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f18617d));
        return new b(linearLayout, true);
    }
}
