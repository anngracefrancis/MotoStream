package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: MutablePropertyReference1.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends t implements KMutableProperty1 {
    public r(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.f(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.a getGetter() {
        return ((KMutableProperty1) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty1.a getSetter() {
        return ((KMutableProperty1) getReflected()).getSetter();
    }
}
