package com.trello.rxlifecycle;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static <T, R> b<T> a(rx.e<R> eVar, rx.m.e<R, R> eVar2) {
        com.trello.rxlifecycle.i.a.a(eVar, "lifecycle == null");
        com.trello.rxlifecycle.i.a.a(eVar2, "correspondingEvents == null");
        return new e(eVar.w0(), eVar2);
    }

    public static <T, R> b<T> b(rx.e<R> eVar, R r) {
        com.trello.rxlifecycle.i.a.a(eVar, "lifecycle == null");
        com.trello.rxlifecycle.i.a.a(r, "event == null");
        return new f(eVar, r);
    }
}
