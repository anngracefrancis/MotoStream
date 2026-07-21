package cm.aptoide.pt.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class MarketResourceFormatter {
    private String marketName;

    public MarketResourceFormatter(String str) {
        this.marketName = str;
    }

    public String formatString(Context context, int i2, String... strArr) {
        return context.getString(i2);
    }
}
