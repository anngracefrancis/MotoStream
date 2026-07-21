package cm.aptoide.pt.root;

import rx.Single;
import rx.b;

/* JADX INFO: loaded from: classes.dex */
public interface RootValueSaver {
    Single<Boolean> isPhoneRoot();

    b save(boolean z);
}
