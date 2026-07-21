package cm.aptoide.pt.home.bundles;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.home.bundles.ads.AdClick;
import cm.aptoide.pt.home.bundles.ads.AdsBundlesViewHolderFactory;
import cm.aptoide.pt.home.bundles.ads.WalletAdsOfferViewHolder;
import cm.aptoide.pt.home.bundles.appcoins.EarnAppCoinsViewHolder;
import cm.aptoide.pt.home.bundles.appcoins.FeaturedAppcViewHolder;
import cm.aptoide.pt.home.bundles.apps.AppsBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.ActionBundle;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.editorial.EditorialBundleViewHolder;
import cm.aptoide.pt.home.bundles.editorschoice.EditorsBundleViewHolder;
import cm.aptoide.pt.home.bundles.info.InfoBundleViewHolder;
import cm.aptoide.pt.home.bundles.misc.ErrorHomeBundle;
import cm.aptoide.pt.home.bundles.misc.LoadingBundleViewHolder;
import cm.aptoide.pt.home.bundles.misc.LoadingMoreErrorViewHolder;
import cm.aptoide.pt.home.bundles.misc.ProgressBundle;
import cm.aptoide.pt.home.bundles.promotional.ComingSoonViewHolder;
import cm.aptoide.pt.home.bundles.promotional.EventViewHolder;
import cm.aptoide.pt.home.bundles.promotional.NewAppVersionViewHolder;
import cm.aptoide.pt.home.bundles.promotional.NewAppViewHolder;
import cm.aptoide.pt.home.bundles.promotional.NewsViewHolder;
import cm.aptoide.pt.home.bundles.top.TopBundleViewHolder;
import cm.aptoide.pt.themes.ThemeManager;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BundlesAdapter extends RecyclerView.g<AppBundleViewHolder> {
    private static final int ADS = 3;
    private static final int APPS = 2;
    private static final int APP_COMING_SOON = 18;
    private static final int EARN_APPCOINS = 11;
    private static final int EDITORIAL = 5;
    private static final int EDITORS = 1;
    private static final int EVENT = 16;
    private static final int FEATURED_BONUS_APPCOINS = 12;
    private static final int INFO = 6;
    private static final int LOADING = 4;
    private static final int LOAD_MORE_ERROR = 10;
    private static final int NEWS = 14;
    private static final int NEW_APP_VERSION = 15;
    private static final int NEW_PACKAGE = 13;
    private static final int TOP = 9;
    private static final int WALLET_ADS_OFFER = 8;
    private final AdsBundlesViewHolderFactory adsBundlesViewHolderFactory;
    private List<HomeBundle> bundles;
    private final CaptionBackgroundPainter captionBackgroundPainter;
    private final ErrorHomeBundle errorBundle;
    private final String marketName;
    private final DecimalFormat oneDecimalFormatter;
    private final ProgressBundle progressBundle;
    private final ThemeManager themeManager;
    private final rx.s.b<HomeEvent> uiEventsListener;

    /* JADX INFO: renamed from: cm.aptoide.pt.home.bundles.BundlesAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType;

        static {
            int[] iArr = new int[HomeBundle.BundleType.values().length];
            $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType = iArr;
            try {
                iArr[HomeBundle.BundleType.APPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.APPCOINS_ADS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.FEATURED_BONUS_APPC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.NEW_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.NEWS_ITEM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.IN_GAME_EVENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.NEW_APP_VERSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.EDITORS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.ADS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.INFO_BUNDLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.LOADING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.EDITORIAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.WALLET_ADS_OFFER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.LOAD_MORE_ERROR.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[HomeBundle.BundleType.APP_COMING_SOON.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public BundlesAdapter(List<HomeBundle> list, ProgressBundle progressBundle, ErrorHomeBundle errorHomeBundle, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar, AdsBundlesViewHolderFactory adsBundlesViewHolderFactory, CaptionBackgroundPainter captionBackgroundPainter, String str, ThemeManager themeManager) {
        this.bundles = list;
        this.progressBundle = progressBundle;
        this.errorBundle = errorHomeBundle;
        this.uiEventsListener = bVar;
        this.oneDecimalFormatter = decimalFormat;
        this.marketName = str;
        this.adsBundlesViewHolderFactory = adsBundlesViewHolderFactory;
        this.captionBackgroundPainter = captionBackgroundPainter;
        this.themeManager = themeManager;
    }

    public void add(List<HomeBundle> list) {
        int size = this.bundles.size();
        this.bundles.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public void addHighlightedAd(AdClick adClick) {
        for (HomeBundle homeBundle : this.bundles) {
            if (homeBundle.getType() == HomeBundle.BundleType.ADS) {
                List<?> content = homeBundle.getContent();
                if (content == null) {
                    return;
                }
                for (int i2 = 0; i2 < content.size(); i2++) {
                    if (((AdClick) content.get(i2)).getAd().getPackageName().equals(adClick.getAd().getPackageName())) {
                        content.remove(i2);
                        break;
                    }
                }
                content.add(0, adClick);
            }
        }
        notifyDataSetChanged();
    }

    public void addLoadMore() {
        if (getLoadingPosition() < 0) {
            this.bundles.add(this.progressBundle);
            notifyItemInserted(this.bundles.size() - 1);
        }
    }

    public HomeBundle getBundle(int i2) {
        return this.bundles.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.bundles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$home$bundles$base$HomeBundle$BundleType[this.bundles.get(i2).getType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 11;
            case 3:
                return 12;
            case 4:
                return 13;
            case 5:
                return 14;
            case 6:
                return 16;
            case 7:
                return 15;
            case 8:
                return 1;
            case 9:
                return 3;
            case 10:
                return 6;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 8;
            case 14:
                return 9;
            case 15:
                return 10;
            case 16:
                return 18;
            default:
                throw new IllegalStateException("Bundle type not supported by the adapter: " + this.bundles.get(i2).getType().name());
        }
    }

    public synchronized int getLoadingPosition() {
        for (int size = this.bundles.size() - 1; size >= 0; size--) {
            if (this.bundles.get(size) instanceof ProgressBundle) {
                return size;
            }
        }
        return -1;
    }

    public boolean isLoaded() {
        List<HomeBundle> list = this.bundles;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<HomeBundle> it = this.bundles.iterator();
        while (it.hasNext()) {
            if (it.next().getContent() == null) {
                return false;
            }
        }
        return true;
    }

    public void remove(int i2) {
        this.bundles.remove(i2);
        notifyItemRemoved(i2);
    }

    public void removeLoadMore() {
        int loadingPosition = getLoadingPosition();
        if (loadingPosition >= 0) {
            this.bundles.remove(loadingPosition);
            notifyItemRemoved(loadingPosition);
        }
    }

    public void removeLoadMoreError() {
        remove(this.bundles.size() - 1);
    }

    public void showLoadMoreError() {
        this.bundles.add(this.errorBundle);
        notifyItemInserted(this.bundles.indexOf(this.errorBundle));
    }

    public void update(List<HomeBundle> list) {
        this.bundles = list;
        notifyDataSetChanged();
    }

    public void updateAppComingSoonCard(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle, boolean z) {
        int iIndexOf = this.bundles.indexOf(appComingSoonPromotionalBundle);
        ((AppComingSoonPromotionalBundle) this.bundles.get(iIndexOf)).setRegisteredForNotification(z);
        notifyItemChanged(iIndexOf);
    }

    public synchronized void updateEditorials() {
        for (int i2 = 0; i2 < this.bundles.size(); i2++) {
            if (this.bundles.get(i2) instanceof ActionBundle) {
                notifyItemChanged(i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(AppBundleViewHolder appBundleViewHolder, int i2) {
        appBundleViewHolder.setBundle(this.bundles.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public AppBundleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        switch (i2) {
            case 1:
                return new EditorsBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editors_choice_bundle_item, viewGroup, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
            case 2:
                return new AppsBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.apps_bundle_item, viewGroup, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
            case 3:
                return this.adsBundlesViewHolderFactory.createViewHolder(viewGroup);
            case 4:
                return new LoadingBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progress_item, viewGroup, false));
            case 5:
                return new EditorialBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editorial_action_item, viewGroup, false), this.uiEventsListener, this.captionBackgroundPainter, this.themeManager);
            case 6:
                return new InfoBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_action_item_card, viewGroup, false), this.uiEventsListener);
            case 7:
            case 17:
            default:
                throw new IllegalStateException("Invalid bundle view type");
            case 8:
                return new WalletAdsOfferViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_action_item_card, viewGroup, false), this.uiEventsListener);
            case 9:
                return new TopBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_bundle_item, viewGroup, false), this.uiEventsListener, this.oneDecimalFormatter, this.marketName);
            case 10:
                return new LoadingMoreErrorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.load_more_error, viewGroup, false), this.uiEventsListener);
            case 11:
                return new EarnAppCoinsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bundle_earn_appcoins, viewGroup, false), new DecimalFormat("0.00"), this.uiEventsListener);
            case 12:
                return new FeaturedAppcViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bundle_featured_appcoins, viewGroup, false), this.oneDecimalFormatter, this.uiEventsListener);
            case 13:
                return new NewAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_new_package, viewGroup, false), this.uiEventsListener);
            case 14:
                return new NewsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_news, viewGroup, false), this.uiEventsListener);
            case 15:
                return new NewAppVersionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_new_app_version, viewGroup, false), this.uiEventsListener);
            case 16:
                return new EventViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_event, viewGroup, false), this.uiEventsListener);
            case 18:
                return new ComingSoonViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_coming_soon, viewGroup, false), this.uiEventsListener);
        }
    }
}
