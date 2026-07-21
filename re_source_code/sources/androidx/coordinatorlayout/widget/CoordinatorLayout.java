package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.c0;
import androidx.core.view.l;
import androidx.core.view.m;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements l, m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Class<?>[] f813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<c>>> f814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Comparator<View> f815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final c.i.j.f<Rect> f816j;
    private Drawable A;
    ViewGroup.OnHierarchyChangeListener B;
    private p C;
    private final o D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<View> f817k;
    private final androidx.coordinatorlayout.widget.a<View> l;
    private final List<View> m;
    private final List<View> n;
    private Paint o;
    private final int[] p;
    private final int[] q;
    private boolean r;
    private boolean s;
    private int[] t;
    private View u;
    private View v;
    private g w;
    private boolean x;
    private c0 y;
    private boolean z;

    class a implements p {
        a() {
        }

        @Override // androidx.core.view.p
        public c0 a(View view, c0 c0Var) {
            return CoordinatorLayout.this.W(c0Var);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return z(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                B(coordinatorLayout, v, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public c0 f(CoordinatorLayout coordinatorLayout, V v, c0 c0Var) {
            return c0Var;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                p(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                r(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            s(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                u(coordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.B;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.B;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class h implements Comparator<View> {
        h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fI = u.I(view);
            float fI2 = u.I(view2);
            if (fI > fI2) {
                return -1;
            }
            return fI < fI2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f812f = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f815i = new h();
        } else {
            f815i = null;
        }
        f813g = new Class[]{Context.class, AttributeSet.class};
        f814h = new ThreadLocal<>();
        f816j = new c.i.j.h(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.h.a.a);
    }

    private boolean A(View view) {
        return this.l.j(view);
    }

    private void C(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.y != null && u.v(this) && !u.v(view)) {
            rectA.left += this.y.i();
            rectA.top += this.y.k();
            rectA.right -= this.y.j();
            rectA.bottom -= this.y.h();
        }
        Rect rectA2 = a();
        androidx.core.view.d.a(S(fVar.f821c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i2);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        O(rectA);
        O(rectA2);
    }

    private void D(View view, View view2, int i2) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            t(view2, rectA);
            u(view, i2, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            O(rectA);
            O(rectA2);
        }
    }

    private void E(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int iB = androidx.core.view.d.b(T(fVar.f821c), i3);
        int i4 = iB & 7;
        int i5 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int iW = w(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            iW += measuredWidth / 2;
        } else if (i4 == 5) {
            iW += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iW, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void F(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (u.O(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            O(rectA2);
            if (rectA.isEmpty()) {
                O(rectA);
                return;
            }
            int iB = androidx.core.view.d.b(fVar.f826h, i2);
            boolean z3 = true;
            if ((iB & 48) != 48 || (i7 = (rectA.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f828j) >= (i8 = rect.top)) {
                z = false;
            } else {
                V(view, i8 - i7);
                z = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f828j) < (i6 = rect.bottom)) {
                V(view, height - i6);
                z = true;
            }
            if (!z) {
                V(view, 0);
            }
            if ((iB & 3) != 3 || (i4 = (rectA.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f827i) >= (i5 = rect.left)) {
                z2 = false;
            } else {
                U(view, i5 - i4);
                z2 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f827i) >= (i3 = rect.right)) {
                z3 = z2;
            } else {
                U(view, width - i3);
            }
            if (!z3) {
                U(view, 0);
            }
            O(rectA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f812f;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f814h;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f813g);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean L(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.m;
        z(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(zK || z) || actionMasked == 0) {
                if (!zK && cVarF != null) {
                    if (i2 == 0) {
                        zK = cVarF.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        zK = cVarF.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.u = view;
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z = zI && !zC;
                if (zI && !z) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    cVarF.k(this, view, motionEventObtain);
                } else if (i2 == 1) {
                    cVarF.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    private void M() {
        this.f817k.clear();
        this.l.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f fVarY = y(childAt);
            fVarY.d(this, childAt);
            this.l.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (fVarY.b(this, childAt, childAt2)) {
                        if (!this.l.d(childAt2)) {
                            this.l.b(childAt2);
                        }
                        this.l.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f817k.addAll(this.l.i());
        Collections.reverse(this.f817k);
    }

    private static void O(Rect rect) {
        rect.setEmpty();
        f816j.a(rect);
    }

    private void Q(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    cVarF.k(this, childAt, motionEventObtain);
                } else {
                    cVarF.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m();
        }
        this.u = null;
        this.r = false;
    }

    private static int R(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int S(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int T(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void U(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f827i;
        if (i3 != i2) {
            u.T(view, i2 - i3);
            fVar.f827i = i2;
        }
    }

    private void V(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f828j;
        if (i3 != i2) {
            u.U(view, i2 - i3);
            fVar.f828j = i2;
        }
    }

    private void X() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!u.v(this)) {
            u.v0(this, null);
            return;
        }
        if (this.C == null) {
            this.C = new a();
        }
        u.v0(this, this.C);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rectB = f816j.b();
        return rectB == null ? new Rect() : rectB;
    }

    private static int c(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i3;
        }
        return i2 > i4 ? i4 : i2;
    }

    private void d(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    private c0 e(c0 c0Var) {
        c cVarF;
        if (c0Var.n()) {
            return c0Var;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (u.v(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                c0Var = cVarF.f(this, childAt, c0Var);
                if (c0Var.n()) {
                    break;
                }
            }
        }
        return c0Var;
    }

    private void v(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int iWidth;
        int iHeight;
        int iB = androidx.core.view.d.b(R(fVar.f821c), i2);
        int iB2 = androidx.core.view.d.b(S(fVar.f822d), i2);
        int i5 = iB & 7;
        int i6 = iB & 112;
        int i7 = iB2 & 7;
        int i8 = iB2 & 112;
        if (i7 != 1) {
            iWidth = i7 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i8 != 16) {
            iHeight = i8 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i5 == 1) {
            iWidth -= i3 / 2;
        } else if (i5 != 5) {
            iWidth -= i3;
        }
        if (i6 == 16) {
            iHeight -= i4 / 2;
        } else if (i6 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    private int w(int i2) {
        int[] iArr = this.t;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        }
        if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
        return 0;
    }

    private void z(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = f815i;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(View view, int i2, int i3) {
        Rect rectA = a();
        t(view, rectA);
        try {
            return rectA.contains(i2, i3);
        } finally {
            O(rectA);
        }
    }

    void G(View view, int i2) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f829k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            t(fVar.f829k, rectA);
            q(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            v(view, i2, rectA, rectA3, fVar, measuredWidth, measuredHeight);
            boolean z = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(fVar, rectA3, measuredWidth, measuredHeight);
            int i3 = rectA3.left - rectA2.left;
            int i4 = rectA3.top - rectA2.top;
            if (i3 != 0) {
                u.T(view, i3);
            }
            if (i4 != 0) {
                u.U(view, i4);
            }
            if (z && (cVarF = fVar.f()) != null) {
                cVarF.h(this, view, fVar.f829k);
            }
            O(rectA);
            O(rectA2);
            O(rectA3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    final void H(int i2) {
        int i3;
        c cVarF;
        boolean zH;
        int iY = u.y(this);
        int size = this.f817k.size();
        Rect rectA = a();
        Rect rectA2 = a();
        Rect rectA3 = a();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.f817k.get(i4);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (fVar.l == this.f817k.get(i5)) {
                        G(view, iY);
                    }
                }
                q(view, true, rectA2);
                if (fVar.f825g != 0 && !rectA2.isEmpty()) {
                    int iB = androidx.core.view.d.b(fVar.f825g, iY);
                    int i6 = iB & 112;
                    if (i6 == 48) {
                        rectA.top = Math.max(rectA.top, rectA2.bottom);
                    } else if (i6 == 80) {
                        rectA.bottom = Math.max(rectA.bottom, getHeight() - rectA2.top);
                    }
                    int i7 = iB & 7;
                    if (i7 == 3) {
                        rectA.left = Math.max(rectA.left, rectA2.right);
                    } else if (i7 == 5) {
                        rectA.right = Math.max(rectA.right, getWidth() - rectA2.left);
                    }
                }
                if (fVar.f826h != 0 && view.getVisibility() == 0) {
                    F(view, rectA, iY);
                }
                if (i2 != 2) {
                    x(view, rectA3);
                    if (!rectA3.equals(rectA2)) {
                        N(view, rectA2);
                        for (i3 = i4 + 1; i3 < size; i3++) {
                            View view2 = this.f817k.get(i3);
                            f fVar2 = (f) view2.getLayoutParams();
                            cVarF = fVar2.f();
                            if (cVarF == null && cVarF.e(this, view2, view)) {
                                if (i2 == 0 && fVar2.g()) {
                                    fVar2.k();
                                } else {
                                    if (i2 != 2) {
                                        zH = cVarF.h(this, view2, view);
                                    } else {
                                        cVarF.i(this, view2, view);
                                        zH = true;
                                    }
                                    if (i2 == 1) {
                                        fVar2.p(zH);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i3 < size) {
                        View view3 = this.f817k.get(i3);
                        f fVar3 = (f) view3.getLayoutParams();
                        cVarF = fVar3.f();
                        if (cVarF == null) {
                        }
                    }
                }
            }
        }
        O(rectA);
        O(rectA2);
        O(rectA3);
    }

    public void I(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f829k;
        if (view2 != null) {
            D(view, view2, i2);
            return;
        }
        int i3 = fVar.f823e;
        if (i3 >= 0) {
            E(view, i3, i2);
        } else {
            C(view, i2);
        }
    }

    public void J(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    void P() {
        if (this.s && this.w != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.w);
        }
        this.x = false;
    }

    final c0 W(c0 c0Var) {
        if (c.i.j.d.a(this.y, c0Var)) {
            return c0Var;
        }
        this.y = c0Var;
        boolean z = c0Var != null && c0Var.k() > 0;
        this.z = z;
        setWillNotDraw(!z && getBackground() == null);
        c0 c0VarE = e(c0Var);
        requestLayout();
        return c0VarE;
    }

    void b() {
        if (this.s) {
            if (this.w == null) {
                this.w = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.w);
        }
        this.x = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.a;
        if (cVar != null) {
            float fD = cVar.d(this, view);
            if (fD > 0.0f) {
                if (this.o == null) {
                    this.o = new Paint();
                }
                this.o.setColor(fVar.a.c(this, view));
                this.o.setAlpha(c(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.o);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.A;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public void f(View view) {
        List listG = this.l.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < listG.size(); i2++) {
            View view2 = (View) listG.get(i2);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.h(this, view2, view);
            }
        }
    }

    void g() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (A(getChildAt(i2))) {
                z = true;
                break;
            }
        }
        if (z != this.x) {
            if (z) {
                b();
            } else {
                P();
            }
        }
    }

    final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f817k);
    }

    public final c0 getLastWindowInsets() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.D.a();
    }

    public Drawable getStatusBarBackground() {
        return this.A;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // androidx.core.view.m
    public void j(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVarF;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i6) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.p;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.t(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.p;
                    iMax = i4 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i5 > 0 ? Math.max(iMax2, this.p[1]) : Math.min(iMax2, this.p[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            H(1);
        }
    }

    @Override // androidx.core.view.l
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
        j(view, i2, i3, i4, i5, 0, this.q);
    }

    @Override // androidx.core.view.l
    public boolean l(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zA = cVarF.A(this, childAt, view, view2, i2, i3);
                    z |= zA;
                    fVar.r(i3, zA);
                } else {
                    fVar.r(i3, false);
                }
            }
        }
        return z;
    }

    @Override // androidx.core.view.l
    public void m(View view, View view2, int i2, int i3) {
        c cVarF;
        this.D.c(view, view2, i2, i3);
        this.v = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i3) && (cVarF = fVar.f()) != null) {
                cVarF.v(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // androidx.core.view.l
    public void n(View view, int i2) {
        this.D.e(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i2)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.C(this, childAt, view, i2);
                }
                fVar.l(i2);
                fVar.k();
            }
        }
        this.v = null;
    }

    @Override // androidx.core.view.l
    public void o(View view, int i2, int i3, int[] iArr, int i4) {
        c cVarF;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i4) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.p;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.p;
                    iMax = i2 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.p;
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            H(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.x) {
            if (this.w == null) {
                this.w = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.w);
        }
        if (this.y == null && u.v(this)) {
            u.f0(this);
        }
        this.s = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.x && this.w != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.w);
        }
        View view = this.v;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.s = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.z || this.A == null) {
            return;
        }
        c0 c0Var = this.y;
        int iK = c0Var != null ? c0Var.k() : 0;
        if (iK > 0) {
            this.A.setBounds(0, 0, getWidth(), iK);
            this.A.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean zL = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return zL;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c cVarF;
        int iY = u.y(this);
        int size = this.f817k.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f817k.get(i6);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.l(this, view, iY))) {
                I(view, iY);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x011d  */
    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        c cVarF;
        f fVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        M();
        g();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iY = u.y(this);
        boolean z = iY == 1;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i11 = paddingLeft + paddingRight;
        int i12 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.y != null && u.v(this);
        int size3 = this.f817k.size();
        int i13 = suggestedMinimumWidth;
        int i14 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i15 = 0;
        while (i15 < size3) {
            View view = this.f817k.get(i15);
            if (view.getVisibility() == 8) {
                i9 = i15;
                i6 = size3;
                i7 = paddingLeft;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                int i16 = fVar2.f823e;
                if (i16 < 0 || mode == 0) {
                    i4 = iCombineMeasuredStates;
                } else {
                    int iW = w(i16);
                    int iB = androidx.core.view.d.b(T(fVar2.f821c), iY) & 7;
                    i4 = iCombineMeasuredStates;
                    if ((iB == 3 && !z) || (iB == 5 && z)) {
                        iMax = Math.max(0, (size - paddingRight) - iW);
                    } else if ((iB == 5 && !z) || (iB == 3 && z)) {
                        iMax = Math.max(0, iW - paddingLeft);
                    }
                    if (z2 || u.v(view)) {
                        iMakeMeasureSpec = i2;
                        iMakeMeasureSpec2 = i3;
                    } else {
                        int i17 = this.y.i() + this.y.j();
                        int iK = this.y.k() + this.y.h();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - i17, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iK, mode2);
                    }
                    cVarF = fVar2.f();
                    if (cVarF != null) {
                        fVar = fVar2;
                        i8 = i4;
                        i9 = i15;
                        i5 = i14;
                        i7 = paddingLeft;
                        i10 = i13;
                        i6 = size3;
                        if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i10, i11 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin + ((ViewGroup.MarginLayoutParams) fVar3).rightMargin);
                        int iMax3 = Math.max(i5, i12 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin + ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(i8, view.getMeasuredState());
                        i13 = iMax2;
                        i14 = iMax3;
                    } else {
                        fVar = fVar2;
                        i5 = i14;
                        i6 = size3;
                        i7 = paddingLeft;
                        i8 = i4;
                        i9 = i15;
                        i10 = i13;
                    }
                    J(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i10, i11 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin + ((ViewGroup.MarginLayoutParams) fVar4).rightMargin);
                    int iMax5 = Math.max(i5, i12 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin + ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i8, view.getMeasuredState());
                    i13 = iMax4;
                    i14 = iMax5;
                }
                iMax = 0;
                if (z2) {
                    iMakeMeasureSpec = i2;
                    iMakeMeasureSpec2 = i3;
                } else {
                    iMakeMeasureSpec = i2;
                    iMakeMeasureSpec2 = i3;
                }
                cVarF = fVar2.f();
                if (cVarF != null) {
                    fVar = fVar2;
                    i8 = i4;
                    i9 = i15;
                    i5 = i14;
                    i7 = paddingLeft;
                    i10 = i13;
                    i6 = size3;
                    if (!cVarF.m(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i10, i11 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar5).leftMargin + ((ViewGroup.MarginLayoutParams) fVar5).rightMargin);
                    int iMax7 = Math.max(i5, i12 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar5).topMargin + ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(i8, view.getMeasuredState());
                    i13 = iMax6;
                    i14 = iMax7;
                } else {
                    fVar = fVar2;
                    i5 = i14;
                    i6 = size3;
                    i7 = paddingLeft;
                    i8 = i4;
                    i9 = i15;
                    i10 = i13;
                }
                J(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i10, i11 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) fVar6).leftMargin + ((ViewGroup.MarginLayoutParams) fVar6).rightMargin);
                int iMax9 = Math.max(i5, i12 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) fVar6).topMargin + ((ViewGroup.MarginLayoutParams) fVar6).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i8, view.getMeasuredState());
                i13 = iMax8;
                i14 = iMax9;
            }
            i15 = i9 + 1;
            paddingLeft = i7;
            size3 = i6;
        }
        int i18 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i13, i2, (-16777216) & i18), View.resolveSizeAndState(i14, i3, i18 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        c cVarF;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zN |= cVarF.n(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (zN) {
            H(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c cVarF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zO |= cVarF.o(this, childAt, view, f2, f3);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        o(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        k(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        m(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f818h;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVarF = y(childAt).f();
            if (id != -1 && cVarF != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVarF.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && cVarF != null && (parcelableY = cVarF.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        savedState.f818h = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return l(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.n
    public void onStopNestedScroll(View view) {
        n(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r3
      0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zL;
        boolean zD;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.u == null) {
            zL = L(motionEvent, 1);
            if (!zL) {
                zD = false;
            }
            motionEventObtain = null;
            if (this.u == null) {
                zD |= super.onTouchEvent(motionEvent);
            } else if (zL) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                Q(false);
            }
            return zD;
        }
        zL = false;
        c cVarF = ((f) this.u.getLayoutParams()).f();
        if (cVarF != null) {
            zD = cVarF.D(this, this.u, motionEvent);
        } else {
            zD = false;
        }
        motionEventObtain = null;
        if (this.u == null) {
            zD |= super.onTouchEvent(motionEvent);
        } else if (zL) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            Q(false);
        } else {
            Q(false);
        }
        return zD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void q(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> r(View view) {
        List<View> listH = this.l.h(view);
        this.n.clear();
        if (listH != null) {
            this.n.addAll(listH);
        }
        return this.n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.w(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.r) {
            return;
        }
        Q(false);
        this.r = true;
    }

    public List<View> s(View view) {
        List listG = this.l.g(view);
        this.n.clear();
        if (listG != null) {
            this.n.addAll(listG);
        }
        return this.n;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        X();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.B = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.A;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.A = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.A.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.A, u.y(this));
                this.A.setVisible(getVisibility() == 0, false);
                this.A.setCallback(this);
            }
            u.Z(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.a.f(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.A;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.A.setVisible(z, false);
    }

    void t(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void u(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A;
    }

    void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f820b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f820b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.f820b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f817k = new ArrayList();
        this.l = new androidx.coordinatorlayout.widget.a<>();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.p = new int[2];
        this.q = new int[2];
        this.D = new o(this);
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, c.h.c.f3156b, 0, c.h.b.a) : context.obtainStyledAttributes(attributeSet, c.h.c.f3156b, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, c.h.c.f3156b, attributeSet, typedArrayObtainStyledAttributes, 0, c.h.b.a);
            } else {
                saveAttributeDataForStyleable(context, c.h.c.f3156b, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(c.h.c.f3157c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.t = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.t.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.t;
                iArr[i3] = (int) (iArr[i3] * f2);
            }
        }
        this.A = typedArrayObtainStyledAttributes.getDrawable(c.h.c.f3158d);
        typedArrayObtainStyledAttributes.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (u.w(this) == 0) {
            u.t0(this, 1);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SparseArray<Parcelable> f818h;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i2 = parcel.readInt();
            int[] iArr = new int[i2];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f818h = new SparseArray<>(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f818h.append(iArr[i3], parcelableArray[i3]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f818h;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f818h.keyAt(i3);
                parcelableArr[i3] = this.f818h.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {
        c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f823e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f827i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f828j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        View f829k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public f(int i2, int i3) {
            super(i2, i3);
            this.f820b = false;
            this.f821c = 0;
            this.f822d = 0;
            this.f823e = -1;
            this.f824f = -1;
            this.f825g = 0;
            this.f826h = 0;
            this.q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f824f);
            this.f829k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.f829k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f824f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.l = null;
                this.f829k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.l = null;
                    this.f829k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.l = viewFindViewById;
        }

        private boolean s(View view, int i2) {
            int iB = androidx.core.view.d.b(((f) view.getLayoutParams()).f825g, i2);
            return iB != 0 && (androidx.core.view.d.b(this.f826h, i2) & iB) == iB;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f829k.getId() != this.f824f) {
                return false;
            }
            View view2 = this.f829k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.f829k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
            return true;
        }

        boolean a() {
            return this.f829k == null && this.f824f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.l || s(view2, u.y(coordinatorLayout)) || ((cVar = this.a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.a == null) {
                this.m = false;
            }
            return this.m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f824f == -1) {
                this.l = null;
                this.f829k = null;
                return null;
            }
            if (this.f829k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f829k;
        }

        public int e() {
            return this.f824f;
        }

        public c f() {
            return this.a;
        }

        boolean g() {
            return this.p;
        }

        Rect h() {
            return this.q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.a;
            boolean zA = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = zA;
            return zA;
        }

        boolean j(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        void k() {
            this.p = false;
        }

        void l(int i2) {
            r(i2, false);
        }

        void m() {
            this.m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.a = cVar;
                this.r = null;
                this.f820b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        void p(boolean z) {
            this.p = z;
        }

        void q(Rect rect) {
            this.q.set(rect);
        }

        void r(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.o = z;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f820b = false;
            this.f821c = 0;
            this.f822d = 0;
            this.f823e = -1;
            this.f824f = -1;
            this.f825g = 0;
            this.f826h = 0;
            this.q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.h.c.f3159e);
            this.f821c = typedArrayObtainStyledAttributes.getInteger(c.h.c.f3160f, 0);
            this.f824f = typedArrayObtainStyledAttributes.getResourceId(c.h.c.f3161g, -1);
            this.f822d = typedArrayObtainStyledAttributes.getInteger(c.h.c.f3162h, 0);
            this.f823e = typedArrayObtainStyledAttributes.getInteger(c.h.c.l, -1);
            this.f825g = typedArrayObtainStyledAttributes.getInt(c.h.c.f3165k, 0);
            this.f826h = typedArrayObtainStyledAttributes.getInt(c.h.c.f3164j, 0);
            int i2 = c.h.c.f3163i;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
            this.f820b = zHasValue;
            if (zHasValue) {
                this.a = CoordinatorLayout.K(context, attributeSet, typedArrayObtainStyledAttributes.getString(i2));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f820b = false;
            this.f821c = 0;
            this.f822d = 0;
            this.f823e = -1;
            this.f824f = -1;
            this.f825g = 0;
            this.f826h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f820b = false;
            this.f821c = 0;
            this.f822d = 0;
            this.f823e = -1;
            this.f824f = -1;
            this.f825g = 0;
            this.f826h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f820b = false;
            this.f821c = 0;
            this.f822d = 0;
            this.f823e = -1;
            this.f824f = -1;
            this.f825g = 0;
            this.f826h = 0;
            this.q = new Rect();
        }
    }
}
