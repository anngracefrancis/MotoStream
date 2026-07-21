package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.n;

/* JADX INFO: compiled from: ReflectJavaField.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends t implements n {
    private final Field a;

    public r(Field field) {
        m.f(field, "member");
        this.a = field;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.n
    public boolean G() {
        return U().isEnumConstant();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.n
    public boolean O() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.t
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Field U() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.n
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public z getType() {
        z.a aVar = z.a;
        Type genericType = U().getGenericType();
        m.e(genericType, "member.genericType");
        return aVar.a(genericType);
    }
}
