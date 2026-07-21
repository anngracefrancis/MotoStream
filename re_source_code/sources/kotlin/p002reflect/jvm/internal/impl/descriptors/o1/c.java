package kotlin.p002reflect.jvm.internal.impl.descriptors.o1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;

/* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class a implements c {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c
        public boolean c(e eVar, y0 y0Var) {
            m.f(eVar, "classDescriptor");
            m.f(y0Var, "functionDescriptor");
            return true;
        }
    }

    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class b implements c {
        public static final b a = new b();

        private b() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c
        public boolean c(e eVar, y0 y0Var) {
            m.f(eVar, "classDescriptor");
            m.f(y0Var, "functionDescriptor");
            return !y0Var.getAnnotations().R0(d.a());
        }
    }

    boolean c(e eVar, y0 y0Var);
}
