package com.bumptech.glide.load.o.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.load.l;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: GifDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f9418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9423k;
    private int l;
    private boolean m;
    private Paint n;
    private Rect o;
    private List<c.y.a.a.b> p;

    /* JADX INFO: compiled from: GifDrawable.java */
    static final class a extends Drawable.ConstantState {
        final g a;

        a(g gVar) {
            this.a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, com.bumptech.glide.l.a aVar, l<Bitmap> lVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.c(context), aVar, i2, i3, lVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.o == null) {
            this.o = new Rect();
        }
        return this.o;
    }

    private Paint h() {
        if (this.n == null) {
            this.n = new Paint(2);
        }
        return this.n;
    }

    private void j() {
        List<c.y.a.a.b> list = this.p;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.p.get(i2).a(this);
            }
        }
    }

    private void l() {
        this.f9423k = 0;
    }

    private void n() {
        com.bumptech.glide.r.j.a(!this.f9421i, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f9418f.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f9419g) {
                return;
            }
            this.f9419g = true;
            this.f9418f.a.s(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f9419g = false;
        this.f9418f.a.t(this);
    }

    @Override // com.bumptech.glide.load.o.g.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f9423k++;
        }
        int i2 = this.l;
        if (i2 == -1 || this.f9423k < i2) {
            return;
        }
        j();
        stop();
    }

    public ByteBuffer c() {
        return this.f9418f.a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f9421i) {
            return;
        }
        if (this.m) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.m = false;
        }
        canvas.drawBitmap(this.f9418f.a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f9418f.a.e();
    }

    public int f() {
        return this.f9418f.a.f();
    }

    public int g() {
        return this.f9418f.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9418f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f9418f.a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f9418f.a.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f9418f.a.k();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f9419g;
    }

    public void k() {
        this.f9421i = true;
        this.f9418f.a.a();
    }

    public void m(l<Bitmap> lVar, Bitmap bitmap) {
        this.f9418f.a.p(lVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        h().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.bumptech.glide.r.j.a(!this.f9421i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f9422j = z;
        if (!z) {
            o();
        } else if (this.f9420h) {
            n();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f9420h = true;
        l();
        if (this.f9422j) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f9420h = false;
        o();
    }

    c(a aVar) {
        this.f9422j = true;
        this.l = -1;
        this.f9418f = (a) com.bumptech.glide.r.j.d(aVar);
    }
}
