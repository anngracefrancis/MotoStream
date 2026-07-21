package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.u;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Calendar f18553f;

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.a0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter().h());
        } else if (i2 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i getAdapter() {
        return (i) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iA;
        int iC;
        int iA2;
        int iC2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        i adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f18612h;
        b bVar = adapter.f18613i;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.h());
        for (c.i.j.e<Long, Long> eVar : dateSelector.D()) {
            Long l = eVar.a;
            if (l != null) {
                if (eVar.f3281b == null) {
                    continue;
                } else {
                    long jLongValue = l.longValue();
                    long jLongValue2 = eVar.f3281b.longValue();
                    if (d(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        return;
                    }
                    if (jLongValue < item.longValue()) {
                        iA = adapter.b();
                        iC = adapter.f(iA) ? 0 : materialCalendarGridView.getChildAt(iA - 1).getRight();
                    } else {
                        materialCalendarGridView.f18553f.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f18553f.get(5));
                        iC = c(materialCalendarGridView.getChildAt(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iA2 = adapter.h();
                        iC2 = adapter.g(iA2) ? getWidth() : materialCalendarGridView.getChildAt(iA2).getRight();
                    } else {
                        materialCalendarGridView.f18553f.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f18553f.get(5));
                        iC2 = c(materialCalendarGridView.getChildAt(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iA ? 0 : iC, childAt.getTop() + bVar.a.c(), iA2 > numColumns2 ? getWidth() : iC2, childAt.getBottom() - bVar.a.b(), bVar.f18572h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18553f = o.l();
        if (f.s(getContext())) {
            setNextFocusLeftId(e.e.b.c.f.a);
            setNextFocusRightId(e.e.b.c.f.f20999b);
        }
        u.i0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof i)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), i.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
