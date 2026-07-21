package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.x;
import androidx.core.view.a0;
import androidx.core.view.b0;
import androidx.core.view.u;
import androidx.core.view.y;
import androidx.core.view.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator a = new AccelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f232b = new DecelerateInterpolator();
    c.a.o.h A;
    private boolean B;
    boolean C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ActionBarOverlayLayout f236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ActionBarContainer f237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    x f238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ActionBarContextView f239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    View f240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    j0 f241k;
    private boolean n;
    d o;
    c.a.o.b p;
    c.a.o.b.a q;
    private boolean r;
    private boolean t;
    boolean w;
    boolean x;
    private boolean y;
    private ArrayList<?> l = new ArrayList<>();
    private int m = -1;
    private ArrayList<androidx.appcompat.app.a.b> s = new ArrayList<>();
    private int u = 0;
    boolean v = true;
    private boolean z = true;
    final z D = new a();
    final z E = new b();
    final b0 F = new c();

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class a extends a0 {
        a() {
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationEnd(View view) {
            View view2;
            o oVar = o.this;
            if (oVar.v && (view2 = oVar.f240j) != null) {
                view2.setTranslationY(0.0f);
                o.this.f237g.setTranslationY(0.0f);
            }
            o.this.f237g.setVisibility(8);
            o.this.f237g.setTransitioning(false);
            o oVar2 = o.this;
            oVar2.A = null;
            oVar2.A();
            ActionBarOverlayLayout actionBarOverlayLayout = o.this.f236f;
            if (actionBarOverlayLayout != null) {
                u.f0(actionBarOverlayLayout);
            }
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class b extends a0 {
        b() {
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationEnd(View view) {
            o oVar = o.this;
            oVar.A = null;
            oVar.f237g.requestLayout();
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    class c implements b0 {
        c() {
        }

        @Override // androidx.core.view.b0
        public void a(View view) {
            ((View) o.this.f237g.getParent()).invalidate();
        }
    }

    /* JADX INFO: compiled from: WindowDecorActionBar.java */
    public class d extends c.a.o.b implements androidx.appcompat.view.menu.g.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Context f242h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f243i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c.a.o.b.a f244j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private WeakReference<View> f245k;

        public d(Context context, c.a.o.b.a aVar) {
            this.f242h = context;
            this.f244j = aVar;
            androidx.appcompat.view.menu.g gVarW = new androidx.appcompat.view.menu.g(context).W(1);
            this.f243i = gVarW;
            gVarW.V(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            c.a.o.b.a aVar = this.f244j;
            if (aVar != null) {
                return aVar.d(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.f244j == null) {
                return;
            }
            k();
            o.this.f239i.l();
        }

        @Override // c.a.o.b
        public void c() {
            o oVar = o.this;
            if (oVar.o != this) {
                return;
            }
            if (o.z(oVar.w, oVar.x, false)) {
                this.f244j.a(this);
            } else {
                o oVar2 = o.this;
                oVar2.p = this;
                oVar2.q = this.f244j;
            }
            this.f244j = null;
            o.this.y(false);
            o.this.f239i.g();
            o.this.f238h.r().sendAccessibilityEvent(32);
            o oVar3 = o.this;
            oVar3.f236f.setHideOnContentScrollEnabled(oVar3.C);
            o.this.o = null;
        }

        @Override // c.a.o.b
        public View d() {
            WeakReference<View> weakReference = this.f245k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // c.a.o.b
        public Menu e() {
            return this.f243i;
        }

        @Override // c.a.o.b
        public MenuInflater f() {
            return new c.a.o.g(this.f242h);
        }

        @Override // c.a.o.b
        public CharSequence g() {
            return o.this.f239i.getSubtitle();
        }

        @Override // c.a.o.b
        public CharSequence i() {
            return o.this.f239i.getTitle();
        }

        @Override // c.a.o.b
        public void k() {
            if (o.this.o != this) {
                return;
            }
            this.f243i.h0();
            try {
                this.f244j.c(this, this.f243i);
            } finally {
                this.f243i.g0();
            }
        }

        @Override // c.a.o.b
        public boolean l() {
            return o.this.f239i.j();
        }

        @Override // c.a.o.b
        public void m(View view) {
            o.this.f239i.setCustomView(view);
            this.f245k = new WeakReference<>(view);
        }

        @Override // c.a.o.b
        public void n(int i2) {
            o(o.this.f233c.getResources().getString(i2));
        }

        @Override // c.a.o.b
        public void o(CharSequence charSequence) {
            o.this.f239i.setSubtitle(charSequence);
        }

        @Override // c.a.o.b
        public void q(int i2) {
            r(o.this.f233c.getResources().getString(i2));
        }

        @Override // c.a.o.b
        public void r(CharSequence charSequence) {
            o.this.f239i.setTitle(charSequence);
        }

        @Override // c.a.o.b
        public void s(boolean z) {
            super.s(z);
            o.this.f239i.setTitleOptional(z);
        }

        public boolean t() {
            this.f243i.h0();
            try {
                return this.f244j.b(this, this.f243i);
            } finally {
                this.f243i.g0();
            }
        }
    }

    public o(Activity activity, boolean z) {
        this.f235e = activity;
        View decorView = activity.getWindow().getDecorView();
        G(decorView);
        if (z) {
            return;
        }
        this.f240j = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x D(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void F() {
        if (this.y) {
            this.y = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f236f;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void G(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(c.a.f.p);
        this.f236f = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f238h = D(view.findViewById(c.a.f.a));
        this.f239i = (ActionBarContextView) view.findViewById(c.a.f.f2726f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(c.a.f.f2723c);
        this.f237g = actionBarContainer;
        x xVar = this.f238h;
        if (xVar == null || this.f239i == null || actionBarContainer == null) {
            throw new IllegalStateException(o.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f233c = xVar.getContext();
        boolean z = (this.f238h.t() & 4) != 0;
        if (z) {
            this.n = true;
        }
        c.a.o.a aVarB = c.a.o.a.b(this.f233c);
        t(aVarB.a() || z);
        J(aVarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.f233c.obtainStyledAttributes(null, c.a.j.a, c.a.a.f2686c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(c.a.j.f2765k, false)) {
            K(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.a.j.f2763i, 0);
        if (dimensionPixelSize != 0) {
            I(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void J(boolean z) {
        this.t = z;
        if (z) {
            this.f237g.setTabContainer(null);
            this.f238h.i(this.f241k);
        } else {
            this.f238h.i(null);
            this.f237g.setTabContainer(this.f241k);
        }
        boolean z2 = E() == 2;
        j0 j0Var = this.f241k;
        if (j0Var != null) {
            if (z2) {
                j0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f236f;
                if (actionBarOverlayLayout != null) {
                    u.f0(actionBarOverlayLayout);
                }
            } else {
                j0Var.setVisibility(8);
            }
        }
        this.f238h.w(!this.t && z2);
        this.f236f.setHasNonEmbeddedTabs(!this.t && z2);
    }

    private boolean L() {
        return u.O(this.f237g);
    }

    private void M() {
        if (this.y) {
            return;
        }
        this.y = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f236f;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        N(false);
    }

    private void N(boolean z) {
        if (z(this.w, this.x, this.y)) {
            if (this.z) {
                return;
            }
            this.z = true;
            C(z);
            return;
        }
        if (this.z) {
            this.z = false;
            B(z);
        }
    }

    static boolean z(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    void A() {
        c.a.o.b.a aVar = this.q;
        if (aVar != null) {
            aVar.a(this.p);
            this.p = null;
            this.q = null;
        }
    }

    public void B(boolean z) {
        View view;
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
        }
        if (this.u != 0 || (!this.B && !z)) {
            this.D.onAnimationEnd(null);
            return;
        }
        this.f237g.setAlpha(1.0f);
        this.f237g.setTransitioning(true);
        c.a.o.h hVar2 = new c.a.o.h();
        float f2 = -this.f237g.getHeight();
        if (z) {
            int[] iArr = {0, 0};
            this.f237g.getLocationInWindow(iArr);
            f2 -= iArr[1];
        }
        y yVarK = u.c(this.f237g).k(f2);
        yVarK.i(this.F);
        hVar2.c(yVarK);
        if (this.v && (view = this.f240j) != null) {
            hVar2.c(u.c(view).k(f2));
        }
        hVar2.f(a);
        hVar2.e(250L);
        hVar2.g(this.D);
        this.A = hVar2;
        hVar2.h();
    }

    public void C(boolean z) {
        View view;
        View view2;
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
        }
        this.f237g.setVisibility(0);
        if (this.u == 0 && (this.B || z)) {
            this.f237g.setTranslationY(0.0f);
            float f2 = -this.f237g.getHeight();
            if (z) {
                int[] iArr = {0, 0};
                this.f237g.getLocationInWindow(iArr);
                f2 -= iArr[1];
            }
            this.f237g.setTranslationY(f2);
            c.a.o.h hVar2 = new c.a.o.h();
            y yVarK = u.c(this.f237g).k(0.0f);
            yVarK.i(this.F);
            hVar2.c(yVarK);
            if (this.v && (view2 = this.f240j) != null) {
                view2.setTranslationY(f2);
                hVar2.c(u.c(this.f240j).k(0.0f));
            }
            hVar2.f(f232b);
            hVar2.e(250L);
            hVar2.g(this.E);
            this.A = hVar2;
            hVar2.h();
        } else {
            this.f237g.setAlpha(1.0f);
            this.f237g.setTranslationY(0.0f);
            if (this.v && (view = this.f240j) != null) {
                view.setTranslationY(0.0f);
            }
            this.E.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f236f;
        if (actionBarOverlayLayout != null) {
            u.f0(actionBarOverlayLayout);
        }
    }

    public int E() {
        return this.f238h.n();
    }

    public void H(int i2, int i3) {
        int iT = this.f238h.t();
        if ((i3 & 4) != 0) {
            this.n = true;
        }
        this.f238h.k((i2 & i3) | ((i3 ^ (-1)) & iT));
    }

    public void I(float f2) {
        u.q0(this.f237g, f2);
    }

    public void K(boolean z) {
        if (z && !this.f236f.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.C = z;
        this.f236f.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.x) {
            this.x = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.x) {
            return;
        }
        this.x = true;
        N(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        c.a.o.h hVar = this.A;
        if (hVar != null) {
            hVar.a();
            this.A = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        x xVar = this.f238h;
        if (xVar == null || !xVar.j()) {
            return false;
        }
        this.f238h.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void h(boolean z) {
        if (z == this.r) {
            return;
        }
        this.r = z;
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.get(i2).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int i() {
        return this.f238h.t();
    }

    @Override // androidx.appcompat.app.a
    public Context j() {
        if (this.f234d == null) {
            TypedValue typedValue = new TypedValue();
            this.f233c.getTheme().resolveAttribute(c.a.a.f2690g, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f234d = new ContextThemeWrapper(this.f233c, i2);
            } else {
                this.f234d = this.f233c;
            }
        }
        return this.f234d;
    }

    @Override // androidx.appcompat.app.a
    public void l(Configuration configuration) {
        J(c.a.o.a.b(this.f233c).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean n(int i2, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.o;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void onWindowVisibilityChanged(int i2) {
        this.u = i2;
    }

    @Override // androidx.appcompat.app.a
    public void q(boolean z) {
        if (this.n) {
            return;
        }
        r(z);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        H(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        H(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        this.f238h.s(z);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
        c.a.o.h hVar;
        this.B = z;
        if (z || (hVar = this.A) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f238h.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.f238h.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public c.a.o.b x(c.a.o.b.a aVar) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.c();
        }
        this.f236f.setHideOnContentScrollEnabled(false);
        this.f239i.k();
        d dVar2 = new d(this.f239i.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.o = dVar2;
        dVar2.k();
        this.f239i.h(dVar2);
        y(true);
        this.f239i.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void y(boolean z) {
        y yVarO;
        y yVarF;
        if (z) {
            M();
        } else {
            F();
        }
        if (!L()) {
            if (z) {
                this.f238h.q(4);
                this.f239i.setVisibility(0);
                return;
            } else {
                this.f238h.q(0);
                this.f239i.setVisibility(8);
                return;
            }
        }
        if (z) {
            yVarF = this.f238h.o(4, 100L);
            yVarO = this.f239i.f(0, 200L);
        } else {
            yVarO = this.f238h.o(0, 200L);
            yVarF = this.f239i.f(8, 100L);
        }
        c.a.o.h hVar = new c.a.o.h();
        hVar.d(yVarF, yVarO);
        hVar.h();
    }

    public o(Dialog dialog) {
        G(dialog.getWindow().getDecorView());
    }
}
