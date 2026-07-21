package cm.aptoide.pt.account;

import cm.aptoide.accountmanager.AdultContent;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class MatureBodyInterceptorV7 implements BodyInterceptor<BaseBody> {
    private final AdultContent adultContent;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;

    public MatureBodyInterceptorV7(BodyInterceptor<BaseBody> bodyInterceptor, AdultContent adultContent) {
        this.bodyInterceptorV7 = bodyInterceptor;
        this.adultContent = adultContent;
    }

    static /* synthetic */ BaseBody lambda$intercept$0(BaseBody baseBody, Boolean bool) {
        baseBody.setMature(bool.booleanValue());
        return baseBody;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.BodyInterceptor
    public Single<BaseBody> intercept(BaseBody baseBody) {
        return Single.C(this.bodyInterceptorV7.intercept(baseBody), this.adultContent.enabled().E().Z0(), new rx.m.f() { // from class: cm.aptoide.pt.account.t0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                BaseBody baseBody2 = (BaseBody) obj;
                MatureBodyInterceptorV7.lambda$intercept$0(baseBody2, (Boolean) obj2);
                return baseBody2;
            }
        });
    }
}
