package cm.aptoide.pt.store;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest;
import cm.aptoide.pt.logger.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class StoreUtils {
    private static final String PRIVATE_STORE_ERROR_CODE = "STORE-3";
    private static final String PRIVATE_STORE_WRONG_CREDENTIALS_ERROR_CODE = "STORE-4";
    private static final String STORE_DOESNT_EXIST_ERROR_CODE = "STORE-1";
    private static final String STORE_SUSPENDED_ERROR_CODE = "STORE-7";

    public static String formatRepoUri(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.contains("http//")) {
            lowerCase = lowerCase.replaceFirst("http//", "http://");
        }
        if (lowerCase.length() != 0 && lowerCase.charAt(lowerCase.length() - 1) != '/') {
            lowerCase = lowerCase + '/';
            Logger.getInstance().d("Aptoide-ManageRepo", "repo uri: " + lowerCase);
        }
        if (lowerCase.startsWith("http://")) {
            return lowerCase;
        }
        String str2 = "http://" + lowerCase;
        Logger.getInstance().d("Aptoide-ManageRepo", "repo uri: " + str2);
        return str2;
    }

    public static StoreError getErrorType(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1166288347:
                if (str.equals(STORE_DOESNT_EXIST_ERROR_CODE)) {
                    b2 = 0;
                }
                break;
            case -1166288345:
                if (str.equals(PRIVATE_STORE_ERROR_CODE)) {
                    b2 = 1;
                }
                break;
            case -1166288344:
                if (str.equals(PRIVATE_STORE_WRONG_CREDENTIALS_ERROR_CODE)) {
                    b2 = 2;
                }
                break;
            case -1166288341:
                if (str.equals(STORE_SUSPENDED_ERROR_CODE)) {
                    b2 = 3;
                }
                break;
        }
        switch (b2) {
            case 0:
                return StoreError.STORE_DOESNT_EXIST;
            case 1:
                return StoreError.PRIVATE_STORE_ERROR;
            case 2:
                return StoreError.PRIVATE_STORE_WRONG_CREDENTIALS;
            case 3:
                return StoreError.STORE_SUSPENDED;
            default:
                return StoreError.GENERIC_ERROR;
        }
    }

    @Deprecated
    public static BaseRequestWithStore.StoreCredentials getStoreCredentials(long j2, StoreCredentialsProvider storeCredentialsProvider) {
        return storeCredentialsProvider.get(j2);
    }

    @Deprecated
    public static BaseRequestWithStore.StoreCredentials getStoreCredentialsFromUrl(String str, StoreCredentialsProvider storeCredentialsProvider) {
        return storeCredentialsProvider.fromUrl(str);
    }

    public static HashMapNotNull<String, List<String>> getSubscribedStoresAuthMap(RoomStoreRepository roomStoreRepository) {
        HashMapNotNull<String, List<String>> hashMapNotNull = new HashMapNotNull<>();
        for (RoomStore roomStore : roomStoreRepository.getAll().W0().b()) {
            if (roomStore.getPasswordSha1() != null) {
                hashMapNotNull.put(roomStore.getStoreName(), new LinkedList(Arrays.asList(roomStore.getUsername(), roomStore.getPasswordSha1())));
            }
        }
        if (hashMapNotNull.size() > 0) {
            return hashMapNotNull;
        }
        return null;
    }

    public static List<Long> getSubscribedStoresIds(RoomStoreRepository roomStoreRepository) {
        LinkedList linkedList = new LinkedList();
        Iterator<RoomStore> it = roomStoreRepository.getAll().W0().b().iterator();
        while (it.hasNext()) {
            linkedList.add(Long.valueOf(it.next().getStoreId()));
        }
        return linkedList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isPrivateCredentialsSet(GetStoreMetaRequest getStoreMetaRequest) {
        return (((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStoreUser() == null || ((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStorePassSha1() == null) ? false : true;
    }

    public static Single<Boolean> isSubscribedStore(String str, RoomStoreRepository roomStoreRepository) {
        return roomStoreRepository.get(str).n(new rx.m.e() { // from class: cm.aptoide.pt.store.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RoomStore) obj) != null);
            }
        });
    }

    static /* synthetic */ rx.e lambda$subscribeStore$0(GetStoreMeta getStoreMeta, AptoideAccountManager aptoideAccountManager, String str, String str2, Account account) {
        if (BaseV7Response.Info.Status.OK.equals(getStoreMeta.getInfo().getStatus())) {
            return account.isLoggedIn() ? aptoideAccountManager.subscribeStore(getStoreMeta.getData().getName(), str, str2).b(rx.e.S(getStoreMeta)) : rx.e.S(getStoreMeta);
        }
        return rx.e.C(new Exception("Something went wrong while getting store meta"));
    }

    static /* synthetic */ void lambda$subscribeStore$3(SuccessRequestListener successRequestListener, GetStoreMeta getStoreMeta) {
        if (successRequestListener != null) {
            successRequestListener.call(getStoreMeta);
        }
    }

    static /* synthetic */ void lambda$subscribeStore$4(ErrorRequestListener errorRequestListener, Throwable th) {
        if (errorRequestListener != null) {
            errorRequestListener.onError(th);
        }
        CrashReport.getInstance().log(th);
    }

    static /* synthetic */ void lambda$unSubscribeStore$6(AptoideAccountManager aptoideAccountManager, String str, StoreCredentialsProvider storeCredentialsProvider, Boolean bool) {
        if (bool.booleanValue()) {
            aptoideAccountManager.unsubscribeStore(str, storeCredentialsProvider.get(str).getName(), storeCredentialsProvider.get(str).getPasswordSha1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static rx.b saveStore(Store store, GetStoreMetaRequest getStoreMetaRequest, RoomStoreRepository roomStoreRepository) {
        RoomStore roomStore = new RoomStore();
        roomStore.setStoreId(store.getId());
        roomStore.setStoreName(store.getName());
        roomStore.setDownloads(store.getStats().getDownloads());
        roomStore.setIconPath(store.getAvatar());
        roomStore.setTheme(store.getAppearance().getTheme());
        if (isPrivateCredentialsSet(getStoreMetaRequest)) {
            roomStore.setUsername(((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStoreUser());
            roomStore.setPasswordSha1(((GetHomeMetaRequest.Body) getStoreMetaRequest.getBody()).getStorePassSha1());
        }
        return roomStoreRepository.save(roomStore);
    }

    public static ArrayList<String> split(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(split(it.next()));
            }
        }
        return arrayList;
    }

    @Deprecated
    public static rx.e<GetStoreMeta> subscribeStore(final GetStoreMetaRequest getStoreMetaRequest, final AptoideAccountManager aptoideAccountManager, final String str, final String str2, final RoomStoreRepository roomStoreRepository) {
        return getStoreMetaRequest.observe().G(new rx.m.e() { // from class: cm.aptoide.pt.store.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                AptoideAccountManager aptoideAccountManager2 = aptoideAccountManager;
                return aptoideAccountManager2.accountStatus().E().Z0().k(new rx.m.e() { // from class: cm.aptoide.pt.store.b
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return StoreUtils.lambda$subscribeStore$0(getStoreMeta, aptoideAccountManager2, str, str, (Account) obj2);
                    }
                });
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                GetStoreMeta getStoreMeta = (GetStoreMeta) obj;
                return StoreUtils.saveStore(getStoreMeta.getData(), getStoreMetaRequest, roomStoreRepository).b(rx.e.S(getStoreMeta));
            }
        });
    }

    public static void unSubscribeStore(final String str, final AptoideAccountManager aptoideAccountManager, final StoreCredentialsProvider storeCredentialsProvider, final RoomStoreRepository roomStoreRepository) {
        aptoideAccountManager.accountStatus().X(new rx.m.e() { // from class: cm.aptoide.pt.store.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Account) obj).isLoggedIn());
            }
        }).E().x(new rx.m.b() { // from class: cm.aptoide.pt.store.e
            @Override // rx.m.b
            public final void call(Object obj) {
                StoreUtils.lambda$unSubscribeStore$6(aptoideAccountManager, str, storeCredentialsProvider, (Boolean) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.store.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return roomStoreRepository.remove(str);
            }
        }).D0();
    }

    @Deprecated
    public static BaseRequestWithStore.StoreCredentials getStoreCredentials(String str, StoreCredentialsProvider storeCredentialsProvider) {
        return storeCredentialsProvider.get(str);
    }

    public static String split(String str) {
        Logger.getInstance().d("Aptoide-RepoUtils", "Splitting " + str);
        return formatRepoUri(str).split("http://")[1].split("\\.store")[0].split("\\.bazaarandroid.com")[0];
    }

    @Deprecated
    public static void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, final SuccessRequestListener<GetStoreMeta> successRequestListener, final ErrorRequestListener errorRequestListener, AptoideAccountManager aptoideAccountManager, String str, String str2, RoomStoreRepository roomStoreRepository) {
        subscribeStore(getStoreMetaRequest, aptoideAccountManager, str, str2, roomStoreRepository).j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.g
            @Override // rx.m.b
            public final void call(Object obj) {
                StoreUtils.lambda$subscribeStore$3(successRequestListener, (GetStoreMeta) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.c
            @Override // rx.m.b
            public final void call(Object obj) {
                StoreUtils.lambda$subscribeStore$4(errorRequestListener, (Throwable) obj);
            }
        });
    }
}
