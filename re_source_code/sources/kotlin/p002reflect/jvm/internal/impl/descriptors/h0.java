package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.w1.k;

/* JADX INFO: compiled from: MultiFieldValueClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h0<Type extends k> extends g1<Type> {
    private final List<Pair<f, Type>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<f, Type> f25144b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h0(List<? extends Pair<f, ? extends Type>> list) {
        super(null);
        m.f(list, "underlyingPropertyNamesToTypes");
        this.a = list;
        Map<f, Type> mapQ = q0.q(a());
        if (!(mapQ.size() == a().size())) {
            throw new IllegalArgumentException("Some properties have the same names".toString());
        }
        this.f25144b = mapQ;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g1
    public List<Pair<f, Type>> a() {
        return this.a;
    }
}
