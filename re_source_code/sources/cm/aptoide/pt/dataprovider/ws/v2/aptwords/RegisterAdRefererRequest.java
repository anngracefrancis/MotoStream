package cm.aptoide.pt.dataprovider.ws.v2.aptwords;

import android.content.SharedPreferences;
import android.os.Build;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class RegisterAdRefererRequest extends Aptwords<DefaultResponse> {
    private long adId;
    private long appId;
    private final String q;
    private String success;
    private String tracker;

    public static class DefaultResponse {
        private String status;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }
    }

    private RegisterAdRefererRequest(long j2, long j3, String str, boolean z, OkHttpClient okHttpClient, Converter.Factory factory, String str2, SharedPreferences sharedPreferences) {
        super(okHttpClient, factory, sharedPreferences);
        this.q = str2;
        this.adId = j2;
        this.appId = j3;
        this.success = z ? "1" : "0";
        extractAndSetTracker(str);
    }

    private void extractAndSetTracker(String str) {
        this.tracker = str.substring(0, str.indexOf("/", str.indexOf("//") + 2));
    }

    static /* synthetic */ void lambda$execute$0(DefaultResponse defaultResponse) {
    }

    static /* synthetic */ void lambda$execute$1(Throwable th) {
    }

    public static RegisterAdRefererRequest of(long j2, long j3, String str, boolean z, OkHttpClient okHttpClient, Converter.Factory factory, String str2, SharedPreferences sharedPreferences) {
        return new RegisterAdRefererRequest(j2, j3, str, z, okHttpClient, factory, str2, sharedPreferences);
    }

    public void execute() {
        super.execute(new SuccessRequestListener() { // from class: cm.aptoide.pt.dataprovider.ws.v2.aptwords.d
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                RegisterAdRefererRequest.lambda$execute$0((RegisterAdRefererRequest.DefaultResponse) obj);
            }
        }, new ErrorRequestListener() { // from class: cm.aptoide.pt.dataprovider.ws.v2.aptwords.c
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                RegisterAdRefererRequest.lambda$execute$1(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<DefaultResponse> loadDataFromNetwork(Aptwords.Interfaces interfaces, boolean z) {
        HashMapNotNull<String, String> hashMapNotNull = new HashMapNotNull<>();
        hashMapNotNull.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, this.success);
        hashMapNotNull.put("adid", Long.toString(this.adId));
        hashMapNotNull.put("appid", Long.toString(this.appId));
        hashMapNotNull.put("q", this.q);
        hashMapNotNull.put("androidversion", Build.VERSION.RELEASE);
        hashMapNotNull.put("tracker", this.tracker);
        return interfaces.load(hashMapNotNull);
    }
}
