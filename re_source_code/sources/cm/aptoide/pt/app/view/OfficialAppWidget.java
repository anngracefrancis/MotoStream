package cm.aptoide.pt.app.view;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.Translator;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class OfficialAppWidget extends Widget<OfficialAppDisplayable> {
    private static final String TAG = "cm.aptoide.pt.app.view.OfficialAppWidget";
    private TextView appDownloads;
    private ImageView appImage;
    private TextView appName;
    private RatingBar appRating;
    private TextView appSize;
    private TextView appVersion;
    private Button installButton;
    private TextView installMessage;
    private View verticalSeparator;

    public OfficialAppWidget(View view) {
        super(view);
    }

    private void hideOfficialAppMessage() {
        this.installMessage.setVisibility(8);
        this.verticalSeparator.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(boolean z, GetAppMeta.App app, Void r3) {
        if (z) {
            AptoideUtils.SystemU.openApp(app.getPackageName(), getContext().getPackageManager(), getContext());
        } else {
            getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(app.getPackageName(), AppViewFragment.OpenType.OPEN_AND_INSTALL), true);
        }
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.appImage = (ImageView) view.findViewById(R.id.app_image);
        this.installButton = (Button) view.findViewById(R.id.app_install_button);
        this.installMessage = (TextView) view.findViewById(R.id.install_message);
        this.appName = (TextView) view.findViewById(R.id.app_name);
        this.verticalSeparator = view.findViewById(R.id.vertical_separator);
        this.appRating = (RatingBar) view.findViewById(R.id.app_rating);
        this.appDownloads = (TextView) view.findViewById(R.id.app_downloads);
        this.appVersion = (TextView) view.findViewById(R.id.app_version);
        this.appSize = (TextView) view.findViewById(R.id.app_size);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(OfficialAppDisplayable officialAppDisplayable, int i2) {
        androidx.fragment.app.d context = getContext();
        Pair<String, GetAppMeta> messageGetApp = officialAppDisplayable.getMessageGetApp();
        final boolean zIsAppInstalled = officialAppDisplayable.isAppInstalled();
        int primaryColor = officialAppDisplayable.getPrimaryColor();
        final GetAppMeta.App data = ((GetAppMeta) messageGetApp.second).getData();
        String name = data.getName();
        if (TextUtils.isEmpty((CharSequence) messageGetApp.first)) {
            hideOfficialAppMessage();
        } else {
            String[] strArrTranslateToMultiple = Translator.translateToMultiple((String) messageGetApp.first, getContext().getApplicationContext());
            if (strArrTranslateToMultiple == null || strArrTranslateToMultiple.length != 4) {
                this.installMessage.setText((CharSequence) messageGetApp.first);
            } else {
                SpannableString spannableString = new SpannableString(String.format(zIsAppInstalled ? strArrTranslateToMultiple[3] : strArrTranslateToMultiple[2], name));
                spannableString.setSpan(new ForegroundColorSpan(primaryColor), 0, spannableString.length(), 17);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) strArrTranslateToMultiple[0]);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) strArrTranslateToMultiple[1]);
                this.installMessage.setText(spannableStringBuilder);
            }
        }
        this.appRating.setRating(data.getStats().getRating().getAvg());
        this.appName.setText(name);
        this.appDownloads.setText(String.format(context.getString(R.string.downloads_count), AptoideUtils.StringU.withSuffix(data.getStats().getDownloads())));
        this.appVersion.setText(String.format(context.getString(R.string.version_number), data.getFile().getVername()));
        this.appSize.setText(String.format(context.getString(R.string.app_size), AptoideUtils.StringU.formatBytes(data.getFile().getFilesize(), false)));
        ImageLoader.with(context).load(data.getIcon(), this.appImage);
        this.installButton.setBackgroundResource(officialAppDisplayable.getRaisedButtonDrawable());
        this.installButton.setText(context.getString(zIsAppInstalled ? R.string.open : R.string.install));
        this.compositeSubscription.a(e.g.a.c.a.a(this.installButton).H0(new rx.m.b() { // from class: cm.aptoide.pt.app.view.zf
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4727f.a(zIsAppInstalled, data, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.app.view.yf
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
