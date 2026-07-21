package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBodyWithStore;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRequestWithStore<U, B extends BaseBodyWithStore> extends V7<U, B> {
    public BaseRequestWithStore(B b2, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(b2, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static class StoreCredentials {
        private final Long id;
        private final String name;
        private final String passwordSha1;
        private final String username;

        public StoreCredentials() {
            this.name = null;
            this.id = null;
            this.username = null;
            this.passwordSha1 = null;
        }

        public Long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getPasswordSha1() {
            return this.passwordSha1;
        }

        public String getUsername() {
            return this.username;
        }

        public StoreCredentials(long j2, String str, String str2) {
            this.name = null;
            this.id = Long.valueOf(j2);
            this.username = str;
            this.passwordSha1 = str2;
        }

        public StoreCredentials(String str, String str2, String str3) {
            this.id = null;
            this.name = str;
            this.username = str2;
            this.passwordSha1 = str3;
        }

        public StoreCredentials(long j2, String str, String str2, String str3) {
            this.id = Long.valueOf(j2);
            this.name = str;
            this.username = str2;
            this.passwordSha1 = str3;
        }
    }
}
