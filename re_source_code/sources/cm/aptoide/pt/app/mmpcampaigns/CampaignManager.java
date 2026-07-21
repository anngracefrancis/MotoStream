package cm.aptoide.pt.app.mmpcampaigns;

import android.content.SharedPreferences;
import cm.aptoide.pt.apkfy.ApkFyParser;
import h.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.f;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CampaignManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/app/mmpcampaigns/CampaignManager;", HttpUrl.FRAGMENT_ENCODE_SET, "campaignRepository", "Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;", "securePreferences", "Landroid/content/SharedPreferences;", "(Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;Landroid/content/SharedPreferences;)V", "convertCampaign", "Lio/reactivex/Completable;", "campaign", "Lcm/aptoide/pt/app/mmpcampaigns/Campaign;", "medium", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignManager {
    private final CampaignRepository campaignRepository;
    private final SharedPreferences securePreferences;

    /* JADX INFO: renamed from: cm.aptoide.pt.app.mmpcampaigns.CampaignManager$convertCampaign$1, reason: invalid class name */
    /* JADX INFO: compiled from: CampaignManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.app.mmpcampaigns.CampaignManager$convertCampaign$1", f = "CampaignManager.kt", l = {14}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {
        final /* synthetic */ Campaign $campaign;
        final /* synthetic */ String $medium;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CampaignManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Campaign campaign, CampaignManager campaignManager, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$campaign = campaign;
            this.this$0 = campaignManager;
            this.$medium = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$campaign, this.this$0, this.$medium, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            Iterator it;
            CampaignManager campaignManager;
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                List<CampaignUrl> download = this.$campaign.getDownload();
                if (download != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : download) {
                        if (m.a(((CampaignUrl) obj2).getName(), "aptoide-mmp")) {
                            arrayList.add(obj2);
                        }
                    }
                    CampaignManager campaignManager2 = this.this$0;
                    str = this.$medium;
                    it = arrayList.iterator();
                    campaignManager = campaignManager2;
                }
                return u.a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$2;
            str = (String) this.L$1;
            campaignManager = (CampaignManager) this.L$0;
            o.b(obj);
            while (it.hasNext()) {
                CampaignUrl campaignUrl = (CampaignUrl) it.next();
                CampaignRepository campaignRepository = campaignManager.campaignRepository;
                String strInjectCampaignAttributes = CampaignManagerKt.injectCampaignAttributes(campaignUrl.getUrl(), str, campaignManager.securePreferences.getString(ApkFyParser.MMP_GUEST_UID, HttpUrl.FRAGMENT_ENCODE_SET));
                this.L$0 = campaignManager;
                this.L$1 = str;
                this.L$2 = it;
                this.label = 1;
                if (campaignRepository.knock(strInjectCampaignAttributes, this) == objC) {
                    return objC;
                }
            }
            return u.a;
        }
    }

    public CampaignManager(CampaignRepository campaignRepository, SharedPreferences sharedPreferences) {
        m.f(campaignRepository, "campaignRepository");
        m.f(sharedPreferences, "securePreferences");
        this.campaignRepository = campaignRepository;
        this.securePreferences = sharedPreferences;
    }

    public final b convertCampaign(Campaign campaign, String str) {
        m.f(campaign, "campaign");
        m.f(str, "medium");
        return f.c(null, new AnonymousClass1(campaign, this, str, null), 1, null);
    }
}
