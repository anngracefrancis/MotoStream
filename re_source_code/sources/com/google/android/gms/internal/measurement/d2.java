package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class d2<T extends zzey<T>> {
    d2() {
    }

    abstract int a(Map.Entry<?, ?> entry);

    abstract h2<T> b(Object obj);

    abstract Object c(zzeq zzeqVar, zzgo zzgoVar, int i2);

    abstract <UT, UB> UB d(q3 q3Var, Object obj, zzeq zzeqVar, h2<T> h2Var, UB ub, h4<UT, UB> h4Var) throws IOException;

    abstract void e(zzdu zzduVar, Object obj, zzeq zzeqVar, h2<T> h2Var) throws IOException;

    abstract void f(q3 q3Var, Object obj, zzeq zzeqVar, h2<T> h2Var) throws IOException;

    abstract void g(y4 y4Var, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean h(zzgo zzgoVar);

    abstract h2<T> i(Object obj);

    abstract void j(Object obj);
}
