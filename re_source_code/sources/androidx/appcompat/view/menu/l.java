package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.u;

/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m.a f345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k f346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f347k;
    private final PopupWindow.OnDismissListener l;

    /* JADX INFO: compiled from: MenuPopupHelper.java */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    private k a() {
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        k dVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(c.a.d.f2703c) ? new d(this.a, this.f342f, this.f340d, this.f341e, this.f339c) : new q(this.a, this.f338b, this.f342f, this.f340d, this.f341e, this.f339c);
        dVar.m(this.f338b);
        dVar.v(this.l);
        dVar.q(this.f342f);
        dVar.g(this.f345i);
        dVar.s(this.f344h);
        dVar.t(this.f343g);
        return dVar;
    }

    private void l(int i2, int i3, boolean z, boolean z2) {
        k kVarC = c();
        kVarC.w(z2);
        if (z) {
            if ((androidx.core.view.d.b(this.f343g, u.y(this.f342f)) & 7) == 5) {
                i2 -= this.f342f.getWidth();
            }
            kVarC.u(i2);
            kVarC.x(i3);
            int i4 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            kVarC.r(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        kVarC.show();
    }

    public void b() {
        if (d()) {
            this.f346j.dismiss();
        }
    }

    public k c() {
        if (this.f346j == null) {
            this.f346j = a();
        }
        return this.f346j;
    }

    public boolean d() {
        k kVar = this.f346j;
        return kVar != null && kVar.a();
    }

    protected void e() {
        this.f346j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f347k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f342f = view;
    }

    public void g(boolean z) {
        this.f344h = z;
        k kVar = this.f346j;
        if (kVar != null) {
            kVar.s(z);
        }
    }

    public void h(int i2) {
        this.f343g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f347k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.f345i = aVar;
        k kVar = this.f346j;
        if (kVar != null) {
            kVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f342f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f342f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f343g = 8388611;
        this.l = new a();
        this.a = context;
        this.f338b = gVar;
        this.f342f = view;
        this.f339c = z;
        this.f340d = i2;
        this.f341e = i3;
    }
}
