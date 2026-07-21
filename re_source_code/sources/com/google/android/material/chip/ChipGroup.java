package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.u;
import com.google.android.material.internal.j;
import e.e.b.c.k;
import e.e.b.c.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ChipGroup extends com.google.android.material.internal.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18537j = k.r;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18538k;
    private int l;
    private boolean m;
    private boolean n;
    private d o;
    private final b p;
    private e q;
    private int r;
    private boolean s;

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.s) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.n) {
                ChipGroup.this.q(compoundButton.getId(), true);
                ChipGroup.this.p(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z) {
                if (ChipGroup.this.r == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.r != -1 && ChipGroup.this.r != id && ChipGroup.this.m) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.q(chipGroup.r, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }
    }

    public interface d {
        void a(ChipGroup chipGroup, int i2);
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f18539f;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : view2.hashCode());
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.p);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f18539f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f18539f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.f20969h);
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i2, boolean z) {
        this.r = i2;
        d dVar = this.o;
        if (dVar != null && this.m && z) {
            dVar.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i2, boolean z) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById instanceof Chip) {
            this.s = true;
            ((Chip) viewFindViewById).setChecked(z);
            this.s = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i2) {
        p(i2, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.r;
                if (i3 != -1 && this.m) {
                    q(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // com.google.android.material.internal.c
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.m) {
            return this.r;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.m) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f18538k;
    }

    public int getChipSpacingVertical() {
        return this.l;
    }

    public void m() {
        this.s = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.s = false;
        setCheckedId(-1);
    }

    int n(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                if (((Chip) getChildAt(i3)) == view) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public boolean o() {
        return this.m;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.r;
        if (i2 != -1) {
            q(i2, true);
            setCheckedId(this.r);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.d0.c.y0(accessibilityNodeInfo).a0(androidx.core.view.d0.c.b.a(getRowCount(), c() ? getChipCount() : -1, false, o() ? 1 : 2));
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f18538k != i2) {
            this.f18538k = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(int i2) {
        if (this.l != i2) {
            this.l = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.o = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.q.f18539f = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.n = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        if (this.m != z) {
            this.m = z;
            m();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f18537j;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.p = new b();
        this.q = new e();
        this.r = -1;
        this.s = false;
        TypedArray typedArrayH = j.h(getContext(), attributeSet, l.W0, i2, i3, new int[0]);
        int dimensionPixelOffset = typedArrayH.getDimensionPixelOffset(l.Y0, 0);
        setChipSpacingHorizontal(typedArrayH.getDimensionPixelOffset(l.Z0, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayH.getDimensionPixelOffset(l.a1, dimensionPixelOffset));
        setSingleLine(typedArrayH.getBoolean(l.c1, false));
        setSingleSelection(typedArrayH.getBoolean(l.d1, false));
        setSelectionRequired(typedArrayH.getBoolean(l.b1, false));
        int resourceId = typedArrayH.getResourceId(l.X0, -1);
        if (resourceId != -1) {
            this.r = resourceId;
        }
        typedArrayH.recycle();
        super.setOnHierarchyChangeListener(this.q);
        u.t0(this, 1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
