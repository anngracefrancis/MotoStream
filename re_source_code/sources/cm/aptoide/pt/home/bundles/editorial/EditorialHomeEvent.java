package cm.aptoide.pt.home.bundles.editorial;

import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;

/* JADX INFO: loaded from: classes.dex */
public class EditorialHomeEvent extends HomeEvent {
    private final String cardId;
    private final String groupId;

    public EditorialHomeEvent(String str, String str2, HomeBundle homeBundle, int i2, HomeEvent.Type type) {
        super(homeBundle, i2, type);
        this.cardId = str;
        this.groupId = str2;
    }

    public String getCardId() {
        return this.cardId;
    }

    public String getGroupId() {
        return this.groupId;
    }
}
