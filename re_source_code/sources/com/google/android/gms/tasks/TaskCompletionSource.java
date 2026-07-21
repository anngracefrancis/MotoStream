package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
public class TaskCompletionSource<TResult> {
    private final x a = new x();

    public Task<TResult> a() {
        return this.a;
    }

    public void b(Exception exc) {
        this.a.q(exc);
    }

    public void c(TResult tresult) {
        this.a.r(tresult);
    }

    public boolean d(Exception exc) {
        return this.a.t(exc);
    }

    public boolean e(TResult tresult) {
        return this.a.u(tresult);
    }
}
