package cm.aptoide.pt.dataprovider.ws.v3;

import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v3.BaseV3Response;
import cm.aptoide.pt.dataprovider.model.v3.CheckUserCredentialsJson;
import cm.aptoide.pt.dataprovider.model.v3.OAuth;
import cm.aptoide.pt.dataprovider.model.v3.TermsAndConditionsResponse;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.v2.GenericResponseV2;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public interface Service {
    @FormUrlEncoded
    @POST("addApkFlag")
    e<GenericResponseV2> addApkFlag(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("checkUserCredentials")
    e<CheckUserCredentialsJson> checkUserCredentials(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("createUser")
    e<BaseV3Response> createUser(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @POST("createUser")
    @Multipart
    e<BaseV3Response> createUserWithFile(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, RequestBody> hashMapNotNull, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("getPushNotifications")
    e<GetPushNotificationsResponse> getPushNotifications(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("getUserInfo")
    e<TermsAndConditionsResponse> getTermsAndConditionsStatus(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("getUserInfo")
    e<CheckUserCredentialsJson> getUserInfo(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("oauth2Authentication")
    e<OAuth> oauth2Authentication(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

    @FormUrlEncoded
    @POST("acceptUserAgreement")
    e<BaseV3Response> updateTermsAndConditions(@FieldMap BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);
}
