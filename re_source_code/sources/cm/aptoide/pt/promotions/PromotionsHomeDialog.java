package cm.aptoide.pt.promotions;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.analytics.implementation.CrashLogger;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.home.HomePromotionsWrapper;
import cm.aptoide.pt.networking.image.ImageLoader;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsHomeDialog {
    private static final String HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL = "HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL";
    private Button cancel;
    private AlertDialog dialog;
    private View dialogView;
    private Button navigate;
    private final CrashLogger crashReport = CrashReport.getInstance();
    private rx.s.b<String> uiEvents = rx.s.b.g1();

    public PromotionsHomeDialog(Context context) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.dialog = new AlertDialog.Builder(context).create();
        View viewInflate = layoutInflaterFrom.inflate(R.layout.promotions_home_dialog, (ViewGroup) null);
        this.dialogView = viewInflate;
        this.dialog.setView(viewInflate);
        this.cancel = (Button) this.dialogView.findViewById(R.id.cancel_button);
        this.navigate = (Button) this.dialogView.findViewById(R.id.navigate_button);
        this.dialog.setCancelable(true);
        this.dialog.setCanceledOnTouchOutside(true);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.navigate.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.promotions.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7057f.a(view);
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.promotions.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7048f.b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(View view) {
        rx.s.b<String> bVar = this.uiEvents;
        if (bVar != null) {
            bVar.onNext("navigate");
        } else {
            this.crashReport.log(HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL, HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(View view) {
        rx.s.b<String> bVar = this.uiEvents;
        if (bVar != null) {
            bVar.onNext("cancel");
        } else {
            this.crashReport.log(HOME_PROMOTIONS_DIALOG_EVENT_LISTENER_IS_NULL, HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    public void destroyDialog() {
        dismissDialog();
        this.dialog = null;
        this.navigate = null;
        this.cancel = null;
        this.uiEvents = null;
    }

    public rx.e<String> dialogClicked() {
        return this.uiEvents;
    }

    public void dismissDialog() {
        this.dialog.dismiss();
    }

    public void showDialog(HomePromotionsWrapper homePromotionsWrapper) {
        this.dialog.show();
        ((TextView) this.dialogView.findViewById(R.id.description)).setText(homePromotionsWrapper.getDescription());
        TextView textView = (TextView) this.dialog.findViewById(R.id.promotion_title);
        ImageView imageView = (ImageView) this.dialog.findViewById(R.id.promotion_graphic);
        textView.setText(homePromotionsWrapper.getTitle());
        ImageLoader.with(this.dialog.getContext()).load(homePromotionsWrapper.getFeatureGraphic(), imageView);
    }
}
