package kotlin.reflect.y.internal.j0.d.a;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends h0 {
    public static final e n = new e();

    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    static final class a extends Lambda implements Function1<b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y0 f23362f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(y0 y0Var) {
            super(1);
            this.f23362f = y0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(h0.a.j().containsKey(v.d(this.f23362f)));
        }
    }

    private e() {
    }

    public final f i(y0 y0Var) {
        m.f(y0Var, "functionDescriptor");
        Map<String, f> mapJ = h0.a.j();
        String strD = v.d(y0Var);
        if (strD == null) {
            return null;
        }
        return mapJ.get(strD);
    }

    public final boolean j(y0 y0Var) {
        m.f(y0Var, "functionDescriptor");
        return h.f0(y0Var) && kotlin.reflect.y.internal.j0.i.t.a.c(y0Var, false, new a(y0Var), 1, null) != null;
    }

    public final boolean k(y0 y0Var) {
        m.f(y0Var, "<this>");
        return m.a(y0Var.getName().k(), "removeAt") && m.a(v.d(y0Var), h0.a.h().b());
    }
}
