package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: Jsr305Settings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private final f0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f0 f23700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<c, f0> f23701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f23702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23703e;

    /* JADX INFO: compiled from: Jsr305Settings.kt */
    static final class a extends Lambda implements Function0<String[]> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            y yVar = y.this;
            List listC = t.c();
            listC.add(yVar.a().k());
            f0 f0VarB = yVar.b();
            if (f0VarB != null) {
                listC.add("under-migration:" + f0VarB.k());
            }
            for (Map.Entry<c, f0> entry : yVar.c().entrySet()) {
                listC.add('@' + entry.getKey() + ':' + entry.getValue().k());
            }
            Object[] array = t.a(listC).toArray(new String[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (String[]) array;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(f0 f0Var, f0 f0Var2, Map<c, ? extends f0> map) {
        m.f(f0Var, "globalLevel");
        m.f(map, "userDefinedLevelForSpecificAnnotation");
        this.a = f0Var;
        this.f23700b = f0Var2;
        this.f23701c = map;
        this.f23702d = i.b(new a());
        f0 f0Var3 = f0.IGNORE;
        this.f23703e = f0Var == f0Var3 && f0Var2 == f0Var3 && map.isEmpty();
    }

    public final f0 a() {
        return this.a;
    }

    public final f0 b() {
        return this.f23700b;
    }

    public final Map<c, f0> c() {
        return this.f23701c;
    }

    public final boolean d() {
        return this.f23703e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a == yVar.a && this.f23700b == yVar.f23700b && m.a(this.f23701c, yVar.f23701c);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        f0 f0Var = this.f23700b;
        return ((iHashCode + (f0Var == null ? 0 : f0Var.hashCode())) * 31) + this.f23701c.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.a + ", migrationLevel=" + this.f23700b + ", userDefinedLevelForSpecificAnnotation=" + this.f23701c + ')';
    }

    public /* synthetic */ y(f0 f0Var, f0 f0Var2, Map map, int i2, g gVar) {
        this(f0Var, (i2 & 2) != 0 ? null : f0Var2, (i2 & 4) != 0 ? q0.i() : map);
    }
}
