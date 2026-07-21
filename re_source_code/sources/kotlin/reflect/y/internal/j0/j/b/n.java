package kotlin.reflect.y.internal.j0.j.b;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.i.r.b;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: DeserializedArrayValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e0 f24600c;

    /* JADX INFO: compiled from: DeserializedArrayValue.kt */
    static final class a extends Lambda implements Function1<g0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e0 f24601f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(1);
            this.f24601f = e0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "it");
            return this.f24601f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(List<? extends g<?>> list, e0 e0Var) {
        super(list, new a(e0Var));
        m.f(list, "value");
        m.f(e0Var, "type");
        this.f24600c = e0Var;
    }

    public final e0 c() {
        return this.f24600c;
    }
}
