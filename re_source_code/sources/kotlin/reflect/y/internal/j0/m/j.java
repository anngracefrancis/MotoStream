package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
final class j implements f {
    public static final j a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24905b = "second parameter must be of type KProperty<*> or its supertype";

    private j() {
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public boolean b(y yVar) {
        m.f(yVar, "functionDescriptor");
        i1 i1Var = yVar.f().get(1);
        kotlin.f0.y.e.j0.b.j.b bVar = kotlin.reflect.y.internal.j0.b.j.a;
        m.e(i1Var, "secondParameter");
        e0 e0VarA = bVar.a(a.l(i1Var));
        if (e0VarA == null) {
            return false;
        }
        e0 type = i1Var.getType();
        m.e(type, "secondParameter.type");
        return kotlin.reflect.y.internal.j0.l.x1.a.o(e0VarA, kotlin.reflect.y.internal.j0.l.x1.a.s(type));
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String getDescription() {
        return f24905b;
    }
}
