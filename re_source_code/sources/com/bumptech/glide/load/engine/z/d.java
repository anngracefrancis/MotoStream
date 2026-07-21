package com.bumptech.glide.load.engine.z;

import com.bumptech.glide.load.engine.z.m;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d<T extends m> {
    private final Queue<T> a = com.bumptech.glide.r.k.f(20);

    d() {
    }

    abstract T a();

    T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
