package cm.aptoide.pt.share;

import android.content.Context;
import android.content.Intent;
import cm.aptoide.pt.R;
import cm.aptoide.pt.util.MarketResourceFormatter;

/* JADX INFO: loaded from: classes.dex */
public class ShareStoreHelper {
    private final Context context;
    private final MarketResourceFormatter marketResourceFormatter;

    public ShareStoreHelper(Context context, MarketResourceFormatter marketResourceFormatter) {
        this.context = context;
        this.marketResourceFormatter = marketResourceFormatter;
    }

    public void shareStore(String str) {
        String str2 = this.marketResourceFormatter.formatString(this.context, R.string.hello_follow_me_on_aptoide, new String[0]) + " " + str;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str2);
        Context context = this.context;
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.share)));
    }
}
