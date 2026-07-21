package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    public KFunction a(i iVar) {
        return iVar;
    }

    public KClass b(Class cls) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer c(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    public KMutableProperty0 d(p pVar) {
        return pVar;
    }

    public KMutableProperty1 e(r rVar) {
        return rVar;
    }

    public KProperty0 f(v vVar) {
        return vVar;
    }

    public KProperty1 g(x xVar) {
        return xVar;
    }

    public KProperty2 h(z zVar) {
        return zVar;
    }

    public String i(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String j(Lambda lambda) {
        return i(lambda);
    }
}
