package com.trello.rxlifecycle.h.a;

import android.os.Bundle;
import rx.e;

/* JADX INFO: compiled from: RxAppCompatActivity.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends androidx.appcompat.app.d {
    private final rx.s.a<com.trello.rxlifecycle.g.a> lifecycleSubject = rx.s.a.g1();

    public final <T> com.trello.rxlifecycle.b<T> bindToLifecycle() {
        return com.trello.rxlifecycle.g.c.a(this.lifecycleSubject);
    }

    public final e<com.trello.rxlifecycle.g.a> lifecycle() {
        return this.lifecycleSubject.a();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.CREATE);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPause() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.RESUME);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.START);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.STOP);
        super.onStop();
    }

    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(com.trello.rxlifecycle.g.a aVar) {
        return com.trello.rxlifecycle.c.b(this.lifecycleSubject, aVar);
    }
}
