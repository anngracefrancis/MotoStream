package cm.aptoide.pt.dataprovider.util.referrer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class ReferrerUtils {
    public static final int DELAY = 5;
    public static final int RETRIES = 2;
    public static final ReferrersMap excludedNetworks = new ReferrersMap();
    protected static final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
}
