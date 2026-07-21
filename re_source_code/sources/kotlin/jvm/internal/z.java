package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

/* JADX INFO: compiled from: PropertyReference2.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends b0 implements KProperty2 {
    public z(Class cls, String str, String str2, int i2) {
        super(c.NO_RECEIVER, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.i(this);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return t(obj, obj2);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty2.a getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }
}
