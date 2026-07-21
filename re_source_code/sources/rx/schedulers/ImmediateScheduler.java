package rx.schedulers;

import rx.h;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class ImmediateScheduler extends h {
    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.h
    public h.a createWorker() {
        return null;
    }
}
