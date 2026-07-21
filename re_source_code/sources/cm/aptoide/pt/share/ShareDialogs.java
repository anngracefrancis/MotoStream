package cm.aptoide.pt.share;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;
import com.bumptech.glide.p.l.g;
import com.bumptech.glide.p.m.d;
import rx.e;
import rx.j;

/* JADX INFO: loaded from: classes.dex */
public class ShareDialogs {

    public enum ShareResponse {
        USING
    }

    public static e<ShareResponse> createStoreShareDialog(final Context context, final String str, final String str2) {
        return e.l(new e.a() { // from class: cm.aptoide.pt.share.c
            @Override // rx.m.b
            public final void call(Object obj) {
                ShareDialogs.lambda$createStoreShareDialog$2(context, str, str2, (j) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createStoreShareDialog$0(j jVar, DialogInterface dialogInterface, int i2) {
        if (jVar.isUnsubscribed() || i2 != 0) {
            return;
        }
        jVar.onNext(ShareResponse.USING);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createStoreShareDialog$2(Context context, String str, String str2, final j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(context).v(str).h(R.array.store_share_options_array, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.share.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ShareDialogs.lambda$createStoreShareDialog$0(jVar, dialogInterface, i2);
            }
        }).a();
        ImageLoader.with(context).loadIntoTarget(str2, new g<Drawable>() { // from class: cm.aptoide.pt.share.ShareDialogs.1
            @Override // com.bumptech.glide.p.l.i
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, d dVar) {
                onResourceReady((Drawable) obj, (d<? super Drawable>) dVar);
            }

            public void onResourceReady(Drawable drawable, d<? super Drawable> dVar) {
                cVarA.h(drawable);
            }
        });
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.share.b
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }
}
