package cm.aptoide.pt.account.view;

import cm.aptoide.pt.account.view.exception.InvalidImageException;
import java.util.ArrayList;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ImageValidator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcm/aptoide/pt/account/view/ImageValidator;", HttpUrl.FRAGMENT_ENCODE_SET, "scheduler", "Lrx/Scheduler;", "imageInfoProvider", "Lcm/aptoide/pt/account/view/ImageInfoProvider;", "(Lrx/Scheduler;Lcm/aptoide/pt/account/view/ImageInfoProvider;)V", "getInfo", "Lcm/aptoide/pt/account/view/ImageInfo;", "imagePath", HttpUrl.FRAGMENT_ENCODE_SET, "validate", HttpUrl.FRAGMENT_ENCODE_SET, "validateOrGetException", "Lrx/Completable;", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ImageValidator {
    private static final int MAX_IMAGE_HEIGHT = 10240;
    private static final int MAX_IMAGE_SIZE_IN_BYTES = 5242880;
    private static final int MAX_IMAGE_WIDTH = 10240;
    private static final int MIN_IMAGE_HEIGHT = 600;
    private static final int MIN_IMAGE_WIDTH = 600;
    private final ImageInfoProvider imageInfoProvider;
    private final rx.h scheduler;

    public ImageValidator(rx.h hVar, ImageInfoProvider imageInfoProvider) {
        kotlin.jvm.internal.m.f(hVar, "scheduler");
        kotlin.jvm.internal.m.f(imageInfoProvider, "imageInfoProvider");
        this.scheduler = hVar;
        this.imageInfoProvider = imageInfoProvider;
    }

    private final ImageInfo getInfo(String imagePath) throws InvalidImageException {
        ImageInfo info = this.imageInfoProvider.getInfo(imagePath);
        if (info != null) {
            return info;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(InvalidImageException.ImageError.ERROR_DECODING);
        throw new InvalidImageException(arrayList);
    }

    private final void validate(String imagePath) throws InvalidImageException {
        ImageInfo info = getInfo(imagePath);
        ArrayList arrayList = new ArrayList();
        if (info.getHeight() < 600) {
            arrayList.add(InvalidImageException.ImageError.MIN_HEIGHT);
        } else if (info.getHeight() > 10240) {
            arrayList.add(InvalidImageException.ImageError.MAX_HEIGHT);
        }
        if (info.getWidth() < 600) {
            arrayList.add(InvalidImageException.ImageError.MIN_WIDTH);
        } else if (info.getWidth() > 10240) {
            arrayList.add(InvalidImageException.ImageError.MAX_WIDTH);
        }
        if (info.getSize() > 5242880) {
            arrayList.add(InvalidImageException.ImageError.MAX_IMAGE_SIZE);
        }
        if (!arrayList.isEmpty()) {
            throw new InvalidImageException(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: validateOrGetException$lambda-0, reason: not valid java name */
    public static final rx.b m22validateOrGetException$lambda0(ImageValidator imageValidator, String str) throws InvalidImageException {
        kotlin.jvm.internal.m.f(imageValidator, "this$0");
        kotlin.jvm.internal.m.f(str, "$imagePath");
        imageValidator.validate(str);
        return rx.b.e();
    }

    public rx.b validateOrGetException(final String str) {
        kotlin.jvm.internal.m.f(str, "imagePath");
        return rx.b.i(new rx.m.d() { // from class: cm.aptoide.pt.account.view.u0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return ImageValidator.m22validateOrGetException$lambda0(this.f3952f, str);
            }
        }).K(this.scheduler);
    }
}
