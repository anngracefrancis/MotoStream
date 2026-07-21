package com.airbnb.lottie.s.j;

import android.graphics.Paint;
import java.util.List;

/* JADX INFO: compiled from: ShapeStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements com.airbnb.lottie.s.j.b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.s.i.b> f8785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.a f8786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.d f8787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.s.i.b f8788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f8789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f8790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f8791i;

    /* JADX INFO: compiled from: ShapeStroke.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8792b;

        static {
            int[] iArr = new int[c.values().length];
            f8792b = iArr;
            try {
                iArr[c.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8792b[c.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8792b[c.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: ShapeStroke.java */
    public enum b {
        Butt,
        Round,
        Unknown;

        public Paint.Cap g() {
            int i2 = a.a[ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: ShapeStroke.java */
    public enum c {
        Miter,
        Round,
        Bevel;

        public Paint.Join g() {
            int i2 = a.f8792b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, com.airbnb.lottie.s.i.b bVar, List<com.airbnb.lottie.s.i.b> list, com.airbnb.lottie.s.i.a aVar, com.airbnb.lottie.s.i.d dVar, com.airbnb.lottie.s.i.b bVar2, b bVar3, c cVar, float f2) {
        this.a = str;
        this.f8784b = bVar;
        this.f8785c = list;
        this.f8786d = aVar;
        this.f8787e = dVar;
        this.f8788f = bVar2;
        this.f8789g = bVar3;
        this.f8790h = cVar;
        this.f8791i = f2;
    }

    @Override // com.airbnb.lottie.s.j.b
    public com.airbnb.lottie.q.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar) {
        return new com.airbnb.lottie.q.a.q(fVar, aVar, this);
    }

    public b b() {
        return this.f8789g;
    }

    public com.airbnb.lottie.s.i.a c() {
        return this.f8786d;
    }

    public com.airbnb.lottie.s.i.b d() {
        return this.f8784b;
    }

    public c e() {
        return this.f8790h;
    }

    public List<com.airbnb.lottie.s.i.b> f() {
        return this.f8785c;
    }

    public float g() {
        return this.f8791i;
    }

    public String h() {
        return this.a;
    }

    public com.airbnb.lottie.s.i.d i() {
        return this.f8787e;
    }

    public com.airbnb.lottie.s.i.b j() {
        return this.f8788f;
    }
}
