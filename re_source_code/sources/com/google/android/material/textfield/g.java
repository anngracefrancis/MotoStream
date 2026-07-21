package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.d0;
import com.google.android.material.internal.j;
import e.e.b.c.k;
import e.e.b.c.l;

/* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends androidx.appcompat.widget.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d0 f18815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AccessibilityManager f18816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f18817k;

    /* JADX INFO: compiled from: MaterialAutoCompleteTextView.java */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            g.this.e(i2 < 0 ? g.this.f18815i.u() : g.this.getAdapter().getItem(i2));
            AdapterView.OnItemClickListener onItemClickListener = g.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i2 < 0) {
                    view = g.this.f18815i.x();
                    i2 = g.this.f18815i.w();
                    j2 = g.this.f18815i.v();
                }
                onItemClickListener.onItemClick(g.this.f18815i.j(), view, i2, j2);
            }
            g.this.f18815i.dismiss();
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.f20963b);
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutC = c();
        int i2 = 0;
        if (adapter == null || textInputLayoutC == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f18815i.w()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutC);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableH = this.f18815i.h();
        if (drawableH != null) {
            drawableH.getPadding(this.f18817k);
            Rect rect = this.f18817k;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutC.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutC = c();
        return (textInputLayoutC == null || !textInputLayoutC.isProvidingHint()) ? super.getHint() : textInputLayoutC.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f18815i.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() == 0 && (accessibilityManager = this.f18816j) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f18815i.show();
        } else {
            super.showDropDown();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, 0), attributeSet, i2);
        this.f18817k = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = j.h(context2, attributeSet, l.r2, i2, k.f21034f, new int[0]);
        int i3 = l.s2;
        if (typedArrayH.hasValue(i3) && typedArrayH.getInt(i3, 0) == 0) {
            setKeyListener(null);
        }
        this.f18816j = (AccessibilityManager) context2.getSystemService("accessibility");
        d0 d0Var = new d0(context2);
        this.f18815i = d0Var;
        d0Var.I(true);
        d0Var.C(this);
        d0Var.H(2);
        d0Var.o(getAdapter());
        d0Var.K(new a());
        typedArrayH.recycle();
    }
}
