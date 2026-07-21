package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends b0 implements KProperty1 {
    public x(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.h(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.a getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }
}
