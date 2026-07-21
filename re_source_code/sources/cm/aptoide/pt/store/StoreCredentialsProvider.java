package cm.aptoide.pt.store;

import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;

/* JADX INFO: loaded from: classes.dex */
public interface StoreCredentialsProvider {
    BaseRequestWithStore.StoreCredentials fromUrl(String str);

    BaseRequestWithStore.StoreCredentials get(long j2);

    BaseRequestWithStore.StoreCredentials get(String str);
}
