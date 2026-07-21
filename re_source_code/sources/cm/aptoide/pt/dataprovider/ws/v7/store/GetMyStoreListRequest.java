package cm.aptoide.pt.dataprovider.ws.v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.WindowManager;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetMyStoreListRequest extends V7<ListStores, EndlessBody> {
    private static boolean useEndless;
    private String url;

    public static class Body extends BaseBody {
        private boolean refresh;
        private WidgetsArgs widgetsArgs;

        public Body(WidgetsArgs widgetsArgs) {
            this.widgetsArgs = widgetsArgs;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBody, cm.aptoide.pt.dataprovider.ws.RefreshBody
        public void setRefresh(boolean z) {
            this.refresh = z;
        }
    }

    public static class EndlessBody extends Body implements Endless {
        private Integer limit;
        private int offset;

        public EndlessBody(WidgetsArgs widgetsArgs) {
            super(widgetsArgs);
            this.limit = 25;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return this.limit;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }
    }

    public GetMyStoreListRequest(String str, EndlessBody endlessBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(endlessBody, V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.url = str;
    }

    public static GetMyStoreListRequest of(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        return of(str, false, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, resources, windowManager);
    }

    public static GetMyStoreListRequest of(String str, boolean z, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        useEndless = z;
        return new GetMyStoreListRequest(str, new EndlessBody(WidgetsArgs.createDefault(resources, windowManager)), bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<ListStores> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        if (this.url.contains("getSubscribed")) {
            ((EndlessBody) this.body).setRefresh(z);
        }
        if (TextUtils.isEmpty(this.url)) {
            return interfaces.getMyStoreList((Body) this.body, z);
        }
        return useEndless ? interfaces.getMyStoreListEndless(this.url, (EndlessBody) this.body, z) : interfaces.getMyStoreList(this.url, (Body) this.body, z);
    }
}
