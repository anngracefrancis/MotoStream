package cm.aptoide.pt.link;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.a;
import c.c.b.c;
import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsHelper {
    private static CustomTabsHelper customTabsHelper;

    private CustomTabsHelper() {
        if (customTabsHelper != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    private void addRefererHttpHeader(Context context, c cVar) {
        Bundle bundle = new Bundle();
        bundle.putString("Referer", "http://m.aptoide.com");
        cVar.a.putExtra("com.android.browser.headers", bundle);
        cVar.a.getExtras();
        if (Build.VERSION.SDK_INT >= 22) {
            cVar.a.putExtra("android.intent.extra.REFERRER_NAME", "android-app://" + context.getPackageName() + "/");
        }
    }

    private c.a getBuilder(Context context, int i2) {
        return new c.a().h(a.d(context, i2)).f(true).d(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_arrow_back)).a().b(context.getString(R.string.customtabs_open_native_app), PendingIntent.getBroadcast(context.getApplicationContext(), 0, new Intent(context.getApplicationContext(), (Class<?>) CustomTabNativeReceiver.class), 67108864)).g(context, R.anim.slide_in_right, R.anim.slide_out_left).e(context, R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public static CustomTabsHelper getInstance() {
        if (customTabsHelper == null) {
            customTabsHelper = new CustomTabsHelper();
        }
        return customTabsHelper;
    }

    public void openInChromeCustomTab(String str, Context context, int i2) {
        c cVarC = getBuilder(context, i2).c();
        addRefererHttpHeader(context, cVarC);
        cVarC.a.setFlags(268435456);
        cVarC.a(context, Uri.parse(str));
    }
}
