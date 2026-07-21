package com.google.firebase.q;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Subscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    <T> void a(Class<T> cls, b<? super T> bVar);

    <T> void b(Class<T> cls, Executor executor, b<? super T> bVar);
}
