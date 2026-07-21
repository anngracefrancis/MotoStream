package cm.aptoide.pt.dataprovider.ws.v7;

import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.store.RequestBodyFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class SetUserMultipartRequest extends V7<BaseV7Response, HashMapNotNull<String, RequestBody>> {
    private final MultipartBody.Part multipartBody;

    private SetUserMultipartRequest(MultipartBody.Part part, HashMapNotNull<String, RequestBody> hashMapNotNull, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(hashMapNotNull, getHost(), okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        this.multipartBody = part;
    }

    public static String getHost() {
        return "https://ws75-primary.aptoide.com/api/7/";
    }

    public static SetUserMultipartRequest of(String str, String str2, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, ObjectMapper objectMapper, TokenInvalidator tokenInvalidator) {
        RequestBodyFactory requestBodyFactory = new RequestBodyFactory();
        HashMapNotNull hashMapNotNull = new HashMapNotNull();
        try {
            hashMapNotNull.put("user_properties", requestBodyFactory.createBodyPartFromString(objectMapper.writeValueAsString(new SetUserRequest.UserProperties(str))));
            return new SetUserMultipartRequest(requestBodyFactory.createBodyPartFromFile("user_avatar", new File(str2)), hashMapNotNull, okHttpClient, factory, bodyInterceptor, tokenInvalidator);
        } catch (JsonProcessingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<BaseV7Response> loadDataFromNetwork(V7.Interfaces interfaces, boolean z) {
        return interfaces.editUser(this.multipartBody, (HashMapNotNull) this.body);
    }
}
