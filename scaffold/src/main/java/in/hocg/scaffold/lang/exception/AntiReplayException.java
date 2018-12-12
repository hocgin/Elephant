package in.hocg.scaffold.lang.exception;

/**
 * Created by hocgin on 2018/12/12.
 * email: hocgin@gmail.com
 * <p>
 * 防重放异常
 *
 * @author hocgin
 */
public final class AntiReplayException extends Exception {
    
    private AntiReplayException(String message) {
        super(message);
    }
    
    public static AntiReplayException wrap(String message) {
        return new AntiReplayException(message);
    }
}
