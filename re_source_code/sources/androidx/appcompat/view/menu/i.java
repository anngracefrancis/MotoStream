package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: MenuItemImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c.i.f.a.b {
    private View A;
    private androidx.core.view.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Intent f322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private char f323h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private char f325j;
    private Drawable l;
    g n;
    private r o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f324i = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f326k = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
    private int m = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    /* JADX INFO: compiled from: MenuItemImpl.java */
    class a implements androidx.core.view.b.InterfaceC0024b {
        a() {
        }

        @Override // androidx.core.view.b.InterfaceC0024b
        public void onActionProviderVisibilityChanged(boolean z) {
            i iVar = i.this;
            iVar.n.L(iVar);
        }
    }

    i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.z = 0;
        this.n = gVar;
        this.a = i3;
        this.f317b = i2;
        this.f318c = i4;
        this.f319d = i5;
        this.f320e = charSequence;
        this.z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.o(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.p(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.n.J() && g() != 0;
    }

    public boolean B() {
        return (this.z & 4) == 4;
    }

    @Override // c.i.f.a.b
    public c.i.f.a.b a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.n.M(true);
        androidx.core.view.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    @Override // c.i.f.a.b
    public androidx.core.view.b b() {
        return this.B;
    }

    public void c() {
        this.n.K(this);
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.f(this);
        }
        return false;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.m(this);
        }
        return false;
    }

    public int f() {
        return this.f319d;
    }

    char g() {
        return this.n.I() ? this.f325j : this.f323h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View viewD = bVar.d(this);
        this.A = viewD;
        return viewD;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f326k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f325j;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f317b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable drawableD = c.a.k.a.a.d(this.n.w(), this.m);
        this.m = 0;
        this.l = drawableD;
        return e(drawableD);
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f322g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f324i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f323h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f318c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f320e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f321f;
        if (charSequence == null) {
            charSequence = this.f320e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        Resources resources = this.n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(c.a.h.f2751k));
        }
        int i2 = this.n.I() ? this.f326k : this.f324i;
        d(sb, i2, 65536, resources.getString(c.a.h.f2747g));
        d(sb, i2, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT, resources.getString(c.a.h.f2743c));
        d(sb, i2, 2, resources.getString(c.a.h.f2742b));
        d(sb, i2, 1, resources.getString(c.a.h.f2748h));
        d(sb, i2, 4, resources.getString(c.a.h.f2750j));
        d(sb, i2, 8, resources.getString(c.a.h.f2746f));
        if (cG == '\b') {
            sb.append(resources.getString(c.a.h.f2744d));
        } else if (cG == '\n') {
            sb.append(resources.getString(c.a.h.f2745e));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(c.a.h.f2749i));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    CharSequence i(n.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.B;
        if (bVar == null || !bVar.g()) {
            return (this.y & 8) == 0;
        }
        return (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f322g != null) {
            try {
                this.n.w().startActivity(this.f322g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        androidx.core.view.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public c.i.f.a.b setActionView(int i2) {
        Context contextW = this.n.w();
        setActionView(LayoutInflater.from(contextW).inflate(i2, (ViewGroup) new LinearLayout(contextW), false));
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public c.i.f.a.b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.a) > 0) {
            view.setId(i2);
        }
        this.n.K(this);
        return this;
    }

    public void r(boolean z) {
        this.D = z;
        this.n.M(false);
    }

    void s(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 2 : 0) | (i2 & (-3));
        this.y = i3;
        if (i2 != i3) {
            this.n.M(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f325j == c2) {
            return this;
        }
        this.f325j = Character.toLowerCase(c2);
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.y = i3;
        if (i2 != i3) {
            this.n.M(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.X(this);
        } else {
            s(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f322g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f323h == c2) {
            return this;
        }
        this.f323h = c2;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f323h = c2;
        this.f325j = Character.toLowerCase(c3);
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i2;
        this.n.K(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f320e = charSequence;
        this.n.M(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f321f = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (y(z)) {
            this.n.L(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f320e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public c.i.f.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(r rVar) {
        this.o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 0 : 8) | (i2 & (-9));
        this.y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.n.C();
    }

    @Override // android.view.MenuItem
    public c.i.f.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public c.i.f.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f325j == c2 && this.f326k == i2) {
            return this;
        }
        this.f325j = Character.toLowerCase(c2);
        this.f326k = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f323h == c2 && this.f324i == i2) {
            return this;
        }
        this.f323h = c2;
        this.f324i = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // c.i.f.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f323h = c2;
        this.f324i = KeyEvent.normalizeMetaState(i2);
        this.f325j = Character.toLowerCase(c3);
        this.f326k = KeyEvent.normalizeMetaState(i3);
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.l = null;
        this.m = i2;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.n.w().getString(i2));
    }
}
