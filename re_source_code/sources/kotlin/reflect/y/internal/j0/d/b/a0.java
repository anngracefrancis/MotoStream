package kotlin.reflect.y.internal.j0.d.b;

import com.google.android.gms.ads.AdRequest;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: TypeMappingMode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f23722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f23723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f23724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a0 f23725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a0 f23726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a0 f23727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a0 f23728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a0 f23729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a0 f23730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f23731k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final a0 p;
    private final boolean q;
    private final a0 r;
    private final a0 s;
    private final boolean t;

    /* JADX INFO: compiled from: TypeMappingMode.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: TypeMappingMode.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.IN_VARIANCE.ordinal()] = 1;
            iArr[r1.INVARIANT.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        a0 a0Var = null;
        boolean z5 = false;
        a0 a0Var2 = null;
        a0 a0Var3 = null;
        boolean z6 = false;
        g gVar = null;
        a0 a0Var4 = new a0(z, false, z2, z3, z4, a0Var, z5, a0Var2, a0Var3, z6, 1023, gVar);
        f23722b = a0Var4;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        a0 a0Var5 = null;
        a0 a0Var6 = null;
        boolean z13 = true;
        g gVar2 = null;
        a0 a0Var7 = new a0(z7, z8, z9, z10, z11, null, z12, a0Var5, a0Var6, z13, 511, gVar2);
        f23723c = a0Var7;
        f23724d = new a0(z, true, z2, z3, z4, a0Var, z5, a0Var2, a0Var3, z6, 1021, gVar);
        int i2 = 988;
        f23725e = new a0(z, false, z2, z3, z4, a0Var4, z5, a0Var2, a0Var3, z6, i2, gVar);
        f23726f = new a0(z7, z8, z9, z10, z11, a0Var7, z12, a0Var5, a0Var6, z13, 476, gVar2);
        f23727g = new a0(z, true, z2, z3, z4, a0Var4, z5, a0Var2, a0Var3, z6, i2, gVar);
        boolean z14 = false;
        boolean z15 = true;
        f23728h = new a0(z, z14, z2, z15, z4, a0Var4, z5, a0Var2, a0Var3, z6, 983, gVar);
        f23729i = new a0(z, z14, z2, z15, z4, a0Var4, z5, a0Var2, a0Var3, z6, 919, gVar);
        f23730j = new a0(z, z14, true, false, z4, a0Var4, z5, a0Var2, a0Var3, z6, 984, gVar);
    }

    public a0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, a0 a0Var, boolean z6, a0 a0Var2, a0 a0Var3, boolean z7) {
        this.f23731k = z;
        this.l = z2;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = a0Var;
        this.q = z6;
        this.r = a0Var2;
        this.s = a0Var3;
        this.t = z7;
    }

    public final boolean a() {
        return this.q;
    }

    public final boolean b() {
        return this.t;
    }

    public final boolean c() {
        return this.l;
    }

    public final boolean d() {
        return this.f23731k;
    }

    public final boolean e() {
        return this.m;
    }

    public final a0 f(r1 r1Var, boolean z) {
        m.f(r1Var, "effectiveVariance");
        if (!z || !this.m) {
            int i2 = b.a[r1Var.ordinal()];
            if (i2 == 1) {
                a0 a0Var = this.r;
                if (a0Var != null) {
                    return a0Var;
                }
            } else if (i2 != 2) {
                a0 a0Var2 = this.p;
                if (a0Var2 != null) {
                    return a0Var2;
                }
            } else {
                a0 a0Var3 = this.s;
                if (a0Var3 != null) {
                    return a0Var3;
                }
            }
        }
        return this;
    }

    public final a0 g() {
        return new a0(this.f23731k, true, this.m, this.n, this.o, this.p, this.q, this.r, this.s, false, AdRequest.MAX_CONTENT_URL_LENGTH, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ a0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, a0 a0Var, boolean z6, a0 a0Var2, a0 a0Var3, boolean z7, int i2, g gVar) {
        boolean z8 = (i2 & 1) != 0 ? true : z;
        boolean z9 = (i2 & 2) != 0 ? true : z2;
        boolean z10 = (i2 & 4) != 0 ? false : z3;
        boolean z11 = (i2 & 8) != 0 ? false : z4;
        boolean z12 = (i2 & 16) != 0 ? false : z5;
        a0 a0Var4 = (i2 & 32) != 0 ? null : a0Var;
        this(z8, z9, z10, z11, z12, a0Var4, (i2 & 64) == 0 ? z6 : true, (i2 & 128) != 0 ? a0Var4 : a0Var2, (i2 & 256) != 0 ? a0Var4 : a0Var3, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 ? z7 : false);
    }
}
