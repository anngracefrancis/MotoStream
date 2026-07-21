package cm.aptoide.pt.dataprovider.cache;

import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.utils.AptoideUtils;
import j.f;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public class POSTCacheKeyAlgorithm implements KeyAlgorithm<Request, String> {
    @Override // cm.aptoide.pt.dataprovider.cache.KeyAlgorithm
    public String getKeyFrom(Request request) {
        Request requestBuild = request.newBuilder().build();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("URL:%s\n", requestBuild.url().getUrl()));
        Headers headers = requestBuild.headers();
        if (headers.size() > 0) {
            sb.append("Headers:\n");
            for (String str : headers.names()) {
                sb.append(String.format("\t%s: %s\n", str, AptoideUtils.StringU.join(headers.values(str), ", ")));
            }
        }
        try {
            if (requestBuild.body() != null && requestBuild.body().contentLength() > 0) {
                sb.append("Body:\n");
                f fVar = new f();
                requestBuild.body().writeTo(fVar);
                sb.append(fVar.T());
            }
            return AptoideUtils.AlgorithmU.computeSha1(sb.toString());
        } catch (IOException e2) {
            CrashReport.getInstance().log(e2);
            return null;
        }
    }
}
