package cm.aptoide.pt.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.rx.RxAlertDialog;

/* JADX INFO: loaded from: classes.dex */
public class ImagePickerDialog implements DialogInterface {
    public static final int LAYOUT = 2131492969;
    private final RxAlertDialog dialog;
    private View selectFromCamera;
    private View selectFromGallery;

    public static class Builder {
        private final RxAlertDialog.Builder builder;
        private int cameraButtonRes;
        private int galleryButtonRes;
        private final LayoutInflater layoutInflater;
        private int viewRes;

        public Builder(Context context, ThemeManager themeManager) {
            this.builder = new RxAlertDialog.Builder(context, themeManager);
            this.layoutInflater = LayoutInflater.from(context);
        }

        public ImagePickerDialog build() {
            int i2 = this.viewRes;
            if (i2 == 0 || this.cameraButtonRes == 0 || this.galleryButtonRes == 0) {
                throw new IllegalArgumentException("View and edit text resource ids must be provided");
            }
            View viewInflate = this.layoutInflater.inflate(i2, (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(this.cameraButtonRes);
            TextView textView2 = (TextView) viewInflate.findViewById(this.galleryButtonRes);
            this.builder.setView(viewInflate);
            return new ImagePickerDialog(this.builder.build(), textView, textView2);
        }

        public Builder setCameraButton(int i2) {
            this.cameraButtonRes = i2;
            return this;
        }

        public Builder setGalleryButton(int i2) {
            this.galleryButtonRes = i2;
            return this;
        }

        public Builder setNegativeButton(int i2) {
            this.builder.setNegativeButton(i2);
            return this;
        }

        public Builder setTitle(int i2) {
            this.builder.setTitle(i2);
            return this;
        }

        public Builder setViewRes(int i2) {
            this.viewRes = i2;
            return this;
        }
    }

    private /* synthetic */ DialogInterface lambda$cameraSelected$0(Void r1) {
        return this;
    }

    private /* synthetic */ DialogInterface lambda$gallerySelected$1(Void r1) {
        return this;
    }

    public /* synthetic */ DialogInterface a(Void r1) {
        lambda$cameraSelected$0(r1);
        return this;
    }

    public /* synthetic */ DialogInterface b(Void r1) {
        lambda$gallerySelected$1(r1);
        return this;
    }

    public rx.e<DialogInterface> cameraSelected() {
        return e.g.a.c.a.a(this.selectFromCamera).X(new rx.m.e() { // from class: cm.aptoide.pt.view.dialog.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                ImagePickerDialog imagePickerDialog = this.f8044f;
                imagePickerDialog.a((Void) obj);
                return imagePickerDialog;
            }
        });
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.dialog.cancel();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.dialog.dismiss();
    }

    public rx.e<DialogInterface> gallerySelected() {
        return e.g.a.c.a.a(this.selectFromGallery).X(new rx.m.e() { // from class: cm.aptoide.pt.view.dialog.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                ImagePickerDialog imagePickerDialog = this.f8043f;
                imagePickerDialog.b((Void) obj);
                return imagePickerDialog;
            }
        });
    }

    public void show() {
        this.dialog.show();
    }

    private ImagePickerDialog(RxAlertDialog rxAlertDialog, TextView textView, TextView textView2) {
        this.dialog = rxAlertDialog;
        this.selectFromCamera = textView;
        this.selectFromGallery = textView2;
    }
}
