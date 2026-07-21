package cm.aptoide.pt.autoupdate;

import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: AutoUpdateService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/autoupdate/AutoUpdateService;", HttpUrl.FRAGMENT_ENCODE_SET, "service", "Lcm/aptoide/pt/autoupdate/Service;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "clientSdkVersion", HttpUrl.FRAGMENT_ENCODE_SET, "(Lcm/aptoide/pt/autoupdate/Service;Ljava/lang/String;I)V", "loading", HttpUrl.FRAGMENT_ENCODE_SET, "createErrorAutoUpdateModel", "Lcm/aptoide/pt/autoupdate/AutoUpdateModel;", "throwable", HttpUrl.FRAGMENT_ENCODE_SET, "loadAutoUpdateModel", "Lrx/Single;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoUpdateService {
    private final int clientSdkVersion;
    private boolean loading;
    private final String packageName;
    private final Service service;

    public AutoUpdateService(Service service, String str, int i2) {
        kotlin.jvm.internal.m.f(service, "service");
        kotlin.jvm.internal.m.f(str, "packageName");
        this.service = service;
        this.packageName = str;
        this.clientSdkVersion = i2;
    }

    private final AutoUpdateModel createErrorAutoUpdateModel(Throwable throwable) {
        return throwable instanceof NoNetworkConnectionException ? new AutoUpdateModel(Status.ERROR_NETWORK) : new AutoUpdateModel(Status.ERROR_GENERIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-0, reason: not valid java name */
    public static final void m70loadAutoUpdateModel$lambda0(AutoUpdateService autoUpdateService) {
        kotlin.jvm.internal.m.f(autoUpdateService, "this$0");
        autoUpdateService.loading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-1, reason: not valid java name */
    public static final void m71loadAutoUpdateModel$lambda1(AutoUpdateService autoUpdateService) {
        kotlin.jvm.internal.m.f(autoUpdateService, "this$0");
        autoUpdateService.loading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-2, reason: not valid java name */
    public static final void m72loadAutoUpdateModel$lambda2(AutoUpdateService autoUpdateService) {
        kotlin.jvm.internal.m.f(autoUpdateService, "this$0");
        autoUpdateService.loading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-3, reason: not valid java name */
    public static final rx.e m73loadAutoUpdateModel$lambda3(AutoUpdateService autoUpdateService, AutoUpdateJsonResponse autoUpdateJsonResponse) {
        kotlin.jvm.internal.m.f(autoUpdateService, "this$0");
        int versioncode = autoUpdateJsonResponse.getVersioncode();
        String uri = autoUpdateJsonResponse.getUri();
        kotlin.jvm.internal.m.e(uri, "it.uri");
        String md5 = autoUpdateJsonResponse.getMd5();
        kotlin.jvm.internal.m.e(md5, "it.md5");
        String minSdk = autoUpdateJsonResponse.getMinSdk();
        kotlin.jvm.internal.m.e(minSdk, "it.minSdk");
        return rx.e.S(new AutoUpdateModel(versioncode, uri, md5, minSdk, autoUpdateService.packageName, false, null, false, 224, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-4, reason: not valid java name */
    public static final AutoUpdateModel m74loadAutoUpdateModel$lambda4(AutoUpdateService autoUpdateService, Throwable th) {
        kotlin.jvm.internal.m.f(autoUpdateService, "this$0");
        return autoUpdateService.createErrorAutoUpdateModel(th);
    }

    public final Single<AutoUpdateModel> loadAutoUpdateModel() {
        if (this.loading) {
            Single<AutoUpdateModel> singleM = Single.m(new AutoUpdateModel(true));
            kotlin.jvm.internal.m.e(singleM, "just(AutoUpdateModel(loading = true))");
            return singleM;
        }
        Single<AutoUpdateModel> singleZ0 = this.service.getAutoUpdateResponse(this.packageName, this.clientSdkVersion).y(new rx.m.a() { // from class: cm.aptoide.pt.autoupdate.y
            @Override // rx.m.a
            public final void call() {
                AutoUpdateService.m70loadAutoUpdateModel$lambda0(this.f4762f);
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.autoupdate.x
            @Override // rx.m.a
            public final void call() {
                AutoUpdateService.m71loadAutoUpdateModel$lambda1(this.f4761f);
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.autoupdate.w
            @Override // rx.m.a
            public final void call() {
                AutoUpdateService.m72loadAutoUpdateModel$lambda2(this.f4760f);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateService.m73loadAutoUpdateModel$lambda3(this.f4758f, (AutoUpdateJsonResponse) obj);
            }
        }).p0(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateService.m74loadAutoUpdateModel$lambda4(this.f4759f, (Throwable) obj);
            }
        }).Z0();
        kotlin.jvm.internal.m.e(singleZ0, "service.getAutoUpdateRes…it) }\n        .toSingle()");
        return singleZ0;
    }
}
