package cm.aptoide.pt.app.view.widget;

import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.s0;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.displayable.OtherVersionDisplayable;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.Malware;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class OtherVersionWidget extends Widget<OtherVersionDisplayable> implements View.OnClickListener {
    private long appId;
    private TextView date;
    private OtherVersionDisplayable displayable;
    private TextView downloads;
    private TextView followers;
    private String packageName;
    private ImageView storeIcon;
    private String storeName;
    private TextView storeNameView;
    private ImageView trustedBadge;
    private TextView version;
    private static final String TAG = OtherVersionWidget.class.getSimpleName();
    private static final Locale DEFAULT_LOCALE = Locale.getDefault();

    /* JADX INFO: renamed from: cm.aptoide.pt.app.view.widget.OtherVersionWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank;

        static {
            int[] iArr = new int[Malware.Rank.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = iArr;
            try {
                iArr[Malware.Rank.TRUSTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public OtherVersionWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(View view) {
        navigateToAppView();
    }

    private void navigateToAppView() {
        Logger.getInstance().d(TAG, "showing other version for app with id = " + this.appId);
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newAppViewFragment(this.appId, this.packageName, null, this.storeName, HttpUrl.FRAGMENT_ENCODE_SET), true);
    }

    private void setBadge(App app) {
        int i2;
        int i3 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[(app.getFile().getMalware().getRank() == null ? Malware.Rank.UNKNOWN : app.getFile().getMalware().getRank()).ordinal()];
        if (i3 == 1) {
            i2 = R.drawable.ic_badges_trusted;
        } else if (i3 != 2) {
            i2 = i3 != 3 ? 0 : R.drawable.ic_badges_critical;
        } else {
            i2 = R.drawable.ic_badges_warning;
        }
        this.trustedBadge.setImageResource(i2);
    }

    private void setItemBackgroundColor(View view) {
        int color;
        Resources.Theme theme = view.getContext().getTheme();
        Resources resources = view.getResources();
        if (getLayoutPosition() % 2 == 0) {
            color = Build.VERSION.SDK_INT >= 23 ? resources.getColor(this.displayable.getThemeManager().getAttributeForTheme(R.attr.backgroundSecondary).resourceId, theme) : resources.getColor(this.displayable.getThemeManager().getAttributeForTheme(R.attr.backgroundSecondary).resourceId);
        } else {
            color = Build.VERSION.SDK_INT >= 23 ? resources.getColor(this.displayable.getThemeManager().getAttributeForTheme(R.attr.backgroundMain).resourceId, theme) : resources.getColor(this.displayable.getThemeManager().getAttributeForTheme(R.attr.backgroundMain).resourceId);
        }
        view.setBackgroundColor(color);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.version = (TextView) view.findViewById(R.id.version_name);
        this.trustedBadge = (ImageView) view.findViewById(R.id.badge_icon);
        this.date = (TextView) view.findViewById(R.id.version_date);
        this.downloads = (TextView) view.findViewById(R.id.downloads);
        this.storeIcon = (ImageView) view.findViewById(R.id.store_icon);
        this.storeNameView = (TextView) view.findViewById(R.id.store_name);
        this.followers = (TextView) view.findViewById(R.id.store_followers);
        view.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        navigateToAppView();
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(OtherVersionDisplayable otherVersionDisplayable, int i2) {
        this.displayable = otherVersionDisplayable;
        setItemBackgroundColor(this.itemView);
        try {
            App pojo = otherVersionDisplayable.getPojo();
            this.appId = pojo.getId();
            this.storeName = pojo.getStore().getName();
            this.packageName = pojo.getPackageName();
            this.version.setText(pojo.getFile().getVername());
            s0.a(this.version, pojo.getFile().getVername());
            this.version.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4659f.a(view);
                }
            });
            setBadge(pojo);
            if (pojo.getStore().getName().equals("catappult")) {
                this.date.setText(AptoideUtils.DateTimeU.getInstance(getContext()).getTimeDiffString(getContext(), pojo.getFile().getAdded().getTime(), getContext().getResources()));
            } else {
                this.date.setText(AptoideUtils.DateTimeU.getInstance(getContext()).getTimeDiffString(getContext(), pojo.getModified().getTime(), getContext().getResources()));
            }
            TextView textView = this.downloads;
            Locale locale = DEFAULT_LOCALE;
            textView.setText(String.format(locale, getContext().getString(R.string.other_versions_downloads_count_text), AptoideUtils.StringU.withSuffix(pojo.getStats().getDownloads())));
            ImageLoader.with(getContext()).load(pojo.getStore().getAvatar(), this.storeIcon);
            this.storeNameView.setText(pojo.getStore().getName());
            this.followers.setText(String.format(locale, getContext().getString(R.string.appview_followers_count_text), Integer.valueOf(pojo.getStore().getStats().getSubscribers())));
        } catch (NullPointerException e2) {
            CrashReport.getInstance().log(e2);
        }
    }
}
