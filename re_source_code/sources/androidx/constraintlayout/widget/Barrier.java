package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends b {
    private int o;
    private int p;
    private c.g.b.k.a q;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void p(c.g.b.k.e eVar, int i2, boolean z) {
        this.p = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.o;
            if (i3 == 5) {
                this.p = 0;
            } else if (i3 == 6) {
                this.p = 1;
            }
        } else if (z) {
            int i4 = this.o;
            if (i4 == 5) {
                this.p = 1;
            } else if (i4 == 6) {
                this.p = 0;
            }
        } else {
            int i5 = this.o;
            if (i5 == 5) {
                this.p = 0;
            } else if (i5 == 6) {
                this.p = 1;
            }
        }
        if (eVar instanceof c.g.b.k.a) {
            ((c.g.b.k.a) eVar).j1(this.p);
        }
    }

    public int getMargin() {
        return this.q.f1();
    }

    public int getType() {
        return this.o;
    }

    @Override // androidx.constraintlayout.widget.b
    protected void h(AttributeSet attributeSet) {
        super.h(attributeSet);
        this.q = new c.g.b.k.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == i.j1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.i1) {
                    this.q.i1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == i.k1) {
                    this.q.k1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f743i = this.q;
        n();
    }

    @Override // androidx.constraintlayout.widget.b
    public void i(c.g.b.k.e eVar, boolean z) {
        p(eVar, this.o, z);
    }

    public boolean o() {
        return this.q.d1();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.q.i1(z);
    }

    public void setDpMargin(int i2) {
        this.q.k1((int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i2) {
        this.q.k1(i2);
    }

    public void setType(int i2) {
        this.o = i2;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
