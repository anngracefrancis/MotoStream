package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
abstract class vu<T extends zzdnu<T>> {
    vu() {
    }

    abstract int a(Map.Entry<?, ?> entry);

    abstract Object b(zzdno zzdnoVar, zzdpk zzdpkVar, int i2);

    abstract <UT, UB> UB c(kw kwVar, Object obj, zzdno zzdnoVar, yu<T> yuVar, UB ub, cx<UT, UB> cxVar) throws IOException;

    abstract void d(zzdmr zzdmrVar, Object obj, zzdno zzdnoVar, yu<T> yuVar) throws IOException;

    abstract void e(kw kwVar, Object obj, zzdno zzdnoVar, yu<T> yuVar) throws IOException;

    abstract void f(ux uxVar, Map.Entry<?, ?> entry) throws IOException;

    abstract void g(Object obj);

    abstract boolean h(zzdpk zzdpkVar);

    abstract yu<T> i(Object obj);

    abstract yu<T> j(Object obj);
}
