package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetMySubscribedStoresResponse;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GetMySubscribedStoresRequest extends V7<GetMySubscribedStoresResponse, Body> {

    public static class Body extends BaseBody implements Endless {
        private Integer limit;
        private int offset;
        private Order order;
        private boolean refresh;
        Sort sort;

        public enum Sort {
            added,
            latest,
            alpha,
            downloads,
            trending
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public Integer getLimit() {
            return this.limit;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public int getOffset() {
            return this.offset;
        }

        public Order getOrder() {
            return this.order;
        }

        public Sort getSort() {
            return this.sort;
        }

        public void setLimit(Integer num) {
            this.limit = num;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
        public void setOffset(int i2) {
            this.offset = i2;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBody, cm.aptoide.pt.dataprovider.ws.RefreshBody
        public void setRefresh(boolean z) {
            this.refresh = z;
        }

        public void setSort(Sort sort) {
            this.sort = sort;
        }
    }

    public GetMySubscribedStoresRequest(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(new Body(), V7.getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<GetMySubscribedStoresResponse> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.getMySubscribedStores(z, (Body) this.body);
    }
}
