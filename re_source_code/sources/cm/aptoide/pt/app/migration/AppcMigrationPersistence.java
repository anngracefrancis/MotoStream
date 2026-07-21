package cm.aptoide.pt.app.migration;

import rx.e;

/* JADX INFO: loaded from: classes.dex */
public interface AppcMigrationPersistence {
    void insert(String str);

    e<Boolean> isAppMigrated(String str);
}
