package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.w0;
import androidx.core.view.c0;
import androidx.core.view.y;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class g extends androidx.appcompat.app.f implements androidx.appcompat.view.menu.g.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final c.e.g<String, Integer> f166i = new c.e.g<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f168k;
    private static final boolean l;
    private static final boolean m;
    private static boolean n;
    ActionBarContextView A;
    PopupWindow B;
    Runnable C;
    y D;
    private boolean E;
    private boolean F;
    ViewGroup G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    private boolean Q;
    private t[] R;
    private t S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    boolean X;
    private int Y;
    private int Z;
    private boolean a0;
    private boolean b0;
    private m c0;
    private m d0;
    boolean e0;
    int f0;
    private final Runnable g0;
    private boolean h0;
    private Rect i0;
    private Rect j0;
    private androidx.appcompat.app.j k0;
    final Object o;
    final Context p;
    Window q;
    private k r;
    final androidx.appcompat.app.e s;
    androidx.appcompat.app.a t;
    MenuInflater u;
    private CharSequence v;
    private w w;
    private i x;
    private u y;
    c.a.o.b z;

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f169f;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f169f = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f169f.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f169f.uncaughtException(thread, notFoundException);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if ((gVar.f0 & 1) != 0) {
                gVar.Z(0);
            }
            g gVar2 = g.this;
            if ((gVar2.f0 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) != 0) {
                gVar2.Z(108);
            }
            g gVar3 = g.this;
            gVar3.e0 = false;
            gVar3.f0 = 0;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class c implements androidx.core.view.p {
        c() {
        }

        @Override // androidx.core.view.p
        public c0 a(View view, c0 c0Var) {
            int iK = c0Var.k();
            int iP0 = g.this.P0(c0Var, null);
            if (iK != iP0) {
                c0Var = c0Var.o(c0Var.i(), iP0, c0Var.j(), c0Var.h());
            }
            return androidx.core.view.u.V(view, c0Var);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class d implements a0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.a0.a
        public void a(Rect rect) {
            rect.top = g.this.P0(null, rect);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            g.this.X();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class f implements Runnable {

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends androidx.core.view.a0 {
            a() {
            }

            @Override // androidx.core.view.a0, androidx.core.view.z
            public void onAnimationEnd(View view) {
                g.this.A.setAlpha(1.0f);
                g.this.D.f(null);
                g.this.D = null;
            }

            @Override // androidx.core.view.a0, androidx.core.view.z
            public void onAnimationStart(View view) {
                g.this.A.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.B.showAtLocation(gVar.A, 55, 0, 0);
            g.this.a0();
            if (!g.this.I0()) {
                g.this.A.setAlpha(1.0f);
                g.this.A.setVisibility(0);
            } else {
                g.this.A.setAlpha(0.0f);
                g gVar2 = g.this;
                gVar2.D = androidx.core.view.u.c(gVar2.A).a(1.0f);
                g.this.D.f(new a());
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class C0010g extends androidx.core.view.a0 {
        C0010g() {
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationEnd(View view) {
            g.this.A.setAlpha(1.0f);
            g.this.D.f(null);
            g.this.D = null;
        }

        @Override // androidx.core.view.a0, androidx.core.view.z
        public void onAnimationStart(View view) {
            g.this.A.setVisibility(0);
            g.this.A.sendAccessibilityEvent(32);
            if (g.this.A.getParent() instanceof View) {
                androidx.core.view.u.f0((View) g.this.A.getParent());
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class h implements androidx.appcompat.app.b {
        h() {
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private final class i implements androidx.appcompat.view.menu.m.a {
        i() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            g.this.Q(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackK0 = g.this.k0();
            if (callbackK0 == null) {
                return true;
            }
            callbackK0.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class j implements c.a.o.b.a {
        private c.a.o.b.a a;

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends androidx.core.view.a0 {
            a() {
            }

            @Override // androidx.core.view.a0, androidx.core.view.z
            public void onAnimationEnd(View view) {
                g.this.A.setVisibility(8);
                g gVar = g.this;
                PopupWindow popupWindow = gVar.B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (gVar.A.getParent() instanceof View) {
                    androidx.core.view.u.f0((View) g.this.A.getParent());
                }
                g.this.A.removeAllViews();
                g.this.D.f(null);
                g gVar2 = g.this;
                gVar2.D = null;
                androidx.core.view.u.f0(gVar2.G);
            }
        }

        public j(c.a.o.b.a aVar) {
            this.a = aVar;
        }

        @Override // c.a.o.b.a
        public void a(c.a.o.b bVar) {
            this.a.a(bVar);
            g gVar = g.this;
            if (gVar.B != null) {
                gVar.q.getDecorView().removeCallbacks(g.this.C);
            }
            g gVar2 = g.this;
            if (gVar2.A != null) {
                gVar2.a0();
                g gVar3 = g.this;
                gVar3.D = androidx.core.view.u.c(gVar3.A).a(0.0f);
                g.this.D.f(new a());
            }
            g gVar4 = g.this;
            androidx.appcompat.app.e eVar = gVar4.s;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(gVar4.z);
            }
            g gVar5 = g.this;
            gVar5.z = null;
            androidx.core.view.u.f0(gVar5.G);
        }

        @Override // c.a.o.b.a
        public boolean b(c.a.o.b bVar, Menu menu) {
            return this.a.b(bVar, menu);
        }

        @Override // c.a.o.b.a
        public boolean c(c.a.o.b bVar, Menu menu) {
            androidx.core.view.u.f0(g.this.G);
            return this.a.c(bVar, menu);
        }

        @Override // c.a.o.b.a
        public boolean d(c.a.o.b bVar, MenuItem menuItem) {
            return this.a.d(bVar, menuItem);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class l extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f175c;

        l(Context context) {
            super();
            this.f175c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.g.m
        IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g.m
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f175c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.g.m
        public void d() {
            g.this.e();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    abstract class m {
        private BroadcastReceiver a;

        /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                m.this.d();
            }
        }

        m() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    g.this.p.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            g.this.p.registerReceiver(this.a, intentFilterB);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class n extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.n f178c;

        n(androidx.appcompat.app.n nVar) {
            super();
            this.f178c = nVar;
        }

        @Override // androidx.appcompat.app.g.m
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g.m
        public int c() {
            return this.f178c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.g.m
        public void d() {
            g.this.e();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.densityDpi;
            int i3 = configuration2.densityDpi;
            if (i2 != i3) {
                configuration3.densityDpi = i3;
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    static class q {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i2 = configuration.colorMode & 3;
            int i3 = configuration2.colorMode;
            if (i2 != (i3 & 3)) {
                configuration3.colorMode |= i3 & 3;
            }
            int i4 = configuration.colorMode & 12;
            int i5 = configuration2.colorMode;
            if (i4 != (i5 & 12)) {
                configuration3.colorMode |= i5 & 12;
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private static class r {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        private boolean c(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.Y(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            g.this.S(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(c.a.k.a.a.d(getContext(), i2));
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    protected static final class t {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f183e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f185g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f186h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f187i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.g f188j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.e f189k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        t(int i2) {
            this.a = i2;
        }

        androidx.appcompat.view.menu.n a(androidx.appcompat.view.menu.m.a aVar) {
            if (this.f188j == null) {
                return null;
            }
            if (this.f189k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, c.a.g.f2740j);
                this.f189k = eVar;
                eVar.g(aVar);
                this.f188j.b(this.f189k);
            }
            return this.f189k.j(this.f185g);
        }

        public boolean b() {
            if (this.f186h == null) {
                return false;
            }
            return this.f187i != null || this.f189k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f188j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.Q(this.f189k);
            }
            this.f188j = gVar;
            if (gVar == null || (eVar = this.f189k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(c.a.a.a, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            }
            themeNewTheme.resolveAttribute(c.a.a.F, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            } else {
                themeNewTheme.applyStyle(c.a.i.f2753c, true);
            }
            c.a.o.d dVar = new c.a.o.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(c.a.j.z0);
            this.f180b = typedArrayObtainStyledAttributes.getResourceId(c.a.j.C0, 0);
            this.f184f = typedArrayObtainStyledAttributes.getResourceId(c.a.j.B0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    private final class u implements androidx.appcompat.view.menu.m.a {
        u() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g gVarF = gVar.F();
            boolean z2 = gVarF != gVar;
            g gVar2 = g.this;
            if (z2) {
                gVar = gVarF;
            }
            t tVarD0 = gVar2.d0(gVar);
            if (tVarD0 != null) {
                if (!z2) {
                    g.this.T(tVarD0, z);
                } else {
                    g.this.P(tVarD0.a, tVarD0, gVarF);
                    g.this.T(tVarD0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackK0;
            if (gVar != gVar.F()) {
                return true;
            }
            g gVar2 = g.this;
            if (!gVar2.L || (callbackK0 = gVar2.k0()) == null || g.this.X) {
                return true;
            }
            callbackK0.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 < 21;
        f167j = z;
        f168k = new int[]{R.attr.windowBackground};
        l = !"robolectric".equals(Build.FINGERPRINT);
        m = i2 >= 17;
        if (!z || n) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        n = true;
    }

    g(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    private void C0(t tVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (tVar.o || this.X) {
            return;
        }
        if (tVar.a == 0) {
            if ((this.p.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackK0 = k0();
        if (callbackK0 != null && !callbackK0.onMenuOpened(tVar.a, tVar.f188j)) {
            T(tVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.p.getSystemService("window");
        if (windowManager != null && F0(tVar, keyEvent)) {
            ViewGroup viewGroup = tVar.f185g;
            if (viewGroup != null && !tVar.q) {
                View view = tVar.f187i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                tVar.n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, tVar.f182d, tVar.f183e, 1002, 8519680, -3);
                layoutParams2.gravity = tVar.f181c;
                layoutParams2.windowAnimations = tVar.f184f;
                windowManager.addView(tVar.f185g, layoutParams2);
                tVar.o = true;
            }
            if (viewGroup == null) {
                if (!n0(tVar) || tVar.f185g == null) {
                    return;
                }
            } else if (tVar.q && viewGroup.getChildCount() > 0) {
                tVar.f185g.removeAllViews();
            }
            if (!m0(tVar) || !tVar.b()) {
                tVar.q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = tVar.f186h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            tVar.f185g.setBackgroundResource(tVar.f180b);
            ViewParent parent = tVar.f186h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(tVar.f186h);
            }
            tVar.f185g.addView(tVar.f186h, layoutParams3);
            if (!tVar.f186h.hasFocus()) {
                tVar.f186h.requestFocus();
            }
            i2 = -2;
            tVar.n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i2, -2, tVar.f182d, tVar.f183e, 1002, 8519680, -3);
            layoutParams4.gravity = tVar.f181c;
            layoutParams4.windowAnimations = tVar.f184f;
            windowManager.addView(tVar.f185g, layoutParams4);
            tVar.o = true;
        }
    }

    private boolean E0(t tVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((tVar.m || F0(tVar, keyEvent)) && (gVar = tVar.f188j) != null) {
            zPerformShortcut = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.w == null) {
            T(tVar, true);
        }
        return zPerformShortcut;
    }

    private boolean F0(t tVar, KeyEvent keyEvent) {
        w wVar;
        w wVar2;
        w wVar3;
        if (this.X) {
            return false;
        }
        if (tVar.m) {
            return true;
        }
        t tVar2 = this.S;
        if (tVar2 != null && tVar2 != tVar) {
            T(tVar2, false);
        }
        Window.Callback callbackK0 = k0();
        if (callbackK0 != null) {
            tVar.f187i = callbackK0.onCreatePanelView(tVar.a);
        }
        int i2 = tVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (wVar3 = this.w) != null) {
            wVar3.c();
        }
        if (tVar.f187i == null && (!z || !(D0() instanceof androidx.appcompat.app.l))) {
            androidx.appcompat.view.menu.g gVar = tVar.f188j;
            if (gVar == null || tVar.r) {
                if (gVar == null && (!o0(tVar) || tVar.f188j == null)) {
                    return false;
                }
                if (z && this.w != null) {
                    if (this.x == null) {
                        this.x = new i();
                    }
                    this.w.a(tVar.f188j, this.x);
                }
                tVar.f188j.h0();
                if (!callbackK0.onCreatePanelMenu(tVar.a, tVar.f188j)) {
                    tVar.c(null);
                    if (z && (wVar = this.w) != null) {
                        wVar.a(null, this.x);
                    }
                    return false;
                }
                tVar.r = false;
            }
            tVar.f188j.h0();
            Bundle bundle = tVar.s;
            if (bundle != null) {
                tVar.f188j.R(bundle);
                tVar.s = null;
            }
            if (!callbackK0.onPreparePanel(0, tVar.f187i, tVar.f188j)) {
                if (z && (wVar2 = this.w) != null) {
                    wVar2.a(null, this.x);
                }
                tVar.f188j.g0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            tVar.p = z2;
            tVar.f188j.setQwertyMode(z2);
            tVar.f188j.g0();
        }
        tVar.m = true;
        tVar.n = false;
        this.S = tVar;
        return true;
    }

    private void G0(boolean z) {
        w wVar = this.w;
        if (wVar == null || !wVar.d() || (ViewConfiguration.get(this.p).hasPermanentMenuKey() && !this.w.e())) {
            t tVarI0 = i0(0, true);
            tVarI0.q = true;
            T(tVarI0, false);
            C0(tVarI0, null);
            return;
        }
        Window.Callback callbackK0 = k0();
        if (this.w.b() && z) {
            this.w.f();
            if (this.X) {
                return;
            }
            callbackK0.onPanelClosed(108, i0(0, true).f188j);
            return;
        }
        if (callbackK0 == null || this.X) {
            return;
        }
        if (this.e0 && (this.f0 & 1) != 0) {
            this.q.getDecorView().removeCallbacks(this.g0);
            this.g0.run();
        }
        t tVarI1 = i0(0, true);
        androidx.appcompat.view.menu.g gVar = tVarI1.f188j;
        if (gVar == null || tVarI1.r || !callbackK0.onPreparePanel(0, tVarI1.f187i, gVar)) {
            return;
        }
        callbackK0.onMenuOpened(108, tVarI1.f188j);
        this.w.g();
    }

    private int H0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean J0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.q.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || androidx.core.view.u.N((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean L(boolean z) {
        if (this.X) {
            return false;
        }
        int iO = O();
        boolean zN0 = N0(s0(this.p, iO), z);
        if (iO == 0) {
            h0(this.p).e();
        } else {
            m mVar = this.c0;
            if (mVar != null) {
                mVar.a();
            }
        }
        if (iO == 3) {
            g0(this.p).e();
        } else {
            m mVar2 = this.d0;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
        return zN0;
    }

    private void L0() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void M() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.G.findViewById(R.id.content);
        View decorView = this.q.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.p.obtainStyledAttributes(c.a.j.z0);
        typedArrayObtainStyledAttributes.getValue(c.a.j.L0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(c.a.j.M0, contentFrameLayout.getMinWidthMinor());
        int i2 = c.a.j.J0;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = c.a.j.K0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = c.a.j.H0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = c.a.j.I0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private androidx.appcompat.app.d M0() {
        for (Context baseContext = this.p; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void N(Window window) {
        if (this.q != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof k) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        k kVar = new k(callback);
        this.r = kVar;
        window.setCallback(kVar);
        q0 q0VarU = q0.u(this.p, null, f168k);
        Drawable drawableH = q0VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        q0VarU.w();
        this.q = window;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private boolean N0(int i2, boolean z) {
        boolean z2;
        Configuration configurationU = U(this.p, i2, null);
        boolean zQ0 = q0();
        int i3 = this.p.getResources().getConfiguration().uiMode & 48;
        int i4 = configurationU.uiMode & 48;
        boolean z3 = true;
        if (i3 != i4 && z && !zQ0 && this.U && (l || this.V)) {
            Object obj = this.o;
            if (!(obj instanceof Activity) || ((Activity) obj).isChild()) {
                z2 = false;
            } else {
                androidx.core.app.a.p((Activity) this.o);
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2 || i3 == i4) {
            z3 = z2;
        } else {
            O0(i4, zQ0, null);
        }
        if (z3) {
            Object obj2 = this.o;
            if (obj2 instanceof androidx.appcompat.app.d) {
                ((androidx.appcompat.app.d) obj2).onNightModeChanged(i2);
            }
        }
        return z3;
    }

    private int O() {
        int i2 = this.Y;
        return i2 != -100 ? i2 : androidx.appcompat.app.f.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O0(int i2, boolean z, Configuration configuration) {
        Resources resources = this.p.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            androidx.appcompat.app.k.a(resources);
        }
        int i4 = this.Z;
        if (i4 != 0) {
            this.p.setTheme(i4);
            if (i3 >= 23) {
                this.p.getTheme().applyStyle(this.Z, true);
            }
        }
        if (z) {
            Object obj = this.o;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.k) {
                    if (((androidx.lifecycle.k) activity).getLifecycle().b().g(androidx.lifecycle.g.c.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.W) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void Q0(View view) {
        view.setBackgroundColor((androidx.core.view.u.H(view) & 8192) != 0 ? androidx.core.content.a.d(this.p, c.a.c.f2695b) : androidx.core.content.a.d(this.p, c.a.c.a));
    }

    private void R() {
        m mVar = this.c0;
        if (mVar != null) {
            mVar.a();
        }
        m mVar2 = this.d0;
        if (mVar2 != null) {
            mVar2.a();
        }
    }

    private Configuration U(Context context, int i2, Configuration configuration) {
        int i3;
        if (i2 != 1) {
            i3 = i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup V() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.p.obtainStyledAttributes(c.a.j.z0);
        int i2 = c.a.j.E0;
        if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c.a.j.N0, false)) {
            C(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i2, false)) {
            C(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c.a.j.F0, false)) {
            C(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c.a.j.G0, false)) {
            C(10);
        }
        this.O = typedArrayObtainStyledAttributes.getBoolean(c.a.j.A0, false);
        typedArrayObtainStyledAttributes.recycle();
        c0();
        this.q.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.p);
        if (this.P) {
            viewGroup = this.N ? (ViewGroup) layoutInflaterFrom.inflate(c.a.g.o, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(c.a.g.n, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(c.a.g.f2736f, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            this.p.getTheme().resolveAttribute(c.a.a.f2689f, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new c.a.o.d(this.p, typedValue.resourceId) : this.p).inflate(c.a.g.p, (ViewGroup) null);
            w wVar = (w) viewGroup.findViewById(c.a.f.p);
            this.w = wVar;
            wVar.setWindowCallback(k0());
            if (this.M) {
                this.w.h(109);
            }
            if (this.J) {
                this.w.h(2);
            }
            if (this.K) {
                this.w.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.L + ", windowActionBarOverlay: " + this.M + ", android:windowIsFloating: " + this.O + ", windowActionModeOverlay: " + this.N + ", windowNoTitle: " + this.P + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            androidx.core.view.u.v0(viewGroup, new c());
        } else if (viewGroup instanceof a0) {
            ((a0) viewGroup).setOnFitSystemWindowsListener(new d());
        }
        if (this.w == null) {
            this.H = (TextView) viewGroup.findViewById(c.a.f.M);
        }
        w0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(c.a.f.f2722b);
        ViewGroup viewGroup2 = (ViewGroup) this.q.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.q.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void b0() {
        if (this.F) {
            return;
        }
        this.G = V();
        CharSequence charSequenceJ0 = j0();
        if (!TextUtils.isEmpty(charSequenceJ0)) {
            w wVar = this.w;
            if (wVar != null) {
                wVar.setWindowTitle(charSequenceJ0);
            } else if (D0() != null) {
                D0().w(charSequenceJ0);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(charSequenceJ0);
                }
            }
        }
        M();
        B0(this.G);
        this.F = true;
        t tVarI0 = i0(0, false);
        if (this.X) {
            return;
        }
        if (tVarI0 == null || tVarI0.f188j == null) {
            p0(108);
        }
    }

    private void c0() {
        if (this.q == null) {
            Object obj = this.o;
            if (obj instanceof Activity) {
                N(((Activity) obj).getWindow());
            }
        }
        if (this.q == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration e0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                p.a(configuration, configuration2, configuration3);
            } else if (!c.i.j.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                q.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            if (i6 >= 17) {
                o.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private m g0(Context context) {
        if (this.d0 == null) {
            this.d0 = new l(context);
        }
        return this.d0;
    }

    private m h0(Context context) {
        if (this.c0 == null) {
            this.c0 = new n(androidx.appcompat.app.n.a(context));
        }
        return this.c0;
    }

    private void l0() {
        b0();
        if (this.L && this.t == null) {
            Object obj = this.o;
            if (obj instanceof Activity) {
                this.t = new androidx.appcompat.app.o((Activity) this.o, this.M);
            } else if (obj instanceof Dialog) {
                this.t = new androidx.appcompat.app.o((Dialog) this.o);
            }
            androidx.appcompat.app.a aVar = this.t;
            if (aVar != null) {
                aVar.q(this.h0);
            }
        }
    }

    private boolean m0(t tVar) {
        View view = tVar.f187i;
        if (view != null) {
            tVar.f186h = view;
            return true;
        }
        if (tVar.f188j == null) {
            return false;
        }
        if (this.y == null) {
            this.y = new u();
        }
        View view2 = (View) tVar.a(this.y);
        tVar.f186h = view2;
        return view2 != null;
    }

    private boolean n0(t tVar) {
        tVar.d(f0());
        tVar.f185g = new s(tVar.l);
        tVar.f181c = 81;
        return true;
    }

    private boolean o0(t tVar) {
        Context context = this.p;
        int i2 = tVar.a;
        if ((i2 == 0 || i2 == 108) && this.w != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(c.a.a.f2689f, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(c.a.a.f2690g, typedValue, true);
            } else {
                theme.resolveAttribute(c.a.a.f2690g, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                c.a.o.d dVar = new c.a.o.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.V(this);
        tVar.c(gVar);
        return true;
    }

    private void p0(int i2) {
        this.f0 = (1 << i2) | this.f0;
        if (this.e0) {
            return;
        }
        androidx.core.view.u.a0(this.q.getDecorView(), this.g0);
        this.e0 = true;
    }

    private boolean q0() {
        int i2;
        if (!this.b0 && (this.o instanceof Activity)) {
            PackageManager packageManager = this.p.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = i3 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.p, this.o.getClass()), i2);
                this.a0 = (activityInfo == null || (activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.a0 = false;
            }
        }
        this.b0 = true;
        return this.a0;
    }

    private boolean v0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        t tVarI0 = i0(i2, true);
        if (tVarI0.o) {
            return false;
        }
        return F0(tVarI0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean y0(int i2, KeyEvent keyEvent) {
        boolean zF0;
        w wVar;
        if (this.z != null) {
            return false;
        }
        boolean zF = true;
        t tVarI0 = i0(i2, true);
        if (i2 != 0 || (wVar = this.w) == null || !wVar.d() || ViewConfiguration.get(this.p).hasPermanentMenuKey()) {
            boolean z = tVarI0.o;
            if (z || tVarI0.n) {
                T(tVarI0, true);
                zF = z;
            } else if (tVarI0.m) {
                if (tVarI0.r) {
                    tVarI0.m = false;
                    zF0 = F0(tVarI0, keyEvent);
                } else {
                    zF0 = true;
                }
                if (zF0) {
                    C0(tVarI0, keyEvent);
                } else {
                    zF = false;
                }
            } else {
                zF = false;
            }
        } else if (this.w.b()) {
            zF = this.w.f();
        } else if (this.X || !F0(tVarI0, keyEvent)) {
            zF = false;
        } else {
            zF = this.w.g();
        }
        if (zF) {
            AudioManager audioManager = (AudioManager) this.p.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zF;
    }

    void A0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a aVarP = p();
            if (aVarP != null) {
                aVarP.h(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            t tVarI0 = i0(i2, true);
            if (tVarI0.o) {
                T(tVarI0, false);
            }
        }
    }

    void B0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public boolean C(int i2) {
        int iH0 = H0(i2);
        if (this.P && iH0 == 108) {
            return false;
        }
        if (this.L && iH0 == 1) {
            this.L = false;
        }
        if (iH0 == 1) {
            L0();
            this.P = true;
            return true;
        }
        if (iH0 == 2) {
            L0();
            this.J = true;
            return true;
        }
        if (iH0 == 5) {
            L0();
            this.K = true;
            return true;
        }
        if (iH0 == 10) {
            L0();
            this.N = true;
            return true;
        }
        if (iH0 == 108) {
            L0();
            this.L = true;
            return true;
        }
        if (iH0 != 109) {
            return this.q.requestFeature(iH0);
        }
        L0();
        this.M = true;
        return true;
    }

    @Override // androidx.appcompat.app.f
    public void D(int i2) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.p).inflate(i2, viewGroup);
        this.r.a().onContentChanged();
    }

    final androidx.appcompat.app.a D0() {
        return this.t;
    }

    @Override // androidx.appcompat.app.f
    public void E(View view) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.r.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void F(View view, ViewGroup.LayoutParams layoutParams) {
        b0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.r.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void H(Toolbar toolbar) {
        if (this.o instanceof Activity) {
            androidx.appcompat.app.a aVarP = p();
            if (aVarP instanceof androidx.appcompat.app.o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.u = null;
            if (aVarP != null) {
                aVarP.m();
            }
            if (toolbar != null) {
                androidx.appcompat.app.l lVar = new androidx.appcompat.app.l(toolbar, j0(), this.r);
                this.t = lVar;
                this.q.setCallback(lVar.z());
            } else {
                this.t = null;
                this.q.setCallback(this.r);
            }
            r();
        }
    }

    @Override // androidx.appcompat.app.f
    public void I(int i2) {
        this.Z = i2;
    }

    final boolean I0() {
        ViewGroup viewGroup;
        return this.F && (viewGroup = this.G) != null && androidx.core.view.u.O(viewGroup);
    }

    @Override // androidx.appcompat.app.f
    public final void J(CharSequence charSequence) {
        this.v = charSequence;
        w wVar = this.w;
        if (wVar != null) {
            wVar.setWindowTitle(charSequence);
            return;
        }
        if (D0() != null) {
            D0().w(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.f
    public c.a.o.b K(c.a.o.b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        c.a.o.b bVar = this.z;
        if (bVar != null) {
            bVar.c();
        }
        j jVar = new j(aVar);
        androidx.appcompat.app.a aVarP = p();
        if (aVarP != null) {
            c.a.o.b bVarX = aVarP.x(jVar);
            this.z = bVarX;
            if (bVarX != null && (eVar = this.s) != null) {
                eVar.onSupportActionModeStarted(bVarX);
            }
        }
        if (this.z == null) {
            this.z = K0(jVar);
        }
        return this.z;
    }

    c.a.o.b K0(c.a.o.b.a aVar) {
        c.a.o.b bVarOnWindowStartingSupportActionMode;
        Context dVar;
        androidx.appcompat.app.e eVar;
        a0();
        c.a.o.b bVar = this.z;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof j)) {
            aVar = new j(aVar);
        }
        androidx.appcompat.app.e eVar2 = this.s;
        if (eVar2 == null || this.X) {
            bVarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                bVarOnWindowStartingSupportActionMode = eVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                bVarOnWindowStartingSupportActionMode = null;
            }
        }
        if (bVarOnWindowStartingSupportActionMode != null) {
            this.z = bVarOnWindowStartingSupportActionMode;
        } else {
            if (this.A == null) {
                if (this.O) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.p.getTheme();
                    theme.resolveAttribute(c.a.a.f2689f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.p.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new c.a.o.d(this.p, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.p;
                    }
                    this.A = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, c.a.a.f2692i);
                    this.B = popupWindow;
                    androidx.core.widget.j.b(popupWindow, 2);
                    this.B.setContentView(this.A);
                    this.B.setWidth(-1);
                    dVar.getTheme().resolveAttribute(c.a.a.f2685b, typedValue, true);
                    this.A.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.B.setHeight(-2);
                    this.C = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.G.findViewById(c.a.f.f2728h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(f0()));
                        this.A = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.A != null) {
                a0();
                this.A.k();
                c.a.o.e eVar3 = new c.a.o.e(this.A.getContext(), this.A, aVar, this.B == null);
                if (aVar.b(eVar3, eVar3.e())) {
                    eVar3.k();
                    this.A.h(eVar3);
                    this.z = eVar3;
                    if (I0()) {
                        this.A.setAlpha(0.0f);
                        y yVarA = androidx.core.view.u.c(this.A).a(1.0f);
                        this.D = yVarA;
                        yVarA.f(new C0010g());
                    } else {
                        this.A.setAlpha(1.0f);
                        this.A.setVisibility(0);
                        this.A.sendAccessibilityEvent(32);
                        if (this.A.getParent() instanceof View) {
                            androidx.core.view.u.f0((View) this.A.getParent());
                        }
                    }
                    if (this.B != null) {
                        this.q.getDecorView().post(this.C);
                    }
                } else {
                    this.z = null;
                }
            }
        }
        c.a.o.b bVar2 = this.z;
        if (bVar2 != null && (eVar = this.s) != null) {
            eVar.onSupportActionModeStarted(bVar2);
        }
        return this.z;
    }

    void P(int i2, t tVar, Menu menu) {
        if (menu == null) {
            if (tVar == null && i2 >= 0) {
                t[] tVarArr = this.R;
                if (i2 < tVarArr.length) {
                    tVar = tVarArr[i2];
                }
            }
            if (tVar != null) {
                menu = tVar.f188j;
            }
        }
        if ((tVar == null || tVar.o) && !this.X) {
            this.r.a().onPanelClosed(i2, menu);
        }
    }

    final int P0(c0 c0Var, Rect rect) {
        int iK;
        boolean z;
        boolean z2;
        if (c0Var != null) {
            iK = c0Var.k();
        } else {
            iK = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.A;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            boolean z3 = true;
            if (this.A.isShown()) {
                if (this.i0 == null) {
                    this.i0 = new Rect();
                    this.j0 = new Rect();
                }
                Rect rect2 = this.i0;
                Rect rect3 = this.j0;
                if (c0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(c0Var.i(), c0Var.k(), c0Var.j(), c0Var.h());
                }
                w0.a(this.G, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                c0 c0VarE = androidx.core.view.u.E(this.G);
                int i5 = c0VarE == null ? 0 : c0VarE.i();
                int iJ = c0VarE == null ? 0 : c0VarE.j();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != i5 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = i5;
                            marginLayoutParams2.rightMargin = iJ;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.p);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = iJ;
                    this.G.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                z3 = view3 != null;
                if (z3 && view3.getVisibility() != 0) {
                    Q0(this.I);
                }
                if (!this.N && z3) {
                    iK = 0;
                }
                z = z3;
                z3 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.A.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.I;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iK;
    }

    void Q(androidx.appcompat.view.menu.g gVar) {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.w.i();
        Window.Callback callbackK0 = k0();
        if (callbackK0 != null && !this.X) {
            callbackK0.onPanelClosed(108, gVar);
        }
        this.Q = false;
    }

    void S(int i2) {
        T(i0(i2, true), true);
    }

    void T(t tVar, boolean z) {
        ViewGroup viewGroup;
        w wVar;
        if (z && tVar.a == 0 && (wVar = this.w) != null && wVar.b()) {
            Q(tVar.f188j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.p.getSystemService("window");
        if (windowManager != null && tVar.o && (viewGroup = tVar.f185g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                P(tVar.a, tVar, null);
            }
        }
        tVar.m = false;
        tVar.n = false;
        tVar.o = false;
        tVar.f186h = null;
        tVar.q = true;
        if (this.S == tVar) {
            this.S = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View W(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zJ0 = false;
        if (this.k0 == null) {
            String string = this.p.obtainStyledAttributes(c.a.j.z0).getString(c.a.j.D0);
            if (string == null) {
                this.k0 = new androidx.appcompat.app.j();
            } else {
                try {
                    this.k0 = (androidx.appcompat.app.j) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.k0 = new androidx.appcompat.app.j();
                }
            }
        }
        boolean z2 = f167j;
        if (z2) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zJ0 = J0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zJ0 = true;
            }
            z = zJ0;
        } else {
            z = false;
        }
        return this.k0.q(view, str, context, attributeSet, z, z2, true, v0.b());
    }

    void X() {
        androidx.appcompat.view.menu.g gVar;
        w wVar = this.w;
        if (wVar != null) {
            wVar.i();
        }
        if (this.B != null) {
            this.q.getDecorView().removeCallbacks(this.C);
            if (this.B.isShowing()) {
                try {
                    this.B.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.B = null;
        }
        a0();
        t tVarI0 = i0(0, false);
        if (tVarI0 == null || (gVar = tVarI0.f188j) == null) {
            return;
        }
        gVar.close();
    }

    boolean Y(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.o;
        if (((obj instanceof androidx.core.view.e.a) || (obj instanceof androidx.appcompat.app.h)) && (decorView = this.q.getDecorView()) != null && androidx.core.view.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.r.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? u0(keyCode, keyEvent) : x0(keyCode, keyEvent);
    }

    void Z(int i2) {
        t tVarI0;
        t tVarI1 = i0(i2, true);
        if (tVarI1.f188j != null) {
            Bundle bundle = new Bundle();
            tVarI1.f188j.T(bundle);
            if (bundle.size() > 0) {
                tVarI1.s = bundle;
            }
            tVarI1.f188j.h0();
            tVarI1.f188j.clear();
        }
        tVarI1.r = true;
        tVarI1.q = true;
        if ((i2 != 108 && i2 != 0) || this.w == null || (tVarI0 = i0(0, false)) == null) {
            return;
        }
        tVarI0.m = false;
        F0(tVarI0, null);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        t tVarD0;
        Window.Callback callbackK0 = k0();
        if (callbackK0 == null || this.X || (tVarD0 = d0(gVar.F())) == null) {
            return false;
        }
        return callbackK0.onMenuItemSelected(tVarD0.a, menuItem);
    }

    void a0() {
        y yVar = this.D;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        G0(true);
    }

    @Override // androidx.appcompat.app.f
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        b0();
        ((ViewGroup) this.G.findViewById(R.id.content)).addView(view, layoutParams);
        this.r.a().onContentChanged();
    }

    t d0(Menu menu) {
        t[] tVarArr = this.R;
        int length = tVarArr != null ? tVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            t tVar = tVarArr[i2];
            if (tVar != null && tVar.f188j == menu) {
                return tVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public boolean e() {
        return L(true);
    }

    final Context f0() {
        androidx.appcompat.app.a aVarP = p();
        Context contextJ = aVarP != null ? aVarP.j() : null;
        return contextJ == null ? this.p : contextJ;
    }

    @Override // androidx.appcompat.app.f
    public Context h(Context context) {
        this.U = true;
        int iS0 = s0(context, O());
        if (m && (context instanceof ContextThemeWrapper)) {
            try {
                r.a((ContextThemeWrapper) context, U(context, iS0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof c.a.o.d) {
            try {
                ((c.a.o.d) context).a(U(context, iS0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!l) {
            return super.h(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration configurationU = U(context, iS0, configuration.equals(configuration2) ? null : e0(configuration, configuration2));
            c.a.o.d dVar = new c.a.o.d(context, c.a.i.f2754d);
            dVar.a(configurationU);
            boolean z = false;
            try {
                z = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z) {
                androidx.core.content.d.f.d.a(dVar.getTheme());
            }
            return super.h(dVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    protected t i0(int i2, boolean z) {
        t[] tVarArr = this.R;
        if (tVarArr == null || tVarArr.length <= i2) {
            t[] tVarArr2 = new t[i2 + 1];
            if (tVarArr != null) {
                System.arraycopy(tVarArr, 0, tVarArr2, 0, tVarArr.length);
            }
            this.R = tVarArr2;
            tVarArr = tVarArr2;
        }
        t tVar = tVarArr[i2];
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(i2);
        tVarArr[i2] = tVar2;
        return tVar2;
    }

    final CharSequence j0() {
        Object obj = this.o;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.v;
    }

    @Override // androidx.appcompat.app.f
    public <T extends View> T k(int i2) {
        b0();
        return (T) this.q.findViewById(i2);
    }

    final Window.Callback k0() {
        return this.q.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b m() {
        return new h();
    }

    @Override // androidx.appcompat.app.f
    public int n() {
        return this.Y;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater o() {
        if (this.u == null) {
            l0();
            androidx.appcompat.app.a aVar = this.t;
            this.u = new c.a.o.g(aVar != null ? aVar.j() : this.p);
        }
        return this.u;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return W(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a p() {
        l0();
        return this.t;
    }

    @Override // androidx.appcompat.app.f
    public void q() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.p);
        if (layoutInflaterFrom.getFactory() == null) {
            androidx.core.view.f.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof g) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.f
    public void r() {
        androidx.appcompat.app.a aVarP = p();
        if (aVarP == null || !aVarP.k()) {
            p0(0);
        }
    }

    public boolean r0() {
        return this.E;
    }

    @Override // androidx.appcompat.app.f
    public void s(Configuration configuration) {
        androidx.appcompat.app.a aVarP;
        if (this.L && this.F && (aVarP = p()) != null) {
            aVarP.l(configuration);
        }
        androidx.appcompat.widget.h.b().g(this.p);
        L(false);
    }

    int s0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                    return h0(context).c();
                }
                return -1;
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return g0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.f
    public void t(Bundle bundle) {
        this.U = true;
        L(false);
        c0();
        Object obj = this.o;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = androidx.core.app.g.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarD0 = D0();
                if (aVarD0 == null) {
                    this.h0 = true;
                } else {
                    aVarD0.q(true);
                }
            }
            androidx.appcompat.app.f.c(this);
        }
        this.V = true;
    }

    boolean t0() {
        c.a.o.b bVar = this.z;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a aVarP = p();
        return aVarP != null && aVarP.g();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    @Override // androidx.appcompat.app.f
    public void u() {
        if (this.o instanceof Activity) {
            androidx.appcompat.app.f.A(this);
        }
        if (this.e0) {
            this.q.getDecorView().removeCallbacks(this.g0);
        }
        this.W = false;
        this.X = true;
        if (this.Y != -100) {
            Object obj = this.o;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f166i.put(this.o.getClass().getName(), Integer.valueOf(this.Y));
            } else {
                f166i.remove(this.o.getClass().getName());
            }
        } else {
            f166i.remove(this.o.getClass().getName());
        }
        androidx.appcompat.app.a aVar = this.t;
        if (aVar != null) {
            aVar.m();
        }
        R();
    }

    boolean u0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.T = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            v0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void v(Bundle bundle) {
        b0();
    }

    @Override // androidx.appcompat.app.f
    public void w() {
        androidx.appcompat.app.a aVarP = p();
        if (aVarP != null) {
            aVarP.u(true);
        }
    }

    boolean w0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarP = p();
        if (aVarP != null && aVarP.n(i2, keyEvent)) {
            return true;
        }
        t tVar = this.S;
        if (tVar != null && E0(tVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            t tVar2 = this.S;
            if (tVar2 != null) {
                tVar2.n = true;
            }
            return true;
        }
        if (this.S == null) {
            t tVarI0 = i0(0, true);
            F0(tVarI0, keyEvent);
            boolean zE0 = E0(tVarI0, keyEvent.getKeyCode(), keyEvent, 1);
            tVarI0.m = false;
            if (zE0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void x(Bundle bundle) {
    }

    boolean x0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.T;
            this.T = false;
            t tVarI0 = i0(0, false);
            if (tVarI0 != null && tVarI0.o) {
                if (!z) {
                    T(tVarI0, true);
                }
                return true;
            }
            if (t0()) {
                return true;
            }
        } else if (i2 == 82) {
            y0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void y() {
        this.W = true;
        e();
    }

    @Override // androidx.appcompat.app.f
    public void z() {
        this.W = false;
        androidx.appcompat.app.a aVarP = p();
        if (aVarP != null) {
            aVarP.u(false);
        }
    }

    void z0(int i2) {
        androidx.appcompat.app.a aVarP;
        if (i2 != 108 || (aVarP = p()) == null) {
            return;
        }
        aVarP.h(true);
    }

    g(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private g(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        c.e.g<String, Integer> gVar;
        Integer num;
        androidx.appcompat.app.d dVarM0;
        this.D = null;
        this.E = true;
        this.Y = -100;
        this.g0 = new b();
        this.p = context;
        this.s = eVar;
        this.o = obj;
        if (this.Y == -100 && (obj instanceof Dialog) && (dVarM0 = M0()) != null) {
            this.Y = dVarM0.getDelegate().n();
        }
        if (this.Y == -100 && (num = (gVar = f166i).get(obj.getClass().getName())) != null) {
            this.Y = num.intValue();
            gVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            N(window);
        }
        androidx.appcompat.widget.h.h();
    }

    /* JADX INFO: compiled from: AppCompatDelegateImpl.java */
    class k extends c.a.o.i {
        k(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            c.a.o.f.a aVar = new c.a.o.f.a(g.this.p, callback);
            c.a.o.b bVarK = g.this.K(aVar);
            if (bVarK != null) {
                return aVar.e(bVarK);
            }
            return null;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return g.this.Y(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || g.this.w0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            g.this.z0(i2);
            return true;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            g.this.A0(i2);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.e0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.e0(false);
            }
            return zOnPreparePanel;
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            androidx.appcompat.view.menu.g gVar;
            t tVarI0 = g.this.i0(0, true);
            if (tVarI0 == null || (gVar = tVarI0.f188j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i2);
            }
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return g.this.r0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // c.a.o.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (g.this.r0() && i2 == 0) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }
}
