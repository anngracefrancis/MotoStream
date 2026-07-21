package kotlin.reflect.y.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", HttpUrl.FRAGMENT_ENCODE_SET, "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CreateKCallableVisitor extends l<KCallableImpl<?>, u> {
    private final KDeclarationContainerImpl a;

    public CreateKCallableVisitor(KDeclarationContainerImpl kDeclarationContainerImpl) {
        m.f(kDeclarationContainerImpl, "container");
        this.a = kDeclarationContainerImpl;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l, kotlin.p002reflect.jvm.internal.impl.descriptors.o
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public KCallableImpl<?> g(y yVar, u uVar) {
        m.f(yVar, "descriptor");
        m.f(uVar, "data");
        return new KFunctionImpl(this.a, yVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public KCallableImpl<?> d(t0 t0Var, u uVar) {
        m.f(t0Var, "descriptor");
        m.f(uVar, "data");
        int i2 = (t0Var.f0() != null ? 1 : 0) + (t0Var.m0() != null ? 1 : 0);
        if (t0Var.j0()) {
            if (i2 == 0) {
                return new KMutableProperty0Impl(this.a, t0Var);
            }
            if (i2 == 1) {
                return new KMutableProperty1Impl(this.a, t0Var);
            }
            if (i2 == 2) {
                return new KMutableProperty2Impl(this.a, t0Var);
            }
        } else {
            if (i2 == 0) {
                return new KProperty0Impl(this.a, t0Var);
            }
            if (i2 == 1) {
                return new KProperty1Impl(this.a, t0Var);
            }
            if (i2 == 2) {
                return new KProperty2Impl(this.a, t0Var);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + t0Var);
    }
}
