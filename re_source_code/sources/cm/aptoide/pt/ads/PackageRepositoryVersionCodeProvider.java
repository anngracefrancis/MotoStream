package cm.aptoide.pt.ads;

import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.install.PackageRepository;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class PackageRepositoryVersionCodeProvider implements AdsApplicationVersionCodeProvider {
    private final String packageName;
    private final PackageRepository packageRepository;

    public PackageRepositoryVersionCodeProvider(PackageRepository packageRepository, String str) {
        this.packageName = str;
        this.packageRepository = packageRepository;
    }

    static /* synthetic */ Integer lambda$getApplicationVersionCode$0(Throwable th) {
        return -1;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider
    public Single<Integer> getApplicationVersionCode() {
        return this.packageRepository.getPackageVersionCode(this.packageName).r(new rx.m.e() { // from class: cm.aptoide.pt.ads.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return PackageRepositoryVersionCodeProvider.lambda$getApplicationVersionCode$0((Throwable) obj);
            }
        });
    }
}
