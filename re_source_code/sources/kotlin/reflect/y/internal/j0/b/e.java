package kotlin.reflect.y.internal.j0.b;

import kotlin.jvm.internal.g;
import kotlin.reflect.y.internal.j0.k.f;

/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f23157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e f23158i;

    /* JADX INFO: compiled from: DefaultBuiltIns.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final e a() {
            return e.f23158i;
        }
    }

    static {
        g gVar = null;
        f23157h = new a(gVar);
        f23158i = new e(false, 1, gVar);
    }

    public e(boolean z) {
        super(new f("DefaultBuiltIns"));
        if (z) {
            f(false);
        }
    }

    public /* synthetic */ e(boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? true : z);
    }
}
