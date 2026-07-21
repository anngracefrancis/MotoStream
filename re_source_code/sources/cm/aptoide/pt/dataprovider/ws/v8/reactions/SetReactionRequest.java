package cm.aptoide.pt.dataprovider.ws.v8.reactions;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class SetReactionRequest extends V7<BaseV7Response, Body> {

    public static class Body extends BaseBody {
        private final String id;

        public Body(String str) {
            this.id = str;
        }
    }

    public SetReactionRequest(Body body, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        throw new IllegalStateException("webservice not implemented, should not be used.");
    }
}
