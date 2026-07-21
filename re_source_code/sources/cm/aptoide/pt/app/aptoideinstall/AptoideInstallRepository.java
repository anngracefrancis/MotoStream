package cm.aptoide.pt.app.aptoideinstall;

import cm.aptoide.pt.install.AptoideInstallPersistence;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: AptoideInstallRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/app/aptoideinstall/AptoideInstallRepository;", HttpUrl.FRAGMENT_ENCODE_SET, "aptoideInstallPersistence", "Lcm/aptoide/pt/install/AptoideInstallPersistence;", "(Lcm/aptoide/pt/install/AptoideInstallPersistence;)V", "aptoideInstallCandidates", "Ljava/util/ArrayList;", HttpUrl.FRAGMENT_ENCODE_SET, "getAptoideInstallPersistence", "()Lcm/aptoide/pt/install/AptoideInstallPersistence;", "addAptoideInstallCandidate", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", "isInstalledWithAptoide", "Lrx/Single;", HttpUrl.FRAGMENT_ENCODE_SET, "persistCandidate", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AptoideInstallRepository {
    private final ArrayList<String> aptoideInstallCandidates;
    private final AptoideInstallPersistence aptoideInstallPersistence;

    public AptoideInstallRepository(AptoideInstallPersistence aptoideInstallPersistence) {
        m.f(aptoideInstallPersistence, "aptoideInstallPersistence");
        this.aptoideInstallPersistence = aptoideInstallPersistence;
        this.aptoideInstallCandidates = new ArrayList<>();
    }

    public final void addAptoideInstallCandidate(String packageName) {
        m.f(packageName, "packageName");
        if (this.aptoideInstallCandidates.contains(packageName)) {
            return;
        }
        this.aptoideInstallCandidates.add(packageName);
    }

    public final AptoideInstallPersistence getAptoideInstallPersistence() {
        return this.aptoideInstallPersistence;
    }

    public final Single<Boolean> isInstalledWithAptoide(String packageName) {
        m.f(packageName, "packageName");
        Single<Boolean> singleIsInstalledWithAptoide = this.aptoideInstallPersistence.isInstalledWithAptoide(packageName);
        m.e(singleIsInstalledWithAptoide, "aptoideInstallPersistenc…dWithAptoide(packageName)");
        return singleIsInstalledWithAptoide;
    }

    public final void persistCandidate(String packageName) {
        m.f(packageName, "packageName");
        if (this.aptoideInstallCandidates.contains(packageName)) {
            this.aptoideInstallPersistence.insert(packageName);
            this.aptoideInstallCandidates.remove(packageName);
        }
    }
}
