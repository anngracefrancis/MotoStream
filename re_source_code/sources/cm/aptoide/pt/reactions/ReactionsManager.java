package cm.aptoide.pt.reactions;

import cm.aptoide.pt.reactions.network.LoadReactionModel;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import cm.aptoide.pt.reactions.network.ReactionsService;
import java.util.HashMap;
import okhttp3.HttpUrl;
import rx.Single;
import rx.m.e;

/* JADX INFO: loaded from: classes.dex */
public class ReactionsManager {
    private final ReactionsService reactionsService;
    private HashMap<String, UserReaction> userReactions;

    public ReactionsManager(ReactionsService reactionsService, HashMap<String, UserReaction> map) {
        this.reactionsService = reactionsService;
        this.userReactions = map;
    }

    private String getUID(String str) {
        UserReaction userReaction = this.userReactions.get(str);
        return userReaction != null ? userReaction.getUserId() : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0033  */
    private Single<Boolean> hasNotReacted(String str, String str2) {
        boolean z;
        if (getUID(str + str2) != null) {
            if (getUID(str + str2).equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return Single.m(Boolean.valueOf(z));
    }

    private boolean isSameReaction(String str, String str2, String str3) {
        UserReaction userReaction = this.userReactions.get(str + str2);
        return userReaction != null && userReaction.getReaction().equals(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$deleteReaction$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str, String str2, ReactionsResponse reactionsResponse) {
        if (reactionsResponse.wasSuccess()) {
            this.userReactions.remove(str + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, String str2, LoadReactionModel loadReactionModel) {
        this.userReactions.put(str + str2, new UserReaction(loadReactionModel.getUserId(), loadReactionModel.getMyReaction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setReaction$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(String str, String str2, String str3, Boolean bool) {
        if (bool.booleanValue()) {
            return this.reactionsService.setReaction(str, str2, str3);
        }
        if (isSameReaction(str, str2, str3)) {
            return Single.m(new ReactionsResponse(ReactionsResponse.ReactionResponseMessage.SAME_REACTION));
        }
        return this.reactionsService.setSecondReaction(getUID(str + str2), str3);
    }

    public Single<ReactionsResponse> deleteReaction(final String str, final String str2) {
        return this.reactionsService.deleteReaction(getUID(str + str2)).g(new rx.m.b() { // from class: cm.aptoide.pt.reactions.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7232f.a(str, str2, (ReactionsResponse) obj);
            }
        });
    }

    public Single<Boolean> isFirstReaction(String str, String str2) {
        return hasNotReacted(str, str2);
    }

    public Single<LoadReactionModel> loadReactionModel(final String str, final String str2) {
        return this.reactionsService.loadReactionModel(str, str2).g(new rx.m.b() { // from class: cm.aptoide.pt.reactions.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7235f.b(str, str2, (LoadReactionModel) obj);
            }
        });
    }

    public Single<ReactionsResponse> setReaction(final String str, final String str2, final String str3) {
        return hasNotReacted(str, str2).i(new e() { // from class: cm.aptoide.pt.reactions.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7238f.c(str, str2, str3, (Boolean) obj);
            }
        });
    }
}
