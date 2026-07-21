package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MutablePropertyReference0Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public q(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(c.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        throw null;
    }

    public void set(Object obj) {
        throw null;
    }

    public q(Class cls, String str, String str2, int i2) {
        super(c.NO_RECEIVER, cls, str, str2, i2);
    }

    public q(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
