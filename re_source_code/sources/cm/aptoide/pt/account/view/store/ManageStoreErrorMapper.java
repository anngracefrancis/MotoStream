package cm.aptoide.pt.account.view.store;

import android.content.res.Resources;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.ErrorsMapper;

/* JADX INFO: loaded from: classes.dex */
public class ManageStoreErrorMapper {
    private final ErrorsMapper errorsMapper;
    private final Resources resources;

    /* JADX INFO: renamed from: cm.aptoide.pt.account.view.store.ManageStoreErrorMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType;

        static {
            int[] iArr = new int[SocialErrorType.values().length];
            $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType = iArr;
            try {
                iArr[SocialErrorType.INVALID_URL_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType[SocialErrorType.LINK_CHANNEL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType[SocialErrorType.PAGE_DOES_NOT_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType[SocialErrorType.GENERIC_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum SocialErrorType {
        INVALID_URL_TEXT,
        LINK_CHANNEL_ERROR,
        PAGE_DOES_NOT_EXIST,
        GENERIC_ERROR
    }

    public ManageStoreErrorMapper(Resources resources, ErrorsMapper errorsMapper) {
        this.resources = resources;
        this.errorsMapper = errorsMapper;
    }

    private int getErrorMessage(SocialErrorType socialErrorType) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$account$view$store$ManageStoreErrorMapper$SocialErrorType[socialErrorType.ordinal()];
        if (i2 == 1) {
            return R.string.edit_store_social_link_invalid_url_text;
        }
        if (i2 != 2) {
            return i2 != 3 ? R.string.all_message_general_error : R.string.edit_store_page_doesnt_exist_error_short;
        }
        return R.string.edit_store_social_link_channel_error;
    }

    public String getError(SocialErrorType socialErrorType) {
        return this.resources.getString(getErrorMessage(socialErrorType));
    }

    public String getGenericError() {
        return this.resources.getString(R.string.all_message_general_error);
    }

    public String getImageError() {
        return this.resources.getString(R.string.ws_error_IMAGE_ERROR_1);
    }

    public String getInvalidStoreError() {
        return this.resources.getString(R.string.ws_error_WOP_2);
    }

    public String getNetworkError(String str, String str2) {
        Resources resources = this.resources;
        return resources.getString(this.errorsMapper.getWebServiceErrorMessageFromCode(str, str2, resources));
    }
}
