package com.bumptech.glide.p.l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class j<T extends View, Z> extends com.bumptech.glide.p.l.a<Z> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f9521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Integer f9522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final T f9523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f9524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View.OnAttachStateChangeListener f9525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f9526k;
    private boolean l;

    /* JADX INFO: compiled from: ViewTarget.java */
    static final class a {
        static Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f9527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<h> f9528c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f9529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC0140a f9530e;

        /* JADX INFO: renamed from: com.bumptech.glide.p.l.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ViewTarget.java */
        private static final class ViewTreeObserverOnPreDrawListenerC0140a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final WeakReference<a> f9531f;

            ViewTreeObserverOnPreDrawListenerC0140a(a aVar) {
                this.f9531f = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f9531f.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f9527b = view;
        }

        private static int c(Context context) {
            if (a == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.r.j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return a.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f9529d && this.f9527b.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f9527b.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f9527b.getContext());
        }

        private int f() {
            int paddingTop = this.f9527b.getPaddingTop() + this.f9527b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f9527b.getLayoutParams();
            return e(this.f9527b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f9527b.getPaddingLeft() + this.f9527b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f9527b.getLayoutParams();
            return e(this.f9527b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it = new ArrayList(this.f9528c).iterator();
            while (it.hasNext()) {
                ((h) it.next()).g(i2, i3);
            }
        }

        void a() {
            if (this.f9528c.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f9527b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f9530e);
            }
            this.f9530e = null;
            this.f9528c.clear();
        }

        void d(h hVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                hVar.g(iG, iF);
                return;
            }
            if (!this.f9528c.contains(hVar)) {
                this.f9528c.add(hVar);
            }
            if (this.f9530e == null) {
                ViewTreeObserver viewTreeObserver = this.f9527b.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0140a viewTreeObserverOnPreDrawListenerC0140a = new ViewTreeObserverOnPreDrawListenerC0140a(this);
                this.f9530e = viewTreeObserverOnPreDrawListenerC0140a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0140a);
            }
        }

        void k(h hVar) {
            this.f9528c.remove(hVar);
        }
    }

    public j(T t) {
        this.f9523h = (T) com.bumptech.glide.r.j.d(t);
        this.f9524i = new a(t);
    }

    private Object c() {
        Integer num = f9522g;
        return num == null ? this.f9523h.getTag() : this.f9523h.getTag(num.intValue());
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9525j;
        if (onAttachStateChangeListener == null || this.l) {
            return;
        }
        this.f9523h.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.l = true;
    }

    private void e() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9525j;
        if (onAttachStateChangeListener == null || !this.l) {
            return;
        }
        this.f9523h.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.l = false;
    }

    private void f(Object obj) {
        Integer num = f9522g;
        if (num != null) {
            this.f9523h.setTag(num.intValue(), obj);
        } else {
            f9521f = true;
            this.f9523h.setTag(obj);
        }
    }

    @Override // com.bumptech.glide.p.l.a, com.bumptech.glide.p.l.i
    public com.bumptech.glide.p.d getRequest() {
        Object objC = c();
        if (objC == null) {
            return null;
        }
        if (objC instanceof com.bumptech.glide.p.d) {
            return (com.bumptech.glide.p.d) objC;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.p.l.i
    public void getSize(h hVar) {
        this.f9524i.d(hVar);
    }

    @Override // com.bumptech.glide.p.l.a, com.bumptech.glide.p.l.i
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f9524i.b();
        if (this.f9526k) {
            return;
        }
        e();
    }

    @Override // com.bumptech.glide.p.l.a, com.bumptech.glide.p.l.i
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        d();
    }

    @Override // com.bumptech.glide.p.l.i
    public void removeCallback(h hVar) {
        this.f9524i.k(hVar);
    }

    @Override // com.bumptech.glide.p.l.a, com.bumptech.glide.p.l.i
    public void setRequest(com.bumptech.glide.p.d dVar) {
        f(dVar);
    }

    public String toString() {
        return "Target for: " + this.f9523h;
    }
}
