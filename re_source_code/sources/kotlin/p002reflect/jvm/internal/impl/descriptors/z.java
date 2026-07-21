package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.t;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.s;

/* JADX INFO: compiled from: InlineClassRepresentation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class z<Type extends k> extends g1<Type> {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f25385b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(f fVar, Type type) {
        super(null);
        m.f(fVar, "underlyingPropertyName");
        m.f(type, "underlyingType");
        this.a = fVar;
        this.f25385b = type;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.g1
    public List<Pair<f, Type>> a() {
        return t.e(s.a(this.a, this.f25385b));
    }

    public final f c() {
        return this.a;
    }

    public final Type d() {
        return this.f25385b;
    }
}
