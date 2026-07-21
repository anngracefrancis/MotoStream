package cm.aptoide.pt.networking;

import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import okhttp3.RequestBody;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class MultipartBodyInterceptor implements BodyInterceptor<HashMapNotNull<String, RequestBody>> {
    private final AuthenticationPersistence authenticationPersistence;
    private final IdsRepository idsRepository;
    private final RequestBodyFactory requestBodyFactory;

    public MultipartBodyInterceptor(IdsRepository idsRepository, RequestBodyFactory requestBodyFactory, AuthenticationPersistence authenticationPersistence) {
        this.idsRepository = idsRepository;
        this.authenticationPersistence = authenticationPersistence;
        this.requestBodyFactory = requestBodyFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$intercept$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(Authentication authentication, HashMapNotNull hashMapNotNull, String str) {
        if (authentication.isAuthenticated()) {
            hashMapNotNull.put("access_token", this.requestBodyFactory.createBodyPartFromString(authentication.getAccessToken()));
        }
        hashMapNotNull.put("aptoide_uid", this.requestBodyFactory.createBodyPartFromString(str));
        return Single.m(hashMapNotNull);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$intercept$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single b(final HashMapNotNull hashMapNotNull, final Authentication authentication) {
        return this.idsRepository.getUniqueIdentifier().i(new rx.m.e() { // from class: cm.aptoide.pt.networking.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6658f.a(authentication, hashMapNotNull, (String) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.dataprovider.ws.BodyInterceptor
    public Single<HashMapNotNull<String, RequestBody>> intercept(final HashMapNotNull<String, RequestBody> hashMapNotNull) {
        return this.authenticationPersistence.getAuthentication().i(new rx.m.e() { // from class: cm.aptoide.pt.networking.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6661f.b(hashMapNotNull, (Authentication) obj);
            }
        }).v(Schedulers.computation());
    }
}
