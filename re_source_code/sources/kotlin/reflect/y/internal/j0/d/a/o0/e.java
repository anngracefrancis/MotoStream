package kotlin.reflect.y.internal.j0.d.a.o0;

import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f23613b = new e(null, null, false, false, 8, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f23614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f23615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f23617f;

    /* JADX INFO: compiled from: typeQualifiers.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final e a() {
            return e.f23613b;
        }
    }

    public e(h hVar, f fVar, boolean z, boolean z2) {
        this.f23614c = hVar;
        this.f23615d = fVar;
        this.f23616e = z;
        this.f23617f = z2;
    }

    public final boolean b() {
        return this.f23616e;
    }

    public final f c() {
        return this.f23615d;
    }

    public final h d() {
        return this.f23614c;
    }

    public final boolean e() {
        return this.f23617f;
    }

    public /* synthetic */ e(h hVar, f fVar, boolean z, boolean z2, int i2, g gVar) {
        this(hVar, fVar, z, (i2 & 8) != 0 ? false : z2);
    }
}
