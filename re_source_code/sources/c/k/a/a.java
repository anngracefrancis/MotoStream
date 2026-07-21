package c.k.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.d0.d;
import androidx.core.view.d0.e;
import androidx.core.view.u;
import androidx.core.view.x;
import c.e.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExploreByTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends androidx.core.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Rect f3288d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c.k.a.b.a<androidx.core.view.d0.c> f3289e = new C0078a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c.k.a.b.InterfaceC0079b<h<androidx.core.view.d0.c>, androidx.core.view.d0.c> f3290f = new b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AccessibilityManager f3295k;
    private final View l;
    private c m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Rect f3291g = new Rect();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f3292h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Rect f3293i = new Rect();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f3294j = new int[2];
    int n = Integer.MIN_VALUE;
    int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c.k.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    static class C0078a implements c.k.a.b.a<androidx.core.view.d0.c> {
        C0078a() {
        }

        @Override // c.k.a.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.core.view.d0.c cVar, Rect rect) {
            cVar.l(rect);
        }
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    static class b implements c.k.a.b.InterfaceC0079b<h<androidx.core.view.d0.c>, androidx.core.view.d0.c> {
        b() {
        }

        @Override // c.k.a.b.InterfaceC0079b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public androidx.core.view.d0.c a(h<androidx.core.view.d0.c> hVar, int i2) {
            return hVar.m(i2);
        }

        @Override // c.k.a.b.InterfaceC0079b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(h<androidx.core.view.d0.c> hVar) {
            return hVar.l();
        }
    }

    /* JADX INFO: compiled from: ExploreByTouchHelper.java */
    private class c extends d {
        c() {
        }

        @Override // androidx.core.view.d0.d
        public androidx.core.view.d0.c b(int i2) {
            return androidx.core.view.d0.c.N(a.this.H(i2));
        }

        @Override // androidx.core.view.d0.d
        public androidx.core.view.d0.c d(int i2) {
            int i3 = i2 == 2 ? a.this.n : a.this.o;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i3);
        }

        @Override // androidx.core.view.d0.d
        public boolean f(int i2, int i3, Bundle bundle) {
            return a.this.P(i2, i3, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.l = view;
        this.f3295k = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (u.w(view) == 0) {
            u.t0(view, 1);
        }
    }

    private static Rect D(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.l.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.l.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int F(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i2, Rect rect) {
        androidx.core.view.d0.c cVar;
        h<androidx.core.view.d0.c> hVarY = y();
        int i3 = this.o;
        androidx.core.view.d0.c cVarG = i3 == Integer.MIN_VALUE ? null : hVarY.g(i3);
        if (i2 == 1 || i2 == 2) {
            cVar = (androidx.core.view.d0.c) c.k.a.b.d(hVarY, f3290f, f3289e, cVarG, i2, u.y(this.l) == 1, false);
        } else {
            if (i2 != 17 && i2 != 33 && i2 != 66 && i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i4 = this.o;
            if (i4 != Integer.MIN_VALUE) {
                z(i4, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.l, i2, rect2);
            }
            cVar = (androidx.core.view.d0.c) c.k.a.b.c(hVarY, f3290f, f3289e, cVarG, rect2, i2);
        }
        return T(cVar != null ? hVarY.j(hVarY.i(cVar)) : Integer.MIN_VALUE);
    }

    private boolean Q(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return T(i2);
        }
        if (i3 == 2) {
            return o(i2);
        }
        if (i3 != 64) {
            return i3 != 128 ? J(i2, i3, bundle) : n(i2);
        }
        return S(i2);
    }

    private boolean R(int i2, Bundle bundle) {
        return u.Y(this.l, i2, bundle);
    }

    private boolean S(int i2) {
        int i3;
        if (!this.f3295k.isEnabled() || !this.f3295k.isTouchExplorationEnabled() || (i3 = this.n) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            n(i3);
        }
        this.n = i2;
        this.l.invalidate();
        U(i2, 32768);
        return true;
    }

    private void V(int i2) {
        int i3 = this.p;
        if (i3 == i2) {
            return;
        }
        this.p = i2;
        U(i2, 128);
        U(i3, 256);
    }

    private boolean n(int i2) {
        if (this.n != i2) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        this.l.invalidate();
        U(i2, 65536);
        return true;
    }

    private boolean p() {
        int i2 = this.o;
        return i2 != Integer.MIN_VALUE && J(i2, 16, null);
    }

    private AccessibilityEvent q(int i2, int i3) {
        return i2 != -1 ? r(i2, i3) : s(i3);
    }

    private AccessibilityEvent r(int i2, int i3) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        androidx.core.view.d0.c cVarH = H(i2);
        accessibilityEventObtain.getText().add(cVarH.w());
        accessibilityEventObtain.setContentDescription(cVarH.r());
        accessibilityEventObtain.setScrollable(cVarH.I());
        accessibilityEventObtain.setPassword(cVarH.H());
        accessibilityEventObtain.setEnabled(cVarH.D());
        accessibilityEventObtain.setChecked(cVarH.B());
        L(i2, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(cVarH.o());
        e.c(accessibilityEventObtain, this.l, i2);
        accessibilityEventObtain.setPackageName(this.l.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        this.l.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private androidx.core.view.d0.c t(int i2) {
        androidx.core.view.d0.c cVarL = androidx.core.view.d0.c.L();
        cVarL.e0(true);
        cVarL.g0(true);
        cVarL.Y("android.view.View");
        Rect rect = f3288d;
        cVarL.U(rect);
        cVarL.V(rect);
        cVarL.n0(this.l);
        N(i2, cVarL);
        if (cVarL.w() == null && cVarL.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        cVarL.l(this.f3292h);
        if (this.f3292h.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iJ = cVarL.j();
        if ((iJ & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iJ & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        cVarL.l0(this.l.getContext().getPackageName());
        cVarL.t0(this.l, i2);
        if (this.n == i2) {
            cVarL.S(true);
            cVarL.a(128);
        } else {
            cVarL.S(false);
            cVarL.a(64);
        }
        boolean z = this.o == i2;
        if (z) {
            cVarL.a(2);
        } else if (cVarL.E()) {
            cVarL.a(1);
        }
        cVarL.h0(z);
        this.l.getLocationOnScreen(this.f3294j);
        cVarL.m(this.f3291g);
        if (this.f3291g.equals(rect)) {
            cVarL.l(this.f3291g);
            if (cVarL.f1033c != -1) {
                androidx.core.view.d0.c cVarL2 = androidx.core.view.d0.c.L();
                for (int i3 = cVarL.f1033c; i3 != -1; i3 = cVarL2.f1033c) {
                    cVarL2.o0(this.l, -1);
                    cVarL2.U(f3288d);
                    N(i3, cVarL2);
                    cVarL2.l(this.f3292h);
                    Rect rect2 = this.f3291g;
                    Rect rect3 = this.f3292h;
                    rect2.offset(rect3.left, rect3.top);
                }
                cVarL2.P();
            }
            this.f3291g.offset(this.f3294j[0] - this.l.getScrollX(), this.f3294j[1] - this.l.getScrollY());
        }
        if (this.l.getLocalVisibleRect(this.f3293i)) {
            this.f3293i.offset(this.f3294j[0] - this.l.getScrollX(), this.f3294j[1] - this.l.getScrollY());
            if (this.f3291g.intersect(this.f3293i)) {
                cVarL.V(this.f3291g);
                if (E(this.f3291g)) {
                    cVarL.w0(true);
                }
            }
        }
        return cVarL;
    }

    private androidx.core.view.d0.c u() {
        androidx.core.view.d0.c cVarM = androidx.core.view.d0.c.M(this.l);
        u.W(this.l, cVarM);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (cVarM.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            cVarM.c(this.l, ((Integer) arrayList.get(i2)).intValue());
        }
        return cVarM;
    }

    private h<androidx.core.view.d0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<androidx.core.view.d0.c> hVar = new h<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.k(i2, t(i2));
        }
        return hVar;
    }

    private void z(int i2, Rect rect) {
        H(i2).l(rect);
    }

    public final int A() {
        return this.o;
    }

    protected abstract int B(float f2, float f3);

    protected abstract void C(List<Integer> list);

    androidx.core.view.d0.c H(int i2) {
        return i2 == -1 ? u() : t(i2);
    }

    public final void I(boolean z, int i2, Rect rect) {
        int i3 = this.o;
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        if (z) {
            G(i2, rect);
        }
    }

    protected abstract boolean J(int i2, int i3, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i2, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(androidx.core.view.d0.c cVar) {
    }

    protected abstract void N(int i2, androidx.core.view.d0.c cVar);

    protected void O(int i2, boolean z) {
    }

    boolean P(int i2, int i3, Bundle bundle) {
        return i2 != -1 ? Q(i2, i3, bundle) : R(i3, bundle);
    }

    public final boolean T(int i2) {
        int i3;
        if ((!this.l.isFocused() && !this.l.requestFocus()) || (i3 = this.o) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        this.o = i2;
        O(i2, true);
        U(i2, 8);
        return true;
    }

    public final boolean U(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f3295k.isEnabled() || (parent = this.l.getParent()) == null) {
            return false;
        }
        return x.h(parent, this.l, q(i2, i3));
    }

    @Override // androidx.core.view.a
    public d b(View view) {
        if (this.m == null) {
            this.m = new c();
        }
        return this.m;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public void g(View view, androidx.core.view.d0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i2) {
        if (this.o != i2) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        O(i2, false);
        U(i2, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f3295k.isEnabled() || !this.f3295k.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.p == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i2 < repeatCount && G(iF, null)) {
                        i2++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.n;
    }
}
