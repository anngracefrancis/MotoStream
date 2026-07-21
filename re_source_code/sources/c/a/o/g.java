package c.a.o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.y;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: SupportMenuInflater.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {
    static final Class<?>[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Class<?>[] f2816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object[] f2817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object[] f2818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Context f2819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f2820f;

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Class<?>[] f2821f = {MenuItem.class};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f2822g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Method f2823h;

        public a(Object obj, String str) {
            this.f2822g = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2823h = cls.getMethod(str, f2821f);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2823h.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2823h.invoke(this.f2822g, menuItem)).booleanValue();
                }
                this.f2823h.invoke(this.f2822g, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SupportMenuInflater.java */
    private class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2827e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f2828f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2829g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f2830h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2831i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2832j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f2833k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f2819e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (g.this.f2819e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.a, g.this.f2817c));
                z = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i3);
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                androidx.core.view.h.a(menuItem, bVar);
            }
            androidx.core.view.h.c(menuItem, this.B);
            androidx.core.view.h.h(menuItem, this.C);
            androidx.core.view.h.b(menuItem, this.n, this.o);
            androidx.core.view.h.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                androidx.core.view.h.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                androidx.core.view.h.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2830h = true;
            i(this.a.add(this.f2824b, this.f2831i, this.f2832j, this.f2833k));
        }

        public SubMenu b() {
            this.f2830h = true;
            SubMenu subMenuAddSubMenu = this.a.addSubMenu(this.f2824b, this.f2831i, this.f2832j, this.f2833k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f2830h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f2819e.obtainStyledAttributes(attributeSet, c.a.j.r1);
            this.f2824b = typedArrayObtainStyledAttributes.getResourceId(c.a.j.t1, 0);
            this.f2825c = typedArrayObtainStyledAttributes.getInt(c.a.j.v1, 0);
            this.f2826d = typedArrayObtainStyledAttributes.getInt(c.a.j.w1, 0);
            this.f2827e = typedArrayObtainStyledAttributes.getInt(c.a.j.x1, 0);
            this.f2828f = typedArrayObtainStyledAttributes.getBoolean(c.a.j.u1, true);
            this.f2829g = typedArrayObtainStyledAttributes.getBoolean(c.a.j.s1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            q0 q0VarU = q0.u(g.this.f2819e, attributeSet, c.a.j.y1);
            this.f2831i = q0VarU.n(c.a.j.B1, 0);
            this.f2832j = (q0VarU.k(c.a.j.E1, this.f2825c) & (-65536)) | (q0VarU.k(c.a.j.F1, this.f2826d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            this.f2833k = q0VarU.p(c.a.j.G1);
            this.l = q0VarU.p(c.a.j.H1);
            this.m = q0VarU.n(c.a.j.z1, 0);
            this.n = c(q0VarU.o(c.a.j.I1));
            this.o = q0VarU.k(c.a.j.P1, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            this.p = c(q0VarU.o(c.a.j.J1));
            this.q = q0VarU.k(c.a.j.T1, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            int i2 = c.a.j.K1;
            if (q0VarU.s(i2)) {
                this.r = q0VarU.a(i2, false) ? 1 : 0;
            } else {
                this.r = this.f2827e;
            }
            this.s = q0VarU.a(c.a.j.C1, false);
            this.t = q0VarU.a(c.a.j.D1, this.f2828f);
            this.u = q0VarU.a(c.a.j.A1, this.f2829g);
            this.v = q0VarU.k(c.a.j.U1, -1);
            this.z = q0VarU.o(c.a.j.L1);
            this.w = q0VarU.n(c.a.j.M1, 0);
            this.x = q0VarU.o(c.a.j.O1);
            String strO = q0VarU.o(c.a.j.N1);
            this.y = strO;
            boolean z = strO != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (androidx.core.view.b) e(strO, g.f2816b, g.this.f2818d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = q0VarU.p(c.a.j.Q1);
            this.C = q0VarU.p(c.a.j.V1);
            int i3 = c.a.j.S1;
            if (q0VarU.s(i3)) {
                this.E = y.e(q0VarU.k(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = c.a.j.R1;
            if (q0VarU.s(i4)) {
                this.D = q0VarU.c(i4);
            } else {
                this.D = null;
            }
            q0VarU.w();
            this.f2830h = false;
        }

        public void h() {
            this.f2824b = 0;
            this.f2825c = 0;
            this.f2826d = 0;
            this.f2827e = 0;
            this.f2828f = true;
            this.f2829g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        a = clsArr;
        f2816b = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f2819e = context;
        Object[] objArr = {context};
        this.f2817c = objArr;
        this.f2818d = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            androidx.core.view.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f2820f == null) {
            this.f2820f = a(this.f2819e);
        }
        return this.f2820f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof c.i.f.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f2819e.getResources().getLayout(i2);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
