package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class SetStoreImageRequest extends V7<BaseV7Response, HashMapNotNull<String, RequestBody>> {
    private final MultipartBody.Part multipartBody;

    private SetStoreImageRequest(HashMapNotNull<String, RequestBody> hashMapNotNull, MultipartBody.Part part, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        super(hashMapNotNull, getHost(sharedPreferences), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.multipartBody = part;
    }

    private static void addStoreProperties(String str, String str2, RequestBodyFactory requestBodyFactory, ObjectMapper objectMapper, HashMapNotNull<String, RequestBody> hashMapNotNull) {
        try {
            hashMapNotNull.put("store_properties", requestBodyFactory.createBodyPartFromString(objectMapper.writeValueAsString(new SimpleSetStoreRequest.StoreProperties(str, str2))));
        } catch (JsonProcessingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    public static SetStoreImageRequest of(String str, String str2, String str3, String str4, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, RequestBodyFactory requestBodyFactory, ObjectMapper objectMapper, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        HashMapNotNull hashMapNotNull = new HashMapNotNull();
        hashMapNotNull.put("store_name", requestBodyFactory.createBodyPartFromString(str));
        addStoreProperties(str2, str3, requestBodyFactory, objectMapper, hashMapNotNull);
        return new SetStoreImageRequest(hashMapNotNull, requestBodyFactory.createBodyPartFromFile("store_avatar", new File(str4)), bodyInterceptor, okHttpClient, factory, sharedPreferences, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.editStore(this.multipartBody, (HashMapNotNull) this.body);
    }
}
