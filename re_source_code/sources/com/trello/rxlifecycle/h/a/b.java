package com.trello.rxlifecycle.h.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.i;
import rx.e;

/* JADX INFO: compiled from: RxAppCompatDialogFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends i {
    private final rx.s.a<com.trello.rxlifecycle.g.b> lifecycleSubject = rx.s.a.g1();

    public final <T> com.trello.rxlifecycle.b<T> bindToLifecycle() {
        return com.trello.rxlifecycle.g.c.b(this.lifecycleSubject);
    }

    public final e<com.trello.rxlifecycle.g.b> lifecycle() {
        return this.lifecycleSubject.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.ATTACH);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.DESTROY_VIEW);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDetach() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.DETACH);
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.RESUME);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.START);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStop() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.b.CREATE_VIEW);
    }

    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(com.trello.rxlifecycle.g.b bVar) {
        return com.trello.rxlifecycle.c.b(this.lifecycleSubject, bVar);
    }
}
