package cm.aptoide.pt.account.view;

import android.content.Context;
import android.content.res.Resources;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.GenericDialogs;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ImagePickerErrorHandler {
    private final Context context;
    private final Resources resources;
    private final ThemeManager themeManager;

    /* JADX INFO: renamed from: cm.aptoide.pt.account.view.ImagePickerErrorHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError;

        static {
            int[] iArr = new int[InvalidImageException.ImageError.values().length];
            $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError = iArr;
            try {
                iArr[InvalidImageException.ImageError.MIN_HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[InvalidImageException.ImageError.MAX_HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[InvalidImageException.ImageError.MIN_WIDTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[InvalidImageException.ImageError.MAX_WIDTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[InvalidImageException.ImageError.MAX_IMAGE_SIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[InvalidImageException.ImageError.ERROR_DECODING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ImagePickerErrorHandler(Context context, ThemeManager themeManager) {
        this.context = context;
        this.resources = context.getResources();
        this.themeManager = themeManager;
    }

    private String buildErrorMessage(InvalidImageException invalidImageException) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.resources.getString(R.string.image_requirements_popup_message));
        Iterator<InvalidImageException.ImageError> it = invalidImageException.getImageErrors().iterator();
        while (it.hasNext()) {
            switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError[it.next().ordinal()]) {
                case 1:
                    sb.append(this.resources.getString(R.string.image_requirements_error_min_height));
                    break;
                case 2:
                    sb.append(this.resources.getString(R.string.image_requirements_error_max_height));
                    break;
                case 3:
                    sb.append(this.resources.getString(R.string.image_requirements_error_min_width));
                    break;
                case 4:
                    sb.append(this.resources.getString(R.string.image_requirements_error_max_width));
                    break;
                case 5:
                    sb.append(this.resources.getString(R.string.image_requirements_error_max_file_size));
                    break;
                case 6:
                    sb.append(this.resources.getString(R.string.image_requirements_error_open_image));
                    break;
            }
        }
        int iLastIndexOf = sb.lastIndexOf("\n");
        if (iLastIndexOf > 0) {
            sb.delete(iLastIndexOf, sb.length());
        }
        return sb.toString();
    }

    public rx.e<GenericDialogs.EResponse> showIconPropertiesError(InvalidImageException invalidImageException) {
        return GenericDialogs.createGenericOkMessage(this.context, this.resources.getString(R.string.image_requirements_error_popup_title), buildErrorMessage(invalidImageException), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
    }
}
