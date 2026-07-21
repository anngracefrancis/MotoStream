package kotlin.reflect.y.internal.j0.i.r;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    static final class a extends Lambda implements Function1<g0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e0 f24360f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(1);
            this.f24360f = e0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "it");
            return this.f24360f;
        }
    }

    /* JADX INFO: compiled from: ConstantValueFactory.kt */
    static final class b extends Lambda implements Function1<g0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f24361f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(1);
            this.f24361f = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "module");
            m0 m0VarO = g0Var.o().O(this.f24361f);
            m.e(m0VarO, "module.builtIns.getPrimi…KotlinType(componentType)");
            return m0VarO;
        }
    }

    private h() {
    }

    private final kotlin.reflect.y.internal.j0.i.r.b a(List<?> list, i iVar) {
        List listE0 = c0.E0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listE0.iterator();
        while (it.hasNext()) {
            g<?> gVarC = c(it.next());
            if (gVarC != null) {
                arrayList.add(gVarC);
            }
        }
        return new kotlin.reflect.y.internal.j0.i.r.b(arrayList, new b(iVar));
    }

    public final kotlin.reflect.y.internal.j0.i.r.b b(List<? extends g<?>> list, e0 e0Var) {
        m.f(list, "value");
        m.f(e0Var, "type");
        return new kotlin.reflect.y.internal.j0.i.r.b(list, new a(e0Var));
    }

    public final g<?> c(Object obj) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(n.T((byte[]) obj), i.BYTE);
        }
        if (obj instanceof short[]) {
            return a(n.a0((short[]) obj), i.SHORT);
        }
        if (obj instanceof int[]) {
            return a(n.X((int[]) obj), i.INT);
        }
        if (obj instanceof long[]) {
            return a(n.Y((long[]) obj), i.LONG);
        }
        if (obj instanceof char[]) {
            return a(n.U((char[]) obj), i.CHAR);
        }
        if (obj instanceof float[]) {
            return a(n.W((float[]) obj), i.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(n.V((double[]) obj), i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(n.b0((boolean[]) obj), i.BOOLEAN);
        }
        if (obj == null) {
            return new s();
        }
        return null;
    }
}
