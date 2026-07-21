package cm.aptoide.pt.networking;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class UserAgentInterceptor implements Interceptor {
    private final AptoideMd5Manager aptoideMd5Manager;
    private final DisplayMetrics displayMetrics;
    private final IdsRepository idsRepository;

    public UserAgentInterceptor(IdsRepository idsRepository, DisplayMetrics displayMetrics, AptoideMd5Manager aptoideMd5Manager) {
        this.idsRepository = idsRepository;
        this.displayMetrics = displayMetrics;
        this.aptoideMd5Manager = aptoideMd5Manager;
    }

    private String getDefaultUserAgent() {
        return "Aptoide/9.22.5.3 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.VERSION.SDK_INT + "; " + Build.MODEL + " Build/" + Build.PRODUCT + "; " + System.getProperty("os.arch") + "; cm.aptoide.pt; " + BuildConfig.VERSION_CODE + "; " + this.aptoideMd5Manager.getAptoideMd5() + "; " + (this.displayMetrics.widthPixels + "x" + this.displayMetrics.heightPixels) + ";" + this.idsRepository.getUniqueIdentifier().y().b() + ")";
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String defaultUserAgent;
        Request request = chain.request();
        try {
            defaultUserAgent = getDefaultUserAgent();
        } catch (Exception e2) {
            CrashReport.getInstance().log(e2);
            defaultUserAgent = null;
        }
        try {
            return !TextUtils.isEmpty(defaultUserAgent) ? chain.proceed(request.newBuilder().header("User-Agent", defaultUserAgent).build()) : chain.proceed(request);
        } catch (IOException e3) {
            CrashReport.getInstance().log(e3);
            throw e3;
        }
    }
}
