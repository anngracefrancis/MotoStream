package io.sentry;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SentryValues.java */
/* JADX INFO: loaded from: classes2.dex */
final class c5<T> {
    private final List<T> a;

    c5(List<T> list) {
        this.a = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> a() {
        return this.a;
    }
}
