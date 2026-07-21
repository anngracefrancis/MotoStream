package com.airbnb.lottie.s.i;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: BaseAnimatableValue.java */
/* JADX INFO: loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.w.a<V>> a;

    n(V v) {
        this(Collections.singletonList(new com.airbnb.lottie.w.a(v)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    n(List<com.airbnb.lottie.w.a<V>> list) {
        this.a = list;
    }
}
