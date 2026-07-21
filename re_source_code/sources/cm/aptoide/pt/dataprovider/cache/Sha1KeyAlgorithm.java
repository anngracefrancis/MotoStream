package cm.aptoide.pt.dataprovider.cache;

import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.utils.AptoideUtils;
import j.f;
import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public class Sha1KeyAlgorithm implements KeyAlgorithm<Request, String> {
    private static final String TAG = "cm.aptoide.pt.dataprovider.cache.Sha1KeyAlgorithm";

    @Override // cm.aptoide.pt.dataprovider.cache.KeyAlgorithm
    public String getKeyFrom(Request request) {
        String url;
        try {
            f fVar = new f();
            Request requestBuild = request.newBuilder().build();
            if (requestBuild.body() == null || requestBuild.body().contentLength() <= 0) {
                url = requestBuild.url().getUrl();
            } else {
                requestBuild.body().writeTo(fVar);
                url = requestBuild.url().getUrl() + fVar.T();
            }
            return AptoideUtils.AlgorithmU.computeSha1(url);
        } catch (IOException e2) {
            CrashReport.getInstance().log(e2);
            return null;
        }
    }
}
