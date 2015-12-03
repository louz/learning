import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

/**
 * Created by Louz on 2015/10/8.
 */
public class DemoSteps {
    private String word;
    private int i;

    @假如("^初始化应用$")
    public void 初始化应用() throws Throwable {
        System.out.println("=== i = " + i++);
        System.out.println("=== 应用正在初始化 ======");
    }

    @当("^给定一个词: (\\w+)$")
    public void 给定一个词(String word) throws Throwable {
        System.out.println("==== 给定的词为: " + word);
        this.word = word;
    }

    @那么("^打印一个句子")
    public void 打印一个句子() throws Throwable {
        System.out.println("========== hello " + word);
    }

    // TODO 演示一下每次的step是否会重置（或者说Steps类是否单例）

}
