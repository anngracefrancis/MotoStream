package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.e;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends f implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f25344c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(f fVar, Object[] objArr) {
        super(fVar, null);
        m.f(objArr, "values");
        this.f25344c = objArr;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.e
    public List<f> e() {
        Object[] objArr = this.f25344c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            f.a aVar = f.a;
            m.c(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
