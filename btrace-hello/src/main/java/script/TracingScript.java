package script;

/**
 * Created by Louz on 2015/11/6.
 */

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TracingScript {
    /* put your code here */
    @OnMethod(
            clazz = "io.jasonlu.btrace.BtraceMain",
            method = "run"
    )
    public static void trace() {
        println(strcat("begin ", str(timeMillis())));
    }

    @OnMethod(
            clazz = "io.jasonlu.btrace.BtraceMain",
            method = "run",
            location = @Location(Kind.RETURN)
    )
    public static void traceAfter() {
        println(strcat("end   ", str(timeMillis())));
    }
}