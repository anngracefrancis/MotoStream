package cm.aptoide.pt.install;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface AptoideInstallPersistence {
    void insert(String str);

    Single<Boolean> isInstalledWithAptoide(String str);
}
