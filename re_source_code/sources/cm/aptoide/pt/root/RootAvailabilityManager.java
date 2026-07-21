package cm.aptoide.pt.root;

import rx.Single;
import rx.b;

/* JADX INFO: loaded from: classes.dex */
public class RootAvailabilityManager {
    private RootValueSaver rootValueSaver;

    public RootAvailabilityManager(RootValueSaver rootValueSaver) {
        this.rootValueSaver = rootValueSaver;
    }

    public Single<Boolean> isRootAvailable() {
        return this.rootValueSaver.isPhoneRoot();
    }

    public b updateRootAvailability() {
        return this.rootValueSaver.save(RootShell.isRootAvailable());
    }
}
