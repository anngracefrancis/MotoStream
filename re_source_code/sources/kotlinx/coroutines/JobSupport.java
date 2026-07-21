package kotlinx.coroutines;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.f2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bZ\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\bj\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b¢\u0006\u0004\bm\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010-J\u0019\u0010q\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bp\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\br\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\bv\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082\b¢\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00018F¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Õ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", HttpUrl.FRAGMENT_ENCODE_SET, "active", "<init>", "(Z)V", HttpUrl.FRAGMENT_ENCODE_SET, "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "rootCause", HttpUrl.FRAGMENT_ENCODE_SET, "exceptions", HttpUrl.FRAGMENT_ENCODE_SET, "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", HttpUrl.FRAGMENT_ENCODE_SET, "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", HttpUrl.FRAGMENT_ENCODE_SET, "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", HttpUrl.FRAGMENT_ENCODE_SET, "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", RoomNotification.KEY, "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class JobSupport implements Job, ChildJob, ParentJob {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25746f = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: kotlinx.coroutines.f2$a */
    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", HttpUrl.FRAGMENT_ENCODE_SET, "parent", "Lkotlinx/coroutines/Job;", "nameString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a<T> extends CancellableContinuationImpl<T> {
        private final JobSupport n;

        public a(Continuation<? super T> continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.n = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String F() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable v(Job job) {
            Throwable thF;
            Object objX = this.n.X();
            if (!(objX instanceof c) || (thF = ((c) objX).f()) == null) {
                return objX instanceof CompletedExceptionally ? ((CompletedExceptionally) objX).f25646b : job.j();
            }
            return thF;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.f2$b */
    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends JobNode {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final JobSupport f25747j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c f25748k;
        private final ChildHandleNode l;
        private final Object m;

        public b(JobSupport jobSupport, c cVar, ChildHandleNode childHandleNode, Object obj) {
            this.f25747j = jobSupport;
            this.f25748k = cVar;
            this.l = childHandleNode;
            this.m = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        public void E(Throwable th) {
            this.f25747j.N(this.f25748k, this.l, this.m);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
            E(th);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.f2$c */
    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", HttpUrl.FRAGMENT_ENCODE_SET, "isCompleting", HttpUrl.FRAGMENT_ENCODE_SET, "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", HttpUrl.FRAGMENT_ENCODE_SET, "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final NodeList f25749f;

        public c(NodeList nodeList, boolean z, Throwable th) {
            this.f25749f = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        private final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void a(Throwable th) {
            Throwable thF = f();
            if (thF == null) {
                m(th);
                return;
            }
            if (th == thF) {
                return;
            }
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                l(th);
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(obj);
                arrayListC.add(th);
                l(arrayListC);
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + obj).toString());
        }

        @Override // kotlinx.coroutines.Incomplete
        /* JADX INFO: renamed from: b */
        public boolean getF25782f() {
            return f() == null;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* JADX INFO: renamed from: e, reason: from getter */
        public NodeList getF25879f() {
            return this.f25749f;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            return get_exceptionsHolder() == g2.f25775e;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayListC;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayListC = c();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(obj);
                arrayListC = arrayListC2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayListC = (ArrayList) obj;
            }
            Throwable thF = f();
            if (thF != null) {
                arrayListC.add(0, thF);
            }
            if (th != null && !kotlin.jvm.internal.m.a(th, thF)) {
                arrayListC.add(th);
            }
            l(g2.f25775e);
            return arrayListC;
        }

        public final void k(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getF25879f() + ']';
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.f2$d */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", HttpUrl.FRAGMENT_ENCODE_SET, "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JobSupport f25750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f25751e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f25750d = jobSupport;
            this.f25751e = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f25750d.X() == this.f25751e) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? g2.f25777g : g2.f25776f;
        this._parentHandle = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object A0(Incomplete incomplete, Object obj) throws Throwable {
        NodeList nodeListV = V(incomplete);
        if (nodeListV == null) {
            return g2.f25773c;
        }
        c cVar = incomplete instanceof c ? (c) incomplete : null;
        if (cVar == null) {
            cVar = new c(nodeListV, false, null);
        }
        kotlin.jvm.internal.f0 f0Var = new kotlin.jvm.internal.f0();
        synchronized (cVar) {
            if (cVar.h()) {
                return g2.a;
            }
            cVar.k(true);
            if (cVar != incomplete && !f25746f.compareAndSet(this, incomplete, cVar)) {
                return g2.f25773c;
            }
            if (s0.a() && !(!cVar.i())) {
                throw new AssertionError();
            }
            boolean zG = cVar.g();
            CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
            if (completedExceptionally != null) {
                cVar.a(completedExceptionally.f25646b);
            }
            T tF = Boolean.valueOf(zG ? false : true).booleanValue() ? cVar.f() : 0;
            f0Var.f22943f = tF;
            kotlin.u uVar = kotlin.u.a;
            Throwable th = (Throwable) tF;
            if (th != null) {
                j0(nodeListV, th);
            }
            ChildHandleNode childHandleNodeQ = Q(incomplete);
            return (childHandleNodeQ == null || !B0(cVar, childHandleNodeQ, obj)) ? P(cVar, obj) : g2.f25772b;
        }
    }

    private final boolean B0(c cVar, ChildHandleNode childHandleNode, Object obj) {
        while (Job.a.d(childHandleNode.f25880j, false, false, new b(this, cVar, childHandleNode, obj), 1, null) == NonDisposableHandle.f25852f) {
            childHandleNode = i0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final Object F(Object obj) {
        Object objZ0;
        do {
            Object objX = X();
            if (!(objX instanceof Incomplete) || ((objX instanceof c) && ((c) objX).h())) {
                return g2.a;
            }
            objZ0 = z0(objX, new CompletedExceptionally(O(obj), false, 2, null));
        } while (objZ0 == g2.f25773c);
        return objZ0;
    }

    private final boolean G(Throwable th) {
        if (c0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandleW = W();
        if (childHandleW == null || childHandleW == NonDisposableHandle.f25852f) {
            return z;
        }
        return childHandleW.u(th) || z;
    }

    private final void M(Incomplete incomplete, Object obj) throws Throwable {
        ChildHandle childHandleW = W();
        if (childHandleW != null) {
            childHandleW.k();
            r0(NonDisposableHandle.f25852f);
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f25646b : null;
        if (!(incomplete instanceof JobNode)) {
            NodeList f25749f = incomplete.getF25879f();
            if (f25749f != null) {
                k0(f25749f, th);
                return;
            }
            return;
        }
        try {
            ((JobNode) incomplete).E(th);
        } catch (Throwable th2) {
            Z(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(c cVar, ChildHandleNode childHandleNode, Object obj) {
        if (s0.a()) {
            if (!(X() == cVar)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode childHandleNodeI0 = i0(childHandleNode);
        if (childHandleNodeI0 == null || !B0(cVar, childHandleNodeI0, obj)) {
            v(P(cVar, obj));
        }
    }

    private final Throwable O(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(K(), null, this) : th;
        }
        if (obj != null) {
            return ((ParentJob) obj).D();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object P(c cVar, Object obj) throws Throwable {
        boolean zG;
        Throwable thS;
        boolean z = true;
        if (s0.a()) {
            if (!(X() == cVar)) {
                throw new AssertionError();
            }
        }
        if (s0.a() && !(!cVar.i())) {
            throw new AssertionError();
        }
        if (s0.a() && !cVar.h()) {
            throw new AssertionError();
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f25646b : null;
        synchronized (cVar) {
            zG = cVar.g();
            List<Throwable> listJ = cVar.j(th);
            thS = S(cVar, listJ);
            if (thS != null) {
                u(thS, listJ);
            }
        }
        if (thS != null && thS != th) {
            obj = new CompletedExceptionally(thS, false, 2, null);
        }
        if (thS != null) {
            if (!G(thS) && !Y(thS)) {
                z = false;
            }
            if (z) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((CompletedExceptionally) obj).b();
            }
        }
        if (!zG) {
            l0(thS);
        }
        m0(obj);
        boolean zCompareAndSet = f25746f.compareAndSet(this, cVar, g2.g(obj));
        if (s0.a() && !zCompareAndSet) {
            throw new AssertionError();
        }
        M(cVar, obj);
        return obj;
    }

    private final ChildHandleNode Q(Incomplete incomplete) {
        ChildHandleNode childHandleNode = incomplete instanceof ChildHandleNode ? (ChildHandleNode) incomplete : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList f25749f = incomplete.getF25879f();
        if (f25749f != null) {
            return i0(f25749f);
        }
        return null;
    }

    private final Throwable R(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f25646b;
        }
        return null;
    }

    private final Throwable S(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.g()) {
                return new JobCancellationException(K(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            for (Object obj2 : list) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final NodeList V(Incomplete incomplete) {
        NodeList f25749f = incomplete.getF25879f();
        if (f25749f != null) {
            return f25749f;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            p0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final Object d0(Object obj) throws Throwable {
        Throwable thO = null;
        while (true) {
            Object objX = X();
            if (objX instanceof c) {
                synchronized (objX) {
                    if (((c) objX).i()) {
                        return g2.f25774d;
                    }
                    boolean zG = ((c) objX).g();
                    if (obj != null || !zG) {
                        if (thO == null) {
                            thO = O(obj);
                        }
                        ((c) objX).a(thO);
                    }
                    Throwable thF = zG ^ true ? ((c) objX).f() : null;
                    if (thF != null) {
                        j0(((c) objX).getF25879f(), thF);
                    }
                    return g2.a;
                }
            }
            if (!(objX instanceof Incomplete)) {
                return g2.f25774d;
            }
            if (thO == null) {
                thO = O(obj);
            }
            Incomplete incomplete = (Incomplete) objX;
            if (!incomplete.getF25782f()) {
                Object objZ0 = z0(objX, new CompletedExceptionally(thO, false, 2, null));
                if (objZ0 == g2.a) {
                    throw new IllegalStateException(("Cannot happen in " + objX).toString());
                }
                if (objZ0 != g2.f25773c) {
                    return objZ0;
                }
            } else if (y0(incomplete, thO)) {
                return g2.a;
            }
        }
    }

    private final JobNode g0(Function1<? super Throwable, kotlin.u> function1, boolean z) {
        JobNode invokeOnCompletion;
        if (z) {
            invokeOnCompletion = function1 instanceof JobCancellingNode ? (JobCancellingNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCancelling(function1);
            }
        } else {
            invokeOnCompletion = function1 instanceof JobNode ? (JobNode) function1 : null;
            if (invokeOnCompletion == null) {
                invokeOnCompletion = new InvokeOnCompletion(function1);
            } else if (s0.a() && !(!(invokeOnCompletion instanceof JobCancellingNode))) {
                throw new AssertionError();
            }
        }
        invokeOnCompletion.G(this);
        return invokeOnCompletion;
    }

    private final ChildHandleNode i0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.y()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.v();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.r();
            if (!lockFreeLinkedListNode.y()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void j0(NodeList nodeList, Throwable th) throws Throwable {
        l0(th);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeR = (LockFreeLinkedListNode) nodeList.q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNodeR, nodeList); lockFreeLinkedListNodeR = lockFreeLinkedListNodeR.r()) {
            if (lockFreeLinkedListNodeR instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNodeR;
                try {
                    jobNode.E(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        kotlin.u uVar = kotlin.u.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Z(completionHandlerException);
        }
        G(th);
    }

    private final void k0(NodeList nodeList, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeR = (LockFreeLinkedListNode) nodeList.q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNodeR, nodeList); lockFreeLinkedListNodeR = lockFreeLinkedListNodeR.r()) {
            if (lockFreeLinkedListNodeR instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNodeR;
                try {
                    jobNode.E(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.b.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                        kotlin.u uVar = kotlin.u.a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            Z(completionHandlerException);
        }
    }

    private final void o0(Empty empty) {
        NodeList nodeList = new NodeList();
        Object inactiveNodeList = nodeList;
        if (!empty.getF25782f()) {
            inactiveNodeList = new InactiveNodeList(nodeList);
        }
        f25746f.compareAndSet(this, empty, inactiveNodeList);
    }

    private final void p0(JobNode jobNode) {
        jobNode.m(new NodeList());
        f25746f.compareAndSet(this, jobNode, jobNode.r());
    }

    private final int s0(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).getF25782f()) {
                return 0;
            }
            if (!f25746f.compareAndSet(this, obj, g2.f25777g)) {
                return -1;
            }
            n0();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        if (!f25746f.compareAndSet(this, obj, ((InactiveNodeList) obj).getF25879f())) {
            return -1;
        }
        n0();
        return 1;
    }

    private final boolean t(Object obj, NodeList nodeList, JobNode jobNode) {
        int iD;
        d dVar = new d(jobNode, this, obj);
        do {
            iD = nodeList.v().D(jobNode, nodeList, dVar);
            if (iD == 1) {
                return true;
            }
        } while (iD != 2);
        return false;
    }

    private final String t0(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof Incomplete) {
                return ((Incomplete) obj).getF25782f() ? "Active" : "New";
            }
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.g()) {
            return "Cancelling";
        }
        return cVar.h() ? "Completing" : "Active";
    }

    private final void u(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable thL = !s0.d() ? th : kotlinx.coroutines.internal.d0.l(th);
        for (Throwable thL2 : list) {
            if (s0.d()) {
                thL2 = kotlinx.coroutines.internal.d0.l(thL2);
            }
            if (thL2 != th && thL2 != thL && !(thL2 instanceof CancellationException) && setNewSetFromMap.add(thL2)) {
                kotlin.b.a(th, thL2);
            }
        }
    }

    public static /* synthetic */ CancellationException v0(JobSupport jobSupport, Throwable th, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return jobSupport.u0(th, str);
    }

    private final Object x(Continuation<Object> continuation) {
        a aVar = new a(kotlin.p003y.intrinsics.c.b(continuation), this);
        aVar.z();
        q.a(aVar, m(new ResumeAwaitOnCompletion(aVar)));
        Object objW = aVar.w();
        if (objW == kotlin.p003y.intrinsics.d.c()) {
            kotlin.p003y.j.p004a.h.c(continuation);
        }
        return objW;
    }

    private final boolean x0(Incomplete incomplete, Object obj) throws Throwable {
        if (s0.a()) {
            if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (s0.a() && !(!(obj instanceof CompletedExceptionally))) {
            throw new AssertionError();
        }
        if (!f25746f.compareAndSet(this, incomplete, g2.g(obj))) {
            return false;
        }
        l0(null);
        m0(obj);
        M(incomplete, obj);
        return true;
    }

    private final boolean y0(Incomplete incomplete, Throwable th) throws Throwable {
        if (s0.a() && !(!(incomplete instanceof c))) {
            throw new AssertionError();
        }
        if (s0.a() && !incomplete.getF25782f()) {
            throw new AssertionError();
        }
        NodeList nodeListV = V(incomplete);
        if (nodeListV == null) {
            return false;
        }
        if (!f25746f.compareAndSet(this, incomplete, new c(nodeListV, false, th))) {
            return false;
        }
        j0(nodeListV, th);
        return true;
    }

    private final Object z0(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return g2.a;
        }
        if ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) {
            return A0((Incomplete) obj, obj2);
        }
        return x0((Incomplete) obj, obj2) ? obj2 : g2.f25773c;
    }

    public final boolean C(Object obj) throws Throwable {
        Object objD0 = g2.a;
        if (U() && (objD0 = F(obj)) == g2.f25772b) {
            return true;
        }
        if (objD0 == g2.a) {
            objD0 = d0(obj);
        }
        if (objD0 == g2.a || objD0 == g2.f25772b) {
            return true;
        }
        if (objD0 == g2.f25774d) {
            return false;
        }
        v(objD0);
        return true;
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException D() {
        Throwable thF;
        Object objX = X();
        if (objX instanceof c) {
            thF = ((c) objX).f();
        } else if (objX instanceof CompletedExceptionally) {
            thF = ((CompletedExceptionally) objX).f25646b;
        } else {
            if (objX instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objX).toString());
            }
            thF = null;
        }
        CancellationException cancellationException = thF instanceof CancellationException ? (CancellationException) thF : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + t0(objX), thF, this);
    }

    public void E(Throwable th) throws Throwable {
        C(th);
    }

    @Override // kotlinx.coroutines.Job
    public void H(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(K(), null, this);
        }
        E(cancellationException);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle J(ChildJob childJob) {
        return (ChildHandle) Job.a.d(this, true, false, new ChildHandleNode(childJob), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String K() {
        return "Job was cancelled";
    }

    public boolean L(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return C(th) && getF25637g();
    }

    /* JADX INFO: renamed from: T */
    public boolean getF25637g() {
        return true;
    }

    public boolean U() {
        return false;
    }

    public final ChildHandle W() {
        return (ChildHandle) this._parentHandle;
    }

    public final Object X() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    protected boolean Y(Throwable th) {
        return false;
    }

    public void Z(Throwable th) throws Throwable {
        throw th;
    }

    protected final void a0(Job job) {
        if (s0.a()) {
            if (!(W() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            r0(NonDisposableHandle.f25852f);
            return;
        }
        job.start();
        ChildHandle childHandleJ = job.J(this);
        r0(childHandleJ);
        if (b0()) {
            childHandleJ.k();
            r0(NonDisposableHandle.f25852f);
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean b() {
        Object objX = X();
        return (objX instanceof Incomplete) && ((Incomplete) objX).getF25782f();
    }

    public final boolean b0() {
        return !(X() instanceof Incomplete);
    }

    protected boolean c0() {
        return false;
    }

    public final boolean e0(Object obj) {
        Object objZ0;
        do {
            objZ0 = z0(X(), obj);
            if (objZ0 == g2.a) {
                return false;
            }
            if (objZ0 == g2.f25772b) {
                return true;
            }
        } while (objZ0 == g2.f25773c);
        v(objZ0);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle f(boolean z, boolean z2, Function1<? super Throwable, kotlin.u> function1) {
        JobNode jobNodeG0 = g0(function1, z);
        while (true) {
            Object objX = X();
            if (objX instanceof Empty) {
                Empty empty = (Empty) objX;
                if (!empty.getF25782f()) {
                    o0(empty);
                } else if (f25746f.compareAndSet(this, objX, jobNodeG0)) {
                    return jobNodeG0;
                }
            } else {
                Throwable thF = null;
                if (!(objX instanceof Incomplete)) {
                    if (z2) {
                        CompletedExceptionally completedExceptionally = objX instanceof CompletedExceptionally ? (CompletedExceptionally) objX : null;
                        function1.invoke(completedExceptionally != null ? completedExceptionally.f25646b : null);
                    }
                    return NonDisposableHandle.f25852f;
                }
                NodeList f25749f = ((Incomplete) objX).getF25879f();
                if (f25749f != null) {
                    DisposableHandle disposableHandle = NonDisposableHandle.f25852f;
                    if (z && (objX instanceof c)) {
                        synchronized (objX) {
                            thF = ((c) objX).f();
                            if (thF == null || ((function1 instanceof ChildHandleNode) && !((c) objX).h())) {
                                if (t(objX, f25749f, jobNodeG0)) {
                                    if (thF == null) {
                                        return jobNodeG0;
                                    }
                                    disposableHandle = jobNodeG0;
                                }
                            }
                            kotlin.u uVar = kotlin.u.a;
                        }
                    }
                    if (thF != null) {
                        if (z2) {
                            function1.invoke(thF);
                        }
                        return disposableHandle;
                    }
                    if (t(objX, f25749f, jobNodeG0)) {
                        return jobNodeG0;
                    }
                } else {
                    if (objX == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    p0((JobNode) objX);
                }
            }
        }
    }

    public final Object f0(Object obj) {
        Object objZ0;
        do {
            objZ0 = z0(X(), obj);
            if (objZ0 == g2.a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, R(obj));
            }
        } while (objZ0 == g2.f25773c);
        return objZ0;
    }

    @Override // kotlin.p003y.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        return (R) Job.a.b(this, r, function2);
    }

    @Override // kotlin.p003y.CoroutineContext.b, kotlin.p003y.CoroutineContext
    public <E extends CoroutineContext.b> E get(CoroutineContext.c<E> cVar) {
        return (E) Job.a.c(this, cVar);
    }

    @Override // kotlin.p003y.CoroutineContext.b
    public final CoroutineContext.c<?> getKey() {
        return Job.f25890e;
    }

    public String h0() {
        return t0.a(this);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object objX = X();
        return (objX instanceof CompletedExceptionally) || ((objX instanceof c) && ((c) objX).g());
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException j() {
        Object objX = X();
        if (!(objX instanceof c)) {
            if (objX instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objX instanceof CompletedExceptionally) {
                return v0(this, ((CompletedExceptionally) objX).f25646b, null, 1, null);
            }
            return new JobCancellationException(t0.a(this) + " has completed normally", null, this);
        }
        Throwable thF = ((c) objX).f();
        if (thF != null) {
            CancellationException cancellationExceptionU0 = u0(thF, t0.a(this) + " is cancelling");
            if (cancellationExceptionU0 != null) {
                return cancellationExceptionU0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void l(ParentJob parentJob) throws Throwable {
        C(parentJob);
    }

    protected void l0(Throwable th) {
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle m(Function1<? super Throwable, kotlin.u> function1) {
        return f(false, true, function1);
    }

    protected void m0(Object obj) {
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.c<?> cVar) {
        return Job.a.e(this, cVar);
    }

    protected void n0() {
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.a.f(this, coroutineContext);
    }

    public final void q0(JobNode jobNode) {
        Object objX;
        do {
            objX = X();
            if (!(objX instanceof JobNode)) {
                if (!(objX instanceof Incomplete) || ((Incomplete) objX).getF25879f() == null) {
                    return;
                }
                jobNode.z();
                return;
            }
            if (objX != jobNode) {
                return;
            }
        } while (!f25746f.compareAndSet(this, objX, g2.f25777g));
    }

    public final void r0(ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iS0;
        do {
            iS0 = s0(X());
            if (iS0 == 0) {
                return false;
            }
        } while (iS0 != 1);
        return true;
    }

    public String toString() {
        return w0() + '@' + t0.b(this);
    }

    protected final CancellationException u0(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = K();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    protected void v(Object obj) {
    }

    public final Object w(Continuation<Object> continuation) throws Throwable {
        Object objX;
        do {
            objX = X();
            if (!(objX instanceof Incomplete)) {
                if (!(objX instanceof CompletedExceptionally)) {
                    return g2.h(objX);
                }
                Throwable th = ((CompletedExceptionally) objX).f25646b;
                if (s0.d() && (continuation instanceof CoroutineStackFrame)) {
                    throw kotlinx.coroutines.internal.d0.j(th, (CoroutineStackFrame) continuation);
                }
                throw th;
            }
        } while (s0(objX) < 0);
        return x(continuation);
    }

    public final String w0() {
        return h0() + '{' + t0(X()) + '}';
    }

    public final boolean y(Throwable th) {
        return C(th);
    }
}
