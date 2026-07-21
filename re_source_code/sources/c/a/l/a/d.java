package c.a.l.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* JADX INFO: compiled from: StateListDrawable.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class d extends b {
    private a r;
    private boolean s;

    /* JADX INFO: compiled from: StateListDrawable.java */
    static class a extends b.c {
        int[][] J;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int iH = h();
            for (int i2 = 0; i2 < iH; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // c.a.l.a.b.c
        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        @Override // c.a.l.a.b.c
        void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // c.a.l.a.b
    void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.r = (a) cVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.a.l.a.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.r, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.s && super.mutate() == this) {
            this.r.r();
            this.s = true;
        }
        return this;
    }

    @Override // c.a.l.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iA = this.r.A(iArr);
        if (iA < 0) {
            iA = this.r.A(StateSet.WILD_CARD);
        }
        return g(iA) || zOnStateChange;
    }

    d(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }
}
