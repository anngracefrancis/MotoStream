package e.e.b.c.t;

import android.content.Context;
import android.graphics.Color;
import e.e.b.c.x.b;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f21077d;

    public a(Context context) {
        this.a = b.b(context, e.e.b.c.b.r, false);
        this.f21075b = e.e.b.c.q.a.a(context, e.e.b.c.b.q, 0);
        this.f21076c = e.e.b.c.q.a.a(context, e.e.b.c.b.o, 0);
        this.f21077d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i2) {
        return c.i.e.a.o(i2, 255) == this.f21076c;
    }

    public float a(float f2) {
        float f3 = this.f21077d;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i2, float f2) {
        float fA = a(f2);
        return c.i.e.a.o(e.e.b.c.q.a.f(c.i.e.a.o(i2, 255), this.f21075b, fA), Color.alpha(i2));
    }

    public int c(int i2, float f2) {
        return (this.a && e(i2)) ? b(i2, f2) : i2;
    }

    public boolean d() {
        return this.a;
    }
}
