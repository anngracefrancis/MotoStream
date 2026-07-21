package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import c.g.b.k.k;

/* JADX INFO: compiled from: VirtualLayout.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends b {
    private boolean o;
    private boolean p;

    @Override // androidx.constraintlayout.widget.b
    protected void h(AttributeSet attributeSet) {
        super.h(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.c1) {
                    this.o = true;
                } else if (index == i.h1) {
                    this.p = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void o(k kVar, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.o || this.p) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i2 = 0; i2 < this.f741g; i2++) {
                View viewH = constraintLayout.h(this.f740f[i2]);
                if (viewH != null) {
                    if (this.o) {
                        viewH.setVisibility(visibility);
                    }
                    if (this.p && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewH.setTranslationZ(viewH.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        d();
    }
}
