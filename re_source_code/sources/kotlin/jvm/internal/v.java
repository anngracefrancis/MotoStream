package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: PropertyReference0.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends b0 implements KProperty0 {
    public v(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.g(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // kotlin.reflect.KProperty
    public KProperty0.a getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }
}
