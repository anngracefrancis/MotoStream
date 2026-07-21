package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends t implements KMutableProperty0 {
    public p() {
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.e(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    public p(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty0.a getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty0.a getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    public p(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
