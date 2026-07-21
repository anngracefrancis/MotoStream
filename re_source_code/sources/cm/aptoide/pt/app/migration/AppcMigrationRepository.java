package cm.aptoide.pt.app.migration;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.e;

/* JADX INFO: compiled from: AppcMigrationRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/app/migration/AppcMigrationRepository;", HttpUrl.FRAGMENT_ENCODE_SET, "appcMigrationPersistence", "Lcm/aptoide/pt/app/migration/AppcMigrationPersistence;", "(Lcm/aptoide/pt/app/migration/AppcMigrationPersistence;)V", "getAppcMigrationPersistence", "()Lcm/aptoide/pt/app/migration/AppcMigrationPersistence;", "migrationCandidates", "Ljava/util/ArrayList;", HttpUrl.FRAGMENT_ENCODE_SET, "addMigrationCandidate", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", "isAppMigrated", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "persistCandidate", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AppcMigrationRepository {
    private final AppcMigrationPersistence appcMigrationPersistence;
    private final ArrayList<String> migrationCandidates;

    public AppcMigrationRepository(AppcMigrationPersistence appcMigrationPersistence) {
        m.f(appcMigrationPersistence, "appcMigrationPersistence");
        this.appcMigrationPersistence = appcMigrationPersistence;
        this.migrationCandidates = new ArrayList<>();
    }

    public final void addMigrationCandidate(String packageName) {
        m.f(packageName, "packageName");
        if (this.migrationCandidates.contains(packageName)) {
            return;
        }
        this.migrationCandidates.add(packageName);
    }

    public final AppcMigrationPersistence getAppcMigrationPersistence() {
        return this.appcMigrationPersistence;
    }

    public final e<Boolean> isAppMigrated(String str) {
        m.f(str, "packageName");
        e<Boolean> eVarIsAppMigrated = this.appcMigrationPersistence.isAppMigrated(str);
        m.e(eVarIsAppMigrated, "appcMigrationPersistence…sAppMigrated(packageName)");
        return eVarIsAppMigrated;
    }

    public final void persistCandidate(String packageName) {
        m.f(packageName, "packageName");
        if (this.migrationCandidates.contains(packageName)) {
            this.appcMigrationPersistence.insert(packageName);
            this.migrationCandidates.remove(packageName);
        }
    }
}
