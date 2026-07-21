package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;

/* JADX INFO: loaded from: classes.dex */
public class BaseBodyWithAlphaBetaKey extends BaseBody {
    private String notApkTags;

    protected BaseBodyWithAlphaBetaKey(SharedPreferences sharedPreferences) {
        if (ManagerPreferences.getUpdatesFilterAlphaBetaKey(sharedPreferences)) {
            this.notApkTags = "alpha,beta";
        }
    }

    public String getNotApkTags() {
        return this.notApkTags;
    }

    public boolean shouldIncludeTag() {
        return true;
    }
}
