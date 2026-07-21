package cm.aptoide.pt.search.model;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchLoadingItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcm/aptoide/pt/search/model/SearchLoadingItem;", "Lcm/aptoide/pt/search/model/SearchItem;", "()V", "getId", HttpUrl.FRAGMENT_ENCODE_SET, "getType", "Lcm/aptoide/pt/search/model/SearchItem$Type;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchLoadingItem implements SearchItem {
    @Override // cm.aptoide.pt.search.model.SearchItem
    public long getId() {
        return SearchItem.Type.LOADING.ordinal();
    }

    @Override // cm.aptoide.pt.search.model.SearchItem
    public SearchItem.Type getType() {
        return SearchItem.Type.LOADING;
    }
}
