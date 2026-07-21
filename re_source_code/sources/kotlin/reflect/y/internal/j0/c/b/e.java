package kotlin.reflect.y.internal.j0.c.b;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f23313f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e f23314g = new e(-1, -1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f23315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f23316i;

    /* JADX INFO: compiled from: LookupLocation.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final e a() {
            return e.f23314g;
        }
    }

    public e(int i2, int i3) {
        this.f23315h = i2;
        this.f23316i = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f23315h == eVar.f23315h && this.f23316i == eVar.f23316i;
    }

    public int hashCode() {
        return (this.f23315h * 31) + this.f23316i;
    }

    public String toString() {
        return "Position(line=" + this.f23315h + ", column=" + this.f23316i + ')';
    }
}
