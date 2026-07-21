package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
final class z implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f11800f;

    z(GoogleApiManager.zaa zaaVar) {
        this.f11800f = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11800f.q();
    }
}
