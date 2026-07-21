package cm.aptoide.pt.dataprovider.ws.v7;

import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class SetUserSettings extends V7<BaseV7Response, Body> {

    public static class Body extends BaseBody {
        public boolean mature;

        public Body(boolean z) {
            this.mature = z;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBody
        public boolean isMature() {
            return this.mature;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBody
        public void setMature(boolean z) {
            this.mature = z;
        }
    }

    protected SetUserSettings(Body body, String str, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost() {
        return "https://ws75-primary.aptoide.com/api/7/";
    }

    public static SetUserSettings of(boolean z, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        Body body = new Body(z);
        body.setMature(z);
        return new SetUserSettings(body, getHost(), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.setUserSettings((Body) this.body);
    }
}
