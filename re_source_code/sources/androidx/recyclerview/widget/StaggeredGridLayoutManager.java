package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.y.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d[] f1964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    n f1965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    n f1966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f1969g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BitSet f1972j;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private int[] w;
    private int a = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f1970h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1971i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f1973k = -1;
    int l = Integer.MIN_VALUE;
    LazySpanLookup m = new LazySpanLookup();
    private int n = 2;
    private final Rect s = new Rect();
    private final b t = new b();
    private boolean u = false;
    private boolean v = true;
    private final Runnable x = new a();

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f1981h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int[] f1982i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f1983j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int[] f1984k;
        List<LazySpanLookup.FullSpanItem> l;
        boolean m;
        boolean n;
        boolean o;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState() {
        }

        void a() {
            this.f1982i = null;
            this.f1981h = 0;
            this.f1979f = -1;
            this.f1980g = -1;
        }

        void b() {
            this.f1982i = null;
            this.f1981h = 0;
            this.f1983j = 0;
            this.f1984k = null;
            this.l = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1979f);
            parcel.writeInt(this.f1980g);
            parcel.writeInt(this.f1981h);
            if (this.f1981h > 0) {
                parcel.writeIntArray(this.f1982i);
            }
            parcel.writeInt(this.f1983j);
            if (this.f1983j > 0) {
                parcel.writeIntArray(this.f1984k);
            }
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeList(this.l);
        }

        SavedState(Parcel parcel) {
            this.f1979f = parcel.readInt();
            this.f1980g = parcel.readInt();
            int i2 = parcel.readInt();
            this.f1981h = i2;
            if (i2 > 0) {
                int[] iArr = new int[i2];
                this.f1982i = iArr;
                parcel.readIntArray(iArr);
            }
            int i3 = parcel.readInt();
            this.f1983j = i3;
            if (i3 > 0) {
                int[] iArr2 = new int[i3];
                this.f1984k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.m = parcel.readInt() == 1;
            this.n = parcel.readInt() == 1;
            this.o = parcel.readInt() == 1;
            this.l = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1981h = savedState.f1981h;
            this.f1979f = savedState.f1979f;
            this.f1980g = savedState.f1980g;
            this.f1982i = savedState.f1982i;
            this.f1983j = savedState.f1983j;
            this.f1984k = savedState.f1984k;
            this.m = savedState.m;
            this.n = savedState.n;
            this.o = savedState.o;
            this.l = savedState.l;
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    }

    class b {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1989e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int[] f1990f;

        b() {
            c();
        }

        void a() {
            this.f1986b = this.f1987c ? StaggeredGridLayoutManager.this.f1965c.i() : StaggeredGridLayoutManager.this.f1965c.m();
        }

        void b(int i2) {
            if (this.f1987c) {
                this.f1986b = StaggeredGridLayoutManager.this.f1965c.i() - i2;
            } else {
                this.f1986b = StaggeredGridLayoutManager.this.f1965c.m() + i2;
            }
        }

        void c() {
            this.a = -1;
            this.f1986b = Integer.MIN_VALUE;
            this.f1987c = false;
            this.f1988d = false;
            this.f1989e = false;
            int[] iArr = this.f1990f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f1990f;
            if (iArr == null || iArr.length < length) {
                this.f1990f = new int[StaggeredGridLayoutManager.this.f1964b.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f1990f[i2] = dVarArr[i2].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        d f1992e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1993f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            d dVar = this.f1992e;
            if (dVar == null) {
                return -1;
            }
            return dVar.f1997e;
        }

        public boolean f() {
            return this.f1993f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class d {
        ArrayList<View> a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1994b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1995c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1996d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f1997e;

        d(int i2) {
            this.f1997e = i2;
        }

        void a(View view) {
            c cVarN = n(view);
            cVarN.f1992e = this;
            this.a.add(view);
            this.f1995c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.f1994b = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1996d += StaggeredGridLayoutManager.this.f1965c.e(view);
            }
        }

        void b(boolean z, int i2) {
            int iL = z ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iL >= StaggeredGridLayoutManager.this.f1965c.i()) {
                if (z || iL <= StaggeredGridLayoutManager.this.f1965c.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        iL += i2;
                    }
                    this.f1995c = iL;
                    this.f1994b = iL;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f1995c = StaggeredGridLayoutManager.this.f1965c.d(view);
            if (cVarN.f1993f && (fullSpanItemF = StaggeredGridLayoutManager.this.m.f(cVarN.a())) != null && fullSpanItemF.f1976g == 1) {
                this.f1995c += fullSpanItemF.a(this.f1997e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.a.get(0);
            c cVarN = n(view);
            this.f1994b = StaggeredGridLayoutManager.this.f1965c.g(view);
            if (cVarN.f1993f && (fullSpanItemF = StaggeredGridLayoutManager.this.m.f(cVarN.a())) != null && fullSpanItemF.f1976g == -1) {
                this.f1994b -= fullSpanItemF.a(this.f1997e);
            }
        }

        void e() {
            this.a.clear();
            q();
            this.f1996d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f1970h ? i(this.a.size() - 1, -1, true) : i(0, this.a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f1970h ? i(0, this.a.size(), true) : i(this.a.size() - 1, -1, true);
        }

        int h(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.f1965c.m();
            int i4 = StaggeredGridLayoutManager.this.f1965c.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.a.get(i2);
                int iG = StaggeredGridLayoutManager.this.f1965c.g(view);
                int iD = StaggeredGridLayoutManager.this.f1965c.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i4 : iG > i4;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i4) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iG < iM || iD > i4) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i2 += i5;
            }
            return -1;
        }

        int i(int i2, int i3, boolean z) {
            return h(i2, i3, false, false, z);
        }

        public int j() {
            return this.f1996d;
        }

        int k() {
            int i2 = this.f1995c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f1995c;
        }

        int l(int i2) {
            int i3 = this.f1995c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            c();
            return this.f1995c;
        }

        public View m(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1970h && staggeredGridLayoutManager.getPosition(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1970h && staggeredGridLayoutManager2.getPosition(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f1970h && staggeredGridLayoutManager3.getPosition(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f1970h && staggeredGridLayoutManager4.getPosition(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i2 = this.f1994b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f1994b;
        }

        int p(int i2) {
            int i3 = this.f1994b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            d();
            return this.f1994b;
        }

        void q() {
            this.f1994b = Integer.MIN_VALUE;
            this.f1995c = Integer.MIN_VALUE;
        }

        void r(int i2) {
            int i3 = this.f1994b;
            if (i3 != Integer.MIN_VALUE) {
                this.f1994b = i3 + i2;
            }
            int i4 = this.f1995c;
            if (i4 != Integer.MIN_VALUE) {
                this.f1995c = i4 + i2;
            }
        }

        void s() {
            int size = this.a.size();
            View viewRemove = this.a.remove(size - 1);
            c cVarN = n(viewRemove);
            cVarN.f1992e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f1996d -= StaggeredGridLayoutManager.this.f1965c.e(viewRemove);
            }
            if (size == 1) {
                this.f1994b = Integer.MIN_VALUE;
            }
            this.f1995c = Integer.MIN_VALUE;
        }

        void t() {
            View viewRemove = this.a.remove(0);
            c cVarN = n(viewRemove);
            cVarN.f1992e = null;
            if (this.a.size() == 0) {
                this.f1995c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1996d -= StaggeredGridLayoutManager.this.f1965c.e(viewRemove);
            }
            this.f1994b = Integer.MIN_VALUE;
        }

        void u(View view) {
            c cVarN = n(view);
            cVarN.f1992e = this;
            this.a.add(0, view);
            this.f1994b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.f1995c = Integer.MIN_VALUE;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f1996d += StaggeredGridLayoutManager.this.f1965c.e(view);
            }
        }

        void v(int i2) {
            this.f1994b = i2;
            this.f1995c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.a);
        setSpanCount(properties.f1930b);
        setReverseLayout(properties.f1931c);
        this.f1969g = new i();
        k();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void A(int i2, int i3, int i4) {
        int i5;
        int i6;
        int iU;
        int iU2 = this.f1971i ? u() : t();
        if (i4 == 8) {
            if (i2 < i3) {
                i5 = i3 + 1;
            } else {
                i5 = i2 + 1;
                i6 = i3;
            }
            this.m.h(i6);
            if (i4 != 1) {
                this.m.j(i2, i3);
            } else if (i4 != 2) {
                this.m.k(i2, i3);
            } else if (i4 == 8) {
                this.m.k(i2, 1);
                this.m.j(i3, 1);
            }
            if (i5 <= iU2) {
                return;
            }
            if (this.f1971i) {
                iU = t();
            } else {
                iU = u();
            }
            if (i6 <= iU) {
                requestLayout();
            }
        }
        i5 = i2 + i3;
        i6 = i2;
        this.m.h(i6);
        if (i4 != 1) {
            this.m.j(i2, i3);
        } else if (i4 != 2) {
            this.m.k(i2, i3);
        } else if (i4 == 8) {
            this.m.k(i2, 1);
            this.m.j(i3, 1);
        }
        if (i5 <= iU2) {
            return;
        }
        if (this.f1971i) {
            iU = t();
        } else {
            iU = u();
        }
        if (i6 <= iU) {
            requestLayout();
        }
    }

    private void D(View view, c cVar, boolean z) {
        if (cVar.f1993f) {
            if (this.f1967e == 1) {
                measureChildWithDecorationsAndMargin(view, this.r, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
                return;
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.r, z);
                return;
            }
        }
        if (this.f1967e == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(this.f1968f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.getChildMeasureSpec(this.f1968f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015a  */
    private void E(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        boolean z2;
        SavedState savedState;
        b bVar = this.t;
        if (!(this.q == null && this.f1973k == -1) && zVar.b() == 0) {
            removeAndRecycleAllViews(vVar);
            bVar.c();
            return;
        }
        boolean z3 = (bVar.f1989e && this.f1973k == -1 && this.q == null) ? false : true;
        if (z3) {
            bVar.c();
            if (this.q != null) {
                b(bVar);
            } else {
                resolveShouldLayoutReverse();
                bVar.f1987c = this.f1971i;
            }
            Q(zVar, bVar);
            bVar.f1989e = true;
        }
        if (this.q == null && this.f1973k == -1 && (bVar.f1987c != this.o || isLayoutRTL() != this.p)) {
            this.m.b();
            bVar.f1988d = true;
        }
        if (getChildCount() > 0 && ((savedState = this.q) == null || savedState.f1981h < 1)) {
            if (bVar.f1988d) {
                for (int i2 = 0; i2 < this.a; i2++) {
                    this.f1964b[i2].e();
                    int i3 = bVar.f1986b;
                    if (i3 != Integer.MIN_VALUE) {
                        this.f1964b[i2].v(i3);
                    }
                }
            } else if (z3 || this.t.f1990f == null) {
                for (int i4 = 0; i4 < this.a; i4++) {
                    this.f1964b[i4].b(this.f1971i, bVar.f1986b);
                }
                this.t.d(this.f1964b);
            } else {
                for (int i5 = 0; i5 < this.a; i5++) {
                    d dVar = this.f1964b[i5];
                    dVar.e();
                    dVar.v(this.t.f1990f[i5]);
                }
            }
        }
        detachAndScrapAttachedViews(vVar);
        this.f1969g.a = false;
        this.u = false;
        S(this.f1966d.n());
        R(bVar.a, zVar);
        if (bVar.f1987c) {
            M(-1);
            l(vVar, this.f1969g, zVar);
            M(1);
            i iVar = this.f1969g;
            iVar.f2089c = bVar.a + iVar.f2090d;
            l(vVar, iVar, zVar);
        } else {
            M(1);
            l(vVar, this.f1969g, zVar);
            M(-1);
            i iVar2 = this.f1969g;
            iVar2.f2089c = bVar.a + iVar2.f2090d;
            l(vVar, iVar2, zVar);
        }
        L();
        if (getChildCount() > 0) {
            if (this.f1971i) {
                r(vVar, zVar, true);
                s(vVar, zVar, false);
            } else {
                s(vVar, zVar, true);
                r(vVar, zVar, false);
            }
        }
        if (z && !zVar.e()) {
            if (this.n != 0 && getChildCount() > 0 && (this.u || B() != null)) {
                removeCallbacks(this.x);
                z2 = g();
            }
        }
        if (zVar.e()) {
            this.t.c();
        }
        this.o = bVar.f1987c;
        this.p = isLayoutRTL();
        if (z2) {
            this.t.c();
            E(vVar, zVar, false);
        }
    }

    private boolean F(int i2) {
        if (this.f1967e == 0) {
            return (i2 == -1) != this.f1971i;
        }
        return ((i2 == -1) == this.f1971i) == isLayoutRTL();
    }

    private void H(View view) {
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            this.f1964b[i2].u(view);
        }
    }

    private void I(RecyclerView.v vVar, i iVar) {
        int iMin;
        if (!iVar.a || iVar.f2095i) {
            return;
        }
        if (iVar.f2088b == 0) {
            if (iVar.f2091e == -1) {
                J(vVar, iVar.f2093g);
                return;
            } else {
                K(vVar, iVar.f2092f);
                return;
            }
        }
        if (iVar.f2091e == -1) {
            int i2 = iVar.f2092f;
            int iW = i2 - w(i2);
            J(vVar, iW < 0 ? iVar.f2093g : iVar.f2093g - Math.min(iW, iVar.f2088b));
        } else {
            int iX = x(iVar.f2093g) - iVar.f2093g;
            if (iX < 0) {
                iMin = iVar.f2092f;
            } else {
                iMin = Math.min(iX, iVar.f2088b) + iVar.f2092f;
            }
            K(vVar, iMin);
        }
    }

    private void J(RecyclerView.v vVar, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f1965c.g(childAt) < i2 || this.f1965c.q(childAt) < i2) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f1993f) {
                for (int i3 = 0; i3 < this.a; i3++) {
                    if (this.f1964b[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.a; i4++) {
                    this.f1964b[i4].s();
                }
            } else if (cVar.f1992e.a.size() == 1) {
                return;
            } else {
                cVar.f1992e.s();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    private void K(RecyclerView.v vVar, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f1965c.d(childAt) > i2 || this.f1965c.p(childAt) > i2) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f1993f) {
                for (int i3 = 0; i3 < this.a; i3++) {
                    if (this.f1964b[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.a; i4++) {
                    this.f1964b[i4].t();
                }
            } else if (cVar.f1992e.a.size() == 1) {
                return;
            } else {
                cVar.f1992e.t();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    private void L() {
        if (this.f1966d.k() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            float fE = this.f1966d.e(childAt);
            if (fE >= fMax) {
                if (((c) childAt.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.a;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i3 = this.f1968f;
        int iRound = Math.round(fMax * this.a);
        if (this.f1966d.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f1966d.n());
        }
        S(iRound);
        if (this.f1968f == i3) {
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            c cVar = (c) childAt2.getLayoutParams();
            if (!cVar.f1993f) {
                if (isLayoutRTL() && this.f1967e == 1) {
                    int i5 = this.a;
                    int i6 = cVar.f1992e.f1997e;
                    childAt2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.f1968f) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.f1992e.f1997e;
                    int i8 = this.f1968f * i7;
                    int i9 = i7 * i3;
                    if (this.f1967e == 1) {
                        childAt2.offsetLeftAndRight(i8 - i9);
                    } else {
                        childAt2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    private void M(int i2) {
        i iVar = this.f1969g;
        iVar.f2091e = i2;
        iVar.f2090d = this.f1971i != (i2 == -1) ? -1 : 1;
    }

    private void N(int i2, int i3) {
        for (int i4 = 0; i4 < this.a; i4++) {
            if (!this.f1964b[i4].a.isEmpty()) {
                T(this.f1964b[i4], i2, i3);
            }
        }
    }

    private boolean O(RecyclerView.z zVar, b bVar) {
        bVar.a = this.o ? q(zVar.b()) : m(zVar.b());
        bVar.f1986b = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    private void R(int i2, RecyclerView.z zVar) {
        int iN;
        int iN2;
        int iC;
        i iVar = this.f1969g;
        boolean z = false;
        iVar.f2088b = 0;
        iVar.f2089c = i2;
        if (isSmoothScrolling() && (iC = zVar.c()) != -1) {
            if (this.f1971i == (iC < i2)) {
                iN = this.f1965c.n();
            } else {
                iN2 = this.f1965c.n();
                iN = 0;
            }
            if (getClipToPadding()) {
                this.f1969g.f2092f = this.f1965c.m() - iN2;
                this.f1969g.f2093g = this.f1965c.i() + iN;
            } else {
                this.f1969g.f2093g = this.f1965c.h() + iN;
                this.f1969g.f2092f = -iN2;
            }
            i iVar2 = this.f1969g;
            iVar2.f2094h = false;
            iVar2.a = true;
            if (this.f1965c.k() == 0 && this.f1965c.h() == 0) {
                z = true;
            }
            iVar2.f2095i = z;
        }
        iN = 0;
        iN2 = 0;
        if (getClipToPadding()) {
            this.f1969g.f2092f = this.f1965c.m() - iN2;
            this.f1969g.f2093g = this.f1965c.i() + iN;
        } else {
            this.f1969g.f2093g = this.f1965c.h() + iN;
            this.f1969g.f2092f = -iN2;
        }
        i iVar3 = this.f1969g;
        iVar3.f2094h = false;
        iVar3.a = true;
        if (this.f1965c.k() == 0) {
            z = true;
        }
        iVar3.f2095i = z;
    }

    private void T(d dVar, int i2, int i3) {
        int iJ = dVar.j();
        if (i2 == -1) {
            if (dVar.o() + iJ <= i3) {
                this.f1972j.set(dVar.f1997e, false);
            }
        } else if (dVar.k() - iJ >= i3) {
            this.f1972j.set(dVar.f1997e, false);
        }
    }

    private int U(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private void a(View view) {
        for (int i2 = this.a - 1; i2 >= 0; i2--) {
            this.f1964b[i2].a(view);
        }
    }

    private void b(b bVar) {
        SavedState savedState = this.q;
        int i2 = savedState.f1981h;
        if (i2 > 0) {
            if (i2 == this.a) {
                for (int i3 = 0; i3 < this.a; i3++) {
                    this.f1964b[i3].e();
                    SavedState savedState2 = this.q;
                    int i4 = savedState2.f1982i[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        i4 += savedState2.n ? this.f1965c.i() : this.f1965c.m();
                    }
                    this.f1964b[i3].v(i4);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.q;
                savedState3.f1979f = savedState3.f1980g;
            }
        }
        SavedState savedState4 = this.q;
        this.p = savedState4.o;
        setReverseLayout(savedState4.m);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.q;
        int i5 = savedState5.f1979f;
        if (i5 != -1) {
            this.f1973k = i5;
            bVar.f1987c = savedState5.n;
        } else {
            bVar.f1987c = this.f1971i;
        }
        if (savedState5.f1983j > 1) {
            LazySpanLookup lazySpanLookup = this.m;
            lazySpanLookup.a = savedState5.f1984k;
            lazySpanLookup.f1974b = savedState5.l;
        }
    }

    private int computeScrollExtent(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.a(zVar, this.f1965c, o(!this.v), n(!this.v), this, this.v);
    }

    private int computeScrollOffset(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.b(zVar, this.f1965c, o(!this.v), n(!this.v), this, this.v, this.f1971i);
    }

    private int computeScrollRange(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.c(zVar, this.f1965c, o(!this.v), n(!this.v), this, this.v);
    }

    private int convertFocusDirectionToLayoutDirection(int i2) {
        if (i2 == 1) {
            return (this.f1967e != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.f1967e != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i2 == 17) {
            return this.f1967e == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 == 33) {
            return this.f1967e == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 != 66) {
            return (i2 == 130 && this.f1967e == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1967e == 0 ? 1 : Integer.MIN_VALUE;
    }

    private void e(View view, c cVar, i iVar) {
        if (iVar.f2091e == 1) {
            if (cVar.f1993f) {
                a(view);
                return;
            } else {
                cVar.f1992e.a(view);
                return;
            }
        }
        if (cVar.f1993f) {
            H(view);
        } else {
            cVar.f1992e.u(view);
        }
    }

    private int f(int i2) {
        if (getChildCount() == 0) {
            return this.f1971i ? 1 : -1;
        }
        return (i2 < t()) != this.f1971i ? -1 : 1;
    }

    private boolean h(d dVar) {
        if (this.f1971i) {
            if (dVar.k() < this.f1965c.i()) {
                ArrayList<View> arrayList = dVar.a;
                return !dVar.n(arrayList.get(arrayList.size() - 1)).f1993f;
            }
        } else if (dVar.o() > this.f1965c.m()) {
            return !dVar.n(dVar.a.get(0)).f1993f;
        }
        return false;
    }

    private LazySpanLookup.FullSpanItem i(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1977h = new int[this.a];
        for (int i3 = 0; i3 < this.a; i3++) {
            fullSpanItem.f1977h[i3] = i2 - this.f1964b[i3].l(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem j(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1977h = new int[this.a];
        for (int i3 = 0; i3 < this.a; i3++) {
            fullSpanItem.f1977h[i3] = this.f1964b[i3].p(i2) - i2;
        }
        return fullSpanItem;
    }

    private void k() {
        this.f1965c = n.b(this, this.f1967e);
        this.f1966d = n.b(this, 1 - this.f1967e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int l(RecyclerView.v vVar, i iVar, RecyclerView.z zVar) {
        int i2;
        int iV;
        d dVarZ;
        int iE;
        int i3;
        int iE2;
        int iE3;
        ?? r9 = 0;
        this.f1972j.set(0, this.a, true);
        if (this.f1969g.f2095i) {
            i2 = iVar.f2091e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = iVar.f2091e == 1 ? iVar.f2093g + iVar.f2088b : iVar.f2092f - iVar.f2088b;
        }
        N(iVar.f2091e, i2);
        int i4 = this.f1971i ? this.f1965c.i() : this.f1965c.m();
        boolean z = false;
        while (iVar.a(zVar) && (this.f1969g.f2095i || !this.f1972j.isEmpty())) {
            View viewB = iVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.m.g(iA);
            boolean z2 = iG == -1;
            if (z2) {
                dVarZ = cVar.f1993f ? this.f1964b[r9] : z(iVar);
                this.m.n(iA, dVarZ);
            } else {
                dVarZ = this.f1964b[iG];
            }
            d dVar = dVarZ;
            cVar.f1992e = dVar;
            if (iVar.f2091e == 1) {
                addView(viewB);
            } else {
                addView(viewB, r9);
            }
            D(viewB, cVar, r9);
            if (iVar.f2091e == 1) {
                int iV2 = cVar.f1993f ? v(i4) : dVar.l(i4);
                int iE4 = this.f1965c.e(viewB) + iV2;
                if (z2 && cVar.f1993f) {
                    LazySpanLookup.FullSpanItem fullSpanItemI = i(iV2);
                    fullSpanItemI.f1976g = -1;
                    fullSpanItemI.f1975f = iA;
                    this.m.a(fullSpanItemI);
                }
                i3 = iE4;
                iE = iV2;
            } else {
                int iY = cVar.f1993f ? y(i4) : dVar.p(i4);
                iE = iY - this.f1965c.e(viewB);
                if (z2 && cVar.f1993f) {
                    LazySpanLookup.FullSpanItem fullSpanItemJ = j(iY);
                    fullSpanItemJ.f1976g = 1;
                    fullSpanItemJ.f1975f = iA;
                    this.m.a(fullSpanItemJ);
                }
                i3 = iY;
            }
            if (cVar.f1993f && iVar.f2090d == -1) {
                if (z2) {
                    this.u = true;
                } else {
                    if (!(iVar.f2091e == 1 ? c() : d())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.m.f(iA);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f1978i = true;
                        }
                        this.u = true;
                    }
                }
            }
            e(viewB, cVar, iVar);
            if (isLayoutRTL() && this.f1967e == 1) {
                int i5 = cVar.f1993f ? this.f1966d.i() : this.f1966d.i() - (((this.a - 1) - dVar.f1997e) * this.f1968f);
                iE3 = i5;
                iE2 = i5 - this.f1966d.e(viewB);
            } else {
                int iM = cVar.f1993f ? this.f1966d.m() : (dVar.f1997e * this.f1968f) + this.f1966d.m();
                iE2 = iM;
                iE3 = this.f1966d.e(viewB) + iM;
            }
            if (this.f1967e == 1) {
                layoutDecoratedWithMargins(viewB, iE2, iE, iE3, i3);
            } else {
                layoutDecoratedWithMargins(viewB, iE, iE2, i3, iE3);
            }
            if (cVar.f1993f) {
                N(this.f1969g.f2091e, i2);
            } else {
                T(dVar, this.f1969g.f2091e, i2);
            }
            I(vVar, this.f1969g);
            if (this.f1969g.f2094h && viewB.hasFocusable()) {
                if (cVar.f1993f) {
                    this.f1972j.clear();
                } else {
                    this.f1972j.set(dVar.f1997e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            I(vVar, this.f1969g);
        }
        if (this.f1969g.f2091e == -1) {
            iV = this.f1965c.m() - y(this.f1965c.m());
        } else {
            iV = v(this.f1965c.i()) - this.f1965c.i();
        }
        if (iV > 0) {
            return Math.min(iVar.f2088b, iV);
        }
        return 0;
    }

    private int m(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            int position = getPosition(getChildAt(i3));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private void measureChildWithDecorationsAndMargin(View view, int i2, int i3, boolean z) {
        calculateItemDecorationsForChild(view, this.s);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.s;
        int iU = U(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.s;
        int iU2 = U(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? shouldReMeasureChild(view, iU, iU2, cVar) : shouldMeasureChild(view, iU, iU2, cVar)) {
            view.measure(iU, iU2);
        }
    }

    private int q(int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i2) {
                return position;
            }
        }
        return 0;
    }

    private void r(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i2;
        int iV = v(Integer.MIN_VALUE);
        if (iV != Integer.MIN_VALUE && (i2 = this.f1965c.i() - iV) > 0) {
            int i3 = i2 - (-scrollBy(-i2, vVar, zVar));
            if (!z || i3 <= 0) {
                return;
            }
            this.f1965c.r(i3);
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.f1967e == 1 || !isLayoutRTL()) {
            this.f1971i = this.f1970h;
        } else {
            this.f1971i = !this.f1970h;
        }
    }

    private void s(RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int iM;
        int iY = y(Integer.MAX_VALUE);
        if (iY != Integer.MAX_VALUE && (iM = iY - this.f1965c.m()) > 0) {
            int iScrollBy = iM - scrollBy(iM, vVar, zVar);
            if (!z || iScrollBy <= 0) {
                return;
            }
            this.f1965c.r(-iScrollBy);
        }
    }

    private int v(int i2) {
        int iL = this.f1964b[0].l(i2);
        for (int i3 = 1; i3 < this.a; i3++) {
            int iL2 = this.f1964b[i3].l(i2);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int w(int i2) {
        int iP = this.f1964b[0].p(i2);
        for (int i3 = 1; i3 < this.a; i3++) {
            int iP2 = this.f1964b[i3].p(i2);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int x(int i2) {
        int iL = this.f1964b[0].l(i2);
        for (int i3 = 1; i3 < this.a; i3++) {
            int iL2 = this.f1964b[i3].l(i2);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int y(int i2) {
        int iP = this.f1964b[0].p(i2);
        for (int i3 = 1; i3 < this.a; i3++) {
            int iP2 = this.f1964b[i3].p(i2);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private d z(i iVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (F(iVar.f2091e)) {
            i2 = this.a - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.a;
            i3 = 1;
        }
        d dVar = null;
        if (iVar.f2091e == 1) {
            int i5 = Integer.MAX_VALUE;
            int iM = this.f1965c.m();
            while (i2 != i4) {
                d dVar2 = this.f1964b[i2];
                int iL = dVar2.l(iM);
                if (iL < i5) {
                    dVar = dVar2;
                    i5 = iL;
                }
                i2 += i3;
            }
            return dVar;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = this.f1965c.i();
        while (i2 != i4) {
            d dVar3 = this.f1964b[i2];
            int iP = dVar3.p(i7);
            if (iP > i6) {
                dVar = dVar3;
                i6 = iP;
            }
            i2 += i3;
        }
        return dVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    View B() {
        int i2;
        int i3;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.a);
        bitSet.set(0, this.a, true);
        byte b2 = (this.f1967e == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.f1971i) {
            i2 = -1;
        } else {
            i2 = childCount + 1;
            childCount = 0;
        }
        int i4 = childCount < i2 ? 1 : -1;
        while (childCount != i2) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            if (bitSet.get(cVar.f1992e.f1997e)) {
                if (h(cVar.f1992e)) {
                    return childAt;
                }
                bitSet.clear(cVar.f1992e.f1997e);
            }
            if (!cVar.f1993f && (i3 = childCount + i4) != i2) {
                View childAt2 = getChildAt(i3);
                if (this.f1971i) {
                    int iD = this.f1965c.d(childAt);
                    int iD2 = this.f1965c.d(childAt2);
                    if (iD < iD2) {
                        return childAt;
                    }
                    if (iD == iD2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iG = this.f1965c.g(childAt);
                    int iG2 = this.f1965c.g(childAt2);
                    if (iG > iG2) {
                        return childAt;
                    }
                    if (iG == iG2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((cVar.f1992e.f1997e - ((c) childAt2.getLayoutParams()).f1992e.f1997e < 0) != (b2 < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i4;
        }
        return null;
    }

    public void C() {
        this.m.b();
        requestLayout();
    }

    void G(int i2, RecyclerView.z zVar) {
        int iT;
        int i3;
        if (i2 > 0) {
            iT = u();
            i3 = 1;
        } else {
            iT = t();
            i3 = -1;
        }
        this.f1969g.a = true;
        R(iT, zVar);
        M(i3);
        i iVar = this.f1969g;
        iVar.f2089c = iT + iVar.f2090d;
        iVar.f2088b = Math.abs(i2);
    }

    boolean P(RecyclerView.z zVar, b bVar) {
        int i2;
        if (!zVar.e() && (i2 = this.f1973k) != -1) {
            if (i2 >= 0 && i2 < zVar.b()) {
                SavedState savedState = this.q;
                if (savedState == null || savedState.f1979f == -1 || savedState.f1981h < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.f1973k);
                    if (viewFindViewByPosition != null) {
                        bVar.a = this.f1971i ? u() : t();
                        if (this.l != Integer.MIN_VALUE) {
                            if (bVar.f1987c) {
                                bVar.f1986b = (this.f1965c.i() - this.l) - this.f1965c.d(viewFindViewByPosition);
                            } else {
                                bVar.f1986b = (this.f1965c.m() + this.l) - this.f1965c.g(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f1965c.e(viewFindViewByPosition) > this.f1965c.n()) {
                            bVar.f1986b = bVar.f1987c ? this.f1965c.i() : this.f1965c.m();
                            return true;
                        }
                        int iG = this.f1965c.g(viewFindViewByPosition) - this.f1965c.m();
                        if (iG < 0) {
                            bVar.f1986b = -iG;
                            return true;
                        }
                        int i3 = this.f1965c.i() - this.f1965c.d(viewFindViewByPosition);
                        if (i3 < 0) {
                            bVar.f1986b = i3;
                            return true;
                        }
                        bVar.f1986b = Integer.MIN_VALUE;
                    } else {
                        int i4 = this.f1973k;
                        bVar.a = i4;
                        int i5 = this.l;
                        if (i5 == Integer.MIN_VALUE) {
                            bVar.f1987c = f(i4) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i5);
                        }
                        bVar.f1988d = true;
                    }
                } else {
                    bVar.f1986b = Integer.MIN_VALUE;
                    bVar.a = this.f1973k;
                }
                return true;
            }
            this.f1973k = -1;
            this.l = Integer.MIN_VALUE;
        }
        return false;
    }

    void Q(RecyclerView.z zVar, b bVar) {
        if (P(zVar, bVar) || O(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    void S(int i2) {
        this.f1968f = i2 / this.a;
        this.r = View.MeasureSpec.makeMeasureSpec(i2, this.f1966d.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    boolean c() {
        int iL = this.f1964b[0].l(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.a; i2++) {
            if (this.f1964b[i2].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.f1967e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.f1967e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f1967e != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        G(i2, zVar);
        int[] iArr = this.w;
        if (iArr == null || iArr.length < this.a) {
            this.w = new int[this.a];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.a; i5++) {
            i iVar = this.f1969g;
            if (iVar.f2090d == -1) {
                iL = iVar.f2092f;
                iP = this.f1964b[i5].p(iL);
            } else {
                iL = this.f1964b[i5].l(iVar.f2093g);
                iP = this.f1969g.f2093g;
            }
            int i6 = iL - iP;
            if (i6 >= 0) {
                this.w[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.w, 0, i4);
        for (int i7 = 0; i7 < i4 && this.f1969g.a(zVar); i7++) {
            cVar.a(this.f1969g.f2089c, this.w[i7]);
            i iVar2 = this.f1969g;
            iVar2.f2089c += iVar2.f2090d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF computeScrollVectorForPosition(int i2) {
        int iF = f(i2);
        PointF pointF = new PointF();
        if (iF == 0) {
            return null;
        }
        if (this.f1967e == 0) {
            pointF.x = iF;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iF;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    boolean d() {
        int iP = this.f1964b[0].p(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.a; i2++) {
            if (this.f1964b[i2].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    boolean g() {
        int iT;
        int iU;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f1971i) {
            iT = u();
            iU = t();
        } else {
            iT = t();
            iU = u();
        }
        if (iT == 0 && B() != null) {
            this.m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.u) {
            return false;
        }
        int i2 = this.f1971i ? -1 : 1;
        int i3 = iU + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.m.e(iT, i3, i2, true);
        if (fullSpanItemE == null) {
            this.u = false;
            this.m.d(i3);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.m.e(iT, fullSpanItemE.f1975f, i2 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.m.d(fullSpanItemE.f1975f);
        } else {
            this.m.d(fullSpanItemE2.f1975f + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return this.f1967e == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f1967e == 1 ? this.a : super.getColumnCountForAccessibility(vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f1967e == 0 ? this.a : super.getRowCountForAccessibility(vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    View n(boolean z) {
        int iM = this.f1965c.m();
        int i2 = this.f1965c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iG = this.f1965c.g(childAt);
            int iD = this.f1965c.d(childAt);
            if (iD > iM && iG < i2) {
                if (iD <= i2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View o(boolean z) {
        int iM = this.f1965c.m();
        int i2 = this.f1965c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int iG = this.f1965c.g(childAt);
            if (this.f1965c.d(childAt) > iM && iG < i2) {
                if (iG >= iM || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.a; i3++) {
            this.f1964b[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.a; i3++) {
            this.f1964b[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        removeCallbacks(this.x);
        for (int i2 = 0; i2 < this.a; i2++) {
            this.f1964b[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        View viewFindContainingItemView;
        View viewM;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewFindContainingItemView.getLayoutParams();
        boolean z = cVar.f1993f;
        d dVar = cVar.f1992e;
        int iU = iConvertFocusDirectionToLayoutDirection == 1 ? u() : t();
        R(iU, zVar);
        M(iConvertFocusDirectionToLayoutDirection);
        i iVar = this.f1969g;
        iVar.f2089c = iVar.f2090d + iU;
        iVar.f2088b = (int) (this.f1965c.n() * 0.33333334f);
        i iVar2 = this.f1969g;
        iVar2.f2094h = true;
        iVar2.a = false;
        l(vVar, iVar2, zVar);
        this.o = this.f1971i;
        if (!z && (viewM = dVar.m(iU, iConvertFocusDirectionToLayoutDirection)) != null && viewM != viewFindContainingItemView) {
            return viewM;
        }
        if (F(iConvertFocusDirectionToLayoutDirection)) {
            for (int i3 = this.a - 1; i3 >= 0; i3--) {
                View viewM2 = this.f1964b[i3].m(iU, iConvertFocusDirectionToLayoutDirection);
                if (viewM2 != null && viewM2 != viewFindContainingItemView) {
                    return viewM2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.a; i4++) {
                View viewM3 = this.f1964b[i4].m(iU, iConvertFocusDirectionToLayoutDirection);
                if (viewM3 != null && viewM3 != viewFindContainingItemView) {
                    return viewM3;
                }
            }
        }
        boolean z2 = (this.f1970h ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            View viewFindViewByPosition = findViewByPosition(z2 ? dVar.f() : dVar.g());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (F(iConvertFocusDirectionToLayoutDirection)) {
            for (int i5 = this.a - 1; i5 >= 0; i5--) {
                if (i5 != dVar.f1997e) {
                    View viewFindViewByPosition2 = findViewByPosition(z2 ? this.f1964b[i5].f() : this.f1964b[i5].g());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.a; i6++) {
                View viewFindViewByPosition3 = findViewByPosition(z2 ? this.f1964b[i6].f() : this.f1964b[i6].g());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewO = o(false);
            View viewN = n(false);
            if (viewO == null || viewN == null) {
                return;
            }
            int position = getPosition(viewO);
            int position2 = getPosition(viewN);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.z zVar, View view, androidx.core.view.d0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.f1967e == 0) {
            cVar.b0(androidx.core.view.d0.c.C0025c.f(cVar2.e(), cVar2.f1993f ? this.a : 1, -1, -1, false, false));
        } else {
            cVar.b0(androidx.core.view.d0.c.C0025c.f(-1, -1, cVar2.e(), cVar2.f1993f ? this.a : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        A(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        A(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        A(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        A(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        E(vVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.f1973k = -1;
        this.l = Integer.MIN_VALUE;
        this.q = null;
        this.t.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        int iP;
        int iM;
        int[] iArr;
        if (this.q != null) {
            return new SavedState(this.q);
        }
        SavedState savedState = new SavedState();
        savedState.m = this.f1970h;
        savedState.n = this.o;
        savedState.o = this.p;
        LazySpanLookup lazySpanLookup = this.m;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.a) == null) {
            savedState.f1983j = 0;
        } else {
            savedState.f1984k = iArr;
            savedState.f1983j = iArr.length;
            savedState.l = lazySpanLookup.f1974b;
        }
        if (getChildCount() > 0) {
            savedState.f1979f = this.o ? u() : t();
            savedState.f1980g = p();
            int i2 = this.a;
            savedState.f1981h = i2;
            savedState.f1982i = new int[i2];
            for (int i3 = 0; i3 < this.a; i3++) {
                if (this.o) {
                    iP = this.f1964b[i3].l(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f1965c.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.f1964b[i3].p(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f1965c.m();
                        iP -= iM;
                    }
                }
                savedState.f1982i[i3] = iP;
            }
        } else {
            savedState.f1979f = -1;
            savedState.f1980g = -1;
            savedState.f1981h = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            g();
        }
    }

    int p() {
        View viewN = this.f1971i ? n(true) : o(true);
        if (viewN == null) {
            return -1;
        }
        return getPosition(viewN);
    }

    int scrollBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        G(i2, zVar);
        int iL = l(vVar, this.f1969g, zVar);
        if (this.f1969g.f2088b >= iL) {
            i2 = i2 < 0 ? -iL : iL;
        }
        this.f1965c.r(-i2);
        this.o = this.f1971i;
        i iVar = this.f1969g;
        iVar.f2088b = 0;
        I(vVar, iVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i2) {
        SavedState savedState = this.q;
        if (savedState != null && savedState.f1979f != i2) {
            savedState.a();
        }
        this.f1973k = i2;
        this.l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f1967e == 1) {
            iChooseSize2 = RecyclerView.o.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = RecyclerView.o.chooseSize(i2, (this.f1968f * this.a) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView.o.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = RecyclerView.o.chooseSize(i3, (this.f1968f * this.a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i2 == this.f1967e) {
            return;
        }
        this.f1967e = i2;
        n nVar = this.f1965c;
        this.f1965c = this.f1966d;
        this.f1966d = nVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.q;
        if (savedState != null && savedState.m != z) {
            savedState.m = z;
        }
        this.f1970h = z;
        requestLayout();
    }

    public void setSpanCount(int i2) {
        assertNotInLayoutOrScroll(null);
        if (i2 != this.a) {
            C();
            this.a = i2;
            this.f1972j = new BitSet(this.a);
            this.f1964b = new d[this.a];
            for (int i3 = 0; i3 < this.a; i3++) {
                this.f1964b[i3] = new d(i3);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i2);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    int t() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    int u() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    static class LazySpanLookup {
        int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<FullSpanItem> f1974b;

        LazySpanLookup() {
        }

        private int i(int i2) {
            if (this.f1974b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i2);
            if (fullSpanItemF != null) {
                this.f1974b.remove(fullSpanItemF);
            }
            int size = this.f1974b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (this.f1974b.get(i3).f1975f >= i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f1974b.get(i3);
            this.f1974b.remove(i3);
            return fullSpanItem.f1975f;
        }

        private void l(int i2, int i3) {
            List<FullSpanItem> list = this.f1974b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1974b.get(size);
                int i4 = fullSpanItem.f1975f;
                if (i4 >= i2) {
                    fullSpanItem.f1975f = i4 + i3;
                }
            }
        }

        private void m(int i2, int i3) {
            List<FullSpanItem> list = this.f1974b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1974b.get(size);
                int i5 = fullSpanItem.f1975f;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f1974b.remove(size);
                    } else {
                        fullSpanItem.f1975f = i5 - i3;
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1974b == null) {
                this.f1974b = new ArrayList();
            }
            int size = this.f1974b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f1974b.get(i2);
                if (fullSpanItem2.f1975f == fullSpanItem.f1975f) {
                    this.f1974b.remove(i2);
                }
                if (fullSpanItem2.f1975f >= fullSpanItem.f1975f) {
                    this.f1974b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f1974b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1974b = null;
        }

        void c(int i2) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i2) {
            List<FullSpanItem> list = this.f1974b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1974b.get(size).f1975f >= i2) {
                        this.f1974b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public FullSpanItem e(int i2, int i3, int i4, boolean z) {
            List<FullSpanItem> list = this.f1974b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f1974b.get(i5);
                int i6 = fullSpanItem.f1975f;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || fullSpanItem.f1976g == i4 || (z && fullSpanItem.f1978i))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i2) {
            List<FullSpanItem> list = this.f1974b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1974b.get(size);
                if (fullSpanItem.f1975f == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i2) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        int h(int i2) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.a.length;
            }
            int i4 = i3 + 1;
            Arrays.fill(this.a, i2, i4, -1);
            return i4;
        }

        void j(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.a, i2, i4, -1);
            l(i2, i3);
        }

        void k(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            m(i2, i3);
        }

        void n(int i2, d dVar) {
            c(i2);
            this.a[i2] = dVar.f1997e;
        }

        int o(int i2) {
            int length = this.a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f1975f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f1976g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int[] f1977h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            boolean f1978i;

            static class a implements Parcelable.Creator<FullSpanItem> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f1975f = parcel.readInt();
                this.f1976g = parcel.readInt();
                this.f1978i = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    this.f1977h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i2) {
                int[] iArr = this.f1977h;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1975f + ", mGapDir=" + this.f1976g + ", mHasUnwantedGapAfter=" + this.f1978i + ", mGapPerSpan=" + Arrays.toString(this.f1977h) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f1975f);
                parcel.writeInt(this.f1976g);
                parcel.writeInt(this.f1978i ? 1 : 0);
                int[] iArr = this.f1977h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1977h);
                }
            }

            FullSpanItem() {
            }
        }
    }
}
