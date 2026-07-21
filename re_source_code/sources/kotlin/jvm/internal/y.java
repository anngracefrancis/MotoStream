package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends x {
    public y(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(c.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public y(Class cls, String str, String str2, int i2) {
        super(c.NO_RECEIVER, cls, str, str2, i2);
    }
}
