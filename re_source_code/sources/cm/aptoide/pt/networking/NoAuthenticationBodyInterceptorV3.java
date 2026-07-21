package cm.aptoide.pt.networking;

import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class NoAuthenticationBodyInterceptorV3 implements BodyInterceptor<BaseBody> {
    private final AptoideMd5Manager aptoideMd5Manager;
    private final String aptoidePackage;
    private final IdsRepository idsRepository;

    public NoAuthenticationBodyInterceptorV3(IdsRepository idsRepository, AptoideMd5Manager aptoideMd5Manager, String str) {
        this.aptoideMd5Manager = aptoideMd5Manager;
        this.aptoidePackage = str;
        this.idsRepository = idsRepository;
    }

    private /* synthetic */ BaseBody lambda$intercept$0(BaseBody baseBody, String str) {
        String aptoideMd5 = this.aptoideMd5Manager.getAptoideMd5();
        if (!aptoideMd5.isEmpty()) {
            baseBody.setAptoideMd5sum(aptoideMd5);
        }
        baseBody.setAptoidePackage(this.aptoidePackage);
        baseBody.setAptoideUid(str);
        return baseBody;
    }

    public /* synthetic */ BaseBody a(BaseBody baseBody, String str) {
        lambda$intercept$0(baseBody, str);
        return baseBody;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.BodyInterceptor
    public Single<BaseBody> intercept(final BaseBody baseBody) {
        return this.idsRepository.getUniqueIdentifier().n(new rx.m.e() { // from class: cm.aptoide.pt.networking.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                NoAuthenticationBodyInterceptorV3 noAuthenticationBodyInterceptorV3 = this.f6663f;
                BaseBody baseBody2 = baseBody;
                noAuthenticationBodyInterceptorV3.a(baseBody2, (String) obj);
                return baseBody2;
            }
        }).v(Schedulers.computation());
    }
}
