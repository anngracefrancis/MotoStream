package cm.aptoide.pt.ads.data;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ApplicationAd {

    public enum Network {
        SERVER("Server");

        private String name;

        Network(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    String getAdTitle();

    Payout getAppcPayout();

    String getIconUrl();

    Network getNetwork();

    String getPackageName();

    Integer getStars();

    boolean hasAppcPayout();

    void registerClickableView(View view);

    void setAdView(View view);
}
