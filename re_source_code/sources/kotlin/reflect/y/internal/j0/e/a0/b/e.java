package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: JvmMetadataVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends kotlin.reflect.y.internal.j0.e.z.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f23888g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f23889h = new e(1, 7, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f23890i = new e(new int[0]);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f23891j;

    /* JADX INFO: compiled from: JvmMetadataVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        m.f(iArr, "versionArray");
        this.f23891j = z;
    }

    public boolean h() {
        boolean zF;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.f23891j) {
            zF = f(f23889h);
        } else {
            int iA = a();
            e eVar = f23889h;
            zF = iA == eVar.a() && b() <= eVar.b() + 1;
        }
        return zF;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int... iArr) {
        this(iArr, false);
        m.f(iArr, "numbers");
    }
}
