package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MutablePropertyReference1Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends r {
    public s(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(c.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void s(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}
