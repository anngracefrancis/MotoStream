package cm.aptoide.pt.dataprovider.ws.v7;

import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetUserInfo;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetUserInfoRequest extends V7<GetUserInfo, Body> {

    public static class Body extends BaseBody {
        private List<String> nodes;

        public Body(List<String> list) {
            this.nodes = list;
        }

        public List<String> getNodes() {
            return this.nodes;
        }

        public void setNodes(List<String> list) {
            this.nodes = list;
        }
    }

    protected GetUserInfoRequest(Body body, String str, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, str, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost() {
        return "https://ws75.aptoide.com/api/7/";
    }

    public static GetUserInfoRequest of(OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("meta");
        arrayList.add("settings");
        return new GetUserInfoRequest(new Body(arrayList), getHost(), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetUserInfo> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        ((Body) this.body).setRefresh(z);
        return interfaces.getUserInfo((Body) this.body, z);
    }
}
