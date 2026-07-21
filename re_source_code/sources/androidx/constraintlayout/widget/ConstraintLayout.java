package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import c.g.b.k.k;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private int A;
    private int B;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    SparseArray<View> f705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<androidx.constraintlayout.widget.b> f706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected c.g.b.k.f f707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f710k;
    private int l;
    protected boolean m;
    private int n;
    private d o;
    protected androidx.constraintlayout.widget.c p;
    private int q;
    private HashMap<String, Integer> r;
    private int s;
    private int t;
    int u;
    int v;
    int w;
    int x;
    private SparseArray<c.g.b.k.e> y;
    c z;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.g.b.k.e.b.values().length];
            a = iArr;
            try {
                iArr[c.g.b.k.e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.g.b.k.e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.g.b.k.e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.g.b.k.e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c implements c.g.b.k.m.b.InterfaceC0070b {
        ConstraintLayout a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f726g;

        public c(ConstraintLayout constraintLayout) {
            this.a = constraintLayout;
        }

        private boolean d(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
            }
            return false;
        }

        @Override // c.g.b.k.m.b.InterfaceC0070b
        public final void a() {
            int childCount = this.a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt instanceof g) {
                    ((g) childAt).a(this.a);
                }
            }
            int size = this.a.f706g.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((androidx.constraintlayout.widget.b) this.a.f706g.get(i3)).k(this.a);
                }
            }
        }

        @Override // c.g.b.k.m.b.InterfaceC0070b
        @SuppressLint({"WrongCall"})
        public final void b(c.g.b.k.e eVar, c.g.b.k.m.b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int iMakeMeasureSpec3;
            int i2;
            if (eVar == null) {
                return;
            }
            if (eVar.Q() == 8 && !eVar.a0()) {
                aVar.f3091h = 0;
                aVar.f3092i = 0;
                aVar.f3093j = 0;
                return;
            }
            if (eVar.I() == null) {
                return;
            }
            c.g.b.k.e.b bVar = aVar.f3087d;
            c.g.b.k.e.b bVar2 = aVar.f3088e;
            int i3 = aVar.f3089f;
            int i4 = aVar.f3090g;
            int i5 = this.f721b + this.f722c;
            int i6 = this.f723d;
            View view = (View) eVar.q();
            int[] iArr = a.a;
            int i7 = iArr[bVar.ordinal()];
            if (i7 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else if (i7 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f725f, i6, -2);
            } else if (i7 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f725f, i6 + eVar.z(), -1);
            } else if (i7 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f725f, i6, -2);
                boolean z = eVar.q == 1;
                int i8 = aVar.m;
                if (i8 == c.g.b.k.m.b.a.f3085b || i8 == c.g.b.k.m.b.a.f3086c) {
                    if (aVar.m == c.g.b.k.m.b.a.f3086c || !z || (z && (view.getMeasuredHeight() == eVar.v())) || (view instanceof g) || eVar.e0()) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.R(), 1073741824);
                    }
                }
            }
            int i9 = iArr[bVar2.ordinal()];
            if (i9 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (i9 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f726g, i5, -2);
            } else if (i9 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f726g, i5 + eVar.P(), -1);
            } else if (i9 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f726g, i5, -2);
                boolean z2 = eVar.r == 1;
                int i10 = aVar.m;
                if (i10 == c.g.b.k.m.b.a.f3085b || i10 == c.g.b.k.m.b.a.f3086c) {
                    if (aVar.m == c.g.b.k.m.b.a.f3086c || !z2 || (z2 && (view.getMeasuredWidth() == eVar.R())) || (view instanceof g) || eVar.f0()) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.v(), 1073741824);
                    }
                }
            }
            c.g.b.k.f fVar = (c.g.b.k.f) eVar.I();
            if (fVar != null && c.g.b.k.j.b(ConstraintLayout.this.n, 256) && view.getMeasuredWidth() == eVar.R() && view.getMeasuredWidth() < fVar.R() && view.getMeasuredHeight() == eVar.v() && view.getMeasuredHeight() < fVar.v() && view.getBaseline() == eVar.n() && !eVar.d0()) {
                if (d(eVar.A(), iMakeMeasureSpec, eVar.R()) && d(eVar.B(), iMakeMeasureSpec2, eVar.v())) {
                    aVar.f3091h = eVar.R();
                    aVar.f3092i = eVar.v();
                    aVar.f3093j = eVar.n();
                    return;
                }
            }
            c.g.b.k.e.b bVar3 = c.g.b.k.e.b.MATCH_CONSTRAINT;
            boolean z3 = bVar == bVar3;
            boolean z4 = bVar2 == bVar3;
            c.g.b.k.e.b bVar4 = c.g.b.k.e.b.MATCH_PARENT;
            boolean z5 = bVar2 == bVar4 || bVar2 == c.g.b.k.e.b.FIXED;
            boolean z6 = bVar == bVar4 || bVar == c.g.b.k.e.b.FIXED;
            boolean z7 = z3 && eVar.X > 0.0f;
            boolean z8 = z4 && eVar.X > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i11 = aVar.m;
            if (i11 != c.g.b.k.m.b.a.f3085b && i11 != c.g.b.k.m.b.a.f3086c && z3 && eVar.q == 0 && z4 && eVar.r == 0) {
                i2 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof j) && (eVar instanceof k)) {
                    ((j) view).o((k) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                eVar.F0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i12 = eVar.t;
                iMax = i12 > 0 ? Math.max(i12, measuredWidth) : measuredWidth;
                int i13 = eVar.u;
                if (i13 > 0) {
                    iMax = Math.min(i13, iMax);
                }
                int i14 = eVar.w;
                iMax2 = i14 > 0 ? Math.max(i14, measuredHeight) : measuredHeight;
                int i15 = eVar.x;
                if (i15 > 0) {
                    iMax2 = Math.min(i15, iMax2);
                }
                if (!c.g.b.k.j.b(ConstraintLayout.this.n, 1)) {
                    if (z7 && z5) {
                        iMax = (int) ((iMax2 * eVar.X) + 0.5f);
                    } else if (z8 && z6) {
                        iMax2 = (int) ((iMax / eVar.X) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec3 = iMakeMeasureSpec;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    iMakeMeasureSpec3 = iMakeMeasureSpec;
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    eVar.F0(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i2 = -1;
            }
            boolean z9 = baseline != i2;
            aVar.l = (iMax == aVar.f3089f && iMax2 == aVar.f3090g) ? false : true;
            if (bVar5.Y) {
                z9 = true;
            }
            if (z9 && baseline != -1 && eVar.n() != baseline) {
                aVar.l = true;
            }
            aVar.f3091h = iMax;
            aVar.f3092i = iMax2;
            aVar.f3094k = z9;
            aVar.f3093j = baseline;
        }

        public void c(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f721b = i4;
            this.f722c = i5;
            this.f723d = i6;
            this.f724e = i7;
            this.f725f = i2;
            this.f726g = i3;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f705f = new SparseArray<>();
        this.f706g = new ArrayList<>(4);
        this.f707h = new c.g.b.k.f();
        this.f708i = 0;
        this.f709j = 0;
        this.f710k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 257;
        this.o = null;
        this.p = null;
        this.q = -1;
        this.r = new HashMap<>();
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        this.y = new SparseArray<>();
        this.z = new c(this);
        this.A = 0;
        this.B = 0;
        j(attributeSet, 0, 0);
    }

    private final c.g.b.k.e g(int i2) {
        if (i2 == 0) {
            return this.f707h;
        }
        View viewFindViewById = this.f705f.get(i2);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i2)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f707h;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).n0;
    }

    private int getPaddingWidth() {
        int iMax = 0;
        int iMax2 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            iMax = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return iMax > 0 ? iMax : iMax2;
    }

    private void j(AttributeSet attributeSet, int i2, int i3) {
        this.f707h.l0(this);
        this.f707h.D1(this.z);
        this.f705f.put(getId(), this);
        this.o = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.a1, i2, i3);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i4);
                if (index == i.f1) {
                    this.f708i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f708i);
                } else if (index == i.g1) {
                    this.f709j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f709j);
                } else if (index == i.d1) {
                    this.f710k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f710k);
                } else if (index == i.e1) {
                    this.l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.l);
                } else if (index == i.n2) {
                    this.n = typedArrayObtainStyledAttributes.getInt(index, this.n);
                } else if (index == i.o1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.p = null;
                        }
                    }
                } else if (index == i.l1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.o = dVar;
                        dVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.o = null;
                    }
                    this.q = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f707h.E1(this.n);
    }

    private void l() {
        this.m = true;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.x = 0;
    }

    private void p() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            c.g.b.k.e eVarI = i(getChildAt(i2));
            if (eVarI != null) {
                eVarI.h0();
            }
        }
        if (zIsInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    g(childAt.getId()).m0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.q != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getId() == this.q && (childAt2 instanceof e)) {
                    this.o = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.o;
        if (dVar != null) {
            dVar.d(this, true);
        }
        this.f707h.d1();
        int size = this.f706g.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.f706g.get(i5).m(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt3 = getChildAt(i6);
            if (childAt3 instanceof g) {
                ((g) childAt3).b(this);
            }
        }
        this.y.clear();
        this.y.put(0, this.f707h);
        this.y.put(getId(), this.f707h);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt4 = getChildAt(i7);
            this.y.put(childAt4.getId(), i(childAt4));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt5 = getChildAt(i8);
            c.g.b.k.e eVarI2 = i(childAt5);
            if (eVarI2 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f707h.a(eVarI2);
                c(zIsInEditMode, childAt5, eVarI2, bVar, this.y);
            }
        }
    }

    private boolean s() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            }
        }
        if (z) {
            p();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0212  */
    /* JADX WARN: Code duplicated, block: B:110:0x0216  */
    /* JADX WARN: Code duplicated, block: B:112:0x021a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0220  */
    /* JADX WARN: Code duplicated, block: B:115:0x023a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0243  */
    /* JADX WARN: Code duplicated, block: B:118:0x0251  */
    /* JADX WARN: Code duplicated, block: B:121:0x025a  */
    /* JADX WARN: Code duplicated, block: B:123:0x025e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0262  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:128:0x0282  */
    /* JADX WARN: Code duplicated, block: B:129:0x028b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0299  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:61:0x010f  */
    /* JADX WARN: Code duplicated, block: B:62:0x011c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0136  */
    /* JADX WARN: Code duplicated, block: B:70:0x013f  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:78:0x016a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0173  */
    /* JADX WARN: Code duplicated, block: B:81:0x0181  */
    /* JADX WARN: Code duplicated, block: B:88:0x019e  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01fb  */
    protected void c(boolean z, View view, c.g.b.k.e eVar, b bVar, SparseArray<c.g.b.k.e> sparseArray) {
        int i2;
        int i3;
        int i4;
        float f2;
        int i5;
        float f3;
        c.g.b.k.e eVar2;
        c.g.b.k.e eVar3;
        int i6;
        int i7;
        c.g.b.k.e eVar4;
        int i8;
        int i9;
        c.g.b.k.e eVar5;
        int i10;
        float f4;
        float f5;
        View view2;
        c.g.b.k.e eVar6;
        c.g.b.k.e eVar7;
        c.g.b.k.e eVar8;
        c.g.b.k.e eVar9;
        c.g.b.k.e eVar10;
        int i11;
        c.g.b.k.e eVar11;
        bVar.a();
        bVar.o0 = false;
        eVar.T0(view.getVisibility());
        if (bVar.b0) {
            eVar.D0(true);
            eVar.T0(8);
        }
        eVar.l0(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).i(eVar, this.f707h.x1());
        }
        if (bVar.Z) {
            c.g.b.k.g gVar = (c.g.b.k.g) eVar;
            int i12 = bVar.k0;
            int i13 = bVar.l0;
            float f6 = bVar.m0;
            if (Build.VERSION.SDK_INT < 17) {
                i12 = bVar.a;
                i13 = bVar.f711b;
                f6 = bVar.f712c;
            }
            if (f6 != -1.0f) {
                gVar.i1(f6);
                return;
            } else if (i12 != -1) {
                gVar.g1(i12);
                return;
            } else {
                if (i13 != -1) {
                    gVar.h1(i13);
                    return;
                }
                return;
            }
        }
        int i14 = bVar.d0;
        int i15 = bVar.e0;
        int i16 = bVar.f0;
        int i17 = bVar.g0;
        int i18 = bVar.h0;
        int i19 = bVar.i0;
        float f7 = bVar.j0;
        if (Build.VERSION.SDK_INT < 17) {
            i14 = bVar.f713d;
            int i20 = bVar.f714e;
            int i21 = bVar.f715f;
            i17 = bVar.f716g;
            int i22 = bVar.t;
            int i23 = bVar.v;
            f7 = bVar.z;
            if (i14 == -1 && i20 == -1) {
                int i24 = bVar.q;
                if (i24 != -1) {
                    i14 = i24;
                } else {
                    int i25 = bVar.p;
                    if (i25 != -1) {
                        i20 = i25;
                    }
                }
            }
            if (i21 == -1 && i17 == -1) {
                i3 = bVar.r;
                if (i3 == -1) {
                    int i26 = bVar.s;
                    if (i26 != -1) {
                        i2 = i23;
                        f2 = f7;
                        i18 = i22;
                        i4 = i26;
                        i15 = i20;
                        i3 = i21;
                    } else {
                        i3 = i21;
                        i2 = i23;
                        i18 = i22;
                        i15 = i20;
                    }
                } else {
                    i2 = i23;
                    i18 = i22;
                    i15 = i20;
                }
            } else {
                i3 = i21;
                i2 = i23;
                i18 = i22;
                i15 = i20;
            }
            i5 = bVar.m;
            if (i5 != -1) {
                eVar11 = sparseArray.get(i5);
                if (eVar11 != null) {
                    eVar.j(eVar11, bVar.o, bVar.n);
                }
            } else {
                if (i14 != -1) {
                    eVar10 = sparseArray.get(i14);
                    if (eVar10 != null) {
                        c.g.b.k.d.b bVar2 = c.g.b.k.d.b.LEFT;
                        f3 = f2;
                        eVar.X(bVar2, eVar10, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
                    } else {
                        f3 = f2;
                    }
                } else {
                    f3 = f2;
                    if (i15 != -1 && (eVar2 = sparseArray.get(i15)) != null) {
                        eVar.X(c.g.b.k.d.b.LEFT, eVar2, c.g.b.k.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
                    }
                }
                if (i3 != -1) {
                    eVar9 = sparseArray.get(i3);
                    if (eVar9 != null) {
                        eVar.X(c.g.b.k.d.b.RIGHT, eVar9, c.g.b.k.d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i2);
                    }
                } else if (i4 != -1 && (eVar3 = sparseArray.get(i4)) != null) {
                    c.g.b.k.d.b bVar3 = c.g.b.k.d.b.RIGHT;
                    eVar.X(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i2);
                }
                i6 = bVar.f717h;
                if (i6 != -1) {
                    eVar8 = sparseArray.get(i6);
                    if (eVar8 != null) {
                        c.g.b.k.d.b bVar4 = c.g.b.k.d.b.TOP;
                        eVar.X(bVar4, eVar8, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.u);
                    }
                } else {
                    i7 = bVar.f718i;
                    if (i7 != -1 && (eVar4 = sparseArray.get(i7)) != null) {
                        eVar.X(c.g.b.k.d.b.TOP, eVar4, c.g.b.k.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.u);
                    }
                }
                i8 = bVar.f719j;
                if (i8 != -1) {
                    eVar7 = sparseArray.get(i8);
                    if (eVar7 != null) {
                        eVar.X(c.g.b.k.d.b.BOTTOM, eVar7, c.g.b.k.d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.w);
                    }
                } else {
                    i9 = bVar.f720k;
                    if (i9 != -1 && (eVar5 = sparseArray.get(i9)) != null) {
                        c.g.b.k.d.b bVar5 = c.g.b.k.d.b.BOTTOM;
                        eVar.X(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.w);
                    }
                }
                i10 = bVar.l;
                if (i10 != -1) {
                    view2 = this.f705f.get(i10);
                    eVar6 = sparseArray.get(bVar.l);
                    if (eVar6 != null && view2 != null && (view2.getLayoutParams() instanceof b)) {
                        b bVar6 = (b) view2.getLayoutParams();
                        bVar.Y = true;
                        bVar6.Y = true;
                        c.g.b.k.d.b bVar7 = c.g.b.k.d.b.BASELINE;
                        eVar.m(bVar7).a(eVar6.m(bVar7), 0, -1, true);
                        eVar.u0(true);
                        bVar6.n0.u0(true);
                        eVar.m(c.g.b.k.d.b.TOP).p();
                        eVar.m(c.g.b.k.d.b.BOTTOM).p();
                    }
                }
                f4 = f3;
                if (f4 >= 0.0f) {
                    eVar.w0(f4);
                }
                f5 = bVar.A;
                if (f5 >= 0.0f) {
                    eVar.N0(f5);
                }
            }
            if (z && ((i11 = bVar.Q) != -1 || bVar.R != -1)) {
                eVar.L0(i11, bVar.R);
            }
            if (!bVar.W) {
                eVar.z0(c.g.b.k.e.b.FIXED);
                eVar.U0(((ViewGroup.MarginLayoutParams) bVar).width);
                if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                    eVar.z0(c.g.b.k.e.b.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
                if (bVar.T) {
                    eVar.z0(c.g.b.k.e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.z0(c.g.b.k.e.b.MATCH_PARENT);
                }
                eVar.m(c.g.b.k.d.b.LEFT).f3058g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
                eVar.m(c.g.b.k.d.b.RIGHT).f3058g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            } else {
                eVar.z0(c.g.b.k.e.b.MATCH_CONSTRAINT);
                eVar.U0(0);
            }
            if (!bVar.X) {
                eVar.Q0(c.g.b.k.e.b.FIXED);
                eVar.v0(((ViewGroup.MarginLayoutParams) bVar).height);
                if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                    eVar.Q0(c.g.b.k.e.b.WRAP_CONTENT);
                }
            } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
                if (bVar.U) {
                    eVar.Q0(c.g.b.k.e.b.MATCH_CONSTRAINT);
                } else {
                    eVar.Q0(c.g.b.k.e.b.MATCH_PARENT);
                }
                eVar.m(c.g.b.k.d.b.TOP).f3058g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
                eVar.m(c.g.b.k.d.b.BOTTOM).f3058g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            } else {
                eVar.Q0(c.g.b.k.e.b.MATCH_CONSTRAINT);
                eVar.v0(0);
            }
            eVar.n0(bVar.B);
            eVar.B0(bVar.E);
            eVar.S0(bVar.F);
            eVar.x0(bVar.G);
            eVar.O0(bVar.H);
            eVar.A0(bVar.I, bVar.K, bVar.M, bVar.O);
            eVar.R0(bVar.J, bVar.L, bVar.N, bVar.P);
        }
        i2 = i19;
        i3 = i16;
        float f8 = f7;
        i4 = i17;
        f2 = f8;
        i5 = bVar.m;
        if (i5 != -1) {
            eVar11 = sparseArray.get(i5);
            if (eVar11 != null) {
                eVar.j(eVar11, bVar.o, bVar.n);
            }
        } else {
            if (i14 != -1) {
                eVar10 = sparseArray.get(i14);
                if (eVar10 != null) {
                    c.g.b.k.d.b bVar8 = c.g.b.k.d.b.LEFT;
                    f3 = f2;
                    eVar.X(bVar8, eVar10, bVar8, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
                } else {
                    f3 = f2;
                }
            } else {
                f3 = f2;
                if (i15 != -1) {
                    eVar.X(c.g.b.k.d.b.LEFT, eVar2, c.g.b.k.d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
                }
            }
            if (i3 != -1) {
                eVar9 = sparseArray.get(i3);
                if (eVar9 != null) {
                    eVar.X(c.g.b.k.d.b.RIGHT, eVar9, c.g.b.k.d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i2);
                }
            } else if (i4 != -1) {
                c.g.b.k.d.b bVar9 = c.g.b.k.d.b.RIGHT;
                eVar.X(bVar9, eVar3, bVar9, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i2);
            }
            i6 = bVar.f717h;
            if (i6 != -1) {
                eVar8 = sparseArray.get(i6);
                if (eVar8 != null) {
                    c.g.b.k.d.b bVar10 = c.g.b.k.d.b.TOP;
                    eVar.X(bVar10, eVar8, bVar10, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.u);
                }
            } else {
                i7 = bVar.f718i;
                if (i7 != -1) {
                    eVar.X(c.g.b.k.d.b.TOP, eVar4, c.g.b.k.d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.u);
                }
            }
            i8 = bVar.f719j;
            if (i8 != -1) {
                eVar7 = sparseArray.get(i8);
                if (eVar7 != null) {
                    eVar.X(c.g.b.k.d.b.BOTTOM, eVar7, c.g.b.k.d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.w);
                }
            } else {
                i9 = bVar.f720k;
                if (i9 != -1) {
                    c.g.b.k.d.b bVar11 = c.g.b.k.d.b.BOTTOM;
                    eVar.X(bVar11, eVar5, bVar11, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.w);
                }
            }
            i10 = bVar.l;
            if (i10 != -1) {
                view2 = this.f705f.get(i10);
                eVar6 = sparseArray.get(bVar.l);
                if (eVar6 != null) {
                    b bVar12 = (b) view2.getLayoutParams();
                    bVar.Y = true;
                    bVar12.Y = true;
                    c.g.b.k.d.b bVar13 = c.g.b.k.d.b.BASELINE;
                    eVar.m(bVar13).a(eVar6.m(bVar13), 0, -1, true);
                    eVar.u0(true);
                    bVar12.n0.u0(true);
                    eVar.m(c.g.b.k.d.b.TOP).p();
                    eVar.m(c.g.b.k.d.b.BOTTOM).p();
                }
            }
            f4 = f3;
            if (f4 >= 0.0f) {
                eVar.w0(f4);
            }
            f5 = bVar.A;
            if (f5 >= 0.0f) {
                eVar.N0(f5);
            }
        }
        if (z) {
            eVar.L0(i11, bVar.R);
        }
        if (!bVar.W) {
            eVar.z0(c.g.b.k.e.b.FIXED);
            eVar.U0(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.z0(c.g.b.k.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.T) {
                eVar.z0(c.g.b.k.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.z0(c.g.b.k.e.b.MATCH_PARENT);
            }
            eVar.m(c.g.b.k.d.b.LEFT).f3058g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.m(c.g.b.k.d.b.RIGHT).f3058g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.z0(c.g.b.k.e.b.MATCH_CONSTRAINT);
            eVar.U0(0);
        }
        if (!bVar.X) {
            eVar.Q0(c.g.b.k.e.b.FIXED);
            eVar.v0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.Q0(c.g.b.k.e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.U) {
                eVar.Q0(c.g.b.k.e.b.MATCH_CONSTRAINT);
            } else {
                eVar.Q0(c.g.b.k.e.b.MATCH_PARENT);
            }
            eVar.m(c.g.b.k.d.b.TOP).f3058g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.m(c.g.b.k.d.b.BOTTOM).f3058g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.Q0(c.g.b.k.e.b.MATCH_CONSTRAINT);
            eVar.v0(0);
        }
        eVar.n0(bVar.B);
        eVar.B0(bVar.E);
        eVar.S0(bVar.F);
        eVar.x0(bVar.G);
        eVar.O0(bVar.H);
        eVar.A0(bVar.I, bVar.K, bVar.M, bVar.O);
        eVar.R0(bVar.J, bVar.L, bVar.N, bVar.P);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.b> arrayList = this.f706g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f706g.get(i2).l(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i4 = Integer.parseInt(strArrSplit[0]);
                        int i5 = Integer.parseInt(strArrSplit[1]);
                        int i6 = Integer.parseInt(strArrSplit[2]);
                        int i7 = (int) ((i4 / 1080.0f) * width);
                        int i8 = (int) ((i5 / 1920.0f) * height);
                        int i9 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i7;
                        float f3 = i8;
                        float f4 = i7 + ((int) ((i6 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float f5 = i8 + i9;
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f2, f5, paint);
                        canvas.drawLine(f2, f5, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, f5, paint);
                        canvas.drawLine(f2, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object f(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.r;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.r.get(str);
    }

    @Override // android.view.View
    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.l;
    }

    public int getMaxWidth() {
        return this.f710k;
    }

    public int getMinHeight() {
        return this.f709j;
    }

    public int getMinWidth() {
        return this.f708i;
    }

    public int getOptimizationLevel() {
        return this.f707h.s1();
    }

    public View h(int i2) {
        return this.f705f.get(i2);
    }

    public final c.g.b.k.e i(View view) {
        if (view == this) {
            return this.f707h;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).n0;
    }

    protected boolean k() {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
        }
        return false;
    }

    protected void m(int i2) {
        this.p = new androidx.constraintlayout.widget.c(getContext(), this, i2);
    }

    protected void n(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        c cVar = this.z;
        int i6 = cVar.f724e;
        int i7 = i4 + cVar.f723d;
        int i8 = i5 + i6;
        if (Build.VERSION.SDK_INT < 11) {
            setMeasuredDimension(i7, i8);
            this.s = i7;
            this.t = i8;
            return;
        }
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(i7, i2, 0);
        int iResolveSizeAndState2 = ViewGroup.resolveSizeAndState(i8, i3, 0) & 16777215;
        int iMin = Math.min(this.f710k, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.l, iResolveSizeAndState2);
        if (z) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z2) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
        this.s = iMin;
        this.t = iMin2;
    }

    protected void o(c.g.b.k.f fVar, int i2, int i3, int i4) {
        int iMax;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int iMax2 = Math.max(0, getPaddingTop());
        int iMax3 = Math.max(0, getPaddingBottom());
        int i5 = iMax2 + iMax3;
        int paddingWidth = getPaddingWidth();
        this.z.c(i3, i4, iMax2, iMax3, paddingWidth, i5);
        if (Build.VERSION.SDK_INT >= 17) {
            int iMax4 = Math.max(0, getPaddingStart());
            int iMax5 = Math.max(0, getPaddingEnd());
            if (iMax4 <= 0 && iMax5 <= 0) {
                iMax4 = Math.max(0, getPaddingLeft());
            } else if (k()) {
                iMax4 = iMax5;
            }
            iMax = iMax4;
        } else {
            iMax = Math.max(0, getPaddingLeft());
        }
        int i6 = size - paddingWidth;
        int i7 = size2 - i5;
        r(fVar, mode, i6, mode2, i7);
        fVar.z1(i2, mode, i6, mode2, i7, this.s, this.t, iMax, iMax2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            b bVar = (b) childAt.getLayoutParams();
            c.g.b.k.e eVar = bVar.n0;
            if ((childAt.getVisibility() != 8 || bVar.Z || bVar.a0 || bVar.c0 || zIsInEditMode) && !bVar.b0) {
                int iS = eVar.S();
                int iT = eVar.T();
                int iR = eVar.R() + iS;
                int iV = eVar.v() + iT;
                childAt.layout(iS, iT, iR, iV);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iS, iT, iR, iV);
                }
            }
        }
        int size = this.f706g.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f706g.get(i7).j(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (!this.m) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (getChildAt(i4).isLayoutRequested()) {
                    this.m = true;
                    break;
                }
            }
        }
        if (!this.m) {
            int i5 = this.A;
            if (i5 == i2 && this.B == i3) {
                n(i2, i3, this.f707h.R(), this.f707h.v(), this.f707h.y1(), this.f707h.w1());
                return;
            }
            if (i5 == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.B) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.f707h.v()) {
                this.A = i2;
                this.B = i3;
                n(i2, i3, this.f707h.R(), this.f707h.v(), this.f707h.y1(), this.f707h.w1());
                return;
            }
        }
        this.A = i2;
        this.B = i3;
        this.f707h.F1(k());
        if (this.m) {
            this.m = false;
            if (s()) {
                this.f707h.H1();
            }
        }
        o(this.f707h, this.n, i2, i3);
        n(i2, i3, this.f707h.R(), this.f707h.v(), this.f707h.y1(), this.f707h.w1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        c.g.b.k.e eVarI = i(view);
        if ((view instanceof Guideline) && !(eVarI instanceof c.g.b.k.g)) {
            b bVar = (b) view.getLayoutParams();
            c.g.b.k.g gVar = new c.g.b.k.g();
            bVar.n0 = gVar;
            bVar.Z = true;
            gVar.j1(bVar.S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.n();
            ((b) view.getLayoutParams()).a0 = true;
            if (!this.f706g.contains(bVar2)) {
                this.f706g.add(bVar2);
            }
        }
        this.f705f.put(view.getId(), view);
        this.m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f705f.remove(view.getId());
        this.f707h.c1(i(view));
        this.f706g.remove(view);
        this.m = true;
    }

    public void q(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.r == null) {
                this.r = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.r.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 c.g.b.k.e$b) = (r2v3 c.g.b.k.e$b), (r2v0 c.g.b.k.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    protected void r(c.g.b.k.f fVar, int i2, int i3, int i4, int i5) {
        c.g.b.k.e.b bVar;
        c cVar = this.z;
        int i6 = cVar.f724e;
        int i7 = cVar.f723d;
        c.g.b.k.e.b bVar2 = c.g.b.k.e.b.FIXED;
        int childCount = getChildCount();
        if (i2 == Integer.MIN_VALUE) {
            bVar = c.g.b.k.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i3 = Math.max(0, this.f708i);
            }
        } else if (i2 == 0) {
            bVar = c.g.b.k.e.b.WRAP_CONTENT;
            i3 = childCount == 0 ? Math.max(0, this.f708i) : 0;
        } else if (i2 != 1073741824) {
            bVar = bVar2;
        } else {
            i3 = Math.min(this.f710k - i7, i3);
            bVar = bVar2;
        }
        if (i4 == Integer.MIN_VALUE) {
            bVar2 = c.g.b.k.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.f709j);
            }
        } else if (i4 == 0) {
            bVar2 = c.g.b.k.e.b.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.f709j);
            } else {
                i5 = 0;
            }
        } else if (i4 != 1073741824) {
            i5 = 0;
        } else {
            i5 = Math.min(this.l - i6, i5);
        }
        if (i3 != fVar.R() || i5 != fVar.v()) {
            fVar.v1();
        }
        fVar.V0(0);
        fVar.W0(0);
        fVar.H0(this.f710k - i7);
        fVar.G0(this.l - i6);
        fVar.K0(0);
        fVar.J0(0);
        fVar.z0(bVar);
        fVar.U0(i3);
        fVar.Q0(bVar2);
        fVar.v0(i5);
        fVar.K0(this.f708i - i7);
        fVar.J0(this.f709j - i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public void setConstraintSet(d dVar) {
        this.o = dVar;
    }

    @Override // android.view.View
    public void setId(int i2) {
        this.f705f.remove(getId());
        super.setId(i2);
        this.f705f.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 == this.l) {
            return;
        }
        this.l = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        if (i2 == this.f710k) {
            return;
        }
        this.f710k = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        if (i2 == this.f709j) {
            return;
        }
        this.f709j = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        if (i2 == this.f708i) {
            return;
        }
        this.f708i = i2;
        requestLayout();
    }

    public void setOnConstraintsChanged(f fVar) {
        androidx.constraintlayout.widget.c cVar = this.p;
        if (cVar != null) {
            cVar.c(fVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.n = i2;
        this.f707h.E1(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public String V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;
        public int a;
        boolean a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f711b;
        boolean b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f712c;
        boolean c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f713d;
        int d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f714e;
        int e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f715f;
        int f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f716g;
        int g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f717h;
        int h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f718i;
        int i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f719j;
        float j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f720k;
        int k0;
        public int l;
        int l0;
        public int m;
        float m0;
        public int n;
        c.g.b.k.e n0;
        public float o;
        public boolean o0;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        private static class a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(i.N1, 8);
                sparseIntArray.append(i.O1, 9);
                sparseIntArray.append(i.Q1, 10);
                sparseIntArray.append(i.R1, 11);
                sparseIntArray.append(i.X1, 12);
                sparseIntArray.append(i.W1, 13);
                sparseIntArray.append(i.v1, 14);
                sparseIntArray.append(i.u1, 15);
                sparseIntArray.append(i.s1, 16);
                sparseIntArray.append(i.w1, 2);
                sparseIntArray.append(i.y1, 3);
                sparseIntArray.append(i.x1, 4);
                sparseIntArray.append(i.f2, 49);
                sparseIntArray.append(i.g2, 50);
                sparseIntArray.append(i.C1, 5);
                sparseIntArray.append(i.D1, 6);
                sparseIntArray.append(i.E1, 7);
                sparseIntArray.append(i.b1, 1);
                sparseIntArray.append(i.S1, 17);
                sparseIntArray.append(i.T1, 18);
                sparseIntArray.append(i.B1, 19);
                sparseIntArray.append(i.A1, 20);
                sparseIntArray.append(i.j2, 21);
                sparseIntArray.append(i.m2, 22);
                sparseIntArray.append(i.k2, 23);
                sparseIntArray.append(i.h2, 24);
                sparseIntArray.append(i.l2, 25);
                sparseIntArray.append(i.i2, 26);
                sparseIntArray.append(i.J1, 29);
                sparseIntArray.append(i.Y1, 30);
                sparseIntArray.append(i.z1, 44);
                sparseIntArray.append(i.L1, 45);
                sparseIntArray.append(i.a2, 46);
                sparseIntArray.append(i.K1, 47);
                sparseIntArray.append(i.Z1, 48);
                sparseIntArray.append(i.q1, 27);
                sparseIntArray.append(i.p1, 28);
                sparseIntArray.append(i.b2, 31);
                sparseIntArray.append(i.F1, 32);
                sparseIntArray.append(i.d2, 33);
                sparseIntArray.append(i.c2, 34);
                sparseIntArray.append(i.e2, 35);
                sparseIntArray.append(i.H1, 36);
                sparseIntArray.append(i.G1, 37);
                sparseIntArray.append(i.I1, 38);
                sparseIntArray.append(i.M1, 39);
                sparseIntArray.append(i.V1, 40);
                sparseIntArray.append(i.P1, 41);
                sparseIntArray.append(i.t1, 42);
                sparseIntArray.append(i.r1, 43);
                a.append(i.U1, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            int i2;
            super(context, attributeSet);
            this.a = -1;
            this.f711b = -1;
            this.f712c = -1.0f;
            this.f713d = -1;
            this.f714e = -1;
            this.f715f = -1;
            this.f716g = -1;
            this.f717h = -1;
            this.f718i = -1;
            this.f719j = -1;
            this.f720k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.g.b.k.e();
            this.o0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = a.a.get(index);
                switch (i4) {
                    case 1:
                        this.S = typedArrayObtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = typedArrayObtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                        }
                        break;
                    case 5:
                        this.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.a);
                        break;
                    case 6:
                        this.f711b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f711b);
                        break;
                    case 7:
                        this.f712c = typedArrayObtainStyledAttributes.getFloat(index, this.f712c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f713d);
                        this.f713d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f713d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f714e);
                        this.f714e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f714e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f715f);
                        this.f715f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f715f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f716g);
                        this.f716g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f716g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f717h);
                        this.f717h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f717h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f718i);
                        this.f718i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f718i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f719j);
                        this.f719j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f719j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f720k);
                        this.f720k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f720k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = typedArrayObtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = typedArrayObtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = typedArrayObtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.I = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.J = i6;
                        if (i6 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                            }
                        }
                        break;
                    case 35:
                        this.O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    case 36:
                        try {
                            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                        break;
                    case 38:
                        this.P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String strSubstring = this.B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i2 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.B.substring(i2);
                                        if (strSubstring2.length() > 0) {
                                            this.C = Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.B.substring(i2, iIndexOf2);
                                        String strSubstring4 = this.B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f3 = Float.parseFloat(strSubstring3);
                                                float f4 = Float.parseFloat(strSubstring4);
                                                if (f3 > 0.0f && f4 > 0.0f) {
                                                    if (this.D == 1) {
                                                        this.C = Math.abs(f4 / f3);
                                                    } else {
                                                        this.C = Math.abs(f3 / f4);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                            case 51:
                                this.V = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Z = false;
            this.W = true;
            this.X = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.W = false;
                if (i2 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.X = false;
                if (i3 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f712c == -1.0f && this.a == -1 && this.f711b == -1) {
                return;
            }
            this.Z = true;
            this.W = true;
            this.X = true;
            if (!(this.n0 instanceof c.g.b.k.g)) {
                this.n0 = new c.g.b.k.g();
            }
            ((c.g.b.k.g) this.n0).j1(this.S);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0052  */
        /* JADX WARN: Code duplicated, block: B:22:0x0059  */
        /* JADX WARN: Code duplicated, block: B:25:0x0060  */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        /* JADX WARN: Code duplicated, block: B:31:0x006c  */
        /* JADX WARN: Code duplicated, block: B:38:0x007e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0086 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0088  */
        /* JADX WARN: Code duplicated, block: B:41:0x008f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:42:0x0091  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i2) {
            boolean z;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i8 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean z2 = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(i2);
                if (1 == getLayoutDirection()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.f0 = -1;
            this.g0 = -1;
            this.d0 = -1;
            this.e0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.h0 = this.t;
            this.i0 = this.v;
            float f2 = this.z;
            this.j0 = f2;
            int i9 = this.a;
            this.k0 = i9;
            int i10 = this.f711b;
            this.l0 = i10;
            float f3 = this.f712c;
            this.m0 = f3;
            if (z) {
                int i11 = this.p;
                if (i11 != -1) {
                    this.f0 = i11;
                } else {
                    int i12 = this.q;
                    if (i12 != -1) {
                        this.g0 = i12;
                    } else {
                        i3 = this.r;
                        if (i3 != -1) {
                            this.e0 = i3;
                            z2 = true;
                        }
                        i4 = this.s;
                        if (i4 != -1) {
                            this.d0 = i4;
                            z2 = true;
                        }
                        i5 = this.x;
                        if (i5 != -1) {
                            this.i0 = i5;
                        }
                        i6 = this.y;
                        if (i6 != -1) {
                            this.h0 = i6;
                        }
                        if (z2) {
                            this.j0 = 1.0f - f2;
                        }
                        if (this.Z && this.S == 1) {
                            if (f3 != -1.0f) {
                                this.m0 = 1.0f - f3;
                                this.k0 = -1;
                                this.l0 = -1;
                            } else if (i9 != -1) {
                                this.l0 = i9;
                                this.k0 = -1;
                                this.m0 = -1.0f;
                            } else if (i10 != -1) {
                                this.k0 = i10;
                                this.l0 = -1;
                                this.m0 = -1.0f;
                            }
                        }
                    }
                }
                z2 = true;
                i3 = this.r;
                if (i3 != -1) {
                    this.e0 = i3;
                    z2 = true;
                }
                i4 = this.s;
                if (i4 != -1) {
                    this.d0 = i4;
                    z2 = true;
                }
                i5 = this.x;
                if (i5 != -1) {
                    this.i0 = i5;
                }
                i6 = this.y;
                if (i6 != -1) {
                    this.h0 = i6;
                }
                if (z2) {
                    this.j0 = 1.0f - f2;
                }
                if (this.Z) {
                    if (f3 != -1.0f) {
                        this.m0 = 1.0f - f3;
                        this.k0 = -1;
                        this.l0 = -1;
                    } else if (i9 != -1) {
                        this.l0 = i9;
                        this.k0 = -1;
                        this.m0 = -1.0f;
                    } else if (i10 != -1) {
                        this.k0 = i10;
                        this.l0 = -1;
                        this.m0 = -1.0f;
                    }
                }
            } else {
                int i13 = this.p;
                if (i13 != -1) {
                    this.e0 = i13;
                }
                int i14 = this.q;
                if (i14 != -1) {
                    this.d0 = i14;
                }
                int i15 = this.r;
                if (i15 != -1) {
                    this.f0 = i15;
                }
                int i16 = this.s;
                if (i16 != -1) {
                    this.g0 = i16;
                }
                int i17 = this.x;
                if (i17 != -1) {
                    this.h0 = i17;
                }
                int i18 = this.y;
                if (i18 != -1) {
                    this.i0 = i18;
                }
            }
            if (this.r == -1 && this.s == -1 && this.q == -1 && this.p == -1) {
                int i19 = this.f715f;
                if (i19 != -1) {
                    this.f0 = i19;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i8 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i8;
                    }
                } else {
                    int i20 = this.f716g;
                    if (i20 != -1) {
                        this.g0 = i20;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i8 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i8;
                        }
                    }
                }
                int i21 = this.f713d;
                if (i21 != -1) {
                    this.d0 = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
                    return;
                }
                int i22 = this.f714e;
                if (i22 != -1) {
                    this.e0 = i22;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i7 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i7;
                }
            }
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.a = -1;
            this.f711b = -1;
            this.f712c = -1.0f;
            this.f713d = -1;
            this.f714e = -1;
            this.f715f = -1;
            this.f716g = -1;
            this.f717h = -1;
            this.f718i = -1;
            this.f719j = -1;
            this.f720k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.g.b.k.e();
            this.o0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = -1;
            this.f711b = -1;
            this.f712c = -1.0f;
            this.f713d = -1;
            this.f714e = -1;
            this.f715f = -1;
            this.f716g = -1;
            this.f717h = -1;
            this.f718i = -1;
            this.f719j = -1;
            this.f720k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = null;
            this.W = true;
            this.X = true;
            this.Y = false;
            this.Z = false;
            this.a0 = false;
            this.b0 = false;
            this.c0 = false;
            this.d0 = -1;
            this.e0 = -1;
            this.f0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = 0.5f;
            this.n0 = new c.g.b.k.e();
            this.o0 = false;
        }
    }
}
