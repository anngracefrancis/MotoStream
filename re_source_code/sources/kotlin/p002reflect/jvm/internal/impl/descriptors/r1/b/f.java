package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.b;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements b {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.f f25342b;

    /* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final f a(Object obj, kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(obj, "value");
            if (d.g(obj.getClass())) {
                return new q(fVar, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new g(fVar, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new j(fVar, (Object[]) obj);
            }
            return obj instanceof Class ? new m(fVar, (Class) obj) : new s(fVar, obj);
        }
    }

    private f(kotlin.reflect.y.internal.j0.f.f fVar) {
        this.f25342b = fVar;
    }

    public /* synthetic */ f(kotlin.reflect.y.internal.j0.f.f fVar, g gVar) {
        this(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.b
    public kotlin.reflect.y.internal.j0.f.f getName() {
        return this.f25342b;
    }
}
