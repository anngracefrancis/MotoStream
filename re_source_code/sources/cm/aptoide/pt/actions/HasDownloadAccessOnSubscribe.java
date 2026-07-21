package cm.aptoide.pt.actions;

import rx.j;

/* JADX INFO: loaded from: classes.dex */
public class HasDownloadAccessOnSubscribe implements rx.e.a<Boolean> {
    private final PermissionService permissionService;

    public HasDownloadAccessOnSubscribe(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    static /* synthetic */ void lambda$call$0(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onNext(Boolean.TRUE);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$call$1(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onNext(Boolean.FALSE);
        jVar.onCompleted();
    }

    @Override // rx.m.b
    public void call(final j<? super Boolean> jVar) {
        this.permissionService.hasDownloadAccess(new rx.m.a() { // from class: cm.aptoide.pt.actions.b
            @Override // rx.m.a
            public final void call() {
                HasDownloadAccessOnSubscribe.lambda$call$0(jVar);
            }
        }, new rx.m.a() { // from class: cm.aptoide.pt.actions.a
            @Override // rx.m.a
            public final void call() {
                HasDownloadAccessOnSubscribe.lambda$call$1(jVar);
            }
        });
    }
}
