package cm.aptoide.pt.actions;

import rx.j;

/* JADX INFO: loaded from: classes.dex */
public class RequestDownloadAccessOnSubscribe implements rx.e.a<Void> {
    private final boolean allowDownloadOnMobileData;
    private final boolean canBypassWifi;
    private final PermissionService permissionRequest;
    private final long size;

    public RequestDownloadAccessOnSubscribe(PermissionService permissionService, boolean z, boolean z2, long j2) {
        this.permissionRequest = permissionService;
        this.allowDownloadOnMobileData = z;
        this.canBypassWifi = z2;
        this.size = j2;
    }

    static /* synthetic */ void lambda$call$0(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onNext(null);
        jVar.onCompleted();
    }

    @Override // rx.m.b
    public void call(final j<? super Void> jVar) {
        this.permissionRequest.requestDownloadAccess(new rx.m.a() { // from class: cm.aptoide.pt.actions.f
            @Override // rx.m.a
            public final void call() {
                RequestDownloadAccessOnSubscribe.lambda$call$0(jVar);
            }
        }, new rx.m.a() { // from class: cm.aptoide.pt.actions.e
            @Override // rx.m.a
            public final void call() {
                jVar.onError(new SecurityException("Permission denied to download file"));
            }
        }, this.allowDownloadOnMobileData, this.canBypassWifi, this.size);
    }
}
