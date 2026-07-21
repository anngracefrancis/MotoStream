package cm.aptoide.pt.dataprovider.util;

import cm.aptoide.pt.dataprovider.ws.RefreshBody;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class HashMapNotNull<K, V> extends HashMap<K, V> implements RefreshBody {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        return v != null ? (V) super.put(k2, v) : v;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.RefreshBody
    public void setRefresh(boolean z) {
    }
}
