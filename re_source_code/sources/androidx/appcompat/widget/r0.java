package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class r0 implements x {
    Toolbar a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    CharSequence f615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f617k;
    Window.Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final androidx.appcompat.view.menu.a f618f;

        a() {
            this.f618f = new androidx.appcompat.view.menu.a(r0.this.a.getContext(), 0, R.id.home, 0, 0, r0.this.f615i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r0 r0Var = r0.this;
            Window.Callback callback = r0Var.l;
            if (callback == null || !r0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f618f);
        }
    }

    /* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
    class b extends androidx.core.view.a0 {
        private boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f620b;

        b(int i2) {
            this.f620b = i2;
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationCancel(View view) {
            this.a = true;
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationEnd(View view) {
            if (this.a) {
                return;
            }
            r0.this.a.setVisibility(this.f620b);
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationStart(View view) {
            r0.this.a.setVisibility(0);
        }
    }

    public r0(Toolbar toolbar, boolean z) {
        this(toolbar, z, c.a.h.a, c.a.e.n);
    }

    private void F(CharSequence charSequence) {
        this.f615i = charSequence;
        if ((this.f608b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void G() {
        if ((this.f608b & 4) != 0) {
            if (TextUtils.isEmpty(this.f617k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.f617k);
            }
        }
    }

    private void H() {
        if ((this.f608b & 4) == 0) {
            this.a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.a;
        Drawable drawable = this.f613g;
        if (drawable == null) {
            drawable = this.q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void I() {
        Drawable drawable;
        int i2 = this.f608b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f612f) == null) {
            drawable = this.f611e;
        }
        this.a.setLogo(drawable);
    }

    private int x() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f612f = drawable;
        I();
    }

    public void B(int i2) {
        C(i2 == 0 ? null : getContext().getString(i2));
    }

    public void C(CharSequence charSequence) {
        this.f617k = charSequence;
        G();
    }

    public void D(Drawable drawable) {
        this.f613g = drawable;
        H();
    }

    public void E(CharSequence charSequence) {
        this.f616j = charSequence;
        if ((this.f608b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.x
    public void a(Menu menu, androidx.appcompat.view.menu.m.a aVar) {
        if (this.n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.a.getContext());
            this.n = actionMenuPresenter;
            actionMenuPresenter.r(c.a.f.f2727g);
        }
        this.n.g(aVar);
        this.a.I((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.x
    public boolean b() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.x
    public void c() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.x
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.x
    public boolean d() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.x
    public boolean e() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.x
    public boolean f() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.x
    public boolean g() {
        return this.a.O();
    }

    @Override // androidx.appcompat.widget.x
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.x
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.x
    public void h() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.x
    public void i(j0 j0Var) {
        View view = this.f609c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.f609c);
            }
        }
        this.f609c = j0Var;
        if (j0Var == null || this.o != 2) {
            return;
        }
        this.a.addView(j0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f609c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        j0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.x
    public boolean j() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.x
    public void k(int i2) {
        View view;
        int i3 = this.f608b ^ i2;
        this.f608b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    G();
                }
                H();
            }
            if ((i3 & 3) != 0) {
                I();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.a.setTitle(this.f615i);
                    this.a.setSubtitle(this.f616j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f610d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.x
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // androidx.appcompat.widget.x
    public void m(int i2) {
        A(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.x
    public int n() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.x
    public androidx.core.view.y o(int i2, long j2) {
        return androidx.core.view.u.c(this.a).a(i2 == 0 ? 1.0f : 0.0f).d(j2).f(new b(i2));
    }

    @Override // androidx.appcompat.widget.x
    public void p(androidx.appcompat.view.menu.m.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.x
    public void q(int i2) {
        this.a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.x
    public ViewGroup r() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.x
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.widget.x
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? c.a.k.a.a.d(getContext(), i2) : null);
    }

    @Override // androidx.appcompat.widget.x
    public void setTitle(CharSequence charSequence) {
        this.f614h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.x
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f614h) {
            return;
        }
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.x
    public int t() {
        return this.f608b;
    }

    @Override // androidx.appcompat.widget.x
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.x
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.x
    public void w(boolean z) {
        this.a.setCollapsible(z);
    }

    public void y(View view) {
        View view2 = this.f610d;
        if (view2 != null && (this.f608b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.f610d = view;
        if (view == null || (this.f608b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void z(int i2) {
        if (i2 == this.p) {
            return;
        }
        this.p = i2;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            B(this.p);
        }
    }

    public r0(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.f615i = toolbar.getTitle();
        this.f616j = toolbar.getSubtitle();
        this.f614h = this.f615i != null;
        this.f613g = toolbar.getNavigationIcon();
        q0 q0VarV = q0.v(toolbar.getContext(), null, c.a.j.a, c.a.a.f2686c, 0);
        this.q = q0VarV.g(c.a.j.l);
        if (z) {
            CharSequence charSequenceP = q0VarV.p(c.a.j.r);
            if (!TextUtils.isEmpty(charSequenceP)) {
                setTitle(charSequenceP);
            }
            CharSequence charSequenceP2 = q0VarV.p(c.a.j.p);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                E(charSequenceP2);
            }
            Drawable drawableG = q0VarV.g(c.a.j.n);
            if (drawableG != null) {
                A(drawableG);
            }
            Drawable drawableG2 = q0VarV.g(c.a.j.m);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f613g == null && (drawable = this.q) != null) {
                D(drawable);
            }
            k(q0VarV.k(c.a.j.f2762h, 0));
            int iN = q0VarV.n(c.a.j.f2761g, 0);
            if (iN != 0) {
                y(LayoutInflater.from(this.a.getContext()).inflate(iN, (ViewGroup) this.a, false));
                k(this.f608b | 16);
            }
            int iM = q0VarV.m(c.a.j.f2764j, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iM;
                this.a.setLayoutParams(layoutParams);
            }
            int iE = q0VarV.e(c.a.j.f2760f, -1);
            int iE2 = q0VarV.e(c.a.j.f2759e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.a.H(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = q0VarV.n(c.a.j.s, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.L(toolbar2.getContext(), iN2);
            }
            int iN3 = q0VarV.n(c.a.j.q, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.K(toolbar3.getContext(), iN3);
            }
            int iN4 = q0VarV.n(c.a.j.o, 0);
            if (iN4 != 0) {
                this.a.setPopupTheme(iN4);
            }
        } else {
            this.f608b = x();
        }
        q0VarV.w();
        z(i2);
        this.f617k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.x
    public void setIcon(Drawable drawable) {
        this.f611e = drawable;
        I();
    }
}
